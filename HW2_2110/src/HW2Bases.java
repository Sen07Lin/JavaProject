/**
 * HW2 Part 1 - Coding with bases.
 * 
 * @author Sen Lin
 * *** NOTE: The rules are different for each java file! ***
 * 
 * You may NOT use any of the following: - Any functions found in Java libraries
 * (especially the Math library) - Example Math.pow, Integer.bitCount,
 * String.valueOf, etc. - Basically, any function that does everything for you.
 * The purpose of this homework is to learn how to do these operations yourself,
 * and the Java API! - The only exception to this rule is String.charAt to get a
 * character from a String, and you may use String.length to get the size of the
 * string.
 * - You may not implement any Java library functions as helpers to use in other
 * functions.
 * - You may not write your own pow() method to use. None of the functions
 * require a pow() function to complete.
 * 
 * - String concatenation with a number for more than one digit. - For example,
 * "" + 123 is banned. "" + 6 is allowed, though.
 * - You may use Modulus(%), Multiplication(*), Division(/), Addition(+),
 * Subtraction(-)
 * 
 * - You may use the assignment operator (of course).
 * 
 * - You may use for/while loops to iterate through values.
 * 
 * - You may only use 2 if-statements max PER method. - You may use if
 * statements inside for/while loops if necessary. - This means you may have 2
 * separate conditions, making these okay:
 * if(cond1) { code; } else { moreCode; } if(cond2) { code; } else { modeCode; }
 * OR
 * 
 * if(cond1){ if(cond2){ code; } code; }
 * 
 * OR
 * if(cond1){ code; }else if(cond2){ code; }else{}
 * - We also understand that for/while loops can be used like if-statements, but
 * it is in your best interest to not exploit the loophole; However, you may use
 * for/while loops to iterate through the values.
 * - You may not use a switch statement.
 * - Recursion is not allowed.
 * - You may not reuse any function to implement another function. - You may
 * reuse portions of your code from different methods inside other methods. You
 * are just not allowed to call methods from within other methods.
 * - You may not use arrays. You shouldn't have to use an array for those
 * problems.
 * - You will only have to worry about the cases we mentioned 
 * in the method descriptions.
 * 
 */
public class HW2Bases {
	/**
	 * strdtoi - Decimal String to int
	 * 
	 * Convert a string containing ASCII characters (in decimal) to an int. You
	 * do not have to handle negative numbers. The Strings we will pass in will
	 * be valid decimal numbers, and able to fit in a 32-bit signed integer.
	 * 
	 * Example: strdtoi("123"); // => 123
	 * 
	 * @param the
	 * decimal in String form
	 * @return return the decimal in int form.
	 */
	public static int strdtoi(String decimal) {
		int realNum = 0x0000;
		int multiplier = 0x0001;
		for (int i = decimal.length(); i > 0; i--) {
			int temp = ((int) decimal.charAt(i - 0x0001) - 0x0030) * multiplier;
			realNum = realNum + temp;
			multiplier = multiplier * 0x000A;
		}
		return realNum;
	}
	/**
	 * strbtoi - Binary String to int
	 * 
	 * Convert a string containing ASCII characters (in binary) to an int. You
	 * do not have to handle negative numbers. The Strings we will pass in will
	 * be valid binary numbers, and able to fit in a 32-bit signed integer.
	 * 
	 * Example: strbtoi("111"); // => 7
	 * 
	 * @param binary
	 * 		The binary string to be converted
	 * @return the decimal after conversion.
	 */
	public static int strbtoi(String binary) {
		int realNum = 0x0000;
		int multiplier = 0x0001;
		for (int i = binary.length(); i > 0; i--) {
			int temp = ((int) binary.charAt(i - 0x0001) - 0x0030) * multiplier;
			realNum = realNum + temp;
			multiplier = multiplier * 0x0002;
		}
		return realNum;
	}
	/**
	 * strxtoi - Hexadecimal String to int
	 * 
	 * Convert a string containing ASCII characters (in hex) to an int. You do
	 * not have to handle negative numbers. The Strings we will pass in will be
	 * valid hexadecimal numbers, and able to fit in a 32-bit signed integer.
	 * You may assume that hex string will be capital (ie. 0xFF2A rather than
	 * 0xff2a).
	 * 
	 * Example: strxtoi("A6"); // => 166
	 * 
	 * @param hex
	 * 		The HexaString to be converted
	 * @return return the decimal of the hexaString
	 */
	public static int strxtoi(String hex) {
		int realNum = 0x0000;
		int multiplier = 0x0001;
		for (int i = hex.length() - 0x0001; i >= 0; i--) {
			int x = (int) hex.charAt(i);
			if (x >= 0x0041) {
				int temp = ((int) hex.charAt(i) - 0x0037) * multiplier;
				realNum = realNum + temp;
			} else {
				int temp = ((int) hex.charAt(i) - 0x0030) * multiplier;
				realNum = realNum + temp;
			}
			multiplier = multiplier * 0x0010;
		}
		return realNum;
	}
	/**
	 * itostrb - int to Binary String
	 * 
	 * Convert a int into a String containing ASCII characters (in binary). You
	 * do not have to handle negative numbers. The String returned should
	 * contain the minimum number of characters necessary to represent the
	 * number that was passed in.
	 * 
	 * Example: itostrb(7); // => "111"
	 * 
	 * @param binary
	 * the integer to be converted into binary String
	 * @return return a converted binary string.
	 */
	public static String itostrb(int binary) {
		if (binary == 0x0000) {
			return "" + 0x0000;
		}
		String bString = "";
		while (binary >= 0x0001) {
			bString = binary % 0x0002 + bString;
			binary = binary / 0x0002;
		}
		return bString;
	}
	/**
	 * itostrx - int to Hexadecimal String
	 * 
	 * Convert a int into a String containing ASCII characters (in hexadecimal).
	 * You do not have to handle negative numbers. The String returned should
	 * contain the minimum number of characters necessary to represent the
	 * number that was passed in.
	 * 
	 * Example: itostrx(166); // => "A6"
	 * 
	 * @param hex
	 * the integer to be converted into hexaString.
	 * @return return a hexaString
	 */
	public static String itostrx(int hex) {
		if (hex == 0x0) {
			return "" + 0x0;
		}
		String HString = "";
		while (hex >= 0x0001) {
			if (hex % 0x0010 >= 0x0A) {
				HString = (char) (hex % 0x0010 + 0x0037) + HString;
			} else {
				HString = hex % 0x0010 + HString;
			}
			hex = hex / 0x0010;
		}
		return HString;
	}
}
