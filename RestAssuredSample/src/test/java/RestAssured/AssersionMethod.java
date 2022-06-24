package RestAssured;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssersionMethod {

	@Test
	public void TestCase1()
	{
		//FOR COMPARING THE 2 DATAS
		String expectedvalue= "{id:1,name:\"saumya\"}";
		String actualvalue="{id:1,name:\"saumya\"}";
		JSONAssert.assertEquals(expectedvalue, actualvalue,JSONCompareMode.LENIENT);

		//Extensible is possible
		String expectedvalue1= "{id:1,name:\"saumya\"}";
		String actualvalue1="{id:1,name:\"saumya\",age:23}";
		JSONAssert.assertEquals(expectedvalue1, actualvalue1,JSONCompareMode.LENIENT);

		//Strict ordering -no
		String expectedvalue2= "{id:1,name:\"saumya\",Friends:[{id:3},{id:4}]}";
		String actualvalue2="{id:1,name:\"saumya\",Friends:[{id:4},{id:3}]}";
		JSONAssert.assertEquals(expectedvalue2, actualvalue2,JSONCompareMode.LENIENT);


	}

	@Test
	public void TestCase2()
	{
		//Extensible is not possible
		String expectedvalue3= "{id:1,name:\"saumya\"}";
		String actualvalue3="{id:1,name:\"saumya\",age:23}";
		JSONAssert.assertEquals(expectedvalue3, actualvalue3,JSONCompareMode.STRICT);

		//Strict ordering -yes
		String expectedvalue4= "{id:1,name:\"saumya\",Friends:[{id:3},{id:4}]}";
		String actualvalue4="{id:1,name:\"saumya\",Friends:[{id:4},{id:3}]}";
		JSONAssert.assertEquals(expectedvalue4, actualvalue4,JSONCompareMode.STRICT);
	}
}
