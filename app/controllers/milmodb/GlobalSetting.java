package controllers.milmodb;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalSetting extends Properties {
	public static final String SENDSERVER_KEY = "sendserver";
	public static final String DBPORT_KEY = "dbport";
	public static final String DBNAME_KEY = "dbname";
	public static final String DBUSER_KEY = "dbuser";
	public static final String DBPASS_KEY = "dbpass";
	public static final String JSONPATH = "jsonpath";
	public static final String LOGPATH = "logpath";

	//private final String mode;

	public GlobalSetting(String workDir) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(workDir + "globalsetting.txt"));
		this.load(is);
		is.close();
		//this.mode = mode;
	}
}
