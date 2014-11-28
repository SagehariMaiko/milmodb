package controllers;

import java.sql.SQLException;
import java.util.Map;

import models.*;
import util.common.Fixed;

public class SaveDataEnum {
	public enum SaveData {
		HOME_CARE_SAVE(Fixed.HOME_CARE_FORMSERCD, new HomeCareSaver()),
		HOME_BATH_SAVE(Fixed.HOME_BATH_FORMSERCD, new HomeBathSaver()),
		HOME_NURSE_SAVE(Fixed.HOME_NURSE_FORMSERCD, new HomeNurseSaver()),
		HOME_REHABILITATION_SAVE(Fixed.HOME_REHABILITATION_FORMSERCD, new HomeRehabilitationSaver()),
		NIGHT_CARE_SAVE(Fixed.NIGHT_CARE_FORMSERCD, new NightHomeCareSaver()),
		ROUTINE_HOME_SAVE(Fixed.ROUTINE_HOME_FORMSERCD, new RoutineHomeSaver()),
		SMALL_HOME_SAVE(Fixed.SMALL_HOME_FORMSERCD, new SmallMultiHomeSaver()),
		MIX_SERVICE_SAVE(Fixed.MIX_SERVICE_FORMSERCD, new MixServiceSaver()),
		SHORT_LIFE_SAVE(Fixed.SHORT_LIFE_FORMSERCD, new ShortLifeSaver()),
		SHORT_HEALTH_SAVE(Fixed.SHORT_HEALTH_FORMSERCD, new ShortNursingHealthSaver()),
		SHORT_MEDICAL_SAVE(Fixed.SHORT_MEDICAL_FORMSERCD, new ShortNursingMedicalSaver()),
		CARE_WELFARE_SAVE(Fixed.CARE_WELFARE_FORMSERCD, new CareWelfareFacilitySaver()),
		CARE_HEARLTH_SAVE(Fixed.CARE_HEARLTH_FORMSERCD, new CareHealthFacilitySaver()),
		CARE_MEDICAL_SAVE(Fixed.CARE_MEDICAL_FORMSERCD, new CareMedicalFacilitySaver()),
		DEMENTIA_SAVE(Fixed.DEMENTIA_FORMSERCD, new DementiaCommunalLifecareSaver()),
		LOCAL_WELFARE_SAVE(Fixed.LOCAL_WELFARE_FORMSERCD, new LocalBasedWelfareSaver()),
		LOCAL_CHARGE_SAVE(Fixed.LOCAL_CHARGE_FORMSERCD, new LocalBasedSpecifiedChargeSaver()),
		LOCAL_LIGHT_SAVE(Fixed.LOCAL_LIGHT_FORMSERCD, new LocalBasedSpecifiedLightSaver()),
		TOOL_RENTAL_SAVE(Fixed.TOOL_RENTAL_FORMSERCD, new WelfareToolRentalSaver()),
		TOOL_SALL_SAVE(Fixed.TOOL_SALL_FORMSERCD, new SpecifiedWelfareToolSaleSaver()),
		LIFE_CHRGE_SAVE(Fixed.LIFE_CHRGE_FORMSERCD, new SpecifiedLifecareChargeSaver()),
		LIFE_LIGHT_SAVE(Fixed.LIFE_LIGHT_FORMSERCD, new SpecifiedLifecareLightSaver())
		;

		String formSerCd;
		IDataSaver saver;

		private SaveData (String formSerCd, IDataSaver saver) {
			this.formSerCd = formSerCd;
			this.saver = saver;
		}

		public static SaveData tableNameOf(String formSerCd) {
			for(SaveData t : values()) {
				if (t.formSerCd.equals(formSerCd)) return t;
			}
			throw new RuntimeException();
		}

		public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
			return this.saver.saveData(id, mapdata, formSerCd, type);
		}

		static interface IDataSaver {
			MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException;
		}

		public static class SpecifiedLifecareLightSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Specified_Lifecare_Light selectdata = Specified_Lifecare_Light.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Specified_Lifecare_Light newdata = new Specified_Lifecare_Light(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_specified_lifecare_light nextdata = V_specified_lifecare_light.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_specified_lifecare_light.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class SpecifiedLifecareChargeSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Specified_Lifecare_Charge selectdata = Specified_Lifecare_Charge.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Specified_Lifecare_Charge newdata = new Specified_Lifecare_Charge(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_specified_lifecare_charge nextdata = V_specified_lifecare_charge.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_specified_lifecare_charge.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class SpecifiedWelfareToolSaleSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Specified_Welfare_Tool_Sale selectdata = Specified_Welfare_Tool_Sale.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Specified_Welfare_Tool_Sale newdata = new Specified_Welfare_Tool_Sale(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_specified_welfare_tool_sale nextdata = V_specified_welfare_tool_sale.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_specified_welfare_tool_sale.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class WelfareToolRentalSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Welfare_Tool_Rental selectdata = Welfare_Tool_Rental.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Welfare_Tool_Rental newdata = new Welfare_Tool_Rental(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_welfare_tool_rental nextdata = V_welfare_tool_rental.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_welfare_tool_rental.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class LocalBasedSpecifiedLightSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Local_Based_Specified_Light selectdata = Local_Based_Specified_Light.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Local_Based_Specified_Light newdata = new Local_Based_Specified_Light(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_local_based_specified_light nextdata = V_local_based_specified_light.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_local_based_specified_light.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class LocalBasedSpecifiedChargeSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Local_Based_Specified_Charge selectdata = Local_Based_Specified_Charge.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Local_Based_Specified_Charge newdata = new Local_Based_Specified_Charge(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_local_based_specified_charge nextdata = V_local_based_specified_charge.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_local_based_specified_charge.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class LocalBasedWelfareSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Local_Based_Welfare selectdata = Local_Based_Welfare.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Local_Based_Welfare newdata = new Local_Based_Welfare(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_local_based_welfare nextdata = V_local_based_welfare.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_local_based_welfare.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class DementiaCommunalLifecareSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Dementia_Communal_Lifecare selectdata = Dementia_Communal_Lifecare.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Dementia_Communal_Lifecare newdata = new Dementia_Communal_Lifecare(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_dementia_communal_lifecare nextdata = V_dementia_communal_lifecare.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_dementia_communal_lifecare.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class CareMedicalFacilitySaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Care_Medical_Facility selectdata = Care_Medical_Facility.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Care_Medical_Facility newdata = new Care_Medical_Facility(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_care_medical_facility nextdata = V_care_medical_facility.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_care_medical_facility.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class CareHealthFacilitySaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Care_Health_Facility selectdata = Care_Health_Facility.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Care_Health_Facility newdata = new Care_Health_Facility(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_care_health_facility nextdata = V_care_health_facility.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_care_health_facility.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class CareWelfareFacilitySaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Care_Welfare_Facility selectdata = Care_Welfare_Facility.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Care_Welfare_Facility newdata = new Care_Welfare_Facility(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_care_welfare_facility nextdata = V_care_welfare_facility.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_care_welfare_facility.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class ShortNursingMedicalSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Short_Nursing_Medical selectdata = Short_Nursing_Medical.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Short_Nursing_Medical newdata = new Short_Nursing_Medical(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_short_nursing_medical nextdata = V_short_nursing_medical.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_short_nursing_medical.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class ShortNursingHealthSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Short_Nursing_Health selectdata = Short_Nursing_Health.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Short_Nursing_Health newdata = new Short_Nursing_Health(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_short_nursing_health nextdata = V_short_nursing_health.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_short_nursing_health.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class ShortLifeSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Short_Life selectdata = Short_Life.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Short_Life newdata = new Short_Life(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_short_life nextdata = V_short_life.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_short_life.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class MixServiceSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Mix_Service selectdata = Mix_Service.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Mix_Service newdata = new Mix_Service(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_mix_service nextdata = V_mix_service.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_mix_service.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class SmallMultiHomeSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Small_Multi_Home selectdata = Small_Multi_Home.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Small_Multi_Home newdata = new Small_Multi_Home(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_small_multi_home nextdata = V_small_multi_home.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_small_multi_home.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class RoutineHomeSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Routine_Home selectdata = Routine_Home.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Routine_Home newdata = new Routine_Home(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_routine_home nextdata = V_routine_home.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_routine_home.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class NightHomeCareSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Night_Home_Care selectdata = Night_Home_Care.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Night_Home_Care newdata = new Night_Home_Care(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_night_home_care nextdata = V_night_home_care.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_night_home_care.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class HomeRehabilitationSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Home_Rehabilitation selectdata = Home_Rehabilitation.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Home_Rehabilitation newdata = new Home_Rehabilitation(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_home_rehabilitation nextdata = V_home_rehabilitation.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_home_rehabilitation.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class HomeNurseSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Home_Nurse selectdata = Home_Nurse.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Home_Nurse newdata = new Home_Nurse(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_home_nurse nextdata = V_home_nurse.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_home_nurse.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class HomeBathSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Home_Bath selectdata = Home_Bath.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Home_Bath newdata = new Home_Bath(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_home_bath nextdata = V_home_bath.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_home_bath.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}

		public static class HomeCareSaver implements IDataSaver{
			public MilmoDBEntity saveData(Long id, Map<String, String> mapdata, String formSerCd, ServiceName type) throws SQLException {
				Home_Care selectdata = Home_Care.findById(id);
				if (selectdata != null) {
					selectdata.updateData(mapdata, formSerCd);
					Office_History_Save.HistorySave(type.table_name, selectdata.office_id, Fixed.UPDATE);
				} else {
					Home_Care newdata = new Home_Care(mapdata, formSerCd);
					newdata.save();
					Office_History_Save.HistorySave(type.table_name, newdata.office_id, Fixed.INSERT);
				}
				V_home_care nextdata = V_home_care.find("office_id > ? and validate = 0 order by office_id ASC", id).first();
				if (!(nextdata != null)) {nextdata = V_home_care.find("validate = 0 order by office_id ASC").first();}
				return nextdata;
			}
		}
	}

	public static MilmoDBEntity savedatas(String formSerCd, Long id, Map<String, String> mapdata, ServiceName type) throws SQLException {
		SaveData table = SaveData.tableNameOf(formSerCd);
		return table.saveData(id, mapdata, formSerCd, type);
	}
}
