package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;

@Entity
@Table(name="v_home_bath")
public class V_home_bath extends MilmoDBEntity {

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
    public String office_time_week;
    public String office_time_sat;
    public String office_time_sun;
    public String office_time_hol;
    public String office_time_reghol;
    public String office_time_memo;
    public String service_time_week;
    public String service_time_sat;
    public String service_time_sun;
    public String service_time_hol;
    public String service_time_memo;
    public String service_area;
    public String service_supply;
    public String carestaffkaizen_1;
    public String carestaffkaizen_2;
    public String carestaffkaizen_3;
    public String outarea_price;
    public String specialbath_price;
    public String cancel_price;
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
        this.office_time_week = mapdata.get(ColumnNames.OFFICE_TIME_WEEK);
        this.office_time_sat = mapdata.get(ColumnNames.OFFICE_TIME_SAT);
        this.office_time_sun = mapdata.get(ColumnNames.OFFICE_TIME_SUN);
        this.office_time_hol = mapdata.get(ColumnNames.OFFICE_TIME_HOL);
        this.office_time_reghol = mapdata.get(ColumnNames.OFFICE_TIME_REGHOL);
        this.office_time_memo = mapdata.get(ColumnNames.OFFICE_TIME_MEMO);
        this.service_time_week = mapdata.get(ColumnNames.SERVICE_TIME_WEEK);
        this.service_time_sat = mapdata.get(ColumnNames.SERVICE_TIME_SAT);
        this.service_time_sun = mapdata.get(ColumnNames.SERVICE_TIME_SUN);
        this.service_time_hol = mapdata.get(ColumnNames.SERVICE_TIME_HOL);
        this.service_time_memo = mapdata.get(ColumnNames.SERVICE_TIME_MEMO);
        this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
        this.carestaffkaizen_1 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_1);
        this.carestaffkaizen_2 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_2);
        this.carestaffkaizen_3 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_3);
        this.outarea_price = mapdata.get(ColumnNames.OUTAREA_PRICE);
        this.specialbath_price = mapdata.get(ColumnNames.SPECIALBATH_PRICE);
        this.cancel_price = mapdata.get(ColumnNames.CANCEL_PRICE);
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
