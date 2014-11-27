package util.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import util.common.*;
import controllers.milmodb.*;

public class CommonFunc {
	
	public static Map<String, String> StringToMap(String string) throws IOException {
		BufferedReader reader = new BufferedReader(new StringReader(string));
		Map<String, String> map = new HashMap<String, String>();
		String[] Array;
		String line = reader.readLine().replace("{", "").replace("}", "");
		Array = line.split(",");
		for (int i = 0; i < Array.length; i++) {
			String str = Array[i].toString().trim();
			String key = str.substring(0,str.indexOf("="));
			String Value = str.substring(str.indexOf("=")+1);
			map.put(key, Value);
		}
		return map;
	}
	
	public static String from_time(Map<String, String> mapdata, String key){
		return (mapdata.get(key) != null) ? mapdata.get(key).substring(0, 5).replace(Fixed.strHOUR, "") : null;
	}
	
	public static String to_time(Map<String, String> mapdata, String key){
		return (mapdata.get(key) != null) ? mapdata.get(key).substring(7, 12).replace(Fixed.strHOUR, "") : null;
	}
	
	public static void CreateCol(List<Map<String, String>> columnlist, List<String> ColList) {
		for (Map<String, String> c : columnlist){
			ColList.add(c.get(ColumnNames.COLUMN_NAME).toString());
		}
	}
  
	public static Boolean func_setBit(Map<String, String> mapdata, String key){
		Boolean rb = null;
		switch (mapdata.get(key)) {
		case Fixed.strARI:
			rb = true;
			break;
		case Fixed.strNASHI:
			rb = false;
			break;
		case Fixed.strTAISHONASHI:
			rb = null;
			break;
		}
		return rb;
	}
	
	public static String func_trim(String val) {
		if (val == null) return val;
		return (val.trim().length() == 0) ? null : val.trim();
	}
	
	public static String replaceEn(String val) {
		if ( val == null) return val;
		return val.replace(Fixed.strEN, "").replace(",", "").replace(".", "");
	}
	
	public static String replaceNin(String val) {
		if ( val == null) return val;
		return val.replace(Fixed.strNIN, "").replace(",", "").replace(".", "");
	}
	
	public static String Normalize(String val){
		if ( val == null) return val;
		return Normalizer.normalize(val, Form.NFKC);
	}
	
	public static String func_replace(String key, String val){
		if (val == null) return val;
		return ReplaceEnum.getreplacevalue(key, val);
	}
	
	public static String ConvertDate(String val) {
		String[] valArray = val.split("/");
		if (valArray.length == 3 ) return valArray[0] + Zerofill(valArray[1]) + Zerofill(valArray[2]);
		return val;
	}
	
	public static String Zerofill(String Val){
		return String.format("%2s", Val).replace(' ', '0');
	}
	
	public static String replaceTime(String val) {
		if ( val == null) return val;
		if ( val.length() == 0) return null;
		if (!Pattern.compile("^\\d*時\\d*分~\\d*時\\d*分$").matcher(val).find()) return val;
		return ConvertTime(val);
	}
	
	public static String ConvertTime(String val) {
		String starthour = val.substring(0, val.indexOf(Fixed.strHOUR));
		String startminute= val.substring(val.indexOf(Fixed.strHOUR)+1, val.indexOf(Fixed.strMINUTE));
		String endhour = val.substring(val.indexOf(Fixed.strMINUTE)+2, val.lastIndexOf(Fixed.strHOUR));
		String endminute = val.substring(val.lastIndexOf(Fixed.strHOUR)+1, val.lastIndexOf(Fixed.strMINUTE));
		return String.format("%s時%s分~%s時%s分", Zerofill(starthour), Zerofill(startminute), Zerofill(endhour),Zerofill(endminute));
	}
	
	public static boolean func_Match_NullTrue(String val, Pattern p) {
		if (val == null) return true;
		return p.matcher(val).find();
	}
	
	public static boolean func_Match_NullFalse(String val, Pattern p) {
		if (val == null) return false;
		return p.matcher(val).find();
	}
	
	public static boolean func_indexOf(String val, String keyword) {
		if (val != null && val.indexOf(keyword) != -1 ) return false;
		return true;
	}
	
	public static boolean func_equaltrue(String val, String keyword) {
		if (val == null) return false;
		return keyword.equals(val);
	}
	
	public static boolean func_equalfalse(String val, String keyword) {
		if (val == null) return true;
		return !keyword.equals(val);
	}
	
	public static boolean func_null(String val) {
		return val != null;
	}
	
	public static boolean func_length(String val, int length) throws UnsupportedEncodingException {
		if (val == null) return true;
		return (length >= val.getBytes("Shift-JIS").length);
	}
	
}
