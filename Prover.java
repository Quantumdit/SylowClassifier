//Given a group size, returns some information about the group by applying the Sylow theorems

public class Prover{
	
	//Generate a report for applying the First Sylow Theorem to the number determined by the prime factorization given as input
	public static String firstSylowTheorem(LongPair[] factorization)
	{
		String report = "First Sylow Theorem: \n";
		
		//Part 1, The existing subgroups
		report = report + "\t" + "By the first Sylow Theorem, the group is guaranteed to have subgroups of the following sizes: \n";
		for (int i = 0; i < factorization.length; i++)
		{
			report = report + "\t\t";
			long number = 1;
			for (int j = 0; j < factorization[i].getSecond(); j++)
			{
				number = number*factorization[i].getFirst();
				if (j != 0)
				{
					report = report + ",";		//Add this before every number, except the first number in a line
				}
				report = report + Long.toString(number);
			}
			if (i != factorization.length-1)
			{
				report = report + ",";			//Add this to the end of every line except the last
			}
			report = report + "\n";
		}
		
		//Part 2, the Sylow p-subgroups
		report = report + "\t" + "By the First Sylow Theorem, the group has the following p-Sylow subgroups: \n";
		for (int i = 0; i < factorization.length; i++)
		{
			report = report + "\t\t" + "Sylow " + Long.toString(factorization[i].getFirst()) + "-subgroups, which are of order ";
			report = report + Long.toString(MathHandler.longPow(factorization[i].getFirst(),factorization[i].getSecond())) + ".\n";
		}
		
		return report;
	}
}