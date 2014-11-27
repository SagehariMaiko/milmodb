package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;

@Entity
@Table(name="office_history")
public class Office_History extends GenericModel {
	@Id
	public Long ID;
	public String table_name;
	public String formSerCd;
	public Long office_id;
	public String sql_type;
	public String usr;
	
	public Office_History(Long id, String table_name, String formSerCd, Long office_id, String sql_type, String fullname){
		this.ID = id;
		this.table_name = table_name;
		this.formSerCd = formSerCd;
		this.office_id = office_id;
		this.sql_type = sql_type;	
		this.usr = fullname;
	}
	
	public Office_History(Long id, String table_name, Long office_id, String sql_type, String fullname){
		this.ID = id;
		this.table_name = table_name;
		this.office_id = office_id;
		this.sql_type = sql_type;	
		this.usr = fullname;
	}
}
