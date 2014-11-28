package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;
@Entity
@Table(name="v_routine_home")
public class V_routine_home extends MilmoDBEntity {
	@Id
	public long office_id;
	public String service_type;
	public String latitude;
	public String longitude;
	public String name;
    public String name_furi;
    public String company_type;
    public String company;
    public String postcode;
    public String municipality;
    public String address_1;
    public String address_2;
    public String tel;
    public String fax;
    public String hp_address;
    public String office_no;
    public String manager_name;
    public String founding_day;
    public String traffic;
    public String office_type;
    public String service_area;
    public String service_supply_1;
    public String service_supply_2;
    public String service_supply_3;
    public String carestaffkaizen_1;
    public String carestaffkaizen_2;
    public String carestaffkaizen_3;
    public String kinkyujihoumon;
    public String specialkanri_1;
    public String specialkanri_2;
    public String terminalcare;
    public String taiinjikyoudousidou;
    public String tube_feeding;
    public String ivh;
    public String iv_drip;
    public String bladder_catheterization;
    public String nephrostomy;
    public String hot;
    public String respirator;
    public String capd;
    public String artificial_anus;
    public String artificial_bladder;
    public String tracheal_cannula;
    public String absorb;
    public String drug_pain_control;
    public String medical_other_name;
    public String medical_other;
    public String outarea_price;
    public String operator_price;
    public String userchargecut;
    public boolean validate;
    public String validate_type;
    public String url;
    
    public void updateData(Map<String, String> mapdata) throws SQLException {
    	this.service_type = mapdata.get(ColumnNames.SERVICE_TYPE);
    	this.latitude = mapdata.get(ColumnNames.LATITUDE);
    	this.longitude = mapdata.get(ColumnNames.LONGITUDE);
    	this.name = mapdata.get(ColumnNames.NAME);
    	this.name_furi = mapdata.get(ColumnNames.NAME_FURI);
    	this.company_type = mapdata.get(ColumnNames.COMPANY_TYPE);
    	this.company = mapdata.get(ColumnNames.COMPANY);
    	this.postcode = mapdata.get(ColumnNames.POSTCODE);
    	this.municipality = mapdata.get(ColumnNames.MUNICIPALITY);
    	this.address_1 = mapdata.get(ColumnNames.ADDRESS_1);
    	this.address_2 = mapdata.get(ColumnNames.ADDRESS_2);
    	this.tel = mapdata.get(ColumnNames.TEL);
    	this.fax = mapdata.get(ColumnNames.FAX);
    	this.hp_address = mapdata.get(ColumnNames.HP_ADDRESS);
    	this.office_no = mapdata.get(ColumnNames.OFFICE_NO);
    	this.manager_name = mapdata.get(ColumnNames.MANAGER_NAME);
    	this.founding_day = mapdata.get(ColumnNames.FOUNDING_DAY);
    	this.traffic = mapdata.get(ColumnNames.TRAFFIC);
    	this.office_type = mapdata.get(ColumnNames.OFFICE_TYPE);
    	this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
    	this.service_supply_1 = mapdata.get(ColumnNames.SERVICE_SUPPLY_1);
    	this.service_supply_2 = mapdata.get(ColumnNames.SERVICE_SUPPLY_2);
    	this.service_supply_3 = mapdata.get(ColumnNames.SERVICE_SUPPLY_3);
    	this.carestaffkaizen_1 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_3);
    	this.kinkyujihoumon = mapdata.get(ColumnNames.KINKYUJIHOUMON);
    	this.specialkanri_1 = mapdata.get(ColumnNames.SPECIALKANRI_1);
    	this.specialkanri_2 = mapdata.get(ColumnNames.SPECIALKANRI_2);
    	this.terminalcare = mapdata.get(ColumnNames.TERMINALCARE);
    	this.taiinjikyoudousidou = mapdata.get(ColumnNames.TAIINJIKYOUDOUSIDOU);
    	this.tube_feeding = mapdata.get(ColumnNames.TUBE_FEEDING);
    	this.ivh = mapdata.get(ColumnNames.IVH);
    	this.iv_drip = mapdata.get(ColumnNames.IV_DRIP);
    	this.bladder_catheterization = mapdata.get(ColumnNames.BLADDER_CATHETERIZATION);
    	this.nephrostomy = mapdata.get(ColumnNames.NEPHROSTOMY);
    	this.hot = mapdata.get(ColumnNames.HOT);
    	this.respirator = mapdata.get(ColumnNames.RESPIRATOR);
    	this.capd = mapdata.get(ColumnNames.CAPD);
    	this.artificial_anus = mapdata.get(ColumnNames.ARTIFICIAL_ANUS);
    	this.artificial_bladder = mapdata.get(ColumnNames.ARTIFICIAL_BLADDER);
    	this.tracheal_cannula = mapdata.get(ColumnNames.TRACHEAL_CANNULA);
    	this.absorb = mapdata.get(ColumnNames.ABSORB);
    	this.drug_pain_control = mapdata.get(ColumnNames.DRUG_PAIN_CONTROL);
    	this.medical_other_name = mapdata.get(ColumnNames.MEDICAL_OTHER_NAME);
    	this.medical_other = mapdata.get(ColumnNames.MEDICAL_OTHER);
    	this.outarea_price = mapdata.get(ColumnNames.OUTAREA_PRICE);
    	this.operator_price = mapdata.get(ColumnNames.OPERATOR_PRICE);
    	this.userchargecut = mapdata.get(ColumnNames.USERCHARGECUT);
    	this.validate = (mapdata.get(ColumnNames.VALIDATE) != null ? false : true);
    	this.validate_type = mapdata.get(ColumnNames.VALIDATE_TYPE);
    	this.url = mapdata.get(ColumnNames.URL);
    	
    	this.save();    	
    }
    
	@Override
	public String getValidationType() {
		return this.validate_type;
	}

	@Override
	public Long getOfficeId() {
		return this.office_id;
	}
}
