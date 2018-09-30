import java.util.*;

public class PrimeFactorization{
	private final ArrayList<IntPair> factorization;						//First number is a prime, second number the associated exponent
	
	public PrimeFactorization(int number)
	{
		ArrayList<IntPair> newFactorization = new ArrayList<IntPair>();
		ArrayList<Integer> primes = new ArrayList<Integer>();			//List of primes already discovered
		int possiblePrime = 2;										//Start off with two
		while (number != 1)
		{
			ListIterator iterator = primes.listIterator();
			boolean isPrime = true;									//Assume that possiblePrime is prime, but we'll see if that's really the case
			while(iterator.hasNext())
			{
				if (possiblePrime % ((Integer)iterator.next()).intValue() == 0)		//If possible prime is divisible by a number we know is prime, then possiblePrime is not a prime
				{
					isPrime = false;
				}
			}
			if (isPrime)
			{
				primes.add(possiblePrime);
				IntPair timesDivisiblePair = findTimesDivisible(number, possiblePrime);		//How many times does nextPrime divide the number?
				int timesDivisible = timesDivisiblePair.getFirst();
				if (timesDivisible > 0)
				{
					System.out.println(possiblePrime);		//DEBUG
					System.out.println(timesDivisible);		//DEBUG
					newFactorization.add(new IntPair(possiblePrime, timesDivisible));
					number = timesDivisiblePair.getSecond();								//Set number to be the remainder after the division
				}
			}
			possiblePrime++;
		}
		factorization = newFactorization;
	}
	
	//Returns the number of times that divisor divides number, along with the remainder
	private IntPair findTimesDivisible(int number, int divisor)
	{
		int counter = 0;
		while(number % divisor == 0)
		{
			counter++;
			number = number / divisor;
		}
		return new IntPair(counter,number);
	}
	
	public ArrayList<IntPair> getFactorization()
	{
		return factorization;
	}
}