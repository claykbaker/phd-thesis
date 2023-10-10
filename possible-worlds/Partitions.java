// author: ChatGPT
// modified by: Clayton Kevin Baker
import java.util.ArrayList;
import java.util.List;

public class Partitions {
	// Function to print a partition
	static int totalSubsets = 0;
	static void printPartition(List<List<String>> ans) 
	{
		//int subsetCount=0;
		for (List<String> subset : ans) 
		{
			//subsetCount = ans.size();
			System.out.print("[ ");
			
			for (String element : subset)
			{
				System.out.print(element + " ");
			}
			System.out.print("] ");
		}
		System.out.println();
		//System.out.println("\t\t" + subsetCount+" subset(s) or rank(s)");
		//totalSubsets += factorial(subsetCount);
		
		
		
	
		
	}
		// function to print all arrangements of partitions
		static void printPartitionArrangements(List<List<String>> ans) {

		
		Arrangements obj = new Arrangements();
		List<List<String>> listOfLists = new ArrayList<>();
		for(List<String> subset: ans)
		{
			listOfLists.add(subset);
		}
		List<List<List<String>>> arrangements = obj.generateListOfListsArrangements(listOfLists);
		obj.display(arrangements);

	}

	// Function to generate all partitions
	static void partition(List<String> set, int index, List<List<String>> ans) {
		// If we have considered all elements
		// in the set, print the partition
		if (index == set.size()) {
			printPartition(ans);
			return;
		}

		// For each subset in the partition,
		// add the current element to it and recall
		for (int i = 0; i < ans.size(); i++) {
			ans.get(i).add(set.get(index));
			partition(set, index + 1, ans);
			ans.get(i).remove(ans.get(i).size() - 1);
		}

		// Add the current element as a singleton subset and recall
		List<String> newSubset = new ArrayList<>();
		newSubset.add(set.get(index));
		ans.add(newSubset);
		partition(set, index + 1, ans);
		ans.remove(ans.size() - 1);
	}
	
		static void partitionArrangements(List<String> set, int index, List<List<String>> ans) {
		// If we have considered all elements
		// in the set, print the partition
		if (index == set.size()) {
			printPartitionArrangements(ans);
			return;
		}

		// For each subset in the partition,
		// add the current element to it and recall
		for (int i = 0; i < ans.size(); i++) {
			ans.get(i).add(set.get(index));
			partitionArrangements(set, index + 1, ans);
			ans.get(i).remove(ans.get(i).size() - 1);
		}

		// Add the current element as a singleton subset and recall
		List<String> newSubset = new ArrayList<>();
		newSubset.add(set.get(index));
		ans.add(newSubset);
		partitionArrangements(set, index + 1, ans);
		ans.remove(ans.size() - 1);
	}

	// Function to generate all partitions for a given set
	static void allPartitions(List<String> set) {
		List<List<String>> partitions = new ArrayList<>();
		partition(set, 0, partitions);
	}
	
	// Function to generate all arrangements of partitions for a given set
	static void allPartitionArrangements(List<String> set) {
		List<List<String>> partitions = new ArrayList<>();
		partitionArrangements(set, 0, partitions);
	}
	
	static int factorial (int n)
	{
		if(n >= 1)
		{
			return n * factorial(n-1);
		}
		else if(n == 0)
		{
			return 1;
		}
		return 0;
	}

	// Main function
	public static void main(String[] args) {
		// The size of the set
		int n = 3;

		// Initialize the set as {"TT", "TF", "FT", "FF"}
		List<String> set = new ArrayList<>();
		set.add("TT");
		set.add("TF");
		set.add("FT");
		set.add("FF");
	
		System.out.println("All partitions of the set: ");

		// Generate and print all partitions of the set
		allPartitions(set);
		System.out.println();


		System.out.println("All arrangements of partitions of the set: ");
		// Generate and print all arrangements of partitions of the set
		allPartitionArrangements(set);
		System.out.println();
		//System.out.println("Possible worlds = " + totalSubsets);
	}
}
// This code was contirbuted by codearcade
