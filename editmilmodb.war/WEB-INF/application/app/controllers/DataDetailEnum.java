package controllers;

import java.util.List;
import java.util.Map;

import play.db.jpa.JPABase;
import util.common.Fixed;
import models.*;

public class DataDetailEnum {
	public enum DataDetail {
		V_HOME_CARE_DETAIL(Fixed.HOME_CARE_FORMSERCD, new HomeCareDetailSupplier()),
		V_HOME_BATH_DETAIL(Fixed.HOME_BATH_FORMSERCD, new HomeBathDetailSupplier()),
		V_HOME_NURSE_DETAIL(Fixed.HOME_NURSE_FORMSERCD, new HomeNurseDetailSupplier()),
		V_HOME_REHABILITATION_DETAIL(Fixed.HOME_REHABILITATION_FORMSERCD, new HomeRehabilitationDetailSupplier()),
		V_NIGHT_CARE_DETAIL(Fixed.NIGHT_CARE_FORMSERCD, new NightHomeCareDetailSupplier()),
		V_ROUTINE_HOME_DETAIL(Fixed.ROUTINE_HOME_FORMSERCD, new RoutineHomeDetailSupplier()),
		V_SMALL_HOME_DETAIL(Fixed.SMALL_HOME_FORMSERCD, new SmallMultiHomeDetailSupplier()),
		V_MIX_SERVICE_DETAIL(Fixed.MIX_SERVICE_FORMSERCD, new MixServiceDetailSupplier()),
		V_SHORT_LIFE_DETAIL(Fixed.SHORT_LIFE_FORMSERCD, new ShortLifeDetailSupplier()),
		V_SHORT_HEALTH_DETAIL(Fixed.SHORT_HEALTH_FORMSERCD, new ShortNursingHealthDetailSupplier()),
		V_SHORT_MEDICAL_DETAIL(Fixed.SHORT_MEDICAL_FORMSERCD, new ShortNursingMedicalDetailSupplier()),
		V_CARE_WELFARE_DETAIL(Fixed.CARE_WELFARE_FORMSERCD, new CareWelfareFacilityDetailSupplier()),
		V_CARE_HEARLTH_DETAIL(Fixed.CARE_HEARLTH_FORMSERCD, new CareHealthFacilityDetailSupplier()),
		V_CARE_MEDICAL_DETAIL(Fixed.CARE_MEDICAL_FORMSERCD, new CareMedicalFacilityDetailSupplier()),
		V_DEMENTIA_DETAIL(Fixed.DEMENTIA_FORMSERCD, new DementiaCommunalLifecareDetailSupplier()),
		V_LOCAL_WELFARE_DETAIL(Fixed.LOCAL_WELFARE_FORMSERCD, new LocalBasedWelfareDetailSupplier()),
		V_LOCAL_CHARGE_DETAIL(Fixed.LOCAL_CHARGE_FORMSERCD, new LocalBasedSpecifiedChargeDetailSupplier()),
		V_LOCAL_LIGHT_DETAIL(Fixed.LOCAL_LIGHT_FORMSERCD, new LocalBasedSpecifiedLightDetailSupplier()),
		V_TOOL_RENTAL_DETAIL(Fixed.TOOL_RENTAL_FORMSERCD, new WelfareToolRentalDetailSupplier()),
		V_TOOL_SALL_DETAIL(Fixed.TOOL_SALL_FORMSERCD, new SpecifiedWelfareToolSaleDetailSupplier()),
		V_LIFE_CHRGE_DETAIL(Fixed.LIFE_CHRGE_FORMSERCD, new SpecifiedLifecareChargeDetailSupplier()),
		V_LIFE_LIGHT_DETAIL(Fixed.LIFE_LIGHT_FORMSERCD, new SpecifiedLifecareLightDetailSupplier())
		;

		String formSerCd;
		IDetailSupplier supplier;

		private DataDetail (String formSerCd, IDetailSupplier supplier) {
			this.formSerCd = formSerCd;
			this.supplier = supplier;
		}

		public static DataDetail tableNameOf(String formSerCd) {
			for(DataDetail t : values()) {
				if (t.formSerCd.equals(formSerCd)) return t;
			}
			throw new RuntimeException();
		}

		public MilmoDBEntity getData(Long id) {
			return this.supplier.getData(id);
		}

		static interface IDetailSupplier {
			MilmoDBEntity getData(Long id);
		}

		public static class SpecifiedLifecareLightDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_specified_lifecare_light.findById(id);
			}
		}

		public static class SpecifiedLifecareChargeDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_specified_lifecare_charge.findById(id);
			}
		}

		public static class SpecifiedWelfareToolSaleDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_specified_welfare_tool_sale.findById(id);
			}
		}

		public static class WelfareToolRentalDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_welfare_tool_rental.findById(id);
			}
		}

		public static class LocalBasedSpecifiedLightDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_local_based_specified_light.findById(id);
			}
		}

		public static class LocalBasedSpecifiedChargeDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_local_based_specified_charge.findById(id);
			}
		}

		public static class LocalBasedWelfareDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_local_based_welfare.findById(id);
			}
		}	

		public static class DementiaCommunalLifecareDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_dementia_communal_lifecare.findById(id);
			}
		}

		public static class CareMedicalFacilityDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_care_medical_facility.findById(id);
			}
		}

		public static class CareHealthFacilityDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_care_health_facility.findById(id);
			}
		}

		public static class CareWelfareFacilityDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_care_welfare_facility.findById(id);
			}
		}

		public static class ShortNursingMedicalDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_short_nursing_medical.findById(id);
			}
		}

		public static class ShortNursingHealthDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_short_nursing_health.findById(id);
			}
		}

		public static class ShortLifeDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_short_life.findById(id);
			}
		}

		public static class MixServiceDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_mix_service.findById(id);
			}
		}

		public static class SmallMultiHomeDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_small_multi_home.findById(id);
			}
		}

		public static class RoutineHomeDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_routine_home.findById(id);
			}
		}

		public static class NightHomeCareDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_night_home_care.findById(id);
			}
		}

		public static class HomeRehabilitationDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_home_rehabilitation.findById(id);
			}
		}

		public static class HomeNurseDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_home_nurse.findById(id);
			}
		}

		public static class HomeBathDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_home_bath.findById(id);
			}
		}

		public static class HomeCareDetailSupplier implements IDetailSupplier {
			public MilmoDBEntity getData(Long id) {
				return V_home_care.findById(id);
			}
		}
	}

	public static MilmoDBEntity getDetail(String formSerCd, Long id) {
		DataDetail type = DataDetail.tableNameOf(formSerCd);
		return type.getData(id);
	}
}
