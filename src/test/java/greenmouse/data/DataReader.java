package greenmouse.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read Json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//greenmouse//data//PurchaseOrder.json"), 
				StandardCharsets.UTF_8);
		
		//String to hashMap Databind, add Jackson databind dependency on pom.xml
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String >>>() {
		});
		return data; //hover getJSONDatatoMap() to set methos to return type, others to throw declaration
		
		//{map, map}
		
	}
}
