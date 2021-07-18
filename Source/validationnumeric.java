import java.util.regex.*;

public class validationnumeric
{
	public static boolean checknumeric(String s)
	{
		boolean temp=false;
	Pattern pat=Pattern.compile("[0-9]{1,5}[ ][a-zA-Z]{1,10}");
		Matcher mat=pat.matcher(s);
		if(mat.find()&&mat.group().equals(s))
		{
			temp=true;
		}
		else
		{
			temp=false;
		}
		return temp;
	}
}