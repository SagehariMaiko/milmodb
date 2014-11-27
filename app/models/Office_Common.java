package models;

import java.sql.SQLException;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import controllers.Office_History_Save;
import play.db.jpa.GenericModel;
import util.common.ColumnNames;
import util.common.Fixed;
import util.common.TableNames;

@Entity
@Table(name="office_common") 
public class Office_Common extends GenericModel {
	@Id
	public long office_id;
	@Id
	public String formSerCd;
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
    public String url;
    
    public Office_Common(Map<String, String> mapdata, String formSerCd) {
        this.office_id = Long.valueOf(mapdata.get(ColumnNames.OFFICE_ID));
        this.formSerCd = formSerCd;
        setData(mapdata);
        Office_History_Save.HistorySave(TableNames.OFFICE_COMMON, formSerCd, this.office_id, Fixed.INSERT);
    }
    
    public void update(Map<String, String> mapdata, String formSerCd) throws SQLException {
    	setData(mapdata);        
        this.save();
        Office_History_Save.HistorySave(TableNames.OFFICE_COMMON, formSerCd, this.office_id, Fixed.UPDATE);
    }
    
    public void setData(Map<String, String> mapdata){
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
        this.url = mapdata.get(ColumnNames.URL);
    }
}
