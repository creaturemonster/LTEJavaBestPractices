package com.ltree.crs516;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;


public class LinkedListTest {

	private LinkedList<String> testSubject;
	
//TODO 1: Write a public void method (you can choose the name but setup is a 
//nice one) and annotate it with @BeforeEach. In that method instantiate your 
//LinkedList<String> and store the reference in the field called testSubject.
	@BeforeEach
	public void setup() {
		testSubject=new LinkedList<String>();
	}





//TODO 2: Test that when you call the method testSubject.add("one") you 
//get the boolean true returned.
	@Test
	public void testAdd() {
		boolean expected=true;
		boolean actual=testSubject.add("one");
		assertEquals(expected,actual);
	}






//After doing TODO 2, save the document and go back to the manual to get 
//directions to run the test. You will see if what you have so far works. 
//Small steps are always better!

//TODO 3(bonus): Test that when you call testSubject.add("one"), 
//testSubject.add("two"), testSubject.add("three") and then call 
//testSubject.getLast(), you get the third string that was added.
@Test
public void testAddThreeStringsAndCallGetLast() {
	String expected="three";
	testSubject.add("one");
	testSubject.add("two");
	testSubject.add("three");
	String actual=testSubject.getLast();
	assertEquals(expected, actual);
	
}








//TODO 4(bonus): Test that when you call testSubject.add("one"), 
//testSubject.add("two"), and then call testSubject.add(1, "three"), 
//if you call testSubject.get(1) you get "three".
@Test
public void testAddWithTwoParameters() {
	String expected="three";
	testSubject.add("one");
	testSubject.add("two");
	testSubject.add(1,"three");
	String actual=testSubject.get(1);
	assertEquals(expected, actual);
	
}









//TODO 5(bonus): Test that when you call testSubject.add(index, myString) 
//and index is a negative integer you get an IndexOutOfBoundsException.
@Test
public void testWithAddNegativeIndex() {
	assertThrows(IndexOutOfBoundsException.class,()-> testSubject.add(-1, "one"));
	
}





//TODO 6: Test that when you call testSubject.add(index, "myString") and index
//is an integer larger than testSubject.size() you get an IndexOutOfBoundsException.
@Test
public void testAddWithLargerThanMaxIndex() {
	assertThrows(IndexOutOfBoundsException.class, ()-> testSubject.add(testSubject.size()+1,"item"));
}







}
