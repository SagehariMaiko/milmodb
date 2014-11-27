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
@Table(name="care_health_facility")
public class Care_Health_Facility extends GenericModel {
	@Id
	public Long office_id;
	public Boolean nightdutyhaichi;
	public Boolean tankirehabili;
	public Boolean nintisyotankirehabili;
	public Boolean nintisyocare;
	public Boolean jyakunenseinyusyo;
	public Boolean zaitakuhukkiryoyo;
	public Boolean caregiving;
	public Boolean ryoyoiji_2;
	public Boolean nyusyozengoshido;
	public Boolean taisyomaeshido;
	public Boolean taisyogoshido;
	public Boolean taisyojishido;
	public Boolean taisyojiinfo;
	public Boolean taisyomaerenkei;
	public Boolean roujinkangoshiji;
	public Boolean eiyomanage;
	public Boolean keikoikou;
	public Boolean keikoiji;
	public Boolean koukutaisei;
	public Boolean kouku;
	public Boolean medical_meal;
	public Boolean zaitakuhukki;
	public Boolean kinkyujiryoyo;
	public Boolean syoteishikkan;
	public Boolean nintisyosenmon_1;
	public Boolean nintisyosenmon_2;
	public Boolean nintisyoshinritaio;
	public Boolean nintisyoinfo;
	public Boolean localrenkeikeikaku;
	public Boolean service_supply_1;
	public Boolean service_supply_2;
	public Boolean service_supply_3;
	public Boolean carestaffkaizen_1;
	public Boolean carestaffkaizen_2;
	public Boolean carestaffkaizen_3;
	public Integer entrance_capacity;
	public Boolean care_health_facility;
	public Boolean satellite_small_carehealth;
	public Boolean medical_small_carehealth;
	public Boolean unit_privateroom;
	public Boolean unit_semi_privateroom;
	public Boolean existingroom;
	public Boolean multibedroom;
	public String meal_price;
	public String residence_price;
	public String special_nursing_price;
	public String special_meal_price;
	public String hairdressing_price;
	public String daily_life_price;

	public Care_Health_Facility(Map<String, String> mapdata, String formSerCd)	throws SQLException {
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
		this.nightdutyhaichi = CommonFunc.func_setBit(mapdata,ColumnNames.NIGHTDUTYHAICHI);
		this.tankirehabili = CommonFunc.func_setBit(mapdata,ColumnNames.TANKIREHABILI);
		this.nintisyotankirehabili = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOTANKIREHABILI);
		this.nintisyocare = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOCARE);
		this.jyakunenseinyusyo = CommonFunc.func_setBit(mapdata,ColumnNames.JYAKUNENSEINYUSYO);
		this.zaitakuhukkiryoyo = CommonFunc.func_setBit(mapdata,ColumnNames.ZAITAKUHUKKIRYOYO);
		this.caregiving = CommonFunc.func_setBit(mapdata,ColumnNames.CAREGIVING);
		this.ryoyoiji_2 = CommonFunc.func_setBit(mapdata,ColumnNames.RYOYOIJI_2);
		this.nyusyozengoshido = CommonFunc.func_setBit(mapdata,ColumnNames.NYUSYOZENGOSHIDO);
		this.taisyomaeshido = CommonFunc.func_setBit(mapdata,ColumnNames.TAISYOMAESHIDO);
		this.taisyogoshido = CommonFunc.func_setBit(mapdata,ColumnNames.TAISYOGOSHIDO);
		this.taisyojishido = CommonFunc.func_setBit(mapdata,ColumnNames.TAISYOJISHIDO);
		this.taisyojiinfo = CommonFunc.func_setBit(mapdata,ColumnNames.TAISYOJIINFO);
		this.taisyomaerenkei = CommonFunc.func_setBit(mapdata,ColumnNames.TAISYOMAERENKEI);
		this.roujinkangoshiji = CommonFunc.func_setBit(mapdata,ColumnNames.ROUJINKANGOSHIJI);
		this.eiyomanage = CommonFunc.func_setBit(mapdata,ColumnNames.EIYOMANAGE);
		this.keikoikou = CommonFunc.func_setBit(mapdata,ColumnNames.KEIKOIKOU);
		this.keikoiji = CommonFunc.func_setBit(mapdata,ColumnNames.KEIKOIJI);
		this.koukutaisei = CommonFunc.func_setBit(mapdata,ColumnNames.KOUKUTAISEI);
		this.kouku = CommonFunc.func_setBit(mapdata,ColumnNames.KOUKU);
		this.medical_meal = CommonFunc.func_setBit(mapdata,ColumnNames.MEDICAL_MEAL);
		this.zaitakuhukki = CommonFunc.func_setBit(mapdata,ColumnNames.ZAITAKUHUKKI);
		this.kinkyujiryoyo = CommonFunc.func_setBit(mapdata,ColumnNames.KINKYUJIRYOYO);
		this.syoteishikkan = CommonFunc.func_setBit(mapdata,ColumnNames.SYOTEISHIKKAN);
		this.nintisyosenmon_1 = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSENMON_1);
		this.nintisyosenmon_2 = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSENMON_2);
		this.nintisyoshinritaio = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSHINRITAIO);
		this.nintisyoinfo = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOINFO);
		this.localrenkeikeikaku = CommonFunc.func_setBit(mapdata,ColumnNames.LOCALRENKEIKEIKAKU);
		this.service_supply_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_1);
		this.service_supply_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_2);
		this.service_supply_3 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_3);
		this.carestaffkaizen_1 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_1);
		this.carestaffkaizen_2 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_2);
		this.carestaffkaizen_3 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_3);
		this.entrance_capacity = Integer.valueOf(mapdata.get(ColumnNames.ENTRANCE_CAPACITY));
		this.care_health_facility = CommonFunc.func_setBit(mapdata,ColumnNames.CARE_HEALTH_FACILITY);
		this.satellite_small_carehealth = CommonFunc.func_setBit(mapdata,ColumnNames.SATELLITE_SMALL_CAREHEALTH);
		this.medical_small_carehealth = CommonFunc.func_setBit(mapdata,ColumnNames.MEDICAL_SMALL_CAREHEALTH);
		this.unit_privateroom = CommonFunc.func_setBit(mapdata,ColumnNames.UNIT_PRIVATEROOM);
		this.unit_semi_privateroom = CommonFunc.func_setBit(mapdata,ColumnNames.UNIT_SEMI_PRIVATEROOM);
		this.existingroom = CommonFunc.func_setBit(mapdata,ColumnNames.EXISTINGROOM);
		this.multibedroom = CommonFunc.func_setBit(mapdata,ColumnNames.MULTIBEDROOM);
		this.meal_price = mapdata.get(ColumnNames.MEAL_PRICE);
		this.residence_price = mapdata.get(ColumnNames.RESIDENCE_PRICE);
		this.special_nursing_price = mapdata.get(ColumnNames.SPECIAL_NURSING_PRICE);
		this.special_meal_price = mapdata.get(ColumnNames.SPECIAL_MEAL_PRICE);
		this.hairdressing_price = mapdata.get(ColumnNames.HAIRDRESSING_PRICE);
		this.daily_life_price = mapdata.get(ColumnNames.DAILY_LIFE_PRICE);
	}
}
