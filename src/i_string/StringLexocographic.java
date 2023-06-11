package i_string;

class GFG
{
/*
 0 a
 1 b
 2 c
 
 
 b can be replaced by a , c can be replaced by b
 * */
//Function to print the required string
static String printString(String s)
{
	StringBuffer result = new StringBuffer();
	char [] str = s.toCharArray();
	int n = s.length();
	// count number of 1s
	int ones = 0;
	for (int i = 0; i < n; i++)
		if (str[i] == 'b')
			ones++;

	// To check if the all the 1s
	// have been used or not
	boolean used = false;

	for (int i = 0; i < n; i++)
	{
		if (str[i] == 'c' && !used)
		{
			used = true;

			// Print all the 1s if any 2 is encountered
			for (int j = 0; j < ones; j++)
				result.append("b");
		}

		// If str[i] = 0 or str[i] = 2
		if (str[i] != 'b')
			result.append(str[i]);

	}

	// If 1s are not printed yet
	if (!used)
		for (int j = 0; j < ones; j++)
			result.append("b");
	
	return result.toString();
}

//Driver code
public static void main(String[] args)
{
	String str = "abaacbac";
	int n = str.length();
	System.out.println(printString(str));
}
}
