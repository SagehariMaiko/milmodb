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
@Table(name="short_nursing_health")
public class Short_Nursing_Health extends GenericModel {
	@Id
	public Long office_id;
	public String office_type_2;
	public Boolean nightdutyhaichi;
	public Boolean rehabilikyouka;
	public Boolean private_rehabili;
	public Boolean sub_nintisyocare;
	public Boolean nintisyoshinritaio;
	public Boolean kinkyutankiuke;
	public Boolean jyakunenseiriyo;
	public Boolean sub_jyudoryoyo;
	public Boolean sougei_2;
	public Boolean ryoyoiji_1;
	public Boolean medical_meal;
	public Boolean kinkyujitiryo;
	public Boolean tokuteitiryo;
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
	public String special_nursing_price;
	public String special_meal_price;
	public String hairdressing_price;
	public String daily_life_price;	
	
    public Short_Nursing_Health(Map<String, String> mapdata, String formSerCd)  throws SQLException {    	
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
    	this.office_type_2 = mapdata.get(ColumnNames.OFFICE_TYPE_2);
    	this.nightdutyhaichi = CommonFunc.func_setBit(mapdata,ColumnNames.NIGHTDUTYHAICHI);
    	this.rehabilikyouka = CommonFunc.func_setBit(mapdata,ColumnNames.REHABILIKYOUKA);
    	this.private_rehabili = CommonFunc.func_setBit(mapdata,ColumnNames.PRIVATE_REHABILI);
    	this.sub_nintisyocare = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_NINTISYOCARE);
    	this.nintisyoshinritaio = CommonFunc.func_setBit(mapdata,ColumnNames.NINTISYOSHINRITAIO);
    	this.kinkyutankiuke = CommonFunc.func_setBit(mapdata,ColumnNames.KINKYUTANKIUKE);
    	this.jyakunenseiriyo = CommonFunc.func_setBit(mapdata,ColumnNames.JYAKUNENSEIRIYO);
    	this.sub_jyudoryoyo = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_JYUDORYOYO);
    	this.sougei_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SOUGEI_2);
    	this.ryoyoiji_1 = CommonFunc.func_setBit(mapdata,ColumnNames.RYOYOIJI_1);
    	this.medical_meal = CommonFunc.func_setBit(mapdata,ColumnNames.MEDICAL_MEAL);
    	this.kinkyujitiryo = CommonFunc.func_setBit(mapdata,ColumnNames.KINKYUJITIRYO);
    	this.tokuteitiryo = CommonFunc.func_setBit(mapdata,ColumnNames.TOKUTEITIRYO);
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
    	this.special_nursing_price = mapdata.get(ColumnNames.SPECIAL_NURSING_PRICE);
    	this.special_meal_price = mapdata.get(ColumnNames.SPECIAL_MEAL_PRICE);
    	this.hairdressing_price = mapdata.get(ColumnNames.HAIRDRESSING_PRICE);
    	this.daily_life_price = mapdata.get(ColumnNames.DAILY_LIFE_PRICE);    
    }

}
