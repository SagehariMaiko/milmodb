package models;

import javax.persistence.*;

import play.db.jpa.Model;

@Entity
@Table(name="validate_type")
public class Validate_type extends Model {

	public Long ID;
	public String title;
	
}
