package models;

import java.util.List;

import javax.swing.text.TabExpander;

public class Test {
	public static enum OfficeType {
		HOME_CARE("home_care", new HomeCareFieldNameSupplier());
		//HOME_BATH("home_bath", V_home_bath.class);
		
		String tableName;
		IFieldNameSupplier supplier;
		OfficeType(String tableName, IFieldNameSupplier supplier) {
			this.tableName = tableName;
			this.supplier = supplier;
		}
		
		public static OfficeType tableNameOf(String tableName) {
			for(OfficeType t : values()) {
				if (t.tableName.equals(tableName)) return t;
			}
			throw new RuntimeException();
		}
		public List<String> getFieldNames() {
			return this.supplier.getFieldNames();
		}
		
		static interface IFieldNameSupplier {
			List<String> getFieldNames();
		}
		
		public static class HomeCareFieldNameSupplier implements IFieldNameSupplier {
			@Override
			public List<String> getFieldNames() {
				// TODO Auto-generated method stub
				return null;
			}
		}
	}
	
	public static void main() {
		String tableName = "home_care";
		OfficeType type = OfficeType.tableNameOf(tableName);
		type.getFieldNames();	
	}
}
