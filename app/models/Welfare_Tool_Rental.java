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
@Table(name="welfare_tool_rental")
public class Welfare_Tool_Rental extends GenericModel {
	@Id
	public Long office_id;
	public String from_office_time_week;
	public String to_office_time_week;
	public String from_office_time_sat;
	public String to_office_time_sat;
	public String from_office_time_sun;
	public String to_office_time_sun;
	public String from_office_time_hol;
	public String to_office_time_hol;
	public String office_time_reghol;
	public String office_time_memo;
	public String service_area;
	public Boolean wheelchair;
	public Integer wheelchair_price_from;
	public Integer wheelchair_price_to;
	public Boolean specialbed;
	public Integer specialbed_price_from;
	public Integer specialbed_price_to;
	public Boolean bedsore;
	public Integer bedsore_price_from;
	public Integer bedsore_price_to;
	public Boolean phyconverter;
	public Integer phyconverter_price_from;
	public Integer phyconverter_price_to;
	public Boolean handrail;
	public Integer handrail_price_from;
	public Integer handrail_price_to;
	public Boolean slope;
	public Integer slope_price_from;
	public Integer slope_price_to;
	public Boolean walker;
	public Integer walker_price_from;
	public Integer walker_price_to;
	public Boolean walkstick;
	public Integer walkstick_price_from;
	public Integer walkstick_price_to;
	public Boolean dementialoiter;
	public Integer dementialoiter_price_from;
	public Integer dementialoiter_price_to;
	public Boolean lift;
	public Integer lift_price_from;
	public Integer lift_price_to;
	public Boolean autoexcretion;
	public Integer autoexcretion_price_from;
	public Integer autoexcretion_price_to;
	public String outarea_price;
	public String welfaretoolcarry_price;
	public String cancel_price;
	
    public Welfare_Tool_Rental(Map<String, String> mapdata, String formSerCd)  throws SQLException {    	
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
    	this.from_office_time_week = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_WEEK);
    	this.to_office_time_week = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_WEEK);   	
    	this.from_office_time_sat = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_SAT);
    	this.to_office_time_sat = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_SAT);    	
    	this.from_office_time_sun = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_SUN);
    	this.to_office_time_sun = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_SUN);
    	this.from_office_time_hol = CommonFunc.from_time(mapdata, ColumnNames.OFFICE_TIME_HOL);
    	this.to_office_time_hol = CommonFunc.to_time(mapdata, ColumnNames.OFFICE_TIME_HOL);  
    	this.office_time_reghol = mapdata.get(ColumnNames.OFFICE_TIME_REGHOL);
    	this.office_time_memo = mapdata.get(ColumnNames.OFFICE_TIME_MEMO);
    	this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
    	this.wheelchair = CommonFunc.func_setBit(mapdata,ColumnNames.WHEELCHAIR);
    	this.wheelchair_price_from = Integer.valueOf(mapdata.get(ColumnNames.WHEELCHAIR_PRICE_FROM));
    	this.wheelchair_price_to = Integer.valueOf(mapdata.get(ColumnNames.WHEELCHAIR_PRICE_TO));
    	this.specialbed = CommonFunc.func_setBit(mapdata,ColumnNames.SPECIALBED);
    	this.specialbed_price_from = Integer.valueOf(mapdata.get(ColumnNames.SPECIALBED_PRICE_FROM));
    	this.specialbed_price_to = Integer.valueOf(mapdata.get(ColumnNames.SPECIALBED_PRICE_TO));
    	this.bedsore = CommonFunc.func_setBit(mapdata,ColumnNames.BEDSORE);
    	this.bedsore_price_from = Integer.valueOf(mapdata.get(ColumnNames.BEDSORE_PRICE_FROM));
    	this.bedsore_price_to = Integer.valueOf(mapdata.get(ColumnNames.BEDSORE_PRICE_TO));
    	this.phyconverter = CommonFunc.func_setBit(mapdata,ColumnNames.PHYCONVERTER);
    	this.phyconverter_price_from = Integer.valueOf(mapdata.get(ColumnNames.PHYCONVERTER_PRICE_FROM));
    	this.phyconverter_price_to = Integer.valueOf(mapdata.get(ColumnNames.PHYCONVERTER_PRICE_TO));
    	this.handrail = CommonFunc.func_setBit(mapdata,ColumnNames.HANDRAIL);
    	this.handrail_price_from = Integer.valueOf(mapdata.get(ColumnNames.HANDRAIL_PRICE_FROM));
    	this.handrail_price_to = Integer.valueOf(mapdata.get(ColumnNames.HANDRAIL_PRICE_TO));
    	this.slope = CommonFunc.func_setBit(mapdata,ColumnNames.SLOPE);
    	this.slope_price_from = Integer.valueOf(mapdata.get(ColumnNames.SLOPE_PRICE_FROM));
    	this.slope_price_to = Integer.valueOf(mapdata.get(ColumnNames.SLOPE_PRICE_TO));
    	this.walker = CommonFunc.func_setBit(mapdata,ColumnNames.WALKER);
    	this.walker_price_from = Integer.valueOf(mapdata.get(ColumnNames.WALKER_PRICE_FROM));
    	this.walker_price_to = Integer.valueOf(mapdata.get(ColumnNames.WALKER_PRICE_TO));
    	this.walkstick = CommonFunc.func_setBit(mapdata,ColumnNames.WALKSTICK);
    	this.walkstick_price_from = Integer.valueOf(mapdata.get(ColumnNames.WALKSTICK_PRICE_FROM));
    	this.walkstick_price_to = Integer.valueOf(mapdata.get(ColumnNames.WALKSTICK_PRICE_TO));
    	this.dementialoiter = CommonFunc.func_setBit(mapdata,ColumnNames.DEMENTIALOITER);
    	this.dementialoiter_price_from = Integer.valueOf(mapdata.get(ColumnNames.DEMENTIALOITER_PRICE_FROM));
    	this.dementialoiter_price_to = Integer.valueOf(mapdata.get(ColumnNames.DEMENTIALOITER_PRICE_TO));
    	this.lift = CommonFunc.func_setBit(mapdata,ColumnNames.LIFT);
    	this.lift_price_from = Integer.valueOf(mapdata.get(ColumnNames.LIFT_PRICE_FROM));
    	this.lift_price_to = Integer.valueOf(mapdata.get(ColumnNames.LIFT_PRICE_TO));
    	this.autoexcretion = CommonFunc.func_setBit(mapdata,ColumnNames.AUTOEXCRETION);
    	this.autoexcretion_price_from = Integer.valueOf(mapdata.get(ColumnNames.AUTOEXCRETION_PRICE_FROM));
    	this.autoexcretion_price_to = Integer.valueOf(mapdata.get(ColumnNames.AUTOEXCRETION_PRICE_TO));
    	this.outarea_price = mapdata.get(ColumnNames.OUTAREA_PRICE);
    	this.welfaretoolcarry_price = mapdata.get(ColumnNames.WELFARETOOLCARRY_PRICE);
    	this.cancel_price = mapdata.get(ColumnNames.CANCEL_PRICE);
    }
}
