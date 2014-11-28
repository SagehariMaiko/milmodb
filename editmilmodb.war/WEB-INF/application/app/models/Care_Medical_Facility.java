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
@Table(name="care_medical_facility")
public class Care_Medical_Facility extends GenericModel {
	@Id
	public Long office_id;
	public String office_kubun;
	public Boolean nightkango_1;
	public Boolean nightkango_2;
	public Boolean nightkango_3;
	public Boolean nightkango_4;
	public Boolean nothing_add;
	public Boolean ryoyobyousyo;
	public Boolean nintisyobyoto;
	public Boolean jyakunenseikanjya;
	public Boolean gaihaku;
	public Boolean shikotekitaiinn;
	public Boolean takajyushin;
	public Boolean taiinmaeshido;
	public Boolean taiingoshido;
	public Boolean taiinjishido;
	public Boolean taiinjiinfo;
	public Boolean taiinmaerenkei;
	public Boolean roujinkangoshiji;
	public Boolean eiyomanage;
	public Boolean keikoikou;
	public Boolean keikoiji;
	public Boolean koukutaisei;
	public Boolean kouku;
	public Boolean medical_meal;
	public Boolean zaitakuhukki;
	public Boolean tokuteishinryo;
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
	public String special_sickroom_price;
	public String special_meal_price;
	public String hairdressing_price;
	public String daily_life_price;

	public Care_Medical_Facility(Map<String, String> mapdata, String formSerCd)	 throws SQLException {
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
		this.office_kubun = mapdata.get(ColumnNames.OFFICE_KUBUN);
		this.nightkango_1 = CommonFunc.func_setBit(mapdata,ColumnNames.NIGHTKANGO_1);
		this.nightkango_2 = CommonFunc.func_setBit(mapdata,ColumnNames.NIGHTKANGO_2);
		this.nightkango_3 = CommonFunc.func_setBit(mapdata,ColumnNames.NIGHTKANGO_3);
		this.nightkango_4 = CommonFunc.func_setBit(mapdata,ColumnNames.NIGHTKANGO_4);
		this.nothing_add = CommonFunc.func_setBit(mapdata,ColumnNames.NOTHING_ADD);
		this.ryoyobyousyo = CommonFunc.func_setBit(mapdata,ColumnNames.RYOYOBYOUSYO);
		this.nintisyobyoto = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOBYOTO);
		this.jyakunenseikanjya = CommonFunc.func_setBit(mapdata,ColumnNames.JYAKUNENSEIKANJYA);
		this.gaihaku = CommonFunc.func_setBit(mapdata,ColumnNames.GAIHAKU);
		this.shikotekitaiinn = CommonFunc.func_setBit(mapdata,ColumnNames.SHIKOTEKITAIINN);
		this.takajyushin = CommonFunc.func_setBit(mapdata,ColumnNames.TAKAJYUSHIN);
		this.taiinmaeshido = CommonFunc.func_setBit(mapdata,ColumnNames.TAIINMAESHIDO);
		this.taiingoshido = CommonFunc.func_setBit(mapdata,ColumnNames.TAIINGOSHIDO);
		this.taiinjishido = CommonFunc.func_setBit(mapdata,ColumnNames.TAIINJISHIDO);
		this.taiinjiinfo = CommonFunc.func_setBit(mapdata,ColumnNames.TAIINJIINFO);
		this.taiinmaerenkei = CommonFunc.func_setBit(mapdata,ColumnNames.TAIINMAERENKEI);
		this.roujinkangoshiji = CommonFunc.func_setBit(mapdata,ColumnNames.ROUJINKANGOSHIJI);
		this.eiyomanage = CommonFunc.func_setBit(mapdata,ColumnNames.EIYOMANAGE);
		this.keikoikou = CommonFunc.func_setBit(mapdata,ColumnNames.KEIKOIKOU);
		this.keikoiji = CommonFunc.func_setBit(mapdata,ColumnNames.KEIKOIJI);
		this.koukutaisei = CommonFunc.func_setBit(mapdata,ColumnNames.KOUKUTAISEI);
		this.kouku = CommonFunc.func_setBit(mapdata,ColumnNames.KOUKU);
		this.medical_meal = CommonFunc.func_setBit(mapdata,ColumnNames.MEDICAL_MEAL);
		this.zaitakuhukki = CommonFunc.func_setBit(mapdata,ColumnNames.ZAITAKUHUKKI);
		this.tokuteishinryo = CommonFunc.func_setBit(mapdata,ColumnNames.TOKUTEISHINRYO);
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
		this.special_sickroom_price = mapdata.get(ColumnNames.SPECIAL_SICKROOM_PRICE);
		this.special_meal_price = mapdata.get(ColumnNames.SPECIAL_MEAL_PRICE);
		this.hairdressing_price = mapdata.get(ColumnNames.HAIRDRESSING_PRICE);
		this.daily_life_price = mapdata.get(ColumnNames.DAILY_LIFE_PRICE);
	}
}
