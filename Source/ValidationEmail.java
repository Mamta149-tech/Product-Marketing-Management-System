import java.util.regex.*;
public class ValidationEmail
{
	public static boolean checkEmail(String s)
	{
		boolean temp=false;
		Pattern pat=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
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