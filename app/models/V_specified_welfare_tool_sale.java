package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import util.common.ColumnNames;

@Entity
@Table(name="v_specified_welfare_tool_sale")
public class V_specified_welfare_tool_sale extends MilmoDBEntity {
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
    public String office_time_week;
    public String office_time_sat;
    public String office_time_sun;
    public String office_time_hol;
    public String office_time_reghol;
    public String office_time_memo;
    public String service_area;
    public String chairtoilet;
    public String chairtoilet_price_from;
    public String chairtoilet_price_to;
    public String autoexcretionparts;
    public String autoexcretionparts_price_from;
    public String autoexcretionparts_price_to;
    public String bathchair;
    public String bathchair_price_from;
    public String bathchair_price_to;
    public String bathtubhandrail;
    public String bathtubhandrail_price_from;
    public String bathtubhandrail_price_to;
    public String bathtubchair;
    public String bathtubchair_price_from;
    public String bathtubchair_price_to;
    public String bathstand;
    public String bathstand_price_from;
    public String bathstand_price_to;
    public String bathroomsunoko;
    public String bathroomsunoko_price_from;
    public String bathroomsunoko_price_to;
    public String bathtubsunoko;
    public String bathtubsunoko_price_from;
    public String bathtubsunoko_price_to;
    public String bathassistbelt;
    public String bathassistbelt_price_from;
    public String bathassistbelt_price_to;
    public String simplebath;
    public String simplebath_price_from;
    public String simplebath_price_to;
    public String liftsling;
    public String liftsling_price_from;
    public String liftsling_price_to;
    public String outarea_price;
    public String welfaretoolcarry_price;
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
    	this.office_time_week = mapdata.get(ColumnNames.OFFICE_TIME_WEEK);
    	this.office_time_sat = mapdata.get(ColumnNames.OFFICE_TIME_SAT);
    	this.office_time_sun = mapdata.get(ColumnNames.OFFICE_TIME_SUN);
    	this.office_time_hol = mapdata.get(ColumnNames.OFFICE_TIME_HOL);
    	this.office_time_reghol = mapdata.get(ColumnNames.OFFICE_TIME_REGHOL);
    	this.office_time_memo = mapdata.get(ColumnNames.OFFICE_TIME_MEMO);
    	this.service_area = mapdata.get(ColumnNames.SERVICE_AREA);
    	this.chairtoilet = mapdata.get(ColumnNames.CHAIRTOILET);
    	this.chairtoilet_price_from = mapdata.get(ColumnNames.CHAIRTOILET_PRICE_FROM);
    	this.chairtoilet_price_to = mapdata.get(ColumnNames.CHAIRTOILET_PRICE_TO);
    	this.autoexcretionparts = mapdata.get(ColumnNames.AUTOEXCRETIONPARTS);
    	this.autoexcretionparts_price_from = mapdata.get(ColumnNames.AUTOEXCRETIONPARTS_PRICE_FROM);
    	this.autoexcretionparts_price_to = mapdata.get(ColumnNames.AUTOEXCRETIONPARTS_PRICE_TO);
    	this.bathchair = mapdata.get(ColumnNames.BATHCHAIR);
    	this.bathchair_price_from = mapdata.get(ColumnNames.BATHCHAIR_PRICE_FROM);
    	this.bathchair_price_to = mapdata.get(ColumnNames.BATHCHAIR_PRICE_TO);
    	this.bathtubhandrail = mapdata.get(ColumnNames.BATHTUBHANDRAIL);
    	this.bathtubhandrail_price_from = mapdata.get(ColumnNames.BATHTUBHANDRAIL_PRICE_FROM);
    	this.bathtubhandrail_price_to = mapdata.get(ColumnNames.BATHTUBHANDRAIL_PRICE_TO);
    	this.bathtubchair = mapdata.get(ColumnNames.BATHTUBCHAIR);
    	this.bathtubchair_price_from = mapdata.get(ColumnNames.BATHTUBCHAIR_PRICE_FROM);
    	this.bathtubchair_price_to = mapdata.get(ColumnNames.BATHTUBCHAIR_PRICE_TO);
    	this.bathstand = mapdata.get(ColumnNames.BATHSTAND);
    	this.bathstand_price_from = mapdata.get(ColumnNames.BATHSTAND_PRICE_FROM);
    	this.bathstand_price_to = mapdata.get(ColumnNames.BATHSTAND_PRICE_TO);
    	this.bathroomsunoko = mapdata.get(ColumnNames.BATHROOMSUNOKO);
    	this.bathroomsunoko_price_from = mapdata.get(ColumnNames.BATHROOMSUNOKO_PRICE_FROM);
    	this.bathroomsunoko_price_to = mapdata.get(ColumnNames.BATHROOMSUNOKO_PRICE_TO);
    	this.bathtubsunoko = mapdata.get(ColumnNames.BATHTUBSUNOKO);
    	this.bathtubsunoko_price_from = mapdata.get(ColumnNames.BATHTUBSUNOKO_PRICE_FROM);
    	this.bathtubsunoko_price_to = mapdata.get(ColumnNames.BATHTUBSUNOKO_PRICE_TO);
    	this.bathassistbelt = mapdata.get(ColumnNames.BATHASSISTBELT);
    	this.bathassistbelt_price_from = mapdata.get(ColumnNames.BATHASSISTBELT_PRICE_FROM);
    	this.bathassistbelt_price_to = mapdata.get(ColumnNames.BATHASSISTBELT_PRICE_TO);
    	this.simplebath = mapdata.get(ColumnNames.SIMPLEBATH);
    	this.simplebath_price_from = mapdata.get(ColumnNames.SIMPLEBATH_PRICE_FROM);
    	this.simplebath_price_to = mapdata.get(ColumnNames.SIMPLEBATH_PRICE_TO);
    	this.liftsling = mapdata.get(ColumnNames.LIFTSLING);
    	this.liftsling_price_from = mapdata.get(ColumnNames.LIFTSLING_PRICE_FROM);
    	this.liftsling_price_to = mapdata.get(ColumnNames.LIFTSLING_PRICE_TO);
    	this.outarea_price = mapdata.get(ColumnNames.OUTAREA_PRICE);
    	this.welfaretoolcarry_price = mapdata.get(ColumnNames.WELFARETOOLCARRY_PRICE);
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
