package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;

@Entity
@Table(name="v_welfare_tool_rental")
public class V_welfare_tool_rental extends MilmoDBEntity {
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
    public String service_area;
    public String wheelchair;
    public String wheelchair_price_from;
    public String wheelchair_price_to;
    public String specialbed;
    public String specialbed_price_from;
    public String specialbed_price_to;
    public String bedsore;
    public String bedsore_price_from;
    public String bedsore_price_to;
    public String phyconverter;
    public String phyconverter_price_from;
    public String phyconverter_price_to;
    public String handrail;
    public String handrail_price_from;
    public String handrail_price_to;
    public String slope;
    public String slope_price_from;
    public String slope_price_to;
    public String walker;
    public String walker_price_from;
    public String walker_price_to;
    public String walkstick;
    public String walkstick_price_from;
    public String walkstick_price_to;
    public String dementialoiter;
    public String dementialoiter_price_from;
    public String dementialoiter_price_to;
    public String lift;
    public String lift_price_from;
    public String lift_price_to;
    public String autoexcretion;
    public String autoexcretion_price_from;
    public String autoexcretion_price_to;
    public String outarea_price;
    public String welfaretoolcarry_price;
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
    	this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
    	this.wheelchair = mapdata.get(ColumnNames.WHEELCHAIR);
    	this.wheelchair_price_from = mapdata.get(ColumnNames.WHEELCHAIR_PRICE_FROM);
    	this.wheelchair_price_to = mapdata.get(ColumnNames.WHEELCHAIR_PRICE_TO);
    	this.specialbed = mapdata.get(ColumnNames.SPECIALBED);
    	this.specialbed_price_from = mapdata.get(ColumnNames.SPECIALBED_PRICE_FROM);
    	this.specialbed_price_to = mapdata.get(ColumnNames.SPECIALBED_PRICE_TO);
    	this.bedsore = mapdata.get(ColumnNames.BEDSORE);
    	this.bedsore_price_from = mapdata.get(ColumnNames.BEDSORE_PRICE_FROM);
    	this.bedsore_price_to = mapdata.get(ColumnNames.BEDSORE_PRICE_TO);
    	this.phyconverter = mapdata.get(ColumnNames.PHYCONVERTER);
    	this.phyconverter_price_from = mapdata.get(ColumnNames.PHYCONVERTER_PRICE_FROM);
    	this.phyconverter_price_to = mapdata.get(ColumnNames.PHYCONVERTER_PRICE_TO);
    	this.handrail = mapdata.get(ColumnNames.HANDRAIL);
    	this.handrail_price_from = mapdata.get(ColumnNames.HANDRAIL_PRICE_FROM);
    	this.handrail_price_to = mapdata.get(ColumnNames.HANDRAIL_PRICE_TO);
    	this.slope = mapdata.get(ColumnNames.SLOPE);
    	this.slope_price_from = mapdata.get(ColumnNames.SLOPE_PRICE_FROM);
    	this.slope_price_to = mapdata.get(ColumnNames.SLOPE_PRICE_TO);
    	this.walker = mapdata.get(ColumnNames.WALKER);
    	this.walker_price_from = mapdata.get(ColumnNames.WALKER_PRICE_FROM);
    	this.walker_price_to = mapdata.get(ColumnNames.WALKER_PRICE_TO);
    	this.walkstick = mapdata.get(ColumnNames.WALKSTICK);
    	this.walkstick_price_from = mapdata.get(ColumnNames.WALKSTICK_PRICE_FROM);
    	this.walkstick_price_to = mapdata.get(ColumnNames.WALKSTICK_PRICE_TO);
    	this.dementialoiter = mapdata.get(ColumnNames.DEMENTIALOITER);
    	this.dementialoiter_price_from = mapdata.get(ColumnNames.DEMENTIALOITER_PRICE_FROM);
    	this.dementialoiter_price_to = mapdata.get(ColumnNames.DEMENTIALOITER_PRICE_TO);
    	this.lift = mapdata.get(ColumnNames.LIFT);
    	this.lift_price_from = mapdata.get(ColumnNames.LIFT_PRICE_FROM);
    	this.lift_price_to = mapdata.get(ColumnNames.LIFT_PRICE_TO);
    	this.autoexcretion = mapdata.get(ColumnNames.AUTOEXCRETION);
    	this.autoexcretion_price_from = mapdata.get(ColumnNames.AUTOEXCRETION_PRICE_FROM);
    	this.autoexcretion_price_to = mapdata.get(ColumnNames.AUTOEXCRETION_PRICE_TO);
    	this.outarea_price = mapdata.get(ColumnNames.OUTAREA_PRICE);
    	this.welfaretoolcarry_price = mapdata.get(ColumnNames.WELFARETOOLCARRY_PRICE);
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
