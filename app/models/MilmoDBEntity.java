package models;

import play.db.jpa.GenericModel;

public abstract class MilmoDBEntity extends GenericModel {
	abstract public String getValidationType();
	abstract public Long getOfficeId();
	
}
