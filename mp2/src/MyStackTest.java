import static org.junit.Assert.*;

import org.junit.Test;



public class MyStackTest {
	
	//test empty constructor
	@Test
	public void testConstructor() {
		MyStack testStack = new MyStack();
		assertTrue(testStack != null);
	}

	//test pushing to the stack
	@Test
	public void testPush() {
		MyStack testStack = new MyStack();
		HtmlTag testTag = new HtmlTag("b");
		testStack.push(testTag);
		assertFalse(testStack.isEmpty());
	}
	
	//test looking at the top of stack
	@Test
	public void testPeek() {
		MyStack testStack = new MyStack();
		HtmlTag testTag = new HtmlTag("b");
		testStack.push(testTag);
		assertEquals(testTag,testStack.peek());
	}
	
	//test looking at an empty stack
	@Test
	public void testPeekNull() {
		MyStack testStack = new MyStack();
		try {
			testStack.peek();
			assertTrue(false);
		} catch (NullPointerException exception) {
			assertTrue(true);
		}
	}
	
	//test isEmpty method
	@Test
	public void testEmptyStack() {
		MyStack testStack = new MyStack();
		assertTrue(testStack.isEmpty());
	}

	//test popping from the stack
	@Test
	public void testPop() {
		MyStack testStack = new MyStack();
		HtmlTag testTag1 = new HtmlTag("b");
		HtmlTag testTag2 = new HtmlTag("i");
		testStack.push(testTag1);
		testStack.push(testTag2);
		assertEquals(testTag2,testStack.peek());
		testStack.pop();
		assertEquals(testTag1,testStack.peek());
	}
	
	//test popping nothing
	@Test
	public void testPopNull() {
		MyStack testStack = new MyStack();
		try {
			testStack.pop();
			assertTrue(false);
		} catch (NullPointerException exception) {
			assertTrue(true);
		}
	}
}
