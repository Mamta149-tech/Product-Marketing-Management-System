import java.util.regex.*;
public class Validation
{
	public static boolean check(String s)
	{
		boolean temp=false;
		Pattern pat=Pattern.compile("(91|0)?[6-9][0-9]{9}");
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