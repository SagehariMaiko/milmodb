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
@Table(name="dementia_communal_lifecare")
public class Dementia_Communal_Lifecare extends GenericModel {
	@Id
	public Long office_id;
	public Boolean night_care_1;
	public Boolean night_care_2;
	public Boolean nintisyoshinritaio;
	public Boolean jyakunenseiriyo;
	public Boolean sub_caregiving;
	public Boolean sub_medicalrenkeitaisei;
	public Boolean taikyojisoudan;
	public Boolean nintisyosenmon_1;
	public Boolean nintisyosenmon_2;
	public Boolean service_supply_1;
	public Boolean service_supply_2;
	public Boolean service_supply_3;
	public Boolean carestaffkaizen_1;
	public Boolean carestaffkaizen_2;
	public Boolean carestaffkaizen_3;
	public Boolean shortuse_communal_lifecare;
	public Boolean share_dementia_daycare;
	public String movein_capacity;
	public Integer rent;
	public Integer deposit;
	public Integer security_money;
	public Integer morning_price;
	public Integer lunch_price;
	public Integer dinner_price;
	public Integer snack_price;
	public Integer meal_day_price;
	public Integer hairdressing_price_2;
	public String hairdressing_biko_2;
	public Integer diaper_price;
	public String diaper_biko;
	public String other_name_3;
	public Integer other_price_3;
	public String other_biko_3;
	public String other_name_4;
	public Integer other_price_4;
	public String other_biko_4;
	public String other_name_5;
	public Integer other_price_5;
	public String other_biko_5;

	public Dementia_Communal_Lifecare(Map<String, String> mapdata, String formSerCd)  throws SQLException {
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
		this.night_care_1 = CommonFunc.func_setBit(mapdata,ColumnNames.NIGHT_CARE_1);
		this.night_care_2 = CommonFunc.func_setBit(mapdata,ColumnNames.NIGHT_CARE_2);
		this.nintisyoshinritaio = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSHINRITAIO);
		this.jyakunenseiriyo = CommonFunc.func_setBit(mapdata,ColumnNames.JYAKUNENSEIRIYO);
		this.sub_caregiving = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_CAREGIVING);
		this.sub_medicalrenkeitaisei = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_MEDICALRENKEITAISEI);
		this.taikyojisoudan = CommonFunc.func_setBit(mapdata,ColumnNames.TAIKYOJISOUDAN);
		this.nintisyosenmon_1 = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSENMON_1);
		this.nintisyosenmon_2 = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSENMON_2);
		this.service_supply_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_1);
		this.service_supply_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_2);
		this.service_supply_3 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_3);
		this.carestaffkaizen_1 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_1);
		this.carestaffkaizen_2 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_2);
		this.carestaffkaizen_3 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_3);
		this.shortuse_communal_lifecare = CommonFunc.func_setBit(mapdata,ColumnNames.SHORTUSE_COMMUNAL_LIFECARE);
		this.share_dementia_daycare = CommonFunc.func_setBit(mapdata,ColumnNames.SHARE_DEMENTIA_DAYCARE);
		this.movein_capacity = mapdata.get(ColumnNames.MOVEIN_CAPACITY);
		this.rent = Integer.valueOf(mapdata.get(ColumnNames.RENT));
		this.deposit = Integer.valueOf(mapdata.get(ColumnNames.DEPOSIT));
		this.security_money = Integer.valueOf(mapdata.get(ColumnNames.SECURITY_MONEY));
		this.morning_price = Integer.valueOf(mapdata.get(ColumnNames.MORNING_PRICE));
		this.lunch_price = Integer.valueOf(mapdata.get(ColumnNames.LUNCH_PRICE));
		this.dinner_price = Integer.valueOf(mapdata.get(ColumnNames.DINNER_PRICE));
		this.snack_price = Integer.valueOf(mapdata.get(ColumnNames.SNACK_PRICE));
		this.meal_day_price = Integer.valueOf(mapdata.get(ColumnNames.MEAL_DAY_PRICE));
		this.hairdressing_price_2 = Integer.valueOf(mapdata.get(ColumnNames.HAIRDRESSING_PRICE_2));
		this.hairdressing_biko_2 = mapdata.get(ColumnNames.HAIRDRESSING_BIKO_2);
		this.diaper_price = Integer.valueOf(mapdata.get(ColumnNames.DIAPER_PRICE));
		this.diaper_biko = mapdata.get(ColumnNames.DIAPER_BIKO);
		this.other_name_3 = mapdata.get(ColumnNames.OTHER_NAME_3);
		this.other_price_3 = Integer.valueOf(mapdata.get(ColumnNames.OTHER_PRICE_3));
		this.other_biko_3 = mapdata.get(ColumnNames.OTHER_BIKO_3);
		this.other_name_4 = mapdata.get(ColumnNames.OTHER_NAME_4);
		this.other_price_4 = Integer.valueOf(mapdata.get(ColumnNames.OTHER_PRICE_4));
		this.other_biko_4 = mapdata.get(ColumnNames.OTHER_BIKO_4);
		this.other_name_5 = mapdata.get(ColumnNames.OTHER_NAME_5);
		this.other_price_5 = Integer.valueOf(mapdata.get(ColumnNames.OTHER_PRICE_5));
		this.other_biko_5 = mapdata.get(ColumnNames.OTHER_BIKO_5);
	}
	
}
