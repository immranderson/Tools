package com.futaba.tools;

import java.util.ArrayList;

public class Data extends ArrayList<String>
    {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Data getDupes()
	    {
		Data dupes = new Data();
		Data datacopy = new Data();
		datacopy.addAll(this);


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
				datacopy.remove(0);
			    }
		    } while (!datacopy.isEmpty());

		return dupes;
	    }

	public Data getUniques()
	    {
		Data uniques = new Data();

		Data datacopy = new Data();
		datacopy.addAll(this);

		do
		    {
			String first_element = datacopy.get(0);
			boolean dupe_flag = false;

			for (int i=1; i<datacopy.size(); i++)
			    {
				if (first_element.equals(datacopy.get(i)))
				    {
					dupe_flag=true;
					datacopy.remove(i);
					i--;
				    }
			    }

			if (dupe_flag == true)
			    {
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

	public Data getSharedUniquesWith (Data data2)
	    {
		Data sharedUniques = new Data();
		sharedUniques.addAll(this.getUniques().getSharedWith(data2.getUniques()));
		return sharedUniques;
	    }
	
	public Data getSharedWith (Data data2)
	    {
		Data shared = new Data();
		Data data2copy = new Data(); // created to prevent removal of information from original data2
		data2copy.addAll(data2);

		for (int i=0; i<this.size(); i++)
		    {
			for (int j=0; j<data2copy.size(); j++)
			    {
				if (this.get(i).equals(data2copy.get(j)))
				    {
					shared.add(this.get(i));
					data2copy.remove(j);
					break;
				    }
			    }
		    }
		return shared;
	    }

	public Data getNotSharedWith (Data data2)
	    {
		Data shared = new Data();
		Data notshared = new Data();
		Data data2copy = new Data(); // created to prevent removal of information from original data2
		data2copy.addAll(data2);

		for (int i=0; i<this.size(); i++)
		    {
			boolean flag = false;

			for (int j=0; j<data2copy.size(); j++)
			    {

				if (this.get(i).equals(data2copy.get(j)))
				    {
					flag = true;
					shared.add(this.get(i));
					data2copy.remove(j);
				    }
			    }
			if (flag == false)
			    notshared.add(this.get(i));
		    }
		notshared.addAll(data2copy);
		return notshared;
	    }



	public static void main(String[] args)
	    {	    
		Data data = new Data();
		Data data2 = new Data();

		data.add("A");
		data.add("B");
		data.add("C");
		data.add("D");

		data2.add("B");
		data2.add("C");
		data2.add("E");
		
		
		for (String string : data.getNotSharedWith(data2))
		    System.out.println(string);

	    }

    }
