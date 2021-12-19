package APITest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class ListofCharities
{
	@Test
	public void JsonTestEvaluate() throws IOException
	{
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("./files/ListOfCharities.json"));
			String line =null;
			
			StringBuilder builder = new StringBuilder();
			
			while((line = bufferedReader.readLine())!=null)
			{
				//System.out.println(line);
				builder.append(line);
			}
			// ****** Retrieve a list of charities **************** //
			
			String JsonContent = builder.toString();
			System.out.println("Retrieve a list of charities=====>>>>> \n " +JsonContent);
			
			// ****** Retrieve St John is included in the charities list  **************** //
			
			JSONArray array = JsonPath.read(JsonContent,"$..Description");
			System.out.println("Reterive Data's from Api =========>>>>> " + array.get(2));
			Assert.assertEquals(array.get(2), "St John");
			
			} catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
 