package util.common;

import java.util.regex.Pattern;

public class Fixed {
	//formSerCd(SQLDataBaseと一致させる)
	public static final String HOME_CARE_FORMSERCD = "110";
	public static final String HOME_BATH_FORMSERCD = "120";
	public static final String HOME_NURSE_FORMSERCD = "130";
	public static final String HOME_REHABILITATION_FORMSERCD = "140";
	public static final String NIGHT_CARE_FORMSERCD = "710";
	public static final String ROUTINE_HOME_FORMSERCD = "760";
	public static final String SMALL_HOME_FORMSERCD = "730";
	public static final String MIX_SERVICE_FORMSERCD = "770";
	public static final String SHORT_LIFE_FORMSERCD = "210";
	public static final String SHORT_HEALTH_FORMSERCD = "220";
	public static final String SHORT_MEDICAL_FORMSERCD = "230";
	public static final String CARE_WELFARE_FORMSERCD = "510";
	public static final String CARE_HEARLTH_FORMSERCD = "520";
	public static final String CARE_MEDICAL_FORMSERCD = "530";
	public static final String DEMENTIA_FORMSERCD = "320";
	public static final String LOCAL_WELFARE_FORMSERCD = "540";
	public static final String LOCAL_CHARGE_FORMSERCD = "361";
	public static final String LOCAL_LIGHT_FORMSERCD = "362";
	public static final String TOOL_RENTAL_FORMSERCD = "170";
	public static final String TOOL_SALL_FORMSERCD = "410";
	public static final String LIFE_CHRGE_FORMSERCD = "331";
	public static final String LIFE_LIGHT_FORMSERCD = "332";
	
	public static final String UPDATE = "UPDATE";
	public static final String INSERT = "INSERT";
	
	public static final String CAUTIONTIME = "00時00分~00時00分";
	public static final String DATANOTHING = "データーなし";
	public static final String strEN = "円";
	public static final String strNIN = "人";
	public static final String strHOUR = "時";
	public static final String strMINUTE = "分";
	public static final String[] REPOSTCODE = {"〒","-","?"};
	public static final String[] RETELFAX = {"（","）","－","ー","-","‐","?",};
	public static final String strARI = "あり";
	public static final String strNASHI = "なし";
	public static final String strTAISHONASHI = "対象なし";
	
	public enum PatternList {
		POSTCODE("postcode", Pattern.compile("^\\d{7}$")),
		TIME("time", Pattern.compile("^([0-1][0-9]|[2][0-4])時[0-5][0-9]分~([0-1][0-9]|[2][0-4])時[0-5][0-9]分$")),
		PERCENT("percent", Pattern.compile("^\\d{1,2}$")),
		PERSON("person", Pattern.compile("^\\d{1,3}$")),
		PRICE("price", Pattern.compile("^\\d{1,9}$")),
		LATITUDE("latitude", Pattern.compile("^\\d{2}.\\d{15}$")),
		LONGITUDE("longitude", Pattern.compile("^\\d{3}.\\d{15}")),
		FOUNDING_DAY("founding_day", Pattern.compile("^\\d{8}$")),
		FAX("fax", Pattern.compile("^\\d{10}$")),
		OFFICE_NO("office_no", Pattern.compile("^\\d{10}$")),
		TEL("tel", Pattern.compile("^\\d{10}$|^\\d{11}$")),
		YESNO("yesno", Pattern.compile("^あり$|^なし$|^対象なし$")),
		HP_ADDRESS("hp_address", Pattern.compile("^(https?|ftp)(:\\/\\/[-_.!~*\\'()a-zA-Z0-9;\\/?:\\@&=+\\$,%#]+)$"))
		;
		
		String patterntype;
		Pattern p;
		
		private PatternList(String patterntype, Pattern p){
			this.patterntype = patterntype;
			this.p = p;
		}
		
		public static PatternList patternof(String patterntype){
			for (PatternList t : values()){
				if (t.patterntype.equals(patterntype)) return t;
			}
			throw new RuntimeException();
		}
		
	}
	
	public static Pattern getPettern(String patterntype){
		PatternList PL = PatternList.patternof(patterntype);
		return PL.p;
	}
	
	public enum BitList{
		ARI(Fixed.strARI, true),
		NASHI(Fixed.strNASHI, false),
		TISYONASHI(Fixed.strTAISHONASHI, null)
		;
		
		String value;
		Boolean b;
		
		private BitList(String value, Boolean b){
			this.value = value;
			this.b = b;
		}
		
		public static BitList patternof(String value){
			for (BitList t : values()){
				if (t.value.equals(value)) return t;
			}
			throw new RuntimeException();
		}
	}
	
	public static Boolean getBoolean(String value){
		BitList BL = BitList.patternof(value);
		return BL.b;
	}

}
