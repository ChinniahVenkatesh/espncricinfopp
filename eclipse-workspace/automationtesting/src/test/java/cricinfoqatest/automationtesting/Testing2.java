package cricinfoqatest.automationtesting;

import org.testng.annotations.Test;

public class Testing2 {

	@Test
	public void getData()
	{
		System.out.println("getData");
	}
	@Test
	public void setData()
	{
		System.out.println("setData");
	}
	@Test
	public void putData()
	{
		System.out.println("putData");
	}
	
	@Test(groups = "smoke")
	public void data() {
		
	}
	
	@Test(enabled = true)
	public void data1()
	{
		
	}
}
