package models;

import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;
import util.common.ViewNames;

@Entity
@Table(name=ViewNames.V_SERVICE_FALSECOUNT) 
public class ServiceName extends Model {
	
	public int ID;
	public String formSerCd;
	public String service_name;
	public String table_name;
	public int rowcnt;
	
    /*public ServiceName(int ID, String formSerCd, String service_name, String table_name, int rowcnt) {
    	this.ID = ID;
        this.formSerCd = formSerCd;
        this.service_name = service_name;
        this.table_name = table_name;
        this.rowcnt = rowcnt;
    }
    
    public static ServiceName connect(String formSerCd, String service_name) {
        return find("byformSerCdAndservice_name", formSerCd, service_name).first();
    }
    
    public String toString() {
        return service_name;
    }*/

}
