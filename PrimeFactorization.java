import java.util.*;

public class PrimeFactorization{
	private List<IntPair> factorization = new ArrayList<IntPair>();		//First number is a prime, second number is exponent
	
	public PrimeFactorization(int number)
	{
		List<Integer> primes = new ArrayList<Integer>();			//List of primes already discovered
		/*primes.add(2);												//First prime
		ListIterator iterator = primes.listIterator();
		while (iterator.hasNext() && number != 1)
		{
			int nextPrime = ((Integer)iterator.next()).intValue();					//Get the next prime from the iterator (and advance the iterator one position)
			IntPair timesDivisiblePair = findTimesDivisible(number, nextPrime);		//How many times does nextPrime divide the number?
			int timesDivisible = timesDivisiblePair.getFirst();
			if (timesDivisible > 0)
			{
				factorization.add(new IntPair(nextPrime, timesDivisible));
				number = timesDivisiblePair.getSecond();							//Set number to be the remainder after the division
			}
		}*/
		//if (number != 1)
		//{
			//int possiblePrime = primes.get(primes.size()-1) + 1;				//Get the number after the last prime we've discovered so far
			int possiblePrime = 2;												//Start off with two
			while (number != 1)
			{
				//iterator = primes.listIterator();						//Reset the iterator
				ListIterator iterator = primes.listIterator();						//Reset the iterator
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
					System.out.println(possiblePrime);		//test
					primes.add(possiblePrime);
					IntPair timesDivisiblePair = findTimesDivisible(number, possiblePrime);		//How many times does nextPrime divide the number?
					int timesDivisible = timesDivisiblePair.getFirst();
					if (timesDivisible > 0)
					{
						factorization.add(new IntPair(possiblePrime, timesDivisible));
						number = timesDivisiblePair.getSecond();								//Set number to be the remainder after the division
					}
				}
				possiblePrime++;
			}
		//}
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
}