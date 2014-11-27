package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import controllers.milmodb.Converter;
import controllers.milmodb.Validater;
import play.db.jpa.GenericModel;
import util.common.ColumnNames;
import util.function.CommonFunc;

@Entity
@Table(name="home_care") 
public class Home_Care extends GenericModel {
	@Id
	public long office_id;
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
	public String from_service_time_week;
	public String to_service_time_week;
	public String from_service_time_sat;
	public String to_service_time_sat;
	public String from_service_time_sun;
	public String to_service_time_sun;
	public String from_service_time_hol;
	public String to_service_time_hol;
	public String service_time_memo;
	public String service_area;
	public Boolean sub_tokuteijigyosyo_1;
	public Boolean sub_tokuteijigyosyo_2;
	public Boolean sub_tokuteijigyosyo_3;
	public Boolean sub_kinkyujihoumon;
	public Boolean seikatsukinoukoujyourenkei;
	public Boolean carestaffkaizen_1;
	public Boolean carestaffkaizen_2;
	public Boolean carestaffkaizen_3;
	public Boolean jyoukoukaijyo;
	public String outarea_price;
	public String cancel_price;
	public Boolean userchargecut;

	public Home_Care(Map<String, String> mapdata, String formSerCd)	 throws SQLException {
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
		this.from_service_time_week = CommonFunc.from_time(mapdata, ColumnNames.SERVICE_TIME_WEEK);
		this.to_service_time_week = CommonFunc.to_time(mapdata, ColumnNames.SERVICE_TIME_WEEK); 
		this.from_service_time_sat = CommonFunc.from_time(mapdata, ColumnNames.SERVICE_TIME_SAT);
		this.to_service_time_sat = CommonFunc.to_time(mapdata, ColumnNames.SERVICE_TIME_SAT);
		this.from_service_time_sun = CommonFunc.from_time(mapdata, ColumnNames.SERVICE_TIME_SUN);
		this.to_service_time_sun = CommonFunc.to_time(mapdata, ColumnNames.SERVICE_TIME_SUN);
		this.from_service_time_hol = CommonFunc.from_time(mapdata, ColumnNames.SERVICE_TIME_HOL);
		this.to_service_time_hol = CommonFunc.to_time(mapdata, ColumnNames.SERVICE_TIME_HOL);
		this.service_time_memo = mapdata.get(ColumnNames.SERVICE_TIME_MEMO);
		this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
		this.sub_tokuteijigyosyo_1 = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_TOKUTEIJIGYOSYO_1);
		this.sub_tokuteijigyosyo_2 = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_TOKUTEIJIGYOSYO_2);
		this.sub_tokuteijigyosyo_3 = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_TOKUTEIJIGYOSYO_3);
		this.sub_kinkyujihoumon = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_KINKYUJIHOUMON);
		this.seikatsukinoukoujyourenkei = CommonFunc.func_setBit(mapdata,ColumnNames.SEIKATSUKINOUKOUJYOURENKEI);
		this.carestaffkaizen_1 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_1);
		this.carestaffkaizen_2 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_2);
		this.carestaffkaizen_3 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_3);
		this.jyoukoukaijyo = CommonFunc.func_setBit(mapdata,ColumnNames.JYOUKOUKAIJYO);
		this.outarea_price = mapdata.get(ColumnNames.OUTAREA_PRICE);
		this.cancel_price = mapdata.get(ColumnNames.CANCEL_PRICE);
		this.userchargecut = CommonFunc.func_setBit(mapdata,ColumnNames.USERCHARGECUT);
	}		
}
