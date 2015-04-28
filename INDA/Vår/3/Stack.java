package inda3;

import java.io.StringWriter;

public class Stack<T> implements IStack<T>
{
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;
        
        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    
    public Stack()
    {
    	first=null;
    	last=null;
    	size=0;
    }
    
	@Override
	/**
	 * Adds the object "o" on top of stack.
	 * @param o The object to add on top of the stack.
	 */
	public void push(T o) {
        ListElement<T> newElement = new ListElement<T>(o);
        
        if(first == null)
        {
        	first = newElement;
        	last = first; // switched from first=last (remember same in addLast)
        }
        else
        {
        	newElement.next = first;
        	first = newElement;		
        }
        size++;
		
	}

	@Override
	/**
	 * Removes and returns the the top element in the stack.
	 * @return Top element in the stack.
	 * @throws StackEmptyException.
	 */
	public T pop() throws StackEmptyException {

    	if(size == 0 || first == null)
    		throw new StackEmptyException();
    	
    	ListElement<T> temp = first;
    	
    	first = first.next;
    	size--;
    	
        return temp.data;
	}

	@Override
	/**
	 * Returns the top element in the stack without removing it.
	 * @return Top element in the stack.
	 * @throws StackEmptyException.
	 */
	public T top() throws StackEmptyException {
		// TODO Auto-generated method stub
		
		if(size == 0)
			throw new StackEmptyException();
		/*
    	if(first == null)
    		return null;
    	*/
		
        return first.data;
	}

	@Override
	
	/**
	 * The number of items in the stack (i.e. the size).
	 * @return size.
	 */
    public int size() {
        // TODO
        return size;
    }

	@Override
	/**
	 * If the stack is empty, this will return true and false otherwise.
	 * @return True or false.
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size == 0)
			return true;
		else
			return false;
	}
	
    /**
     * Returns a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     */
    public String toString() {
        
    	StringWriter out = new StringWriter();
    	out.write("[");
    	
    	ListElement<T> current;
    	
    	current = first;
    	
    	if(current == null)
    		return "[]";
    
    	for (int i = 0; i < size-1; i++) {
    		out.write( current.data.toString() + ", ");
    		current = current.next;
    		
		}
		out.write(current.data.toString() + "]");
		
        return out.toString();
    
    }
	
}
