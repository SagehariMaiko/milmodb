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
@Table(name="short_life")
public class Short_Life extends GenericModel {
	@Id
	public Long office_id;
	public String office_type;
	public Boolean sub_kinoukunrenshidoin;
	public Boolean kinoukunrentaisei_yobo;
	public Boolean sub_kangotaisei_1;
	public Boolean sub_kangotaisei_2;
	public Boolean sub_nightdutyhaichi;
	public Boolean nintisyoshinritaio;
	public Boolean jyakunenseiriyo;
	public Boolean sougei_2;
	public Boolean sub_kinkyutankitaisei;
	public Boolean sub_kinkyutankiuke;
	public Boolean medical_meal;
	public Boolean sub_zaitakuuke;
	public Boolean service_supply_1;
	public Boolean service_supply_2;
	public Boolean service_supply_3;
	public Boolean carestaffkaizen_1;
	public Boolean carestaffkaizen_2;
	public Boolean carestaffkaizen_3;
	public Boolean unit_privateroom;
	public Boolean unit_semi_privateroom;
	public Boolean existingroom;
	public Boolean multibedroom;
	public String meal_price;
	public String stay_price_2;
	public String special_room_price;
	public String special_meal_price;
	public String hairdressing_price;
	public String daily_life_price;
	public Boolean userchargecut;
	
    public Short_Life(Map<String, String> mapdata, String formSerCd)  throws SQLException {    	
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
    	this.office_type = mapdata.get(ColumnNames.OFFICE_TYPE);
    	this.sub_kinoukunrenshidoin = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_KINOUKUNRENSHIDOIN);
    	this.kinoukunrentaisei_yobo = CommonFunc.func_setBit(mapdata,ColumnNames.KINOUKUNRENTAISEI_YOBO);
    	this.sub_kangotaisei_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_KANGOTAISEI_1);
    	this.sub_kangotaisei_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_KANGOTAISEI_2);
    	this.sub_nightdutyhaichi = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_NIGHTDUTYHAICHI);
    	this.nintisyoshinritaio = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSHINRITAIO);
    	this.jyakunenseiriyo = CommonFunc.func_setBit(mapdata,ColumnNames.JYAKUNENSEIRIYO);
    	this.sougei_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SOUGEI_2);
    	this.sub_kinkyutankitaisei = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_KINKYUTANKITAISEI);
    	this.sub_kinkyutankiuke = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_KINKYUTANKIUKE);
    	this.medical_meal = CommonFunc.func_setBit(mapdata,ColumnNames.MEDICAL_MEAL);
    	this.sub_zaitakuuke = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_ZAITAKUUKE);
    	this.service_supply_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_1);
    	this.service_supply_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_2);
    	this.service_supply_3 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_3);
    	this.carestaffkaizen_1 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_3);
    	this.unit_privateroom = CommonFunc.func_setBit(mapdata,ColumnNames.UNIT_PRIVATEROOM);
    	this.unit_semi_privateroom = CommonFunc.func_setBit(mapdata,ColumnNames.UNIT_SEMI_PRIVATEROOM);
    	this.existingroom = CommonFunc.func_setBit(mapdata,ColumnNames.EXISTINGROOM);
    	this.multibedroom = CommonFunc.func_setBit(mapdata,ColumnNames.MULTIBEDROOM);
    	this.meal_price = mapdata.get(ColumnNames.MEAL_PRICE);
    	this.stay_price_2 = mapdata.get(ColumnNames.STAY_PRICE_2);
    	this.special_room_price = mapdata.get(ColumnNames.SPECIAL_ROOM_PRICE);
    	this.special_meal_price = mapdata.get(ColumnNames.SPECIAL_MEAL_PRICE);
    	this.hairdressing_price = mapdata.get(ColumnNames.HAIRDRESSING_PRICE);
    	this.daily_life_price = mapdata.get(ColumnNames.DAILY_LIFE_PRICE);
    	this.userchargecut = CommonFunc.func_setBit(mapdata,ColumnNames.USERCHARGECUT);
    }
}
