package inda5;

import static org.junit.Assert.*;
import inda5.Tree.Node;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void FindTest() {
		Tree<String> tree = new Tree<String>(new Node<String>(100,"test"));
		
		tree.Insert(1, "hi");
		tree.Insert(2, "world");
		tree.Insert(3, "hello");
		tree.Insert(4, "there");
		
		Node<String> a = tree.Find(3);
		System.out.println(a.value);
		
		assertEquals("hello", a.value);
		System.out.println(a.value);
		assertEquals("hello", a.value);
		assertEquals("hello", a.value);
		
	}
	
	@Test
	public void InsertTest()
	{
		//fail();
		
		Tree<String> tree = new Tree<String>(new Node<String>(100,"test"));
		
		tree.Insert(1, "hi");
		tree.Insert(2, "world");
		tree.Insert(3, "hello");
		tree.Insert(4, "there");
	}
	
	
	@Test
	public void DeapthTest()
	{
		Tree<String> tree = new Tree<String>(new Node<String>(50,"test"));
		
		tree.Insert(1, "hi");
		tree.Insert(2, "world");
		tree.Insert(3, "hello");
		tree.Insert(4, "there");
		System.out.println(tree.NumberOfLeaves() + "DeatphTest");
		assertTrue(tree.NumberOfLeaves() == 1);


		assertTrue(tree.Deapth() == 5);
		
		tree.Insert(55, "hi");
		tree.Insert(57, "world");
		tree.Insert(79, "hello");

		assertTrue(tree.Deapth() == 5);
		assertEquals(tree.Find(57).value, "world");
		
		tree.Insert(58, "world");
		tree.Insert(71, "hello");
		
		assertTrue(tree.Deapth() == 6);
		
		
		//fail();
	}
	
	@Test
	public void NumberOfLeavesTest()
	{
		Tree<String> tree = new Tree<String>(new Node<String>(44,"test"));
		
		tree.Insert(17, "");
		tree.Insert(8, "");
		tree.Insert(32, "");
		tree.Insert(28, "");
		tree.Insert(41, "");
		tree.Insert(88, "");
		tree.Insert(65, "");
		tree.Insert(97, "");
		assertTrue(tree.NumberOfLeaves() == 5);
		
		tree.Insert(40, "");
		tree.Insert(43, "");
		assertTrue(tree.NumberOfLeaves() == 6);
		
	}
	
	@Test
	public void ToStringTest()
	{
		Tree<String> tree = new Tree<String>(new Node<String>(44,"test"));
		
		tree.Insert(17, "a");
		tree.Insert(8, "b");
		tree.Insert(32, "c");
		tree.Insert(28, "d");
		tree.Insert(41, "e");
		tree.Insert(88, "f");
		tree.Insert(65, "g");
		tree.Insert(97, "h");
		
		System.out.println(tree.toString());
		assertEquals(tree.toString(), "[b,a,d,c,e,test,g,f,h]");
	}

}
