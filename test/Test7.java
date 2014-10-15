import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.Object;
import java.lang.reflect.Field;
//import netscape.javascript.*;

public class Test7 {

	private final static String inputDatFile = "C:\\Users\\Sagehari Maiko\\Documents\\jsondata.json";

	public final static String SCRIPT
		= "function parseJSON(str){"
		+ "		var obj = JSON.parse(str);"
		//+ "		print(obj.firstname + \",\" + obj.surname + \",\" + obj.phone);"
		+ "		return obj;"
		+ "}";

	public Test7() {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
        
		File inputFile = new File(inputDatFile);
		BufferedReader in = null;
		String line;
		Object JSobj;

		try {
			in = new BufferedReader(new FileReader(inputFile));
			engine.eval(SCRIPT);
			while ((line = in.readLine()) != null){
			//line = in.readLine();
			JSobj = ((Invocable)engine).invokeFunction("parseJSON", line);
			//System.out.println("JSobj = " + JSobj.getMember("firstname"));
			}
		} catch (NoSuchMethodException ex) {
		System.err.println(ex.getMessage());
		} catch (ScriptException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void main(String[] args) throws IOException {
		new Test7();
	}
}