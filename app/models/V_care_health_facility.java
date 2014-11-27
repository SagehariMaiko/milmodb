package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;

@Entity
@Table(name="v_care_health_facility")
public class V_care_health_facility extends MilmoDBEntity {
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
    public String nightdutyhaichi;
    public String tankirehabili;
    public String nintisyotankirehabili;
    public String nintisyocare;
    public String jyakunenseinyusyo;
    public String zaitakuhukkiryoyo;
    public String caregiving;
    public String ryoyoiji_2;
    public String nyusyozengoshido;
    public String taisyomaeshido;
    public String taisyogoshido;
    public String taisyojishido;
    public String taisyojiinfo;
    public String taisyomaerenkei;
    public String roujinkangoshiji;
    public String eiyomanage;
    public String keikoikou;
    public String keikoiji;
    public String koukutaisei;
    public String kouku;
    public String medical_meal;
    public String zaitakuhukki;
    public String kinkyujiryoyo;
    public String syoteishikkan;
    public String nintisyosenmon_1;
    public String nintisyosenmon_2;
    public String nintisyoshinritaio;
    public String nintisyoinfo;
    public String localrenkeikeikaku;
    public String service_supply_1;
    public String service_supply_2;
    public String service_supply_3;
    public String carestaffkaizen_1;
    public String carestaffkaizen_2;
    public String carestaffkaizen_3;
    public String entrance_capacity;
    public String care_health_facility;
    public String satellite_small_carehealth;
    public String medical_small_carehealth;
    public String unit_privateroom;
    public String unit_semi_privateroom;
    public String existingroom;
    public String multibedroom;
    public String meal_price;
    public String residence_price;
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
    	this.nightdutyhaichi = mapdata.get(ColumnNames.NIGHTDUTYHAICHI);
    	this.tankirehabili = mapdata.get(ColumnNames.TANKIREHABILI);
    	this.nintisyotankirehabili = mapdata.get(ColumnNames.NINTISYOTANKIREHABILI);
    	this.nintisyocare = mapdata.get(ColumnNames.NINTISYOCARE);
    	this.jyakunenseinyusyo = mapdata.get(ColumnNames.JYAKUNENSEINYUSYO);
    	this.zaitakuhukkiryoyo = mapdata.get(ColumnNames.ZAITAKUHUKKIRYOYO);
    	this.caregiving = mapdata.get(ColumnNames.CAREGIVING);
    	this.ryoyoiji_2 = mapdata.get(ColumnNames.RYOYOIJI_2);
    	this.nyusyozengoshido = mapdata.get(ColumnNames.NYUSYOZENGOSHIDO);
    	this.taisyomaeshido = mapdata.get(ColumnNames.TAISYOMAESHIDO);
    	this.taisyogoshido = mapdata.get(ColumnNames.TAISYOGOSHIDO);
    	this.taisyojishido = mapdata.get(ColumnNames.TAISYOJISHIDO);
    	this.taisyojiinfo = mapdata.get(ColumnNames.TAISYOJIINFO);
    	this.taisyomaerenkei = mapdata.get(ColumnNames.TAISYOMAERENKEI);
    	this.roujinkangoshiji = mapdata.get(ColumnNames.ROUJINKANGOSHIJI);
    	this.eiyomanage = mapdata.get(ColumnNames.EIYOMANAGE);
    	this.keikoikou = mapdata.get(ColumnNames.KEIKOIKOU);
    	this.keikoiji = mapdata.get(ColumnNames.KEIKOIJI);
    	this.koukutaisei = mapdata.get(ColumnNames.KOUKUTAISEI);
    	this.kouku = mapdata.get(ColumnNames.KOUKU);
    	this.medical_meal = mapdata.get(ColumnNames.MEDICAL_MEAL);
    	this.zaitakuhukki = mapdata.get(ColumnNames.ZAITAKUHUKKI);
    	this.kinkyujiryoyo = mapdata.get(ColumnNames.KINKYUJIRYOYO);
    	this.syoteishikkan = mapdata.get(ColumnNames.SYOTEISHIKKAN);
    	this.nintisyosenmon_1 = mapdata.get(ColumnNames.NINTISYOSENMON_1);
    	this.nintisyosenmon_2 = mapdata.get(ColumnNames.NINTISYOSENMON_2);
    	this.nintisyoshinritaio = mapdata.get(ColumnNames.NINTISYOSHINRITAIO);
    	this.nintisyoinfo = mapdata.get(ColumnNames.NINTISYOINFO);
    	this.localrenkeikeikaku = mapdata.get(ColumnNames.LOCALRENKEIKEIKAKU);
    	this.service_supply_1 = mapdata.get(ColumnNames.SERVICE_SUPPLY_1);
    	this.service_supply_2 = mapdata.get(ColumnNames.SERVICE_SUPPLY_2);
    	this.service_supply_3 = mapdata.get(ColumnNames.SERVICE_SUPPLY_3);
    	this.carestaffkaizen_1 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_3);
    	this.entrance_capacity = mapdata.get(ColumnNames.ENTRANCE_CAPACITY);
    	this.care_health_facility = mapdata.get(ColumnNames.CARE_HEALTH_FACILITY);
    	this.satellite_small_carehealth = mapdata.get(ColumnNames.SATELLITE_SMALL_CAREHEALTH);
    	this.medical_small_carehealth = mapdata.get(ColumnNames.MEDICAL_SMALL_CAREHEALTH);
    	this.unit_privateroom = mapdata.get(ColumnNames.UNIT_PRIVATEROOM);
    	this.unit_semi_privateroom = mapdata.get(ColumnNames.UNIT_SEMI_PRIVATEROOM);
    	this.existingroom = mapdata.get(ColumnNames.EXISTINGROOM);
    	this.multibedroom = mapdata.get(ColumnNames.MULTIBEDROOM);
    	this.meal_price = mapdata.get(ColumnNames.MEAL_PRICE);
    	this.residence_price = mapdata.get(ColumnNames.RESIDENCE_PRICE);
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
