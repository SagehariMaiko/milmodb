package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
@Table(name="m_columnlist")
public class M_columnlist extends Model {
	
	public Integer ID;
	public String column_name;
	public String title;
	public String conv_list;
	public String valid_list;

}
