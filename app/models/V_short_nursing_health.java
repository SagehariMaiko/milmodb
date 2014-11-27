package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;

@Entity
@Table(name="v_short_nursing_health")
public class V_short_nursing_health extends MilmoDBEntity {
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
    
    public String office_type_2;
    public String nightdutyhaichi;
    public String rehabilikyouka;
    public String private_rehabili;
    public String sub_nintisyocare;
    public String nintisyoshinritaio;
    public String kinkyutankiuke;
    public String jyakunenseiriyo;
    public String sub_jyudoryoyo;
    public String sougei_2;
    public String ryoyoiji_1;
    public String medical_meal;
    public String kinkyujitiryo;
    public String tokuteitiryo;
    public String service_supply_1;
    public String service_supply_2;
    public String service_supply_3;
    public String carestaffkaizen_1;
    public String carestaffkaizen_2;
    public String carestaffkaizen_3;
    public String unit_privateroom;
    public String unit_semi_privateroom;
    public String existingroom;
    public String multibedroom;
    public String meal_price;
    public String stay_price_2;
    public String special_nursing_price;
    public String special_meal_price;
    public String hairdressing_price;
    public String daily_life_price;
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
    	this.office_type_2 = mapdata.get(ColumnNames.OFFICE_TYPE_2);
    	this.nightdutyhaichi = mapdata.get(ColumnNames.NIGHTDUTYHAICHI);
    	this.rehabilikyouka = mapdata.get(ColumnNames.REHABILIKYOUKA);
    	this.private_rehabili = mapdata.get(ColumnNames.PRIVATE_REHABILI);
    	this.sub_nintisyocare = mapdata.get(ColumnNames.SUB_NINTISYOCARE);
    	this.nintisyoshinritaio = mapdata.get(ColumnNames.NINTISYOSHINRITAIO);
    	this.kinkyutankiuke = mapdata.get(ColumnNames.KINKYUTANKIUKE);
    	this.jyakunenseiriyo = mapdata.get(ColumnNames.JYAKUNENSEIRIYO);
    	this.sub_jyudoryoyo = mapdata.get(ColumnNames.SUB_JYUDORYOYO);
    	this.sougei_2 = mapdata.get(ColumnNames.SOUGEI_2);
    	this.ryoyoiji_1 = mapdata.get(ColumnNames.RYOYOIJI_1);
    	this.medical_meal = mapdata.get(ColumnNames.MEDICAL_MEAL);
    	this.kinkyujitiryo = mapdata.get(ColumnNames.KINKYUJITIRYO);
    	this.tokuteitiryo = mapdata.get(ColumnNames.TOKUTEITIRYO);
    	this.service_supply_1 = mapdata.get(ColumnNames.SERVICE_SUPPLY_1);
    	this.service_supply_2 = mapdata.get(ColumnNames.SERVICE_SUPPLY_2);
    	this.service_supply_3 = mapdata.get(ColumnNames.SERVICE_SUPPLY_3);
    	this.carestaffkaizen_1 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_3);
    	this.unit_privateroom = mapdata.get(ColumnNames.UNIT_PRIVATEROOM);
    	this.unit_semi_privateroom = mapdata.get(ColumnNames.UNIT_SEMI_PRIVATEROOM);
    	this.existingroom = mapdata.get(ColumnNames.EXISTINGROOM);
    	this.multibedroom = mapdata.get(ColumnNames.MULTIBEDROOM);
    	this.meal_price = mapdata.get(ColumnNames.MEAL_PRICE);
    	this.stay_price_2 = mapdata.get(ColumnNames.STAY_PRICE_2);
    	this.special_nursing_price = mapdata.get(ColumnNames.SPECIAL_NURSING_PRICE);
    	this.special_meal_price = mapdata.get(ColumnNames.SPECIAL_MEAL_PRICE);
    	this.hairdressing_price = mapdata.get(ColumnNames.HAIRDRESSING_PRICE);
    	this.daily_life_price = mapdata.get(ColumnNames.DAILY_LIFE_PRICE);
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
