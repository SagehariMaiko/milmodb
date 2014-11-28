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
@Table(name="routine_home")
public class Routine_Home extends GenericModel {
	@Id
	public Long office_id;
	public String office_type;
	public String service_area;
	public Boolean service_supply_1;
	public Boolean service_supply_2;
	public Boolean service_supply_3;
	public Boolean carestaffkaizen_1;
	public Boolean carestaffkaizen_2;
	public Boolean carestaffkaizen_3;
	public Boolean kinkyujihoumon;
	public Boolean specialkanri_1;
	public Boolean specialkanri_2;
	public Boolean terminalcare;
	public Boolean taiinjikyoudousidou;
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
	public String operator_price;
	public Boolean userchargecut;
	
    public Routine_Home(Map<String, String> mapdata, String formSerCd)  throws SQLException {    	
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
    	this.office_type = mapdata.get(ColumnNames.OFFICE_TYPE);
    	this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
    	this.service_supply_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_1);
    	this.service_supply_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_2);
    	this.service_supply_3 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_3);
    	this.carestaffkaizen_1 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_3);
    	this.kinkyujihoumon = CommonFunc.func_setBit(mapdata,ColumnNames.KINKYUJIHOUMON);
    	this.specialkanri_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SPECIALKANRI_1);
    	this.specialkanri_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SPECIALKANRI_2);
    	this.terminalcare = CommonFunc.func_setBit(mapdata,ColumnNames.TERMINALCARE);
    	this.taiinjikyoudousidou = CommonFunc.func_setBit(mapdata,ColumnNames.TAIINJIKYOUDOUSIDOU);
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
    	this.operator_price = mapdata.get(ColumnNames.OPERATOR_PRICE);
    	this.userchargecut = CommonFunc.func_setBit(mapdata,ColumnNames.USERCHARGECUT);
    }
	
}
