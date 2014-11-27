package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;

@Entity
@Table(name="v_specified_lifecare_charge")
public class V_specified_lifecare_charge extends MilmoDBEntity {
	@Id
	public long office_id;
	public String service_type;
	public String latitude;
	public String longitude;
	public String name;
    public String name_furi;
    public String company_type;
    public String company;
    public String postcode;
    public String municipality;
    public String address_1;
    public String address_2;
    public String tel;
    public String fax;
    public String hp_address;
    public String office_no;
    public String manager_name;
    public String founding_day;
    public String traffic;
    public String private_kinou;
    public String sub_night_nursing;
    public String medicalkikanrenkei;
    public String sub_caregiving;
    public String carestaffkaizen_1;
    public String carestaffkaizen_2;
    public String carestaffkaizen_3;
    public String sub_shortuse_specified;
    public String personal_distribution;
    public String payment_method;
    public String lumpsum_name;
    public String lumpsum_num;
    public String lumpsum_from;
    public String lumpsum_to;
    public String lumpsum_avg;
    public String lumpsum_biko;
    public String repaymentrate;
    public String recoveryperiod;
    public String cancel_returnmoney;
    public String controlcost;
    public String controlcost_biko;
    public String mealprice;
    public String mealprice_biko;
    public String fuelprice;
    public String fuelprice_biko;
    public String personal_distributionyobo_2;
    public String personal_distributionyobo_2_biko;
    public String indivudual_selectyobo;
    public String indivudual_selectyobo_biko;
    public String eq_rent;
    public String eq_rent_from;
    public String eq_rent_to;
    public String eq_ent_avg;
    public String eq_rent_biko;
    public String other_getsugaku;
    public String other_lumpsum;
    public boolean validate;
    public String validate_type;
    public String url;
    
    public void updateData(Map<String, String> mapdata) throws SQLException {
    	this.service_type = mapdata.get(ColumnNames.SERVICE_TYPE);
    	this.latitude = mapdata.get(ColumnNames.LATITUDE);
    	this.longitude = mapdata.get(ColumnNames.LONGITUDE);
    	this.name = mapdata.get(ColumnNames.NAME);
    	this.name_furi = mapdata.get(ColumnNames.NAME_FURI);
    	this.company_type = mapdata.get(ColumnNames.COMPANY_TYPE);
    	this.company = mapdata.get(ColumnNames.COMPANY);
    	this.postcode = mapdata.get(ColumnNames.POSTCODE);
    	this.municipality = mapdata.get(ColumnNames.MUNICIPALITY);
    	this.address_1 = mapdata.get(ColumnNames.ADDRESS_1);
    	this.address_2 = mapdata.get(ColumnNames.ADDRESS_2);
    	this.tel = mapdata.get(ColumnNames.TEL);
    	this.fax = mapdata.get(ColumnNames.FAX);
    	this.hp_address = mapdata.get(ColumnNames.HP_ADDRESS);
    	this.office_no = mapdata.get(ColumnNames.OFFICE_NO);
    	this.manager_name = mapdata.get(ColumnNames.MANAGER_NAME);
    	this.founding_day = mapdata.get(ColumnNames.FOUNDING_DAY);
    	this.traffic = mapdata.get(ColumnNames.TRAFFIC);
    	this.private_kinou = mapdata.get(ColumnNames.PRIVATE_KINOU);
    	this.sub_night_nursing = mapdata.get(ColumnNames.SUB_NIGHT_NURSING);
    	this.medicalkikanrenkei = mapdata.get(ColumnNames.MEDICALKIKANRENKEI);
    	this.sub_caregiving = mapdata.get(ColumnNames.SUB_CAREGIVING);
    	this.carestaffkaizen_1 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_1);
    	this.carestaffkaizen_2 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_2);
    	this.carestaffkaizen_3 = mapdata.get(ColumnNames.CARESTAFFKAIZEN_3);
    	this.sub_shortuse_specified = mapdata.get(ColumnNames.SUB_SHORTUSE_SPECIFIED);
    	this.personal_distribution = mapdata.get(ColumnNames.PERSONAL_DISTRIBUTION);
    	this.payment_method = mapdata.get(ColumnNames.PAYMENT_METHOD);
    	this.lumpsum_name = mapdata.get(ColumnNames.LUMPSUM_NAME);
    	this.lumpsum_num = mapdata.get(ColumnNames.LUMPSUM_NUM);
    	this.lumpsum_from = mapdata.get(ColumnNames.LUMPSUM_FROM);
    	this.lumpsum_to = mapdata.get(ColumnNames.LUMPSUM_TO);
    	this.lumpsum_avg = mapdata.get(ColumnNames.LUMPSUM_AVG);
    	this.lumpsum_biko = mapdata.get(ColumnNames.LUMPSUM_BIKO);
    	this.repaymentrate = mapdata.get(ColumnNames.REPAYMENTRATE);
    	this.recoveryperiod = mapdata.get(ColumnNames.RECOVERYPERIOD);
    	this.cancel_returnmoney = mapdata.get(ColumnNames.CANCEL_RETURNMONEY);
    	this.controlcost = mapdata.get(ColumnNames.CONTROLCOST);
    	this.controlcost_biko = mapdata.get(ColumnNames.CONTROLCOST_BIKO);
    	this.mealprice = mapdata.get(ColumnNames.MEALPRICE);
    	this.mealprice_biko = mapdata.get(ColumnNames.MEALPRICE_BIKO);
    	this.fuelprice = mapdata.get(ColumnNames.FUELPRICE);
    	this.fuelprice_biko = mapdata.get(ColumnNames.FUELPRICE_BIKO);
    	this.personal_distributionyobo_2 = mapdata.get(ColumnNames.PERSONAL_DISTRIBUTIONYOBO_2);
    	this.personal_distributionyobo_2_biko = mapdata.get(ColumnNames.PERSONAL_DISTRIBUTIONYOBO_2_BIKO);
    	this.indivudual_selectyobo = mapdata.get(ColumnNames.INDIVUDUAL_SELECTYOBO);
    	this.indivudual_selectyobo_biko = mapdata.get(ColumnNames.INDIVUDUAL_SELECTYOBO_BIKO);
    	this.eq_rent = mapdata.get(ColumnNames.EQ_RENT);
    	this.eq_rent_from = mapdata.get(ColumnNames.EQ_RENT_FROM);
    	this.eq_rent_to = mapdata.get(ColumnNames.EQ_RENT_TO);
    	this.eq_ent_avg = mapdata.get(ColumnNames.EQ_ENT_AVG);
    	this.eq_rent_biko = mapdata.get(ColumnNames.EQ_RENT_BIKO);
    	this.other_getsugaku = mapdata.get(ColumnNames.OTHER_GETSUGAKU);
    	this.other_lumpsum = mapdata.get(ColumnNames.OTHER_LUMPSUM);
        this.validate = (mapdata.get(ColumnNames.VALIDATE) != null ? false : true);
        this.validate_type = mapdata.get(ColumnNames.VALIDATE_TYPE);
        this.url = mapdata.get(ColumnNames.URL);
        
        this.save();
    }
    
	@Override
	public String getValidationType() {
		return this.validate_type;
	}

	@Override
	public Long getOfficeId() {
		return this.office_id;
	}
}
