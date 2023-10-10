// author: Clayton K. Baker

/*
   This is a driver program to generate a list of all possible worlds for a set of propositional atoms.
*/

import java.util.ArrayList;
import java.util.List;

public class PossibleWorlds 
{
	
	public static void main(String[] args)
	{
		// declaration of variables and objects
		List<String> propositions = new ArrayList<>(); 
		List<String> set = new ArrayList<>();
		Partitions parts = new Partitions();
		PropositionalInterpretations pi = new PropositionalInterpretations();
		
		// initialise list of propositions
		propositions.add("P");
		propositions.add("Q");
		//propositions.add("R");
		System.out.println("Propositions");
		System.out.println();
		for(String x : propositions)
			System.out.println(x + " ");
		
		// generate interpretations
		System.out.println();
		System.out.println("Interpretations");
		System.out.println();
		List<List<Boolean>> interpretations = pi.generateInterpretations(propositions);
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
		
		// generate list of partitions of intepretations
		System.out.println("Partitions ");
		System.out.println();
		parts.allPartitions(set);
		System.out.println();

		// generate and print all arrangements of partitions of the set
		System.out.println("Possible worlds");
		System.out.println();
		parts.allPartitionArrangements(set);
		
	}


}
