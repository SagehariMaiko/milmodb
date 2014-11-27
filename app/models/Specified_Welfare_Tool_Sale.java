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
@Table(name="specified_welfare_tool_sale")
public class Specified_Welfare_Tool_Sale extends GenericModel {
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
	public Boolean chairtoilet;
	public Integer chairtoilet_price_from;
	public Integer chairtoilet_price_to;
	public Boolean autoexcretionparts;
	public Integer autoexcretionparts_price_from;
	public Integer autoexcretionparts_price_to;
	public Boolean bathchair;
	public Integer bathchair_price_from;
	public Integer bathchair_price_to;
	public Boolean bathtubhandrail;
	public Integer bathtubhandrail_price_from;
	public Integer bathtubhandrail_price_to;
	public Boolean bathtubchair;
	public Integer bathtubchair_price_from;
	public Integer bathtubchair_price_to;
	public Boolean bathstand;
	public Integer bathstand_price_from;
	public Integer bathstand_price_to;
	public Boolean bathroomsunoko;
	public Integer bathroomsunoko_price_from;
	public Integer bathroomsunoko_price_to;
	public Boolean bathtubsunoko;
	public Integer bathtubsunoko_price_from;
	public Integer bathtubsunoko_price_to;
	public Boolean bathassistbelt;
	public Integer bathassistbelt_price_from;
	public Integer bathassistbelt_price_to;
	public Boolean simplebath;
	public Integer simplebath_price_from;
	public Integer simplebath_price_to;
	public Boolean liftsling;
	public Integer liftsling_price_from;
	public Integer liftsling_price_to;
	public String outarea_price;
	public String welfaretoolcarry_price;
	
    public Specified_Welfare_Tool_Sale(Map<String, String> mapdata, String formSerCd)  throws SQLException {    	
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
    	this.chairtoilet = CommonFunc.func_setBit(mapdata,ColumnNames.CHAIRTOILET);
    	this.chairtoilet_price_from = Integer.valueOf(mapdata.get(ColumnNames.CHAIRTOILET_PRICE_FROM));
    	this.chairtoilet_price_to = Integer.valueOf(mapdata.get(ColumnNames.CHAIRTOILET_PRICE_TO));
    	this.autoexcretionparts = CommonFunc.func_setBit(mapdata,ColumnNames.AUTOEXCRETIONPARTS);
    	this.autoexcretionparts_price_from = Integer.valueOf(mapdata.get(ColumnNames.AUTOEXCRETIONPARTS_PRICE_FROM));
    	this.autoexcretionparts_price_to = Integer.valueOf(mapdata.get(ColumnNames.AUTOEXCRETIONPARTS_PRICE_TO));
    	this.bathchair = CommonFunc.func_setBit(mapdata,ColumnNames.BATHCHAIR);
    	this.bathchair_price_from = Integer.valueOf(mapdata.get(ColumnNames.BATHCHAIR_PRICE_FROM));
    	this.bathchair_price_to = Integer.valueOf(mapdata.get(ColumnNames.BATHCHAIR_PRICE_TO));
    	this.bathtubhandrail = CommonFunc.func_setBit(mapdata,ColumnNames.BATHTUBHANDRAIL);
    	this.bathtubhandrail_price_from = Integer.valueOf(mapdata.get(ColumnNames.BATHTUBHANDRAIL_PRICE_FROM));
    	this.bathtubhandrail_price_to = Integer.valueOf(mapdata.get(ColumnNames.BATHTUBHANDRAIL_PRICE_TO));
    	this.bathtubchair = CommonFunc.func_setBit(mapdata,ColumnNames.BATHTUBCHAIR);
    	this.bathtubchair_price_from = Integer.valueOf(mapdata.get(ColumnNames.BATHTUBCHAIR_PRICE_FROM));
    	this.bathtubchair_price_to = Integer.valueOf(mapdata.get(ColumnNames.BATHTUBCHAIR_PRICE_TO));
    	this.bathstand = CommonFunc.func_setBit(mapdata,ColumnNames.BATHSTAND);
    	this.bathstand_price_from = Integer.valueOf(mapdata.get(ColumnNames.BATHSTAND_PRICE_FROM));
    	this.bathstand_price_to = Integer.valueOf(mapdata.get(ColumnNames.BATHSTAND_PRICE_TO));
    	this.bathroomsunoko = CommonFunc.func_setBit(mapdata,ColumnNames.BATHROOMSUNOKO);
    	this.bathroomsunoko_price_from = Integer.valueOf(mapdata.get(ColumnNames.BATHROOMSUNOKO_PRICE_FROM));
    	this.bathroomsunoko_price_to = Integer.valueOf(mapdata.get(ColumnNames.BATHROOMSUNOKO_PRICE_TO));
    	this.bathtubsunoko = CommonFunc.func_setBit(mapdata,ColumnNames.BATHTUBSUNOKO);
    	this.bathtubsunoko_price_from = Integer.valueOf(mapdata.get(ColumnNames.BATHTUBSUNOKO_PRICE_FROM));
    	this.bathtubsunoko_price_to = Integer.valueOf(mapdata.get(ColumnNames.BATHTUBSUNOKO_PRICE_TO));
    	this.bathassistbelt = CommonFunc.func_setBit(mapdata,ColumnNames.BATHASSISTBELT);
    	this.bathassistbelt_price_from = Integer.valueOf(mapdata.get(ColumnNames.BATHASSISTBELT_PRICE_FROM));
    	this.bathassistbelt_price_to = Integer.valueOf(mapdata.get(ColumnNames.BATHASSISTBELT_PRICE_TO));
    	this.simplebath = CommonFunc.func_setBit(mapdata,ColumnNames.SIMPLEBATH);
    	this.simplebath_price_from = Integer.valueOf(mapdata.get(ColumnNames.SIMPLEBATH_PRICE_FROM));
    	this.simplebath_price_to = Integer.valueOf(mapdata.get(ColumnNames.SIMPLEBATH_PRICE_TO));
    	this.liftsling = CommonFunc.func_setBit(mapdata,ColumnNames.LIFTSLING);
    	this.liftsling_price_from = Integer.valueOf(mapdata.get(ColumnNames.LIFTSLING_PRICE_FROM));
    	this.liftsling_price_to = Integer.valueOf(mapdata.get(ColumnNames.LIFTSLING_PRICE_TO));
    	this.outarea_price = mapdata.get(ColumnNames.OUTAREA_PRICE);
    	this.welfaretoolcarry_price = mapdata.get(ColumnNames.WELFARETOOLCARRY_PRICE);
    }
}
