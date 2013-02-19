package com.futaba.tools;

import javax.swing.tree.DefaultMutableTreeNode;


public class IndexedObject extends Object
{

    public Object Objref;
    public int Index;

    public IndexedObject(Object objectref, int index)
	{
	    this.Objref = objectref;
	    this.Index = index;
	}
    
    public String toString()
	{
	    return Objref.toString();
	}
    
    
    public static void main(String[] args0)
	{
	    String testobject = "bye";
	    
	    
	    IndexedObject test1 = new IndexedObject(testobject, 1);
	    IndexedObject test2 = new IndexedObject(testobject, 2);
	    IndexedObject test3 = new IndexedObject(testobject, 3);

	    System.out.print(test1);
	}

}
