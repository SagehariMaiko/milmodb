package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;

@Entity
@Table(name="v_dementia_communal_lifecare")
public class V_dementia_communal_lifecare extends MilmoDBEntity {
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
    public String night_care_1;
    public String night_care_2;
    public String nintisyoshinritaio;
    public String jyakunenseiriyo;
    public String sub_caregiving;
    public String sub_medicalrenkeitaisei;
    public String taikyojisoudan;
    public String nintisyosenmon_1;
    public String nintisyosenmon_2;
    public String service_supply_1;
    public String service_supply_2;
    public String service_supply_3;
    public String carestaffkaizen_1;
    public String carestaffkaizen_2;
    public String carestaffkaizen_3;
    public String shortuse_communal_lifecare;
    public String share_dementia_daycare;
    public String movein_capacity;
    public String rent;
    public String deposit;
    public String security_money;
    public String morning_price;
    public String lunch_price;
    public String dinner_price;
    public String snack_price;
    public String meal_day_price;
    public String hairdressing_price_2;
    public String hairdressing_biko_2;
    public String diaper_price;
    public String diaper_biko;
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
    	this.night_care_1 = mapdata.get(ColumnNames.NIGHT_CARE_1);
    	this.night_care_2 = mapdata.get(ColumnNames.NIGHT_CARE_2);
    	this.nintisyoshinritaio = mapdata.get(ColumnNames.NINTISYOSHINRITAIO);
    	this.jyakunenseiriyo = mapdata.get(ColumnNames.JYAKUNENSEIRIYO);
    	this.sub_caregiving = mapdata.get(ColumnNames.SUB_CAREGIVING);
    	this.sub_medicalrenkeitaisei = mapdata.get(ColumnNames.SUB_MEDICALRENKEITAISEI);
    	this.taikyojisoudan = mapdata.get(ColumnNames.TAIKYOJISOUDAN);
    	this.nintisyosenmon_1 = mapdata.get(ColumnNames.NINTISYOSENMON_1);
    	this.nintisyosenmon_2 = mapdata.get(ColumnNames.NINTISYOSENMON_2);
    	this.service_supply_1 = mapdata.get(ColumnNames.SERVICE_SUPPLY_1);
    	this.service_supply_2 = mapdata.get(ColumnNames.SERVICE_SUPPLY_2);
    	this.service_supply_3 = mapdata.get(ColumnNames.SERVICE_SUPPLY_3);
    	this.carestaffkaizen_1 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_3);
    	this.shortuse_communal_lifecare = mapdata.get(ColumnNames.SHORTUSE_COMMUNAL_LIFECARE);
    	this.share_dementia_daycare = mapdata.get(ColumnNames.SHARE_DEMENTIA_DAYCARE);
    	this.movein_capacity = mapdata.get(ColumnNames.MOVEIN_CAPACITY);
    	this.rent = mapdata.get(ColumnNames.RENT);
    	this.deposit = mapdata.get(ColumnNames.DEPOSIT);
    	this.security_money = mapdata.get(ColumnNames.SECURITY_MONEY);
    	this.morning_price = mapdata.get(ColumnNames.MORNING_PRICE);
    	this.lunch_price = mapdata.get(ColumnNames.LUNCH_PRICE);
    	this.dinner_price = mapdata.get(ColumnNames.DINNER_PRICE);
    	this.snack_price = mapdata.get(ColumnNames.SNACK_PRICE);
    	this.meal_day_price = mapdata.get(ColumnNames.MEAL_DAY_PRICE);
    	this.hairdressing_price_2 = mapdata.get(ColumnNames.HAIRDRESSING_PRICE_2);
    	this.hairdressing_biko_2 = mapdata.get(ColumnNames.HAIRDRESSING_BIKO_2);
    	this.diaper_price = mapdata.get(ColumnNames.DIAPER_PRICE);
    	this.diaper_biko = mapdata.get(ColumnNames.DIAPER_BIKO);
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
		return this.office_id;
	}
}
