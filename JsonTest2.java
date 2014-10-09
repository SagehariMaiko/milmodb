import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest2 {
	public static void main(String args[]) throws JsonParseException,JsonMappingException, IOException {
		JsonTest2 converter = new JsonTest2();
		converter.parse("sample3.json");
	}
    public void parse(String fname) throws JsonParseException,JsonMappingException, IOException {
		Data data = new ObjectMapper().readValue(new File(fname),Data.class);
                
        //for (???) {
			System.out.println(data.toString());
        //}
	}
	public static class Data {
		private String company_type;
		private String office_time_hol;
		private String office_time_sun;

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
		
		public String toString() {
			return company_type+":"+office_time_hol+":"+office_time_sun;
		}
	}
}