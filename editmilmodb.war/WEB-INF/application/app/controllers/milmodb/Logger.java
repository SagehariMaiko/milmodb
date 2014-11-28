package controllers.milmodb;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private static PrintWriter pw = null;
	private static File dayLog;

	public static void setup(File log, String today) throws IOException {
		createLog(log, today);
	}

	private static void createLog(File log, String today) throws IOException {
		dayLog = new File(log.getPath() + File.separator + today + ".log");
		if (dayLog.exists()) {
			dayLog.delete();
		}
		dayLog.createNewFile();
		pw = new PrintWriter(dayLog);
	}

	public static void close() {
		if (pw != null) {
			pw.close();
		}
	}

	public static void write(String line) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		pw.println(String.format(">>> %s : %s",df.format(new Date()), line));
		pw.flush();
	}

	public static void output(PrintStream out) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(dayLog));
			String line = null;
			while ((line = br.readLine()) != null) {
				out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
