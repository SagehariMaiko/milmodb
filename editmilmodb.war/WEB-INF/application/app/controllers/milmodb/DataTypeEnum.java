package controllers.milmodb;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import util.common.*;
import util.function.CommonFunc;
import util.function.ReplaceEnum.ReplaceList;

public class DataTypeEnum {
	public enum DataType {
		DATATYPE_INT(ColumnNames.INT, new intsetvalue()),
		DATATYPE_NVARCHAR(ColumnNames.NVARCHAR, new nvarcharsetvalue()),
		DATATYPE_BIT(ColumnNames.BIT, new bitsetvalue())
		;

		String datatype;
		ISetValue setvalue;

		private DataType(String datatype, ISetValue setvalue){
			this.datatype = datatype;
			this.setvalue = setvalue;
		}

		public static DataType tableNameOf(String datatype){
			for (DataType t : values()) {
				if (t.datatype.equals(datatype)) return t;
			}
			throw new RuntimeException();
		}

		public void SetValue(PreparedStatement ps, int i , String key, Map<String,String> d) throws SQLException{
			this.setvalue.SetValue(ps, i, key, d);
		}

		static interface ISetValue{
			void SetValue(PreparedStatement ps, int i , String key, Map<String,String> d) throws SQLException;	
		}

		public static class bitsetvalue implements ISetValue {
			public void SetValue(PreparedStatement ps, int i , String key, Map<String,String> d) throws SQLException{
				ps.setObject(i + 1, Fixed.getBoolean(d.get(key)));
			}
		}

		public static class nvarcharsetvalue implements ISetValue {
			public void SetValue(PreparedStatement ps, int i , String key, Map<String,String> d) throws SQLException{
				ps.setObject(i + 1, TimeFromToEnum.getNewVal(key, d));
			}
		}

		public static class intsetvalue implements ISetValue {
			public void SetValue(PreparedStatement ps, int i , String key, Map<String,String> d) throws SQLException{
				ps.setObject(i + 1, d.get(key));
			}
		}
	}

	public static void getValue(PreparedStatement ps, int i , String datatype, String key, Map<String,String> d) throws SQLException{
		DataType setdatatype = DataType.tableNameOf(datatype);
		setdatatype.SetValue(ps, i, key, d);
	}
}
