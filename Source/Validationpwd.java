import java.util.regex.*;
public class Validationpwd
{
	public static boolean checkpwd(String s)
	{
		boolean temp=false;
		Pattern pat=Pattern.compile("[a-zA-Z0-9. ]{10}");
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