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
@Table(name="specified_lifecare_light")
public class Specified_Lifecare_Light extends GenericModel {
	@Id
	public Long office_id;
	public Boolean private_kinou;
	public Boolean sub_night_nursing;
	public Boolean medicalkikanrenkei;
	public Boolean sub_caregiving;
	public Boolean carestaffkaizen_1;
	public Boolean carestaffkaizen_2;
	public Boolean carestaffkaizen_3;
	public Boolean sub_shortuse_specified;
	public Boolean personal_distribution;
	public String payment_method;
	public String lumpsum_name;
	public String lumpsum_num;
	public Integer lumpsum_from;
	public Integer lumpsum_to;
	public Integer lumpsum_avg;
	public String lumpsum_biko;
	public Integer repaymentrate;
	public String recoveryperiod;
	public String cancel_returnmoney;
	public Integer controlcost;
	public String controlcost_biko;
	public Integer mealprice;
	public String mealprice_biko;
	public Integer fuelprice;
	public String fuelprice_biko;
	public Boolean personal_distributionyobo_2;
	public String personal_distributionyobo_2_biko;
	public Boolean indivudual_selectyobo;
	public String indivudual_selectyobo_biko;
	public Boolean eq_rent;
	public Integer eq_rent_from;
	public Integer eq_rent_to;
	public Integer eq_ent_avg;
	public String eq_rent_biko;
	public String other_getsugaku;
	public String other_lumpsum;
	
    public Specified_Lifecare_Light(Map<String, String> mapdata, String formSerCd)  throws SQLException {    	
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
    	this.private_kinou = CommonFunc.func_setBit(mapdata,ColumnNames.PRIVATE_KINOU);
    	this.sub_night_nursing = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_NIGHT_NURSING);
    	this.medicalkikanrenkei = CommonFunc.func_setBit(mapdata,ColumnNames.MEDICALKIKANRENKEI);
    	this.sub_caregiving = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_CAREGIVING);
    	this.carestaffkaizen_1 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = CommonFunc.func_setBit(mapdata,ColumnNames.CARESTAFFKAIZEN_3);
    	this.sub_shortuse_specified = CommonFunc.func_setBit(mapdata,ColumnNames.SUB_SHORTUSE_SPECIFIED);
    	this.personal_distribution = CommonFunc.func_setBit(mapdata,ColumnNames.PERSONAL_DISTRIBUTION);
    	this.payment_method = mapdata.get(ColumnNames.PAYMENT_METHOD);
    	this.lumpsum_name = mapdata.get(ColumnNames.LUMPSUM_NAME);
    	this.lumpsum_num = mapdata.get(ColumnNames.LUMPSUM_NUM);
    	this.lumpsum_from = Integer.valueOf(mapdata.get(ColumnNames.LUMPSUM_FROM));
    	this.lumpsum_to = Integer.valueOf(mapdata.get(ColumnNames.LUMPSUM_TO));
    	this.lumpsum_avg = Integer.valueOf(mapdata.get(ColumnNames.LUMPSUM_AVG));
    	this.lumpsum_biko = mapdata.get(ColumnNames.LUMPSUM_BIKO);
    	this.repaymentrate = Integer.valueOf(mapdata.get(ColumnNames.REPAYMENTRATE));
    	this.recoveryperiod = mapdata.get(ColumnNames.RECOVERYPERIOD);
    	this.cancel_returnmoney = mapdata.get(ColumnNames.CANCEL_RETURNMONEY);
    	this.controlcost = Integer.valueOf(mapdata.get(ColumnNames.CONTROLCOST));
    	this.controlcost_biko = mapdata.get(ColumnNames.CONTROLCOST_BIKO);
    	this.mealprice = Integer.valueOf(mapdata.get(ColumnNames.MEALPRICE));
    	this.mealprice_biko = mapdata.get(ColumnNames.MEALPRICE_BIKO);
    	this.fuelprice = Integer.valueOf(mapdata.get(ColumnNames.FUELPRICE));
    	this.fuelprice_biko = mapdata.get(ColumnNames.FUELPRICE_BIKO);
    	this.personal_distributionyobo_2 = CommonFunc.func_setBit(mapdata,ColumnNames.PERSONAL_DISTRIBUTIONYOBO_2);
    	this.personal_distributionyobo_2_biko = mapdata.get(ColumnNames.PERSONAL_DISTRIBUTIONYOBO_2_BIKO);
    	this.indivudual_selectyobo = CommonFunc.func_setBit(mapdata,ColumnNames.INDIVUDUAL_SELECTYOBO);
    	this.indivudual_selectyobo_biko = mapdata.get(ColumnNames.INDIVUDUAL_SELECTYOBO_BIKO);
    	this.eq_rent = CommonFunc.func_setBit(mapdata,ColumnNames.EQ_RENT);
    	this.eq_rent_from = Integer.valueOf(mapdata.get(ColumnNames.EQ_RENT_FROM));
    	this.eq_rent_to = Integer.valueOf(mapdata.get(ColumnNames.EQ_RENT_TO));
    	this.eq_ent_avg = Integer.valueOf(mapdata.get(ColumnNames.EQ_ENT_AVG));
    	this.eq_rent_biko = mapdata.get(ColumnNames.EQ_RENT_BIKO);
    	this.other_getsugaku = mapdata.get(ColumnNames.OTHER_GETSUGAKU);
    	this.other_lumpsum = mapdata.get(ColumnNames.OTHER_LUMPSUM);
    }
}
