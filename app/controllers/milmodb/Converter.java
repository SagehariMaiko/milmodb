package controllers.milmodb;

import java.util.*;
import java.text.Normalizer;
import java.text.Normalizer.Form;

import util.common.ColumnNames;
import util.common.ViewNames;

public class Converter {
	public IConvert[] converters = new IConvert[] {
			new OfficeConverter(), 
			new PersonConverter()};
	
	public final List<Map<String, String>> datalist;
	
	public Converter(List<Map<String, String>> datalist) {
		super();
		this.datalist = datalist;
	}
	
	public List<Map<String, String>> isCovert(DB db) {
		List<Map<String, String>> newdatalist = this.datalist;
		for (IConvert v : converters) {
			newdatalist = v.Convert(newdatalist, db);
		}
		return newdatalist;
	}

	public static interface IConvert {
		public List<Map<String, String>> Convert(List<Map<String, String>> s,DB db);
	}
	
	public static class OfficeConverter implements IConvert {
		public List<Map<String, String>> Convert(List<Map<String, String>> data,DB db) {
			List<Map<String, String>> convertlist = Dao.selectData(db, ViewNames.V_OFFICE_CONVERT);
			for ( Map<String, String> d : data){
				for ( Map<String, String> c : convertlist){
					String Key = c.get(ColumnNames.COLUMN_NAME);
					if(d.containsKey(Key)){
						d.put(Key, conv1(Key, d));
					}
				}
			}
			return data;
		}
	}
	
	public static String conv1(String Key, Map<String, String> d ){
		String str = d.get(Key);
		if ( str != null) {
			str = Normalize(str);
			switch (Key){
			case ColumnNames.POSTCODE:
				str = str.replaceAll("〒", "").replaceAll("-", "");
				break;
			case ColumnNames.TEL:
			case ColumnNames.FAX:
				str = str.replaceAll("-", "").replaceAll("‐", "");
				break;
			case ColumnNames.FOUNDING_DAY:
				int index = str.indexOf("※");
				str = (index > 0 )? str.substring(0, index) : str;
				str = StringtoDate(str);
				break;
			}			
		}
		return str;
	}
	

	public static class PersonConverter implements IConvert {
		public List<Map<String, String>> Convert(List<Map<String, String>> data,DB db) {
			List<Map<String, String>> convertlist = Dao.selectData(db, ViewNames.V_PERSONS);
			for ( Map<String, String> d : data){
				for ( Map<String, String> c : convertlist){
					String Key = c.get(ColumnNames.COLUMN_NAME);
						if (d.containsKey(Key)){
							d.put(Key, replaceNin(Key, d));
						}						
				}
			}
			return data;
		}
	}
	
	public static String replaceNin(String Key, Map<String, String> d) {
		String str = d.get(Key);
		if ( str != null) {
			str = Normalize(str).replaceAll("人", "");
		}
		return str;
	}
	
	public static String Normalize(String s){
		String str = Normalizer.normalize(s, Form.NFKC);
		return str;
	}
			
	public static String StringtoDate(String s) {
		String[] strs = s.split("/");
		if (strs.length == 3 ) {
			s = strs[0] + String.format("%2s", strs[1]).replace(' ', '0') + String.format("%2s", strs[2]).replace(' ', '0');
		}
		return s;
	}
	
}
