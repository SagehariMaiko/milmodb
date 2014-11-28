package controllers.milmodb;

import java.io.*;
import java.util.regex.Pattern;

public class Env {
	public final File json;
	public final File log;
	public final File[] jsondatas;
	public final GlobalSetting globalSetting;

	public Env(String workDir, String today, String c) throws Exception {
		this.globalSetting = new GlobalSetting(workDir);
		if ("CreateJsonDB".equals(c)) {
			this.json = find(globalSetting.getProperty(GlobalSetting.JSONPATH));
			this.jsondatas = findGrep(json, "^\\d{3}.json$");
		} else {
			this.json = null;
			this.jsondatas = null;
		}
		this.log = find(globalSetting.getProperty(GlobalSetting.LOGPATH) + File.separator + c);

		Logger.setup(this.log, today);
	}

	private File[] findGrep(File dir, String r) {
		final Pattern p = Pattern.compile(r);
		return dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (dir.isFile()) {
					System.out.printf("'%s' はファイルであるためスキップします。%n", name);
					return false;
				}
				if (p.matcher(name).matches()) {
					return true;
				}
				return false;
			}
		});
	}

	public static File find(String p) {
		File f = new File(p);
		if (!f.exists()) {
			f.mkdirs();
			//throw new IllegalArgumentException("指定された'" + p + "'フォルダが見つかりません。");
		}
		if (f.isFile()) {
			throw new IllegalArgumentException("指定された'" + p + "'はファイルです。");
		}
		return f;
	}
}
