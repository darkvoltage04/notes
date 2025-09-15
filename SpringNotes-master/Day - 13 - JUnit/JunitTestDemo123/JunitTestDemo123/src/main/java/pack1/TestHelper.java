package pack1;

public class TestHelper {
	//AB
	public boolean checkFirstAndLastStringEuqal(String str)
	{
		if(str.length()<=1)
		return false;
		
		String firstTwoChar=str.substring(0, 2);
		String lastTwoChar=str.substring(str.length()-2);
		return firstTwoChar.equals(lastTwoChar);
	}
	
	

}
