package com.futaba.tools;

import java.util.ArrayList;

public class Share
{

    public static ArrayList<String> Sharing (ArrayList<String> data1, ArrayList<String> data2)
    {
	ArrayList<String> shared = new ArrayList<String>();
	ArrayList<String> data2copy = new ArrayList<String>(); // created to prevent removal of information from original data2
	data2copy.addAll(data2);

	for (int i=0; i<data1.size(); i++)
	    {

		for (int j=0; j<data2copy.size(); j++)
		    {

			if (data1.get(i).equals(data2copy.get(j)))
			    {
				shared.add(data1.get(i));
				data2copy.remove(j);
				break;
			    }

		    }

	    }

	return shared;
    }


    public static ArrayList<String> NotSharing (ArrayList<String> data1, ArrayList<String> data2)
    {
	ArrayList<String> shared = new ArrayList<String>();
	ArrayList<String> notshared = new ArrayList<String>();
	ArrayList<String> data2copy = new ArrayList<String>(); // created to prevent removal of information from original data2
	data2copy.addAll(data2);

	for (int i=0; i<data1.size(); i++)
	    {
		boolean flag = false;

		for (int j=0; j<data2copy.size(); j++)
		    {

			if (data1.get(i).equals(data2copy.get(j)))
			    {
				flag = true;
				shared.add(data1.get(i));
				data2copy.remove(j);
			    }

		    }

		if (flag == false)
		    notshared.add(data1.get(i));
	    }

	notshared.addAll(data2copy);

	return notshared;
    }

    public static ArrayList<String> GetDupes (ArrayList<String> data)
    {
	ArrayList<String> dupes = new ArrayList<String>();
	ArrayList<String> uniques = new ArrayList<String>();

	ArrayList<String> datacopy = new ArrayList<String>();
	datacopy.addAll(data);
	
	do
	    {
		String first_element = datacopy.get(0);
		boolean dupe_flag = false;
		
		for (int i=1; i<datacopy.size(); i++)
		    {
			if (first_element.equals(datacopy.get(i)))
			    {
				dupe_flag=true;
				dupes.add(datacopy.get(i));
				datacopy.remove(i);
				i--;
			    }
		    }
		
		if (dupe_flag == true)
		    {
			dupes.add(datacopy.get(0));
			datacopy.remove(0);
		    }
		
		if (dupe_flag == false)
		    {
			uniques.add(datacopy.get(0));
			datacopy.remove(0);
		    }
	    } while (!datacopy.isEmpty());
	
	
	return dupes;
    }
    
    public static ArrayList<String> GetUniques (ArrayList<String> data)
    {
	ArrayList<String> dupes = new ArrayList<String>();
	ArrayList<String> uniques = new ArrayList<String>();

	ArrayList<String> datacopy = new ArrayList<String>();
	datacopy.addAll(data);
	
	do
	    {
		String first_element = datacopy.get(0);
		boolean dupe_flag = false;
		
		for (int i=1; i<datacopy.size(); i++)
		    {
			if (first_element.equals(datacopy.get(i)))
			    {
				dupe_flag=true;
				dupes.add(datacopy.get(i));
				datacopy.remove(i);
				i--;
			    }
		    }
		
		if (dupe_flag == true)
		    {
			dupes.add(datacopy.get(0));
			datacopy.remove(0);
		    }
		
		if (dupe_flag == false)
		    {
			uniques.add(datacopy.get(0));
			datacopy.remove(0);
		    }
	    } while (!datacopy.isEmpty());
	
	
	return uniques;
    }

    public static String Merge (String string1, String string2)
	{
	    String merged = string1 + string2;
	    return merged;
	}


    public static void main(String[] args)
	{

	    ArrayList<String> data1 = new ArrayList<String>();
	    ArrayList<String> data2 = new ArrayList<String>();

	    ArrayList<String> shared = new ArrayList<String>();
	    ArrayList<String> notshared = new ArrayList<String>();

	    data1.add("B");
	    data1.add("A");
	    data1.add("C");
	    data1.add("A");
	    data1.add("E");
	    data1.add("C");
	    data1.add("A");
	    data1.add("B");
	    data1.add("C");
	    data1.add("C");
	    data1.add("D");


	    data2.add("C");
	    data2.add("C");
	    data2.add("C");
	    data2.add("C");
	    data2.add("C");
	    data2.add("D");
	    data2.add("E");
	    data2.add("F");
	    data2.add("F");


//	    shared = Sharing(data1, data2);
//	    notshared = NotSharing(data1 , data2);
//
//	    for (String string : shared)
//		System.out.println(string);
//
//	    System.out.println("********************");
//
//	    for (String string : notshared)
//		System.out.println(string);
	    
	    for (String string : GetDupes(data1))
		System.out.println(string);
	    
	    
	    System.out.println("*********************");
	    
	    for (String string : GetUniques(data1))
		System.out.println(string);
	}

}
