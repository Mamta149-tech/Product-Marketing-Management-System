import java.util.regex.*;

public class validationaddhar
{
	public static boolean checkaddhar(String s)
	{
		boolean temp=false;
		Pattern pat=Pattern.compile("[0-9]{12}");
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