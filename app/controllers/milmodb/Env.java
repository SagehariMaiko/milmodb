package controllers.milmodb;

import java.io.*;
import java.util.regex.Pattern;

public class Env {
	public final File data1;
	public final File data2;
	public final File log;
	public final File[] data1s;
	public final File[] data2s;
	
	public Env(String data1Dir, String data2Dir, String logDir, String today, int flg) throws Exception {
		this.data1 = find(data1Dir);
		this.data2 = find(data2Dir);
		this.log = find(logDir);
		if (flg == 0) {
			this.data1s = findGrep(data1, "^\\d{3}.dat$|^\\d{3}[A-Z]{1}.dat$");
			this.data2s = findGrep(data2, "^\\d{3}_degree.dat$");			
		} else {
			this.data1s = findGrep(data1, "^\\d{3}.json$|^\\d{3}[A-Z]{1}.json$");
			this.data2s = findGrep(data2, "^\\d{3}.csv$|^\\d{3}[A-Z]{1}.csv$");
		}
		
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
	
	private File find(String p) {
		File f = new File(p);
		if (!f.exists()) {
			throw new IllegalArgumentException("指定された'" + p + "'フォルダが見つかりません。");
		}
		if (f.isFile()) {
			throw new IllegalArgumentException("指定された'" + p + "'はファイルです。");
		}
		return f;
	}

}
