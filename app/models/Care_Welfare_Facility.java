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
@Table(name="care_welfare_facility")
public class Care_Welfare_Facility extends GenericModel {
	@Id
	public Long office_id;
	public Boolean nitijyokeizoku;
	public Boolean kangotaisei_1;
	public Boolean kangotaisei_2;
	public Boolean nightdutyhaichi;
	public Boolean semi_unitcare;
	public Boolean private_kinou;
	public Boolean jyakunenseinyusyo;
	public Boolean doctor_haiti;
	public Boolean seishinkairyo;
	public Boolean syogaisyashien;
	public Boolean taisyomaesoudan;
	public Boolean taisyogosoudan;
	public Boolean taisyojisoudan;
	public Boolean taisyomaerenkei;
	public Boolean eiyomanage;
	public Boolean keikoikou;
	public Boolean keikoiji;
	public Boolean koukutaisei;
	public Boolean kouku;
	public Boolean medical_meal;
	public Boolean caregiving;
	public Boolean zaitakuhukki;
	public Boolean zaitakunyusyo;
	public Boolean nintisyosenmon_1;
	public Boolean nintisyosenmon_2;
	public Boolean nintisyoshinritaio;
	public Boolean service_supply_1;
	public Boolean service_supply_2;
	public Boolean service_supply_3;
	public Boolean carestaffkaizen_1;
	public Boolean carestaffkaizen_2;
	public Boolean carestaffkaizen_3;
	public Integer entrance_capacity;
	public Boolean unit_privateroom;
	public Boolean unit_semi_privateroom;
	public Boolean existingroom;
	public Boolean multibedroom;
	public String meal_price;
	public String residence_price;
	public String special_room_price;
	public String special_meal_price;
	public String hairdressing_price;
	public String daily_life_price;
	public Boolean userchargecut;

	public Care_Welfare_Facility(Map<String, String> mapdata, String formSerCd)	 throws SQLException {
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
		this.nitijyokeizoku = CommonFunc.func_setBit(mapdata,ColumnNames.NITIJYOKEIZOKU);
		this.kangotaisei_1 = CommonFunc.func_setBit(mapdata,ColumnNames.KANGOTAISEI_1);
		this.kangotaisei_2 = CommonFunc.func_setBit(mapdata,ColumnNames.KANGOTAISEI_2);
		this.nightdutyhaichi = CommonFunc.func_setBit(mapdata,ColumnNames.NIGHTDUTYHAICHI);
		this.semi_unitcare = CommonFunc.func_setBit(mapdata,ColumnNames.SEMI_UNITCARE);
		this.private_kinou = CommonFunc.func_setBit(mapdata,ColumnNames.PRIVATE_KINOU);
		this.jyakunenseinyusyo = CommonFunc.func_setBit(mapdata,ColumnNames.JYAKUNENSEINYUSYO);
		this.doctor_haiti = CommonFunc.func_setBit(mapdata,ColumnNames.DOCTOR_HAITI);
		this.seishinkairyo = CommonFunc.func_setBit(mapdata,ColumnNames.SEISHINKAIRYO);
		this.syogaisyashien = CommonFunc.func_setBit(mapdata,ColumnNames.SYOGAISYASHIEN);
		this.taisyomaesoudan = CommonFunc.func_setBit(mapdata,ColumnNames.TAISYOMAESOUDAN);
		this.taisyogosoudan = CommonFunc.func_setBit(mapdata,ColumnNames.TAISYOGOSOUDAN);
		this.taisyojisoudan = CommonFunc.func_setBit(mapdata,ColumnNames.TAISYOJISOUDAN);
		this.taisyomaerenkei = CommonFunc.func_setBit(mapdata,ColumnNames.TAISYOMAERENKEI);
		this.eiyomanage = CommonFunc.func_setBit(mapdata,ColumnNames.EIYOMANAGE);
		this.keikoikou = CommonFunc.func_setBit(mapdata,ColumnNames.KEIKOIKOU);
		this.keikoiji = CommonFunc.func_setBit(mapdata,ColumnNames.KEIKOIJI);
		this.koukutaisei = CommonFunc.func_setBit(mapdata,ColumnNames.KOUKUTAISEI);
		this.kouku = CommonFunc.func_setBit(mapdata,ColumnNames.KOUKU);
		this.medical_meal = CommonFunc.func_setBit(mapdata,ColumnNames.MEDICAL_MEAL);
		this.caregiving = CommonFunc.func_setBit(mapdata,ColumnNames.CAREGIVING);
		this.zaitakuhukki = CommonFunc.func_setBit(mapdata,ColumnNames.ZAITAKUHUKKI);
		this.zaitakunyusyo = CommonFunc.func_setBit(mapdata,ColumnNames.ZAITAKUNYUSYO);
		this.nintisyosenmon_1 = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSENMON_1);
		this.nintisyosenmon_2 = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSENMON_2);
		this.nintisyoshinritaio = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSHINRITAIO);
		this.service_supply_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_1);
		this.service_supply_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_2);
		this.service_supply_3 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_3);
		this.carestaffkaizen_1 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_1);
		this.carestaffkaizen_2 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_2);
		this.carestaffkaizen_3 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_3);
		this.entrance_capacity = Integer.valueOf(mapdata.get(ColumnNames.ENTRANCE_CAPACITY));
		this.unit_privateroom = CommonFunc.func_setBit(mapdata,ColumnNames.UNIT_PRIVATEROOM);
		this.unit_semi_privateroom = CommonFunc.func_setBit(mapdata,ColumnNames.UNIT_SEMI_PRIVATEROOM);
		this.existingroom = CommonFunc.func_setBit(mapdata,ColumnNames.EXISTINGROOM);
		this.multibedroom = CommonFunc.func_setBit(mapdata,ColumnNames.MULTIBEDROOM);
		this.meal_price = mapdata.get(ColumnNames.MEAL_PRICE);
		this.residence_price = mapdata.get(ColumnNames.RESIDENCE_PRICE);
		this.special_room_price = mapdata.get(ColumnNames.SPECIAL_ROOM_PRICE);
		this.special_meal_price = mapdata.get(ColumnNames.SPECIAL_MEAL_PRICE);
		this.hairdressing_price = mapdata.get(ColumnNames.HAIRDRESSING_PRICE);
		this.daily_life_price = mapdata.get(ColumnNames.DAILY_LIFE_PRICE);
		this.userchargecut = CommonFunc.func_setBit(mapdata,ColumnNames.USERCHARGECUT);
	}

}
