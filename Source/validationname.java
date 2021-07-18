import java.util.regex.*;
public class validationname
{
	public static boolean checkname(String s)
	{
		boolean temp=false;
		Pattern pat=Pattern.compile("[a-zA-Z. ]+");
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