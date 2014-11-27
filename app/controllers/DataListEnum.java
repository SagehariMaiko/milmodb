package controllers;

import java.util.List;
import java.util.Map;

import util.common.ColumnNames;
import util.common.Fixed;
import models.*;

public class DataListEnum {
	public enum DataList {
		V_HOME_CARE(Fixed.HOME_CARE_FORMSERCD, new HomeCareDataSupplier()),
		V_HOME_BATH(Fixed.HOME_BATH_FORMSERCD, new HomeBathDataSupplier()),
		V_HOME_NURSE(Fixed.HOME_NURSE_FORMSERCD, new HomeNurseDataSupplier()),
		V_HOME_REHABILITATION(Fixed.HOME_REHABILITATION_FORMSERCD, new HomeRehabilitationDataSupplier()),
		V_NIGHT_CARE(Fixed.NIGHT_CARE_FORMSERCD, new NightHomeCareDataSupplier()),
		V_ROUTINE_HOME(Fixed.ROUTINE_HOME_FORMSERCD, new RoutineHomeDataSupplier()),
		V_SMALL_HOME(Fixed.SMALL_HOME_FORMSERCD, new SmallMultiHomeDataSupplier()),
		V_MIX_SERVICE(Fixed.MIX_SERVICE_FORMSERCD, new MixServiceDataSupplier()),
		V_SHORT_LIFE(Fixed.SHORT_LIFE_FORMSERCD, new ShortLifeDataSupplier()),
		V_SHORT_HEALTH(Fixed.SHORT_HEALTH_FORMSERCD, new ShortNursingHealthDataSupplier()),
		V_SHORT_MEDICAL(Fixed.SHORT_MEDICAL_FORMSERCD, new ShortNursingMedicalDataSupplier()),
		V_CARE_WELFARE(Fixed.CARE_WELFARE_FORMSERCD, new CareWelfareFacilityDataSupplier()),
		V_CARE_HEARLTH(Fixed.CARE_HEARLTH_FORMSERCD, new CareHealthFacilityDataSupplier()),
		V_CARE_MEDICAL(Fixed.CARE_MEDICAL_FORMSERCD, new CareMedicalFacilityDataSupplier()),
		V_DEMENTIA(Fixed.DEMENTIA_FORMSERCD, new DementiaCommunalLifecareDataSupplier()),
		V_LOCAL_WELFARE(Fixed.LOCAL_WELFARE_FORMSERCD, new LocalBasedWelfareDataSupplier()),
		V_LOCAL_CHARGE(Fixed.LOCAL_CHARGE_FORMSERCD, new LocalBasedSpecifiedChargeDataSupplier()),
		V_LOCAL_LIGHT(Fixed.LOCAL_LIGHT_FORMSERCD, new LocalBasedSpecifiedLightDataSupplier()),
		V_TOOL_RENTAL(Fixed.TOOL_RENTAL_FORMSERCD, new WelfareToolRentalDataSupplier()),
		V_TOOL_SALL(Fixed.TOOL_SALL_FORMSERCD, new SpecifiedWelfareToolSaleDataSupplier()),
		V_LIFE_CHRGE(Fixed.LIFE_CHRGE_FORMSERCD, new SpecifiedLifecareChargeDataSupplier()),
		V_LIFE_LIGHT(Fixed.LIFE_LIGHT_FORMSERCD, new SpecifiedLifecareLightDataSupplier())
		;

		String formSerCd;
		IDataSupplier supplier;

		private DataList (String formSerCd, IDataSupplier supplier) {
			this.formSerCd = formSerCd;
			this.supplier = supplier;
		}

		public static DataList tableNameOf(String formSerCd) {
			for(DataList t : values()) {
				if (t.formSerCd.equals(formSerCd)) return t;
			}
			throw new RuntimeException();
		}

		public List<Map<String, String>> getData() {
			return this.supplier.getData();
		}

		static interface IDataSupplier {
			List<Map<String, String>> getData();
		}

		public static class SpecifiedLifecareLightDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_specified_lifecare_light.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class SpecifiedLifecareChargeDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_specified_lifecare_charge.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class SpecifiedWelfareToolSaleDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_specified_welfare_tool_sale.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class WelfareToolRentalDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_welfare_tool_rental.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class LocalBasedSpecifiedLightDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_local_based_specified_light.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class LocalBasedSpecifiedChargeDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_local_based_specified_charge.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class LocalBasedWelfareDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_local_based_welfare.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class CareMedicalFacilityDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_care_medical_facility.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class DementiaCommunalLifecareDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_dementia_communal_lifecare.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class CareHealthFacilityDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_care_health_facility.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class CareWelfareFacilityDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_care_welfare_facility.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class ShortNursingMedicalDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_short_nursing_medical.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class ShortNursingHealthDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_short_nursing_health.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class ShortLifeDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_short_life.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class MixServiceDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_mix_service.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class SmallMultiHomeDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_small_multi_home.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class RoutineHomeDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_routine_home.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class NightHomeCareDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_night_home_care.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class HomeCareDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_home_care.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class HomeBathDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_home_bath.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class HomeNurseDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_home_nurse.find(ColumnNames.VALIDATE, false).fetch();
			}
		}

		public static class HomeRehabilitationDataSupplier implements IDataSupplier {
			public List<Map<String, String>> getData() {
				return V_home_rehabilitation.find(ColumnNames.VALIDATE, false).fetch();
			}
		}
	}

	public static List<Map<String, String>> getDataList(String formSerCd) {
		DataList type = DataList.tableNameOf(formSerCd);
		return type.getData();
	}
}
