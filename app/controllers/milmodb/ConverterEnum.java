package controllers.milmodb;

import java.util.List;
import java.util.Map;

import util.common.*;
import util.function.CommonFunc;


public class ConverterEnum {
	public enum ConverterE {
		REPLACE_CONVERTER("A", new ReplaceConverter()),
		NORMALIZE_CONVERTER("B", new NormalizeConverter()),
		PERSON_CONVERTER("D", new PersonConverter()),
		MONEY_CONVERTER("E", new MoneyConverter()),
		TIME_CONVERTER("F", new TimeConverter()),
		TRIM_CONVERTER("G", new TrimConverter())
		;

		String converttype;
		IConverter converter;

		private ConverterE (String converttype, IConverter converter) {
			this.converttype = converttype;
			 this.converter = converter;
		}

		public static ConverterE tableNameOf(String converttype) {
			for(ConverterE t : values()) {
				if (t.converttype.equals(converttype)) return t;
			}
			throw new RuntimeException();
		}

		public void Convert(List<Map<String, String>>newdatalist, String column_name){
			this.converter.Convert(newdatalist, column_name);
		}

		static interface IConverter {
			void Convert(List<Map<String, String>>newdatalist, String column_name);
		}

		public static class ReplaceConverter implements IConverter{
			public void Convert(List<Map<String, String>>newdatalist, String column_name){
				for ( Map<String, String> d : newdatalist){
					d.put(column_name, CommonFunc.func_replace(column_name, d.get(column_name)));
				}
			}
		}

		public static class TrimConverter implements IConverter{
			public void Convert(List<Map<String, String>>newdatalist, String column_name){
				for ( Map<String, String> d : newdatalist){
					if (!ColumnNames.VALIDATE.equals(column_name) && !ColumnNames.VALIDATE_TYPE.equals(column_name)){
						d.put(column_name, CommonFunc.func_trim(d.get(column_name)));
					}
				}
			}
		}

		public static class NormalizeConverter implements IConverter{
			public void Convert(List<Map<String, String>>newdatalist, String column_name){
				for ( Map<String, String> d : newdatalist){
					d.put(column_name, CommonFunc.Normalize(d.get(column_name)));
				}
			}
		}

		public static class PersonConverter implements IConverter{
			public void Convert(List<Map<String, String>>newdatalist, String column_name){
				for ( Map<String, String> d : newdatalist){
					d.put(column_name, CommonFunc.replaceNin(d.get(column_name)));
				}
			}
		}

		public static class MoneyConverter implements IConverter{
			public void Convert(List<Map<String, String>>newdatalist, String column_name){
				for ( Map<String, String> d : newdatalist){
					d.put(column_name, CommonFunc.replaceEn(d.get(column_name)));
				}
			}
		}

		public static class TimeConverter implements IConverter{
			public void Convert(List<Map<String, String>>newdatalist, String column_name){
				for ( Map<String, String> d : newdatalist){
					d.put(column_name, CommonFunc.replaceTime(d.get(column_name)));
				}
			}
		}
	}

	public static void converts(String converttype, List<Map<String, String>>newdatalist, String column_name){
		ConverterE convert = ConverterE.tableNameOf(converttype);
		convert.Convert(newdatalist, column_name);
	}
}
