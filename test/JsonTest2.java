import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonTest2 {

	private final static String outputDatFile = "C:\\Users\\Sagehari Maiko\\Documents\\jsontest\\home_care.dat";	// change pass
	private final static String inputDatFile = "C:\\Users\\Sagehari Maiko\\Documents\\jsontest\\sampleheader.dat";
	
    public static void main(String args[]) throws JsonParseException,
            JsonMappingException, IOException {
        JsonTest2 converter = new JsonTest2();
        converter.parse("sample3.json");
    }
    public void parse(String fname) throws JsonParseException,
            JsonMappingException, IOException {
        List<Data> offices = new ObjectMapper().readValue(new File(fname),
                new TypeReference<List<Data>>() {
                });
                
        File outputFile = new File(outputDatFile);
        File inputFile = new File(inputDatFile);
        
        BufferedWriter out = null;
        BufferedReader in = null;
        
        try{
        	in = new BufferedReader(new FileReader(inputFile));
	        out = new BufferedWriter(new FileWriter(outputFile));
	        
	        out.write(in.readLine());
	        out.newLine();
	        
	        for (Data c : offices) {
	            //System.out.println(c.toString());
	            out.write(c.toString());
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
    public static class Data {
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
    }
}