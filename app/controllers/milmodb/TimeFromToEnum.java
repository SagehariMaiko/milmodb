package controllers.milmodb;

import java.util.Map;

import util.common.ColumnNames;
import util.common.Fixed;

public class TimeFromToEnum {
	public enum TimeFromTo {
		FROM_OFFICETIMEWEEK_PARTITION(ColumnNames.FROM_OFFICE_TIME_WEEK, ColumnNames.OFFICE_TIME_WEEK, new FromTime()),
		TO_OFFICETIMEWEEK_PARTITION(ColumnNames.TO_OFFICE_TIME_WEEK, ColumnNames.OFFICE_TIME_WEEK, new ToTime()),
		FROM_OFFICETIMESAT_PARTITION(ColumnNames.FROM_OFFICE_TIME_SAT, ColumnNames.OFFICE_TIME_SAT, new FromTime()),
		TO_OFFICETIMESAT_PARTITION(ColumnNames.TO_OFFICE_TIME_SAT, ColumnNames.OFFICE_TIME_SAT, new ToTime()),
		FROM_OFFICETIMESUN_PARTITION(ColumnNames.FROM_OFFICE_TIME_SUN, ColumnNames.OFFICE_TIME_SUN, new FromTime()),
		TO_OFFICETIMESUN_PARTITION(ColumnNames.TO_OFFICE_TIME_SUN, ColumnNames.OFFICE_TIME_SUN, new ToTime()),
		FROM_OFFICETIMEHOL_PARTITION(ColumnNames.FROM_OFFICE_TIME_HOL, ColumnNames.OFFICE_TIME_HOL, new FromTime()),
		TO_OFFICETIMEHOL_PARTITION(ColumnNames.TO_OFFICE_TIME_HOL, ColumnNames.OFFICE_TIME_HOL, new ToTime()),
		FROM_SERVICETIMEWEEK_PARTITION(ColumnNames.FROM_SERVICE_TIME_WEEK, ColumnNames.SERVICE_TIME_WEEK, new FromTime()),
		TO_SERVICETIMEWEEK_PARTITION(ColumnNames.TO_SERVICE_TIME_WEEK, ColumnNames.SERVICE_TIME_WEEK, new ToTime()),
		FROM_SERVICETIMESAT_PARTITION(ColumnNames.FROM_SERVICE_TIME_SAT, ColumnNames.SERVICE_TIME_SAT, new FromTime()),
		TO_SERVICETIMESAT_PARTITION(ColumnNames.TO_SERVICE_TIME_SAT, ColumnNames.SERVICE_TIME_SAT, new ToTime()),
		FROM_SERVICETIMESUN_PARTITION(ColumnNames.FROM_SERVICE_TIME_SUN, ColumnNames.SERVICE_TIME_SUN, new FromTime()),
		TO_SERVICETIMESUN_PARTITION(ColumnNames.TO_SERVICE_TIME_SUN, ColumnNames.SERVICE_TIME_SUN, new ToTime()),
		FROM_SERVICETIMEHOL_PARTITION(ColumnNames.FROM_SERVICE_TIME_HOL, ColumnNames.SERVICE_TIME_HOL, new FromTime()),
		TO_SERVICETIMEHOL_PARTITION(ColumnNames.TO_SERVICE_TIME_HOL, ColumnNames.SERVICE_TIME_HOL, new ToTime()),
		FROM_OFFICETIMEKAYOI_PARTITION(ColumnNames.FROM_OFFICE_TIME_KAYOI, ColumnNames.OFFICE_TIME_KAYOI, new FromTime()),
		TO_OFFICETIMEKAYOI_PARTITION(ColumnNames.TO_OFFICE_TIME_KAYOI, ColumnNames.OFFICE_TIME_KAYOI, new ToTime()),
		FROM_OFFICETIMESTAY_PARTITION(ColumnNames.FROM_OFFICE_TIME_STAY, ColumnNames.OFFICE_TIME_STAY, new FromTime()),
		TO_OFFICETIMESTAY_PARTITION(ColumnNames.TO_OFFICE_TIME_STAY, ColumnNames.OFFICE_TIME_STAY, new ToTime())
		;

		String key;
		String v_key;
		IPartition partition;

		private TimeFromTo (String key, String v_key,IPartition partition) {
			this.key = key;
			this.v_key = v_key;
			this.partition = partition;
		 }

		public static TimeFromTo tableNameOf(String key) {
			for(TimeFromTo t : values()) {
				if (t.key.equals(key)) return t;
			}
			return null;
		}

		public String Partition(String key, Map<String,String> d){
			 return this.partition.Partition(key, d, this.v_key);
		}

		static interface IPartition {
			String Partition(String key, Map<String,String> d, String v_key);
		}

		public static class ToTime implements IPartition{
			public String Partition(String key, Map<String,String> d, String v_key){
				return (d.get(v_key) != null) ? d.get(v_key).substring(7, 12).replace(Fixed.strHOUR, "") : null;
			}
		}

		public static class FromTime implements IPartition{
			public String Partition(String key, Map<String,String> d, String v_key){
				return (d.get(v_key) != null) ? d.get(v_key).substring(0, 5).replace(Fixed.strHOUR, "") : null;
			}
		}
	}

	public static String getNewVal(String key, Map<String,String> d){
		TimeFromTo time = TimeFromTo.tableNameOf(key);
		if (time == null) return d.get(key);
		return time.Partition(key, d);
	}
}
