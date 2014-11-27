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
@Table(name="small_multi_home")
public class Small_Multi_Home extends GenericModel {
	@Id
	public Long office_id;
	public String from_office_time_kayoi;
	public String to_office_time_kayoi;
	public String from_office_time_stay;
	public String to_office_time_stay;
	public String service_area;
	public Boolean sougei_1;
	public Boolean sub_nintisyo_1;
	public Boolean sub_nintisyo_2;
	public Boolean sub_kangohaiti_1;
	public Boolean sub_kangohaiti_2;
	public Boolean service_supply_1;
	public Boolean service_supply_2;
	public Boolean service_supply_3;
	public Boolean carestaffkaizen_1;
	public Boolean carestaffkaizen_2;
	public Boolean carestaffkaizen_3;
	public Integer morning_price;
	public Integer lunch_price;
	public Integer dinner_price;
	public Integer snack_price;
	public Integer stay_price;
	public String other_name_1;
	public Integer other_price_1;
	public String other_biko_1;
	public String other_name_2;
	public Integer other_price_2;
	public String other_biko_2;
	public String other_name_3;
	public Integer other_price_3;
	public String other_biko_3;
	public String other_name_4;
	public Integer other_price_4;
	public String other_biko_4;
	public String other_name_5;
	public Integer other_price_5;
	public String other_biko_5;
	
    public Small_Multi_Home(Map<String, String> mapdata, String formSerCd)  throws SQLException {    	
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
    	this.from_office_time_kayoi = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_KAYOI);
    	this.to_office_time_kayoi = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_KAYOI);   	
    	this.from_office_time_stay = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_STAY);
    	this.to_office_time_stay = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_STAY); 
       	this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
    	this.sougei_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SOUGEI_1);
    	this.sub_nintisyo_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_NINTISYO_1);
    	this.sub_nintisyo_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_NINTISYO_2);
    	this.sub_kangohaiti_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_KANGOHAITI_1);
    	this.sub_kangohaiti_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_KANGOHAITI_2);
    	this.service_supply_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_1);
    	this.service_supply_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_2);
    	this.service_supply_3 = CommonFunc.func_setBit(mapdata,ColumnNames.SERVICE_SUPPLY_3);
    	this.carestaffkaizen_1 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_3);
    	this.morning_price = Integer.valueOf(mapdata.get(ColumnNames.MORNING_PRICE));
    	this.lunch_price = Integer.valueOf(mapdata.get(ColumnNames.LUNCH_PRICE));
    	this.dinner_price = Integer.valueOf(mapdata.get(ColumnNames.DINNER_PRICE));
    	this.snack_price = Integer.valueOf(mapdata.get(ColumnNames.SNACK_PRICE));
    	this.stay_price = Integer.valueOf(mapdata.get(ColumnNames.STAY_PRICE));
    	this.other_name_1 = mapdata.get(ColumnNames.OTHER_NAME_1);
    	this.other_price_1 = Integer.valueOf(mapdata.get(ColumnNames.OTHER_PRICE_1));
    	this.other_biko_1 = mapdata.get(ColumnNames.OTHER_BIKO_1);
    	this.other_name_2 = mapdata.get(ColumnNames.OTHER_NAME_2);
    	this.other_price_2 = Integer.valueOf(mapdata.get(ColumnNames.OTHER_PRICE_2));
    	this.other_biko_2 = mapdata.get(ColumnNames.OTHER_BIKO_2);
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
