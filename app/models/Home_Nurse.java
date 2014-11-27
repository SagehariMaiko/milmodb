package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;
import util.function.CommonFunc;

@Entity
@Table(name="home_nurse") 
public class Home_Nurse extends GenericModel {
	@Id
	public Long office_id;
	public Boolean shiteistation;
	public Boolean shiteihomenurse;
	public String from_office_time_week;
	public String to_office_time_week;
	public String from_office_time_sat;
	public String to_office_time_sat;
	public String from_office_time_sun;
	public String to_office_time_sun;
	public String from_office_time_hol;
	public String to_office_time_hol;
	public String office_time_reghol;
	public String office_time_memo;
	public String from_service_time_week;
	public String to_service_time_week;
	public String from_service_time_sat;
	public String to_service_time_sat;
	public String from_service_time_sun;
	public String to_service_time_sun;
	public String from_service_time_hol;
	public String to_service_time_hol;
	public String service_time_memo;
	public String service_area;
	public Boolean kinkyujihoumon;
	public Boolean specialkanri_1;
	public Boolean specialkanri_2;
	public Boolean sub_terminalcare;
	public Boolean service_supply;
	public Boolean taiinjikyoudousidou;
	public Boolean sub_kanngokaigorenkkei;
	public Boolean sub_teikizuijirenkei;
	public Boolean tube_feeding;
	public Boolean ivh;
	public Boolean iv_drip;
	public Boolean bladder_catheterization;
	public Boolean nephrostomy;
	public Boolean hot;
	public Boolean respirator;
	public Boolean capd;
	public Boolean artificial_anus;
	public Boolean artificial_bladder;
	public Boolean tracheal_cannula;
	public Boolean absorb;
	public Boolean drug_pain_control;
	public String medical_other_name;
	public Boolean medical_other;
	public String outarea_price;
	public String cancel_price;
	
	public Home_Nurse(Map<String, String> mapdata, String formSerCd)  throws SQLException {
		this.office_id = Long.valueOf(mapdata.get(ColumnNames.OFFICE_ID));
		Office_Common comnewdata = new Office_Common(mapdata, formSerCd);
		comnewdata.save();
		setData(mapdata);
	}

	public void updateData(Map<String, String> mapdata, String formSerCd) throws SQLException {
		Office_Common office_common = Office_Common.find("office_id = ? and formSerCd = ?", office_id, formSerCd).first();
		office_common.update(mapdata, formSerCd);
		setData(mapdata);
		this.save();
	}

	public void setData(Map<String, String> mapdata){
		this.shiteistation = CommonFunc.func_setBit(mapdata,ColumnNames.SHITEISTATION);
		this.shiteihomenurse = CommonFunc.func_setBit(mapdata,ColumnNames.SHITEIHOMENURSE);
		this.from_office_time_week = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_WEEK);
		this.to_office_time_week = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_WEEK);
		this.from_office_time_sat = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_SAT);
		this.to_office_time_sat = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_SAT);
		this.from_office_time_sun = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_SUN);
		this.to_office_time_sun = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_SUN);
		this.from_office_time_hol = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_HOL);
		this.to_office_time_hol = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_HOL);
		this.office_time_reghol = mapdata.get(ColumnNames.OFFICE_TIME_REGHOL);
		this.office_time_memo = mapdata.get(ColumnNames.OFFICE_TIME_MEMO);
		this.from_service_time_week = CommonFunc.from_time(mapdata, ColumnNames.SERVICE_TIME_WEEK);
		this.to_service_time_week = CommonFunc.to_time(mapdata, ColumnNames.SERVICE_TIME_WEEK); 
		this.from_service_time_sat = CommonFunc.from_time(mapdata, ColumnNames.SERVICE_TIME_SAT);
		this.to_service_time_sat = CommonFunc.to_time(mapdata, ColumnNames.SERVICE_TIME_SAT);
		this.from_service_time_sun = CommonFunc.from_time(mapdata, ColumnNames.SERVICE_TIME_SUN);
		this.to_service_time_sun = CommonFunc.to_time(mapdata, ColumnNames.SERVICE_TIME_SUN);
		this.from_service_time_hol = CommonFunc.from_time(mapdata, ColumnNames.SERVICE_TIME_HOL);
		this.to_service_time_hol = CommonFunc.to_time(mapdata, ColumnNames.SERVICE_TIME_HOL);
		this.service_time_memo = mapdata.get(ColumnNames.SERVICE_TIME_MEMO);
		this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
		this.kinkyujihoumon = CommonFunc.func_setBit(mapdata,ColumnNames.KINKYUJIHOUMON);
		this.specialkanri_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SPECIALKANRI_1);
		this.specialkanri_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SPECIALKANRI_2);
		this.sub_terminalcare = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_TERMINALCARE);
		this.service_supply = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY);
		this.taiinjikyoudousidou = CommonFunc.func_setBit(mapdata,ColumnNames.TAIINJIKYOUDOUSIDOU);
		this.sub_kanngokaigorenkkei = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_KANNGOKAIGORENKKEI);
		this.sub_teikizuijirenkei = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_TEIKIZUIJIRENKEI);
		this.tube_feeding = CommonFunc.func_setBit(mapdata,ColumnNames.TUBE_FEEDING);
		this.ivh = CommonFunc.func_setBit(mapdata,ColumnNames.IVH);
		this.iv_drip = CommonFunc.func_setBit(mapdata,ColumnNames.IV_DRIP);
		this.bladder_catheterization = CommonFunc.func_setBit(mapdata,ColumnNames.BLADDER_CATHETERIZATION);
		this.nephrostomy = CommonFunc.func_setBit(mapdata,ColumnNames.NEPHROSTOMY);
		this.hot = CommonFunc.func_setBit(mapdata,ColumnNames.HOT);
		this.respirator = CommonFunc.func_setBit(mapdata,ColumnNames.RESPIRATOR);
		this.capd = CommonFunc.func_setBit(mapdata,ColumnNames.CAPD);
		this.artificial_anus = CommonFunc.func_setBit(mapdata,ColumnNames.ARTIFICIAL_ANUS);
		this.artificial_bladder = CommonFunc.func_setBit(mapdata,ColumnNames.ARTIFICIAL_BLADDER);
		this.tracheal_cannula = CommonFunc.func_setBit(mapdata,ColumnNames.TRACHEAL_CANNULA);
		this.absorb = CommonFunc.func_setBit(mapdata,ColumnNames.ABSORB);
		this.drug_pain_control = CommonFunc.func_setBit(mapdata,ColumnNames.DRUG_PAIN_CONTROL);
		this.medical_other_name = mapdata.get(ColumnNames.MEDICAL_OTHER_NAME);
		this.medical_other = CommonFunc.func_setBit(mapdata,ColumnNames.MEDICAL_OTHER);
		this.outarea_price = mapdata.get(ColumnNames.OUTAREA_PRICE);
		this.cancel_price = mapdata.get(ColumnNames.CANCEL_PRICE);
	}
}
