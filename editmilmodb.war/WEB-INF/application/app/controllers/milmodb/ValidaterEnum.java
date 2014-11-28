package controllers.milmodb;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import util.common.ColumnNames;
import util.common.Fixed;
import util.function.CommonFunc;


public class ValidaterEnum {
	public enum ValidaterE {
		MATCHNULLTRUE_VALIDATER("1", new MatchNullTrueValidater()),
		CORRUPTION_VALIDATER("2", new CorruptionValidater()),
		DATANOTHING_VALIDATER("3", new DatanothingValidater()),
		CAUTIONTIME_VALIDATER("4", new CautiontimeValidater()),
		MATCHNULLFALSE_VALIDATER("5", new MatchNullFalseValidater()),
		SERVICENAME_VALIDATER("6", new ServiceNameValidater()),
		NOTNULL_VALIDATER("7", new NotNullValidater()),
		LENGTHOVER_VALIDATER("8", new LengthOverValidater())
		;

		String validatetype;
		IValidater validater;

		private ValidaterE (String validatetype, IValidater validater) {
			this.validatetype = validatetype;
			this.validater = validater;
		 }

		public static ValidaterE tableNameOf(String validatetype) {
			for(ValidaterE t : values()) {
				if (t.validatetype.equals(validatetype)) return t;
			}
			throw new RuntimeException();
		}

		public void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException, UnsupportedEncodingException{
			this.validater.Validate(newdatalist, c, validatetype);
		}

		static interface IValidater {
			void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException, UnsupportedEncodingException;
		}

		public static class LengthOverValidater implements IValidater{
			public void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException, UnsupportedEncodingException{
				for ( Map<String, String> d : newdatalist){
					putvalidate(d,CommonFunc.func_length(d.get(c.get(ColumnNames.COLUMN_NAME)), Integer.valueOf(c.get(ColumnNames.LENGTH))),validatetype, c.get(ColumnNames.COLUMN_NAME));
				}
			}
		}

		public static class NotNullValidater implements IValidater{
			public void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException{
				for ( Map<String, String> d : newdatalist){
					putvalidate(d,CommonFunc.func_null(d.get(c.get(ColumnNames.COLUMN_NAME))),validatetype, c.get(ColumnNames.COLUMN_NAME));
				}
			}
		}

		public static class ServiceNameValidater implements IValidater{
			public void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException{
				for ( Map<String, String> d : newdatalist){
					if (d.get(ColumnNames.SERVICE_TYPE) != null) {
						String servicename = d.get(ColumnNames.SERVICE_TYPE).replace(" ", "").replace("　", "").replace("外部サービス利用型", "");
						putvalidate(d,CommonFunc.func_equaltrue(servicename, Validater.servicetype),validatetype, c.get(ColumnNames.COLUMN_NAME));
					}
				}
			}
		}

		public static class MatchNullFalseValidater implements IValidater{
			public void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException{
				for ( Map<String, String> d : newdatalist){
					Pattern p = Fixed.getPettern(c.get(ColumnNames.PATTERNTYPE));
					putvalidate(d,CommonFunc.func_Match_NullFalse(d.get(c.get(ColumnNames.COLUMN_NAME)), p), validatetype, c.get(ColumnNames.COLUMN_NAME));
				}
			}
		}

		public static class CautiontimeValidater implements IValidater{
			public void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException{
				for ( Map<String, String> d : newdatalist){
					putvalidate(d,CommonFunc.func_equalfalse(d.get(c.get(ColumnNames.COLUMN_NAME)), Fixed.CAUTIONTIME),validatetype, c.get(ColumnNames.COLUMN_NAME));
				}
			}
		}

		public static class DatanothingValidater implements IValidater{
			public void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException{
				for ( Map<String, String> d : newdatalist){
					putvalidate(d,CommonFunc.func_equalfalse(d.get(c.get(ColumnNames.COLUMN_NAME)), Fixed.DATANOTHING),validatetype, c.get(ColumnNames.COLUMN_NAME));
				}
			}
		}

		public static class CorruptionValidater implements IValidater{
			public void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException{
				for ( Map<String, String> d : newdatalist){
					putvalidate(d,CommonFunc.func_indexOf(d.get(c.get(ColumnNames.COLUMN_NAME)), "?"),validatetype, c.get(ColumnNames.COLUMN_NAME));
				}
			}
		}

		public static class MatchNullTrueValidater implements IValidater{
			public void Validate(List<Map<String, String>>newdatalist, Map<String, String> c, String validatetype) throws IOException{
				for ( Map<String, String> d : newdatalist){
					Pattern p = Fixed.getPettern(c.get(ColumnNames.PATTERNTYPE));
					putvalidate(d,CommonFunc.func_Match_NullTrue(d.get(c.get(ColumnNames.COLUMN_NAME)), p), validatetype, c.get(ColumnNames.COLUMN_NAME));
				}
			}
		}
	}

	public static void putvalidate(Map<String, String> d, boolean b, String validtype, String Key) throws IOException{
		if(!b){
			Map<String, String> invalidlist = new HashMap<String, String>();
			if (d.containsKey(ColumnNames.VALIDATE_TYPE)){
				invalidlist = CommonFunc.StringToMap(d.get(ColumnNames.VALIDATE_TYPE).toString());
				if (invalidlist.containsKey(Key)) {
					invalidlist.put(Key, invalidlist.get(Key).toString() + ":" +validtype);
				} else {
					invalidlist.put(Key, validtype);
				}
			} else {
				invalidlist.put(Key, validtype);
			}
			d.put(ColumnNames.VALIDATE, String.valueOf(b));
			d.put(ColumnNames.VALIDATE_TYPE, invalidlist.toString());
		}
	}

	public static void validates(String validatetype, List<Map<String, String>>newdatalist, Map<String, String> c) throws IOException{
		ValidaterE validate = ValidaterE.tableNameOf(validatetype);
		validate.Validate(newdatalist, c, validatetype);	
	}
}
