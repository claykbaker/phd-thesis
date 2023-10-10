// author: Clayton K. Baker

/*
   This is a driver program to generate a list of all possible worlds for a set of propositional atoms.
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main 
{
	
	public static void main(String[] args)
	{

		try
		{
			// declaration of variables and objects
			List<String> propositions = new ArrayList<>(); 
			List<String> set = new ArrayList<>();
			File f = new File("output.txt");
			PrintStream ps = new PrintStream(f);
			System.setOut(ps);
			
			
			// initialise list of propositions
			
			propositions.add("P");
			propositions.add("Q");
			//propositions.add("R");
		
			
			
			// display propositinos
			
			System.out.println("Propositions");
			System.out.println();
			for(String x : propositions)
			{
				System.out.println(x + " ");
			}
			
			// generate interpretations
			System.out.println();
			System.out.println("Interpretations");
			System.out.println();
			List<List<Boolean>> interpretations = 
			PropositionalInterpretations.generateInterpretations(propositions);
			
			
			// write interpretations to file 
			String out;
			for (List<Boolean> interpretation : interpretations) 
			{
				out = "";
				for(Boolean val: interpretation)
				{
					if(val == true)
					{
						out += "T";
						//System.out.print("T");
					}
					else
					{	
						out += "F";
						//System.out.print("F");
					}
				}
				set.add(out);
				System.out.println(out);
			}
			System.out.println();
			
			
			// generate all partitions of intepretations and write to file
			
			System.out.println("Partitions ");
			System.out.println();
			Partitions.allPartitions(set);
			System.out.println();

			// generate and all arrangements of partitions of the set and write to file
			System.out.println("Possible worlds");
			System.out.println();
			Partitions.allPartitionArrangements(set);
			
		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(0);
		}
		
		
		
		
	
		
		
		
		
		
		
		

		
		

	}


}
