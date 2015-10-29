/*
 * Implementation of a simple stack for HtmlTags.
 * You should implement this class.
 */

import java.util.ArrayList;

public class MyStack {
	// An ArrayList to hold HtmlTag objects.
	// Use this to implement StackMP2.
	private ArrayList<HtmlTag> stack_internal;
	
	/*
	 * Create an empty stack.
	 */
	public MyStack( ) {
		this.stack_internal = new ArrayList<HtmlTag>( );
	}
	
	/** 
	 * Requires: A valid HtmlTag to be passed in
	 * Effects: Push a tag onto the top of the stack.
	 */
	public void push( HtmlTag tag ) {
		this.stack_internal.add(tag);
	}
	
	/**
	 * Requires: nothing
	 * Effects: Removes the tag at the top of the stack.
	 * Should throw an exception if the stack is empty.
	 */
	public HtmlTag pop( ) throws NullPointerException {
		if(this.stack_internal.isEmpty()) {
			throw new NullPointerException("The stack is empty");
		}else{
			return this.stack_internal.remove(indexOfLastElement());
		}
	}
	
	/**
	 * Requires: nothing
	 * Effects: Looks at the object at the top of the stack but does not actually remove the object. 
	 * Should throw an exception if the stack is empty.
	 * @return the HtmlTag to return
	 */
	public HtmlTag peek( ) {
		if(this.stack_internal.isEmpty()) {
			throw new NullPointerException("The stack is empty");
		}else{
			return this.stack_internal.get(indexOfLastElement());
		}
	}
	
	/**
	 * Requires: the stack_internal to be initialized
	 * Requires: Tests if the stack is empty.
	 * @return Returns true if the stack is empty; false otherwise.
	 */
	public boolean isEmpty( ) {
		if(this.stack_internal.isEmpty()) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Requires: The stack_internal to be initialized
	 * Effects: return the index of the last item on the stack
	 * @return the index of the last item
	 */
	private int indexOfLastElement() {
		return this.stack_internal.size()-1;
	}
}
