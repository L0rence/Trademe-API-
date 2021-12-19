package APITest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class UsedCarsList
{
	@Test
	public void JsonTestEvaluate() throws IOException
	{
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("./files/ListOfUsedCar.json"));
			String line =null;
			
			StringBuilder builder = new StringBuilder();
			
			while((line = bufferedReader.readLine())!=null)
			{
			
				builder.append(line);
			}
			// ****** Retrieve a list of Car **************** //
			
			String JsonContent = builder.toString();
			System.out.println("Retrieve a list of Car=====>>>>>"+ JsonContent);
			
			// ****** Retrieve the Existing list and confirming the details  **************** //
			
			JSONArray NameArray = JsonPath.read(JsonContent,"$.Subcategories..Name");
			System.out.println("Car Name ===>    " + NameArray.get(1));
 			Assert.assertEquals(NameArray.get(1), "Aston Martin");
 			
 			JSONArray NumberArray = JsonPath.read(JsonContent,"$.Subcategories..Number");
 			System.out.println("Car Number ===>    " + NumberArray.get(1));
 			Assert.assertEquals(NumberArray.get(1), "0001-0268-0270-");
			
			JSONArray PathArray = JsonPath.read(JsonContent,"$.Subcategories..Path");
			System.out.println("Car Path ===>    " + PathArray.get(1));
			Assert.assertEquals(PathArray.get(1), "/Trade-Me-Motors/Cars/Aston-Martin");
			
			JSONArray ClassifiedArray = JsonPath.read(JsonContent,"$.Subcategories..HasClassifieds");
			System.out.println("Car HasClassifieds ===>    " + ClassifiedArray.get(1));
			Assert.assertEquals(ClassifiedArray.get(1), true);
			
			JSONArray AreaOfBusinessArray = JsonPath.read(JsonContent,"$.Subcategories..AreaOfBusiness");
			System.out.println("Car AreaOf Business ===>    " + AreaOfBusinessArray.get(1));
			Assert.assertEquals(AreaOfBusinessArray.get(1), 3);
			
			JSONArray IsLeafArray = JsonPath.read(JsonContent,"$.Subcategories..IsLeaf");
			System.out.println("Car Is Laeaf ===>    " + IsLeafArray.get(1));
			Assert.assertEquals(IsLeafArray.get(1), true);
			
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
