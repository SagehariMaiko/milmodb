package util.function;

import util.common.ColumnNames;
import util.common.Fixed;

public class ReplaceEnum {
	public enum ReplaceList {
		POSTCODE_REPLACE(ColumnNames.POSTCODE, new ReplacePostcode()),
		TEL_REPLACE(ColumnNames.TEL, new ReplaceTelFax()),
		FAX_REPLACE(ColumnNames.FAX, new ReplaceTelFax()),
		FOUNDING_DAY_REPLACE(ColumnNames.FOUNDING_DAY, new ReplaceFoundingDay()),
		REPAYMENTRATE_REPLACE(ColumnNames.REPAYMENTRATE, new ReplaceRepaymentrate())
		;
		
		String key;
		IReplacer replacer;
		
		private ReplaceList(String key, IReplacer replacer){
			this.key = key;
			this.replacer = replacer;
		}
		
		public static ReplaceList tableNameOf(String key){
			for (ReplaceList t : values()) {
				if (t.key.equals(key)) return t;
			}
			throw new RuntimeException();
		}
		
		public String Replace(String val){
			return this.replacer.Replace(val);
		}
		
		static interface IReplacer{
			String Replace(String val);
		}
		
		public static class ReplaceRepaymentrate implements IReplacer {
			public String Replace(String val){
				return val.replace("%", "");
			}
		}
		
		public static class ReplaceFoundingDay implements IReplacer {
			public String Replace(String val){
				if (val.indexOf("※") == -1) return val;
				return CommonFunc.ConvertDate(val.substring(0, val.indexOf("※")));
			}
		}
		
		public static class ReplaceTelFax implements IReplacer {
			public String Replace(String val){
				for (int i = 0; i < Fixed.RETELFAX.length; i++){
					val = val.replace(Fixed.RETELFAX[i], "");
				}
				return val;
			}
		}
		
		public static class ReplacePostcode implements IReplacer {
			public String Replace(String val){
				for (int i = 0; i < Fixed.REPOSTCODE.length; i++){
					val = val.replace(Fixed.REPOSTCODE[i], "");
				}
				return val;
			}
		}
	}
	
	public static String getreplacevalue(String key, String val){
		ReplaceList replacelist = ReplaceList.tableNameOf(key);	
		return replacelist.Replace(val);
	}
}
