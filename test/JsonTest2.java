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

	private final static String outputDatFile = "C:\\Users\\Sagehari Maiko\\Documents\\jsontest\\110.dat";	// change pass
	private final static String inputDatFile = "C:\\Users\\Sagehari Maiko\\Documents\\jsontest\\110.csv";	// change pass
	
	public static void main(String args[]) throws JsonParseException,JsonMappingException, IOException {
		JsonTest2 converter = new JsonTest2();
		converter.parse("sample3.json");	// change filename
	}

	public void parse(String fname) throws JsonParseException,JsonMappingException, IOException {
		List<Map<String,String>> offices = new ObjectMapper().readValue(new File(fname),new TypeReference<List<Map<String,String>>>() {});

		File outputFile = new File(outputDatFile);
		File inputFile = new File(inputDatFile);

		BufferedWriter out = null;
		BufferedReader in = null;

		String[] csvArray;
		int count = 0;
		String line;
		int csvReadStart = 5;

		List<String> ColList = new ArrayList<String>();

		try{
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));
	        
			while ((line = in.readLine()) != null){
				csvArray = line.split("\\,");
				count++;
				if(count >= csvReadStart && csvArray.length >= 10){
					System.out.println(csvArray[1]);
					if( count != csvReadStart ){out.write(",");}
					out.write(csvArray[1]);
					ColList.add(csvArray[1]);
				}
			}
			out.newLine();

			for (Map<String,String> c : offices) {
				for ( int i = 0; i < ColList.size(); ++i ) {
					if( i != 0 ){out.write(",");}
					out.write((c.get(ColList.get(i))).replaceAll(",",""));
				}
				out.newLine();
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