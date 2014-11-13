package controllers.milmodb;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.Map;

import util.common.ColumnNames;

public class Converter {
	
	public static List<Map<String, String>> datalist;
	public static List<Map<String, String>> columnlist;
	
	public static final String strEn = "円";
	public static final String strNin = "人";
	public static final String strhour = "時";
	public static final String strminute = "分";
	public static final String[] repostcode = {"〒","-","?"};
	public static final String[] retelfax = {"（","）","－","ー","-","‐","?",};
	
	public Converter(List<Map<String, String>> datalist
			,List<Map<String, String>> columnlist) {
		super();
		this.datalist = datalist;
		this.columnlist = columnlist;
	}
	
	public List<Map<String, String>> isCovert() {
		List<Map<String, String>> newdatalist = this.datalist;
		for ( Map<String, String> c : columnlist){
			String cv = c.get(ColumnNames.CONV_LIST);
			for(int i=0;cv != null && i < cv.length();i++){
				switch (String.valueOf(cv.charAt(i))) {
					case "A":
						ReplaceConverter(newdatalist,c.get(ColumnNames.COLUMN_NAME));
						break;
					case "B":
						NormalizeConverter(newdatalist,c.get(ColumnNames.COLUMN_NAME));
						break;
					case "D":
						PersonConverter(newdatalist,c.get(ColumnNames.COLUMN_NAME));
						break;
					case "E":
						MoneyConverter(newdatalist,c.get(ColumnNames.COLUMN_NAME));
						break;
					case "F":
						TimeConverter(newdatalist,c.get(ColumnNames.COLUMN_NAME));
						break;
				}
			}
			TrimConverter(newdatalist,c.get(ColumnNames.COLUMN_NAME));
		}
		return newdatalist;
	}
	
	public static void TrimConverter(List<Map<String, String>>newdatalist, String column_name){
		for ( Map<String, String> d : datalist){
			d.put(column_name, func_trim(d.get(column_name)));
		}
	}
	
	public static void ReplaceConverter(List<Map<String, String>>newdatalist, String column_name){
		for ( Map<String, String> d : datalist){
			d.put(column_name, func_replace(column_name, d.get(column_name)));
		}
	}
	
	public static void NormalizeConverter(List<Map<String, String>>newdatalist, String column_name){
		for ( Map<String, String> d : datalist){
			d.put(column_name, Normalize(d.get(column_name)));
		}
	}
		
	public static void PersonConverter(List<Map<String, String>>newdatalist, String column_name){
		for ( Map<String, String> d : datalist){
			d.put(column_name, replaceNin(d.get(column_name)));
		}
	}
	
	public static void MoneyConverter(List<Map<String, String>>newdatalist, String column_name){
		for ( Map<String, String> d : datalist){
			d.put(column_name, replaceEn(d.get(column_name)));
		}
	}
	
	public static void TimeConverter(List<Map<String, String>>newdatalist, String column_name){
		for ( Map<String, String> d : datalist){
			d.put(column_name, replaceTime(d.get(column_name)));
		}
	}
	
	public static String replaceEn(String Val) {
		String rVal = null;
		if ( Val != null) {
			rVal = Val.replace(strEn, "").replace(",", "").replace(".", "");
		}
		return rVal;
	}
	
	public static String replaceNin(String Val) {
		String rVal = null;
		if ( Val != null) {
			rVal = Val.replace(strNin, "").replace(",", "").replace(".", "");
		}
		return rVal;
	}
	
	public static String func_trim(String Val) {
		String rVal = null;
		rVal = (Val != null) ? Val.trim(): null;
		rVal = (Val != null && Val.length() == 0) ? null : rVal;
		return rVal;
	}
	
	public static String replaceTime(String Val) {
		String rVal = null;
		if ( Val != null) {
			rVal = ConvertTime(Val);
		}
		return rVal;
	}
	
	public static String func_replace(String Key, String Val ){
		String rVal = null;
		if ( Val != null) {
			switch (Key){
			case ColumnNames.POSTCODE:
				for (int i = 0; i < repostcode.length; i++){
					Val = Val.replace(repostcode[i], "");
				}
				rVal = Val;
				break;
			case ColumnNames.TEL:
			case ColumnNames.FAX:
				for (int i = 0; i < retelfax.length; i++){
					Val = Val.replace(retelfax[i], "");
				}
				rVal = Val;
				break;
			case ColumnNames.FOUNDING_DAY:
				int index = Val.indexOf("※");
				Val = (index > 0 )? Val.substring(0, index) : Val;
				rVal = ConvertDate(Val);
				break;
			case ColumnNames.REPAYMENTRATE:
				rVal = Val.replace("%", "");
				break;
			}
		}
		return rVal;
	}
	
	public static String Normalize(String Val){
		String rVal = null;
		if (Val != null){
			rVal = Normalizer.normalize(Val, Form.NFKC);
		}
		return rVal;
	}
	
	public static String ConvertDate(String Val) {
		String[] Vals = Val.split("/");
		String rVal = null;
		if (Vals.length == 3 ) {
			rVal = Vals[0] + Zerofill(Vals[1]) + Zerofill(Vals[2]);
		}
		return rVal;
	}
	
	public static String ConvertTime(String Val) {
		String rVal = null;
		int index1 = Val.indexOf(strhour);
		String starthour = Val.substring(0, index1);
		int index2 = Val.indexOf(strminute);
		String startminute= Val.substring(index1+1, index2);
		int index3 = Val.lastIndexOf(strhour);
		String endhour = Val.substring(index2+2, index3);
		int index4 = Val.lastIndexOf(strminute);
		String endminute = Val.substring(index3+1, index4);
		if (index1 == 0){
			rVal = null;
		} else {
			rVal = String.format("%s時%s分～%s時%s分", Zerofill(starthour), Zerofill(startminute), Zerofill(endhour),Zerofill(endminute));
		}			
		return rVal;
	}
	
	public static String Zerofill(String Val){
		String rVal = String.format("%2s", Val).replace(' ', '0');
		return rVal;
	}

}
