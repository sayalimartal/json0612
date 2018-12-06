package newJson;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class main {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		int noOfEntries;
		JSONObject jsonObject = new JSONObject();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the no. of enteries you want :");
		noOfEntries = scanner.nextInt();		  
		
		long offset = Timestamp.valueOf("2017-01-01 00:00:00").getTime();
		long end = Timestamp.valueOf("2019-01-01 00:00:00").getTime();
		long diff = end - offset + 1;
		
		for (int i = 1; i <= noOfEntries; i++) {
			// JSON object and values
			
			jsonObject.put("empId", i+"");
			jsonObject.put("fName", "A"+i);
			jsonObject.put("mName", "B"+i);
			jsonObject.put("lName", "C"+i);
			Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
			jsonObject.put("doj", rand+"");
					
			System.out.println(jsonObject);
			System.out.println("***********************");
		
			try {
				
				File file = new File("info.json");
				FileWriter fr = new FileWriter(file, true);
				fr.write(jsonObject.toJSONString());
				fr.flush();
				fr.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
		
/*		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);*/
				
	}

}
