package controllers.milmodb;

import java.util.List;
import java.util.Map;
import java.util.regex.*;

import util.common.ColumnNames;
import util.common.ViewNames;


public class HomeCare {
	public IValidate[] validaters = new IValidate[] {
			new StringValidater(), 
			new LengthValidater(),
			new PersonValidater()};
	
	public final List<Map<String, String>> datalist;
	
	public static final Pattern person = Pattern.compile("^\\d{1,2}$");
	
	public HomeCare(List<Map<String, String>> datalist) {
		super();
		this.datalist = datalist;
	}
	
	public List<Map<String, String>> isValid(DB db) {
		//boolean b = false;
		List<Map<String, String>> newdatalist = this.datalist;
		for ( Map<String, String> data : newdatalist){
			boolean FLG = true;
			for (IValidate v : validaters) {
				if(!v.validate(data, db)){FLG = false;}
			}
			data.put(ColumnNames.IVALIDATE_FLG, String.valueOf(FLG));
		}
		return newdatalist;
	}
	
	public static interface IValidate {
		public boolean validate(Map<String, String> s, DB db);
	}
	
	public static class StringValidater implements IValidate {
		public boolean validate(Map<String, String> s, DB db) {
			//Logger.write(">>>StringValidater");
			return true;
		}
	}
	
	public static class PersonValidater implements IValidate {
		public boolean validate(Map<String, String> d, DB db) {
			boolean b = true;
			//Logger.write(">>>2");
			List<Map<String, String>> collist = Dao.selectData(db, ViewNames.V_PERSONS);
			for ( Map<String, String> c : collist){
				String Key = c.get(ColumnNames.COLUMN_NAME);
				for (int i = 0; i < ColumnNames.JYOUKINSENJYU.length; i++) {
					String Key_ = Key + ColumnNames.JYOUKINSENJYU[i].toString();
					if (d.containsKey(Key_)){
						Matcher m = person.matcher(d.get(Key_));
						//Logger.write("d.get(Key_) = " + d.get(Key_));
						if(!m.find()) {
							Logger.write(String.format(" >>> office_id = %s : < %s > PersonValidater err", d.get(ColumnNames.OFFICE_ID), Key_));
							b = false;
						}
					}
				}
			}
			return b;
		}
	}

	public static class LengthValidater implements IValidate {
		public boolean validate(Map<String, String> s, DB db) {
			return true;
		}
	}
}
