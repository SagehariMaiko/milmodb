package controllers.milmodb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.codehaus.groovy.util.StringUtil;

import com.mysql.jdbc.StringUtils;

import util.common.*;
import util.function.*;

public class Validater {
	public static List<Map<String, String>> datalist;
	public static List<Map<String, String>> v_ColListMap;
	public static List<Map<String, String>> uniColListMap;
	public static List<Map<String, String>> comColListMap;
	public static String servicetype;

	public Validater(List<Map<String, String>> datalist, List<Map<String, String>> v_ColListMap, List<Map<String, String>> uniColListMap, List<Map<String, String>> comColListMap, String servicetype) {
		super();
		this.datalist = datalist;
		this.v_ColListMap = v_ColListMap;
		this.uniColListMap = uniColListMap;
		this.comColListMap = comColListMap;
		this.servicetype = servicetype.replace(" ", "").replace("　", "");
	}

	public List<Map<String, String>> isValid() throws NumberFormatException, UnsupportedEncodingException, IOException{
		List<Map<String, String>> newdatalist = this.datalist;
		for ( Map<String, String> vm : v_ColListMap){
			String validatelist = vm.get(ColumnNames.VALID_LIST);
			if (validatelist != null){
				String[] validateArray = validatelist.split(",");
				for(int i = 0; i < validateArray.length; i++){
					ValidaterEnum.validates(validateArray[i].toString(), newdatalist, vm);
				}
			}
		}

		for (Map<String, String> cm : comColListMap){
			if ((ColumnNames.NVARCHAR.equals(cm.get(ColumnNames.DATATYPE)) && !"-1".equals(cm.get(ColumnNames.LENGTH))) && cm.get(ColumnNames.INPUTTYPE) != null){
				ValidaterEnum.validates("8", newdatalist, cm);
			}
		}

		for (Map<String, String> um : uniColListMap){
			if ((ColumnNames.NVARCHAR.equals(um.get(ColumnNames.DATATYPE)) && !"-1".equals(um.get(ColumnNames.LENGTH))) && um.get(ColumnNames.INPUTTYPE) != null){
				ValidaterEnum.validates("8", newdatalist, um);
			}
		}
		return newdatalist;
	}
}
