//A simple class for a pair of integers

public class IntPair{
	
	private int first;
	private int second;
	
	public IntPair(int newFirst, int newSecond)
	{
		first = newFirst;
		second = newSecond;
	}
	
	//Getters
	public int getFirst()
	{
		return first;
	}
	public int getSecond()
	{
		return second;
	}
	
	//Setters
	public void setFirst(int newFirst)
	{
		first = newFirst;
	}
	public void setSecond(int newSecond)
	{
		second = newSecond;
	}
}