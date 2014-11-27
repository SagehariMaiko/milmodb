package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;

@Entity
@Table(name="v_small_multi_home")
public class V_small_multi_home extends MilmoDBEntity {
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
    public String office_time_kayoi;
    public String office_time_stay;
    public String service_area;
    public String sougei_1;
    public String sub_nintisyo_1;
    public String sub_nintisyo_2;
    public String sub_kangohaiti_1;
    public String sub_kangohaiti_2;
    public String service_supply_1;
    public String service_supply_2;
    public String service_supply_3;
    public String carestaffkaizen_1;
    public String carestaffkaizen_2;
    public String carestaffkaizen_3;
    public String morning_price;
    public String lunch_price;
    public String dinner_price;
    public String snack_price;
    public String stay_price;
    public String other_name_1;
    public String other_price_1;
    public String other_biko_1;
    public String other_name_2;
    public String other_price_2;
    public String other_biko_2;
    public String other_name_3;
    public String other_price_3;
    public String other_biko_3;
    public String other_name_4;
    public String other_price_4;
    public String other_biko_4;
    public String other_name_5;
    public String other_price_5;
    public String other_biko_5;
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
    	this.office_time_kayoi = mapdata.get(ColumnNames.OFFICE_TIME_KAYOI);
    	this.office_time_stay = mapdata.get(ColumnNames.OFFICE_TIME_STAY);
    	this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
    	this.sougei_1 = mapdata.get(ColumnNames.SOUGEI_1);
    	this.sub_nintisyo_1 = mapdata.get(ColumnNames.SUB_NINTISYO_1);
    	this.sub_nintisyo_2 = mapdata.get(ColumnNames.SUB_NINTISYO_2);
    	this.sub_kangohaiti_1 = mapdata.get(ColumnNames.SUB_KANGOHAITI_1);
    	this.sub_kangohaiti_2 = mapdata.get(ColumnNames.SUB_KANGOHAITI_2);
    	this.service_supply_1 = mapdata.get(ColumnNames.SERVICE_SUPPLY_1);
    	this.service_supply_2 = mapdata.get(ColumnNames.SERVICE_SUPPLY_2);
    	this.service_supply_3 = mapdata.get(ColumnNames.SERVICE_SUPPLY_3);
    	this.carestaffkaizen_1 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_3);
    	this.morning_price = mapdata.get(ColumnNames.MORNING_PRICE);
    	this.lunch_price = mapdata.get(ColumnNames.LUNCH_PRICE);
    	this.dinner_price = mapdata.get(ColumnNames.DINNER_PRICE);
    	this.snack_price = mapdata.get(ColumnNames.SNACK_PRICE);
    	this.stay_price = mapdata.get(ColumnNames.STAY_PRICE);
    	this.other_name_1 = mapdata.get(ColumnNames.OTHER_NAME_1);
    	this.other_price_1 = mapdata.get(ColumnNames.OTHER_PRICE_1);
    	this.other_biko_1 = mapdata.get(ColumnNames.OTHER_BIKO_1);
    	this.other_name_2 = mapdata.get(ColumnNames.OTHER_NAME_2);
    	this.other_price_2 = mapdata.get(ColumnNames.OTHER_PRICE_2);
    	this.other_biko_2 = mapdata.get(ColumnNames.OTHER_BIKO_2);
    	this.other_name_3 = mapdata.get(ColumnNames.OTHER_NAME_3);
    	this.other_price_3 = mapdata.get(ColumnNames.OTHER_PRICE_3);
    	this.other_biko_3 = mapdata.get(ColumnNames.OTHER_BIKO_3);
    	this.other_name_4 = mapdata.get(ColumnNames.OTHER_NAME_4);
    	this.other_price_4 = mapdata.get(ColumnNames.OTHER_PRICE_4);
    	this.other_biko_4 = mapdata.get(ColumnNames.OTHER_BIKO_4);
    	this.other_name_5 = mapdata.get(ColumnNames.OTHER_NAME_5);
    	this.other_price_5 = mapdata.get(ColumnNames.OTHER_PRICE_5);
    	this.other_biko_5 = mapdata.get(ColumnNames.OTHER_BIKO_5);    	
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
		// TODO Auto-generated method stub
		return this.office_id;
	}

}
