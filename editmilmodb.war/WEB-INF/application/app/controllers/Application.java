package controllers;

import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.With;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.GenericModel.JPAQuery;
import play.db.jpa.JPA;
import play.db.jpa.JPABase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import play.db.DB;
import controllers.milmodb.*;
import util.common.*;
import util.function.*;
import models.*;

@Check("admin")
@With(Secure.class)
public class Application extends Controller {

	@Before
	static void setConnectedUser() {
		if(Security.isConnected()) {
			User user = User.find("byEmail", Security.connected()).first();
			renderArgs.put("user", user.fullname);
		}
	}

	public static void index() {
		List<ServiceName> servicenames = ServiceName.findAll();
		render(servicenames);
	}

	public static void show(String formSerCd) {
		List<Map<String, String>> data = DataListEnum.getDataList(formSerCd);
		renderArgs.put("formSerCd", formSerCd);
		render(data);
	}
    
    public static void form(String formSerCd, Long office_id) {
		try {	
			renderArgs.put("formSerCd", formSerCd);
			renderArgs.put("office_id", office_id);
			ServiceName type = ServiceName.find(ColumnNames.FORMSERCD, formSerCd).first();
			List<Map<String, String>> titlecollistmap = getcolumndata("v_" + type.table_name);
			MilmoDBEntity data = DataDetailEnum.getDetail(formSerCd, office_id);
			Map<String, String> invalidlist = getinvalidlist(data);
			System.out.println("invalidlist = " + invalidlist);
			render(data, titlecollistmap, invalidlist);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void save(String formSerCd, Long office_id) {
		try {
			ServiceName type = ServiceName.find(ColumnNames.FORMSERCD, formSerCd).first();		
			List<Map<String, String>> v_ColListMap = getcolumndata("v_" + type.table_name);
			Map<String, String> paramdata = new HashMap<String, String>();
			for (Map<String, String> Collist : v_ColListMap){
				if (!ColumnNames.VALIDATE.equals(Collist.get(ColumnNames.COLUMN_NAME)) && !ColumnNames.VALIDATE_TYPE.equals(Collist.get(ColumnNames.COLUMN_NAME))){
					paramdata.put(Collist.get(ColumnNames.COLUMN_NAME), params.get(Collist.get(ColumnNames.COLUMN_NAME)));
				}
			}
			
			JFrame frame = new JFrame();
			frame.setAlwaysOnTop(true);
			int option = JOptionPane.showConfirmDialog(frame, "更新しますか？", "確認", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
			if (option == JOptionPane.YES_OPTION){
				
				List<Map<String, String>> datalist = new ArrayList();
				datalist.add(paramdata);
				Converter conv = new Converter(datalist,v_ColListMap);
				List<Map<String, String>> newdata = conv.isCovert();
			
				List<Map<String, String>> uniColListMap = getcolumndata(type.table_name);
				List<Map<String, String>> comColListMap = getcolumndata(TableNames.OFFICE_COMMON);
				Validater valid = new Validater(newdata, v_ColListMap, uniColListMap, comColListMap, type.service_name);
				newdata = valid.isValid();
			
				Map<String, String> afterdata = newdata.get(0);
				if ((afterdata.get(ColumnNames.VALIDATE) != null)){
					renderArgs.put("formSerCd", formSerCd);
					renderArgs.put("office_id", office_id);
					Map<String, String> invalidlist = getinvalidlist(afterdata);
					MilmoDBEntity beforedata = DataDetailEnum.getDetail(formSerCd, office_id);
					String Msg = "入力が妥当ではない項目があります。再確認してください。";
					renderTemplate("Application/reform.html", beforedata, afterdata, v_ColListMap, invalidlist, Msg);
				} else {
					SaveVdataEnum.saveVdatas(formSerCd, office_id, afterdata, type);
					MilmoDBEntity nextdata = SaveDataEnum.savedatas(formSerCd, office_id, afterdata, type);
					if (nextdata != null) {
						form(formSerCd, nextdata.getOfficeId());
					} else {
						index();
					}
				}
			} else {
				renderArgs.put("formSerCd", formSerCd);
				renderArgs.put("office_id", office_id);
				Map<String, String> afterdata = paramdata;
				afterdata.put(ColumnNames.VALIDATE, params.get(ColumnNames.VALIDATE));
				afterdata.put(ColumnNames.VALIDATE_TYPE, params.get(ColumnNames.VALIDATE_TYPE));
				System.out.println("afterdata.VALIDATE_TYPE = " + afterdata.get(ColumnNames.VALIDATE_TYPE));
				Map<String, String> invalidlist = getinvalidlist(afterdata);
				System.out.println("invalidlist = " + invalidlist);
				MilmoDBEntity beforedata = DataDetailEnum.getDetail(formSerCd, office_id);
				String Msg = "更新を中断しました";
				System.out.println("Msg = " + Msg);
				renderTemplate("Application/reform.html", beforedata, afterdata, v_ColListMap, invalidlist, Msg);
			}
			frame.setAlwaysOnTop(false);
		} catch (SQLException e) {
			e.printStackTrace();
			JPA.setRollbackOnly();
			System.out.println("ROLLBACK!!!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JPA.setRollbackOnly();
			System.out.println("ROLLBACK!!!!!");
		} 
	}

	private static Map<String, String> getinvalidlist(MilmoDBEntity data) throws IOException{
		Map<String, String> invalidlist = new HashMap<String, String>();
		for(Map.Entry<String, String> m : CommonFunc.StringToMap(data.getValidationType().toString()).entrySet()) {
			invalidlist = createinvalidlist(invalidlist, m);
		}
		return invalidlist;
	}

	private static Map<String, String> getinvalidlist(Map<String, String> data) throws IOException{
		Map<String, String> invalidlist = new HashMap<String, String>();
		for(Map.Entry<String, String> m : CommonFunc.StringToMap(data.get(ColumnNames.VALIDATE_TYPE)).entrySet()) {
			invalidlist = createinvalidlist(invalidlist, m);
		}
		return invalidlist;
	}

	private static Map<String, String> createinvalidlist(Map<String, String> invalidlist, Map.Entry<String, String> m){
		String[] valArray = m.getValue().toString().split(":");
		for (int i = 0; i < valArray.length; i++){
			Validate_type validate = Validate_type.findById(Long.valueOf(valArray[i]));
			invalidlist.put(m.getKey(), (invalidlist.containsKey(m.getKey())) ? invalidlist.get(m.getKey()) + "/" + validate.title: validate.title);
		}
		return invalidlist;
	}

	private static List<Map<String, String>> getcolumndata(String tablename) throws SQLException{
		Connection con = DB.getConnection();
		PreparedStatement sql = con.prepareStatement("SELECT * FROM " + StoredProcedureNames.F_GETCOLUMNDATA + "('" +tablename + "')");
		ResultSet resultSet = sql.executeQuery();
		return getData(resultSet);
	}


	protected static final List<Map<String, String>> getData(ResultSet rset) throws SQLException {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		ResultSetMetaData meta = rset.getMetaData();
		while (rset.next()) {
			int count = meta.getColumnCount();
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < count; i++) {
				 String cn = meta.getColumnName(i + 1);
				 String value = rset.getString(cn);
				 map.put(cn, value);
			}
			list.add(map);
		}
		return list;
	}
}