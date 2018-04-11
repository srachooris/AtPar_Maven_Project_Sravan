package ExcelReader;

public class alphaNumeric {
	static int result = 0;

	public static int alpha(String str) {

		char ch[] = str.toCharArray();
		{

			for (char c : ch) {
				int temp = (int) c;

				System.out.println();
				int temp_integer = 64;
				if (temp <= 90 & temp >= 65) {
					result = ((temp - temp_integer) - 1);

				}

			}
		}
		return result;

	}

}