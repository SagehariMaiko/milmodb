import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest2 {

	private final static String outputDatFile = "./110.dat";	// change pass
	private final static String outputDatFile2 = "./110_degree.dat";	// change pass
	private final static String inputCSVFile = "./110.csv";	// change pass
	
	public static void main(String args[]) throws JsonParseException,JsonMappingException, IOException {
		JsonTest2 converter = new JsonTest2();
		converter.parse("110.json");	// change filename
	}

	public void parse(String fname) throws JsonParseException,JsonMappingException, IOException {
		List<Map<String,String>> offices = new ObjectMapper().readValue(new File(fname),new TypeReference<List<Map<String,String>>>() {});

		File outputFile = new File(outputDatFile);
		File outputFile2 = new File(outputDatFile2);
		File inputFile = new File(inputCSVFile);

		BufferedWriter out = null;
		BufferedWriter out2 = null;
		BufferedReader in = null;

		String[] csvArray;
		int count = 0;
		String line;
		int csvReadStart = 5;
		String str = "";

		List<String> ColList = new ArrayList<String>();

		try{
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));
			out2 = new BufferedWriter(new FileWriter(outputFile2));
	        
	        //ColumnList
	        out.write("office_id");
			while ((line = in.readLine()) != null){
				csvArray = line.split("\\,");
				count++;
				if(count > csvReadStart && csvArray.length >= 10){
					System.out.println(count + " : " + csvArray[1]);
					out.write(",");
					out.write(csvArray[1]);
					ColList.add(csvArray[1]);
				}
			}
			out.newLine();

			out2.write("table_name");
			out2.write(",");
			out2.write("office_id");
			out2.write(",");
			out2.write("longitude");
			out2.write(",");
			out2.write("latitude");
			out2.newLine();

			count = 0;

			for (Map<String,String> c : offices) {
				out.write(String.valueOf(count));
				for ( int i = 0; i < ColList.size(); ++i ) {
					str = c.get(ColList.get(i));
					out.write(",");
					if ( str == null || str.length() == 0 ) {
						out.write("");
					} else {
						out.write(((str.replaceAll(",","")).replaceAll("\r\n","")).replaceAll("\n",""));
					}
					
				}
				out.newLine();
				
				out2.write("home_care");
				out2.write(",");
				out2.write(String.valueOf(count));
				out2.write(",");
				out2.write(c.get("longitude"));
				out2.write(",");
				out2.write(c.get("latitude"));
				out2.newLine();
				
				count++;
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(in != null){
					in.close();
				}
				if(out != null){
					out.close();
				}
				if(out2 != null){
					out2.close();
				}
			}catch(IOException e){
				System.out.println("close fail");
				e.printStackTrace();
			}
		}
    }
/*    public static class Data {
        private String company_type;
        private String office_time_hol;
        private String office_time_sun;
        
        public Data() {
        }
        
		public String getcompany_type(){
			return company_type;
		}
		
		public void setcompany_type(String company_type){
			this.company_type = company_type;
		}
		
		public String getoffice_time_hol(){
			return office_time_hol;
		}
		
		public void setoffice_time_hol(String office_time_hol){
			this.office_time_hol = office_time_hol;
		}
		
		public String getoffice_time_sun(){
			return office_time_sun;
		}
		
		public void setoffice_time_sun(String office_time_sun){
			this.office_time_sun = office_time_sun;
		}
        @Override
        public String toString() {
            return company_type+","+office_time_hol+","+office_time_sun;
        }
    }*/
}