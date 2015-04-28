package inda4;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHashTest {

	@Test
	public void CreateNewHashListTest() {
		StringHash a = new StringHash(3);
		
		try
		{
			StringHash b = new StringHash(-3);
			fail("should not happen");
			
		} catch(IllegalArgumentException e){}
		
	}
	
	@Test
	public void AddNewElementTest()
	{
		StringHash a = new StringHash(5);
		
		assertTrue(a.add("hi"));
		assertFalse(a.add("hi"));
		assertTrue(a.add("hello"));
		assertTrue(a.add("hi3"));
	}
	
	@Test
	public void ContainsElementTest()
	{
		StringHash a = new StringHash(5);
		
		assertTrue(a.add("hi"));
		assertTrue(a.add("hello"));
		assertTrue(a.add("hi3"));
		
		assertTrue(a.contains("hello"));
		assertFalse(a.contains("test"));
	}
	
	@Test
	public void RemoveElementTest()
	{
		StringHash a = new StringHash(5);
		
		assertTrue(a.add("hi"));
		assertTrue(a.add("hello"));
		assertTrue(a.add("hi3"));
		
		assertTrue(a.contains("hello"));
		assertTrue(a.remove("hello"));
		assertFalse(a.contains("hello"));
	}
	

}
