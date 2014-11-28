package controllers;

import java.sql.SQLException;
import java.util.Map;

import models.*;
import util.common.Fixed;

public class SaveVdataEnum {
	public enum SaveVdata {
		V_HOME_CARE_SAVE(Fixed.HOME_CARE_FORMSERCD, new VHomeCareSaver()),
		V_HOME_BATH_SAVE(Fixed.HOME_BATH_FORMSERCD, new VHomeBathSaver()),
		V_HOME_NURSE_SAVE(Fixed.HOME_NURSE_FORMSERCD, new VHomeNurseSaver()),
		V_HOME_REHABILITATION_SAVE(Fixed.HOME_REHABILITATION_FORMSERCD, new VHomeRehabilitationSaver()),
		V_NIGHT_CARE_SAVE(Fixed.NIGHT_CARE_FORMSERCD, new VNightHomeCareSaver()),
		V_ROUTINE_HOME_SAVE(Fixed.ROUTINE_HOME_FORMSERCD, new VRoutineHomeSaver()),
		V_SMALL_HOME_SAVE(Fixed.SMALL_HOME_FORMSERCD, new VSmallMultiHomeSaver()),
		V_MIX_SERVICE_SAVE(Fixed.MIX_SERVICE_FORMSERCD, new VMixServiceSaver()),
		V_SHORT_LIFE_SAVE(Fixed.SHORT_LIFE_FORMSERCD, new VShortLifeSaver()),
		V_SHORT_HEALTH_SAVE(Fixed.SHORT_HEALTH_FORMSERCD, new VShortNursingHealthSaver()),
		V_SHORT_MEDICAL_SAVE(Fixed.SHORT_MEDICAL_FORMSERCD, new VShortNursingMedicalSaver()),
		V_CARE_WELFARE_SAVE(Fixed.CARE_WELFARE_FORMSERCD, new VCareWelfareFacilitySaver()),
		V_CARE_HEARLTH_SAVE(Fixed.CARE_HEARLTH_FORMSERCD, new VCareHealthFacilitySaver()),
		V_CARE_MEDICAL_SAVE(Fixed.CARE_MEDICAL_FORMSERCD, new VCareMedicalFacilitySaver()),
		V_DEMENTIA_SAVE(Fixed.DEMENTIA_FORMSERCD, new VDementiaCommunalLifecareSaver()),
		V_LOCAL_WELFARE_SAVE(Fixed.LOCAL_WELFARE_FORMSERCD, new VLocalBasedWelfareSaver()),
		V_LOCAL_CHARGE_SAVE(Fixed.LOCAL_CHARGE_FORMSERCD, new VLocalBasedSpecifiedChargeSaver()),
		V_LOCAL_LIGHT_SAVE(Fixed.LOCAL_LIGHT_FORMSERCD, new VLocalBasedSpecifiedLightSaver()),
		V_TOOL_RENTAL_SAVE(Fixed.TOOL_RENTAL_FORMSERCD, new VWelfareToolRentalSaver()),
		V_TOOL_SALL_SAVE(Fixed.TOOL_SALL_FORMSERCD, new VSpecifiedWelfareToolSaleSaver()),
		V_LIFE_CHRGE_SAVE(Fixed.LIFE_CHRGE_FORMSERCD, new VSpecifiedLifecareChargeSaver()),
		V_LIFE_LIGHT_SAVE(Fixed.LIFE_LIGHT_FORMSERCD, new VSpecifiedLifecareLightSaver())
		;

		String formSerCd;
		IVdataSaver saver;

		private SaveVdata (String formSerCd, IVdataSaver saver) {
			this.formSerCd = formSerCd;
			this.saver = saver;
		}

		public static SaveVdata tableNameOf(String formSerCd) {
			for(SaveVdata t : values()) {
				if (t.formSerCd.equals(formSerCd)) return t;
			}
			throw new RuntimeException();
		}

		public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
			this.saver.saveData(id, mapdata);
		}

		static interface IVdataSaver {
			void saveData(Long id, Map<String, String> mapdata) throws SQLException;
		}

		public static class VSpecifiedLifecareLightSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_specified_lifecare_light v_specified_lifecare_light = V_specified_lifecare_light.findById(id);
				v_specified_lifecare_light.updateData(mapdata);
			}
		}

		public static class VSpecifiedLifecareChargeSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_specified_lifecare_charge v_specified_lifecare_charge = V_specified_lifecare_charge.findById(id);
				v_specified_lifecare_charge.updateData(mapdata);
			}
		}

		public static class VSpecifiedWelfareToolSaleSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_specified_welfare_tool_sale v_specified_welfare_tool_sale = V_specified_welfare_tool_sale.findById(id);
				v_specified_welfare_tool_sale.updateData(mapdata);
			}
		}

		public static class VWelfareToolRentalSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_welfare_tool_rental v_welfare_tool_rental = V_welfare_tool_rental.findById(id);
				v_welfare_tool_rental.updateData(mapdata);
			}
		}

		public static class VLocalBasedSpecifiedLightSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_local_based_specified_light v_local_based_specified_light = V_local_based_specified_light.findById(id);
				v_local_based_specified_light.updateData(mapdata);
			}
		}

		public static class VLocalBasedSpecifiedChargeSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_local_based_specified_charge v_local_based_specified_charge = V_local_based_specified_charge.findById(id);
				v_local_based_specified_charge.updateData(mapdata);
			}
		}

		public static class VLocalBasedWelfareSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_local_based_welfare v_local_based_welfare = V_local_based_welfare.findById(id);
				v_local_based_welfare.updateData(mapdata);
			}
		}

		public static class VDementiaCommunalLifecareSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_dementia_communal_lifecare v_dementia_communal_lifecare = V_dementia_communal_lifecare.findById(id);
				v_dementia_communal_lifecare.updateData(mapdata);
			}
		}

		public static class VCareMedicalFacilitySaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_care_medical_facility v_care_medical_facility = V_care_medical_facility.findById(id);
				v_care_medical_facility.updateData(mapdata);
			}
		}

		public static class VCareHealthFacilitySaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_care_health_facility v_care_health_facility = V_care_health_facility.findById(id);
				v_care_health_facility.updateData(mapdata);
			}
		}

		public static class VCareWelfareFacilitySaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_care_welfare_facility v_care_welfare_facility = V_care_welfare_facility.findById(id);
				v_care_welfare_facility.updateData(mapdata);
			}
		}

		public static class VShortNursingMedicalSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_short_nursing_medical v_short_nursing_medical = V_short_nursing_medical.findById(id);
				v_short_nursing_medical.updateData(mapdata);
			}
		}

		public static class VShortNursingHealthSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_short_nursing_health v_short_nursing_health = V_short_nursing_health.findById(id);
				v_short_nursing_health.updateData(mapdata);
			}
		}

		public static class VShortLifeSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_short_life v_short_life = V_short_life.findById(id);
				v_short_life.updateData(mapdata);
			}
		}

		public static class VRoutineHomeSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_routine_home v_routine_home = V_routine_home.findById(id);
				v_routine_home.updateData(mapdata);
			}
		}

		public static class VMixServiceSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_mix_service v_mix_service = V_mix_service.findById(id);
				v_mix_service.updateData(mapdata);
			}
		}

		public static class VSmallMultiHomeSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_small_multi_home v_small_multi_home = V_small_multi_home.findById(id);
				v_small_multi_home.updateData(mapdata);
			}
		}

		public static class VNightHomeCareSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_night_home_care v_night_home_care = V_night_home_care.findById(id);
				v_night_home_care.updateData(mapdata);
			}
		}

		public static class VHomeRehabilitationSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_home_rehabilitation v_home_rehabilitation = V_home_rehabilitation.findById(id);
				v_home_rehabilitation.updateData(mapdata);
			}
		}

		public static class VHomeNurseSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_home_nurse v_home_nurse = V_home_nurse.findById(id);
				v_home_nurse.updateData(mapdata);
			}
		}

		public static class VHomeBathSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_home_bath v_home_bath = V_home_bath.findById(id);
				v_home_bath.updateData(mapdata);
			}
		}

		public static class VHomeCareSaver implements IVdataSaver {
			public void saveData(Long id, Map<String, String> mapdata) throws SQLException {
				V_home_care v_home_care = V_home_care.findById(id);
				v_home_care.updateData(mapdata);
			}
		}
	}

	public static void saveVdatas(String formSerCd, Long office_id, Map<String, String> mapdata, ServiceName type) throws SQLException {
		SaveVdata table = SaveVdata.tableNameOf(formSerCd);
		table.saveData(office_id, mapdata);
		Office_History_Save.HistorySave("v_"+type.table_name,office_id, Fixed.UPDATE);
	}
}
