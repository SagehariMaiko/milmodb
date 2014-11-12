package controllers.milmodb;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import util.common.*;

public class Validater {
	public static List<Map<String, String>> datalist;
	public static List<Map<String, String>> columnlist;
	public static String servicetype;
	
	public static final Pattern postcode = Pattern.compile("^\\d{7}$");
	public static final Pattern latitude = Pattern.compile("^\\d{2}.\\d{15}$");
	public static final Pattern longitude = Pattern.compile("^\\d{3}.\\d{15}");	
	public static final Pattern tel = Pattern.compile("^\\d{10}$|^\\d{11}$");
	public static final Pattern fax = Pattern.compile("^\\d{10}$");
	public static final Pattern office_no = Pattern.compile("^\\d{10}$");
	public static final Pattern founding_day = Pattern.compile("^\\d{8}$");
	public static final Pattern person = Pattern.compile("^\\d{1,3}$");
	public static final Pattern price = Pattern.compile("^\\d{1,9}$");
	public static final Pattern percent = Pattern.compile("^\\d{1,2}$");
	public static final Pattern time = Pattern.compile("^[0-2]\\d時[0-5]\\d分～[0-2]\\d時[0-5]\\d分$");
	public static final Pattern hpaddress = Pattern.compile("^(https?|ftp)(:\\/\\/[-_.!~*\\'()a-zA-Z0-9;\\/?:\\@&=+\\$,%#]+)$");
	
	public static final String Question = "?";
	public static final String DataNothing = "データーなし";
	public static final String CautionTime = "00時00分～00時00分";
	public static final String strAri = "あり";
	public static final String strNashi = "なし";
	public static final String strTaisyoNashi = "対象なし";
	
	public Validater(List<Map<String, String>> datalist, List<Map<String, String>> columnlist, String servicetype) {
		super();
		this.datalist = datalist;
		this.columnlist = columnlist;
		this.servicetype = servicetype.replace(" ", "").replace("　", "");
	}
	
	public List<Map<String, String>> isValid() {
		List<Map<String, String>> newdatalist = this.datalist;
		for ( Map<String, String> c : columnlist){
			String cv = c.get(ColumnNames.VALID_LIST);
			for(int i=0;cv != null && i < cv.length();i++){
				String validtype = String.valueOf(cv.charAt(i));
				switch (validtype) {
					case "A":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, postcode);
						break;
					case "B":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, latitude);
						break;
					case "C":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, longitude);
						break;
					case "D":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, tel);
						break;
					case "E":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, fax);
						break;
					case "F":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, office_no);
						break;
					case "G":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype,founding_day );
						break;
					case "H":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, person);
						break;
					case "I":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, price);
						break;
					case "J":
						indexOfValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, Question);
						break;
					case "K":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, time);
						break;
					case "L":
						indexOfValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, DataNothing);
						break;
					case "M":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, percent);
						break;
					case "N":
						indexOfValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, CautionTime);
						break;
					case "O":
						MatchValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype, hpaddress);
						break;
					case "P":
						YesNoValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype);
						break;
					case "Q":
						ServiceNameValidater(newdatalist,c.get(ColumnNames.COLUMN_NAME),validtype);
						break;
				}
			}
		}
		return newdatalist;
	}
	
	public static void MatchValidater(List<Map<String, String>>newdatalist, String Key, String validtype, Pattern p){
		for ( Map<String, String> d : datalist){
			putvalidate(d,func_Match(d.get(Key), p),validtype, Key);
		}
	}

	public static void indexOfValidater(List<Map<String, String>>newdatalist, String Key, String validtype, String Keyword){
		for ( Map<String, String> d : datalist){
			putvalidate(d,func_indexOf(d.get(Key), Keyword),validtype, Key);
		}
	}
	
	public static void YesNoValidater(List<Map<String, String>>newdatalist, String Key, String validtype){
		for ( Map<String, String> d : datalist){
			putvalidate(d,func_boolean(d.get(Key)),validtype, Key);
		}
	}
	
	public static void ServiceNameValidater(List<Map<String, String>>newdatalist, String Key, String validtype){
		for ( Map<String, String> d : datalist){
			putvalidate(d,func_servicename(d.get(Key)),validtype, Key);
		}
	}
	
	public static boolean func_servicename(String Val) {
		Val = Val.replace(" ", "").replace("　", "").replace("外部サービス利用型", "");
		if (Val != null && servicetype.equals(Val)) {
			return true;
		} else {
			return false;
		}
	}	
	
	public static boolean func_boolean(String Val) {
		if (strTaisyoNashi.equals(Val) || strAri.equals(Val) || strNashi.equals(Val)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean func_indexOf(String Val, String keyword) {
		if (Val != null && Val.indexOf(keyword) != -1 ) {
			return false;
		} else {
			return true;
		}
	}	
	
	public static boolean func_Match(String Val, Pattern p) {
		if (Val != null){
			return p.matcher(Val).find();
		} else {
			return true;
		}		
	}
		
	public static void putvalidate(Map<String, String> d, boolean b, String validtype, String Key){
		if(!b){
			String pvalidtype = (d.containsKey(ColumnNames.VALIDATE)) ? d.get(ColumnNames.VALIDATE_TYPE) + ", " + Key + ":" + validtype : Key + ":" + validtype;
			d.put(ColumnNames.VALIDATE, String.valueOf(b));
			d.put(ColumnNames.VALIDATE_TYPE, pvalidtype);				
		}
	}
	
	
	
}
