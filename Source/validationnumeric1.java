import java.util.regex.*;

public class validationnumeric1
{
	public static boolean checknumeric1(String s)
	{
		boolean temp=false;
	Pattern pat=Pattern.compile("[0-9.]{1,8}");
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