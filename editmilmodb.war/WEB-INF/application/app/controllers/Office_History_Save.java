package controllers;

import models.Office_History;
import models.User;
import util.common.Fixed;

public class Office_History_Save {
	public static void HistorySave(String tablename, String formSerCd, Long office_id, String sqlType) {
		Long history_id = findHistory();
		User author = connectuser();
		Office_History office_history = new Office_History(history_id, tablename, formSerCd, office_id, sqlType, author.fullname);
		office_history.save();
	}

	public static void HistorySave(String tablename, Long office_id, String sqlType) {	
		Long history_id = findHistory();
		User author = connectuser();
		Office_History office_history = new Office_History(history_id, tablename, office_id, sqlType, author.fullname);
		office_history.save();
	}

	public static long findHistory(){
		Office_History lasthistorydata = Office_History.find("order by ID DESC").first();
		return (lasthistorydata != null) ? lasthistorydata.ID + 1 : 0;
	}

	public static User connectuser(){
		return User.find("byEmail", Security.connected()).first();
	}
}
