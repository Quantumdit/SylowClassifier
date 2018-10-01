//Given a group size, returns some information about the group by applying the Sylow theorems
//Done as a project, so I tried implementing some things on my own rather than implementing existing solutions
//Made by Yehonatan Shabash

import java.util.Scanner;

public class SylowClassifier{
	public static void main(String arg[]){
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the size of the group: ");
		long input = reader.nextLong();
		LongPair[] pf = MathHandler.PrimeFactorization(input);
		String report = Prover.firstSylowTheorem(pf);	//DEBUG
		System.out.println(report);			//DEBUG
		reader.close();
	}
}