import java.util.regex.*;

public class validationamountreceived
{
	public static boolean checkamountreceived(String s)
	{
		boolean temp=false;
		Pattern pat=Pattern.compile("[0-9.]{2,10}");
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