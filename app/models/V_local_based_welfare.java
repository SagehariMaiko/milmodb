package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;

@Entity
@Table(name="v_local_based_welfare")
public class V_local_based_welfare extends MilmoDBEntity {
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
    public String nitijyokeizoku;
    public String kangotaisei_1;
    public String kangotaisei_2;
    public String nightdutyhaichi;
    public String semi_unitcare;
    public String private_kinou;
    public String jyakunenseinyusyo;
    public String doctor_haiti;
    public String seishinkairyo;
    public String syogaisyashien;
    public String taisyomaesoudan;
    public String taisyogoshido;
    public String taisyojisoudan;
    public String taisyomaerenkei;
    public String eiyomanage;
    public String keikoikou;
    public String keikoiji;
    public String koukutaisei;
    public String kouku;
    public String medical_meal;
    public String caregiving;
    public String zaitakuhukki;
    public String zaitakunyusyo;
    public String small_kyoten;
    public String nintisyosenmon_1;
    public String nintisyosenmon_2;
    public String nintisyoshinritaio;
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
    public String residence_price;
    public String special_room_price;
    public String special_meal_price;
    public String hairdressing_price;
    public String daily_life_price;
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
    	this.nitijyokeizoku = mapdata.get(ColumnNames.NITIJYOKEIZOKU);
    	this.kangotaisei_1 = mapdata.get(ColumnNames.KANGOTAISEI_1);
    	this.kangotaisei_2 = mapdata.get(ColumnNames.KANGOTAISEI_2);
    	this.nightdutyhaichi = mapdata.get(ColumnNames.NIGHTDUTYHAICHI);
    	this.semi_unitcare = mapdata.get(ColumnNames.SEMI_UNITCARE);
    	this.private_kinou = mapdata.get(ColumnNames.PRIVATE_KINOU);
    	this.jyakunenseinyusyo = mapdata.get(ColumnNames.JYAKUNENSEINYUSYO);
    	this.doctor_haiti = mapdata.get(ColumnNames.DOCTOR_HAITI);
    	this.seishinkairyo = mapdata.get(ColumnNames.SEISHINKAIRYO);
    	this.syogaisyashien = mapdata.get(ColumnNames.SYOGAISYASHIEN);
    	this.taisyomaesoudan = mapdata.get(ColumnNames.TAISYOMAESOUDAN);
    	this.taisyogoshido = mapdata.get(ColumnNames.TAISYOGOSHIDO);
    	this.taisyojisoudan = mapdata.get(ColumnNames.TAISYOJISOUDAN);
    	this.taisyomaerenkei = mapdata.get(ColumnNames.TAISYOMAERENKEI);
    	this.eiyomanage = mapdata.get(ColumnNames.EIYOMANAGE);
    	this.keikoikou = mapdata.get(ColumnNames.KEIKOIKOU);
    	this.keikoiji = mapdata.get(ColumnNames.KEIKOIJI);
    	this.koukutaisei = mapdata.get(ColumnNames.KOUKUTAISEI);
    	this.kouku = mapdata.get(ColumnNames.KOUKU);
    	this.medical_meal = mapdata.get(ColumnNames.MEDICAL_MEAL);
    	this.caregiving = mapdata.get(ColumnNames.CAREGIVING);
    	this.zaitakuhukki = mapdata.get(ColumnNames.ZAITAKUHUKKI);
    	this.zaitakunyusyo = mapdata.get(ColumnNames.ZAITAKUNYUSYO);
    	this.small_kyoten = mapdata.get(ColumnNames.SMALL_KYOTEN);
    	this.nintisyosenmon_1 = mapdata.get(ColumnNames.NINTISYOSENMON_1);
    	this.nintisyosenmon_2 = mapdata.get(ColumnNames.NINTISYOSENMON_2);
    	this.nintisyoshinritaio = mapdata.get(ColumnNames.NINTISYOSHINRITAIO);
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
    	this.residence_price = mapdata.get(ColumnNames.RESIDENCE_PRICE);
    	this.special_room_price = mapdata.get(ColumnNames.SPECIAL_ROOM_PRICE);
    	this.special_meal_price = mapdata.get(ColumnNames.SPECIAL_MEAL_PRICE);
    	this.hairdressing_price = mapdata.get(ColumnNames.HAIRDRESSING_PRICE);
    	this.daily_life_price = mapdata.get(ColumnNames.DAILY_LIFE_PRICE);
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
