package inda5;

import java.io.StringWriter;

public class Tree<T extends Comparable<T>> {
	
    private Node<T> nodes;   // First element in list.
    private int size;
    /**
     * A node element.
     */
    public static class Node<T> {
    	
    	public int key;
        public T value;
        public Node<T> left;
        public Node<T> right;
        
        
        public Node(int key,T value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    /**
     * Creates a new instance of the Tree class.
     * @param main The main node (root).
     */
    public Tree(Node<T> main)
    {
    	this.nodes = main;
    }
    
    /**
     * Finds the values of the given key. If the key does not exist, null will be returned.
     * @param key The key.
     * @return The object associated with the key or null if the key does not exist.
     */
    public Node<T> Find(int key)
    {
    	Node<T> temp = nodes;
 
    	while(temp != null && temp.key != key)
    	{
    		if (key < temp.key)
    			temp = temp.left;
    		else
    			temp = temp.right;
    	}
    	
    	return temp;
    }
    
    /**
     * Inserts a new value into given key. If the key already exists, the value is updated.
     * @param key The key.
     * @param value The value.
     */
    public void Insert(int key, T value)
    {
    	size++;
    	if(nodes == null)
    	{
    		nodes = new Node<T>(key, value);
    		return;
    	}
    	
    	Node<T> temp = nodes;
    	 
    	while(temp != null && temp.key != key )
    	{
    		if (key < temp.key && temp.left != null)
    			temp = temp.left;
    		else if (key > temp.key &&  temp.right != null)
    			temp = temp.right;
    		else
    			break;
    	}
    	
        if (key == temp.key) {
    		temp.value = value; size--;	
        }
    	else if (key < temp.key)
    		temp.left = new Node<T>(key, value);
    	else
    		temp.right = new Node<T>(key, value);
    }
    
    public int NumberOfLeaves()
    {
    	return getNumberOfLeaves(nodes);
    }
    
    /**
     * Helper method for NumberOfLeaves
     */
    private int getNumberOfLeaves(Node<T> n)
    {
    	if (n == null) return 0;
    	if (n.left == null && n.right == null) return 1;
    	
    	return getNumberOfLeaves(n.left) + getNumberOfLeaves(n.right);
    }
    
    public int Deapth()
    {
    	return getDeapth(nodes);
    }
    
    /**
     * Helper method for Deapth
     */
    private int getDeapth(Node<T> n)
    {
    	if (n == null) return 0;
    	return max(getDeapth(n.left), getDeapth(n.right)) + 1;
    }
    
    /**
     * Finds the max value
     */
    private int max (int a, int b)
    {
    	if (a > b)
    		return a;
    	return b;
    }
    
    /**
     * Returns a string reprsentation of the tree, ordered.
     */
    @Override
    public String toString()
    {
    	StringWriter out = new StringWriter();
    	out.write("[");
    	inorder(nodes, out);
    	String a = out.toString();
    	return a.substring(0, a.length()-1) + "]";
    }
    
    private void inorder(Node<T> node, StringWriter sw)
    {
    	if (node.left != null)
    		inorder(node.left, sw);
    	
    	sw.write(node.value.toString());
    	sw.write(",");
    	
    	if (node.right != null)
    		inorder(node.right, sw);
    }
}
