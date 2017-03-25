import java.io.*;
import java.util.*;

/**
 * Class containing solutions for various Hackerrank/GeeksForGeeks coding
 * challenges
 *
 * @author Onkar Ganjewar
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		hackerRankStdInput();
	}

	/**
	 * A dummy method to accept input from stdin in a format most commonly used
	 * in challenge questions at Hackerrank
	 *
	 * @throws IOException
	 */
	private static void hackerRankStdInput() throws IOException {

		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		System.out.println("Test cases are " + testCases);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// For each test case do following
		for (int j = 0; j < testCases; j++) {
			String str = br.readLine();
			// Get the length of the array and jump position index
			String[] splits = str.split(" ");

			int arrLen = Integer.parseInt(splits[0]);
			int jumpPos = Integer.parseInt(splits[1]);

			// Create an array and fill the elements from the line
			int[] arr = new int[arrLen];

			String arrLine = br.readLine();
			String[] elements = arrLine.split(" ");
			for (int i = 0; i < elements.length; i++) {
				arr[i] = Integer.parseInt(elements[i]);
			}

			// Solve the challenge for the particular problem
			// solveChallenge();

			// print the result
			System.out.println("Result");
			for (int eachObj : arr) {
				System.out.print(" " + eachObj);
			}
			System.out.println(" MOve position " + jumpPos);

			// continue
		}
	}

	/**
	 * Find largest possible difference between any two elements within an array
	 *
	 * @param arr
	 * @return
	 */
	private static int findMaxDiff(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];

			if (arr[i] > max)
				max = arr[i];
		}
		return (max - min);
	}

	/**
	 * Compute the largest possible difference between any two elements within
	 * an array such that larger element always appears after the smaller
	 * element.
	 *
	 * @param arr
	 */
	private static int computeMaxDiff(int[] arr) {
		int diff, maxDiff, min = Integer.MAX_VALUE;
		diff = maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];

			// diff = Math.abs(arr[i]) - Math.abs(min);
			diff = arr[i] - min;
			if (diff > maxDiff)
				maxDiff = diff;
		}
		return maxDiff;
	}

	/**
	 * @param a1
	 * @param a2
	 */
	private static void merge2sortedArrays(int[] a1, int[] a2) {
		// int m = a1.length;
		// int n = a2.length;
		int[] A = { 4, 0, 6, 0, 8, 0 };
		int m = 3;
		int[] B = { 5, 7, 9 };
		int n = 3;

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
			// if(A[i] > B[j])
			// A[k--] = A[i--];
			// else
			// A[k--] = B[j--];
		}
		while (j >= 0)
			A[k--] = B[j--];

	}

	/**
	 * You are playing a game on your cell phone. You are given an array of
	 * length n, indexed from 0 to n-1. Each element of the array is either 0 or
	 * 1. You can only move to an index which contains 0. At first, you are at
	 * the 0th position. In each move you can do one of the following things:
	 * <br>
	 * <br>
	 * Walk one step forward or backward. <br>
	 * Make a jump of exactly m length forward. <br>
	 * <br>
	 * That means you can move from position x to x+1,x-1 or x+m in one move,
	 * but at least one of the following conditions must be true: </br>
	 * <br>
	 * The new position contains 0. <br>
	 * The new position is greater than n-1.<br>
	 * <br>
	 * You can't move backward from position . If you move to any position
	 * greater than n-1, you win the game.
	 *
	 * @param m
	 *            Jump length
	 * @param arr
	 *            Input array
	 * @param i
	 *            Starting position
	 * @return
	 */
	@SuppressWarnings("unused")
	private static boolean isSolvable(int[] array, int m, int i) {

		/* Base Cases */
		if (i < 0 || array[i] == 1) {
			return false;
		} else if (i + 1 >= array.length || i + m >= array.length) {
			return true;
		}

		array[i] = 1; // marks as visited

		/* Recursive Cases */
		return isSolvable(array, m, i - 1) || isSolvable(array, m, i + 1) || isSolvable(array, m, i + m);
	}

	/**
	 * Given an array of positive integers. All numbers occur even number of
	 * times except one number which occurs odd number of times. Find the number
	 * in O(n) time & constant space
	 *
	 * @param arr
	 * @return
	 */
	private static int getOddOccuringElement(int[] arr) {
		int result = 0;
		int res[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			result ^= num;
			res[i] = result;
		}
		return result;
	}

	/**
	 * Find all the palindromes from a given string. Given a string, find all
	 * possible palindromic partitions of given string. Ex. "abba" --> bb, abba,
	 * a, b
	 *
	 * @param input
	 * @return no of combinations of all the palindrome substrings from a given
	 *         string.
	 */
	public static int palindromePermutations(final String str) {
		String input = str;
		List<String> palindromeOutputs = new ArrayList<String>();
		int len = str.length();
		int i = 0, j = len;
		boolean flag = false;
		char[] charArr = new char[str.length()];
		charArr = str.toCharArray();
		for (i = 0; i < len; i++) {
			// Check with keeping current char at center
			char current = charArr[i];
			if (i > 0)
				palindromeOutputs.addAll(centerCombinations(str, i));
			if (i < len - 1)
				palindromeOutputs.addAll(rightCombinations(str, i));
		}
		/*
		 * while (i < j) { String inp = input.substring(i, j); flag =
		 * checkPalindrome(inp); if (flag) palindromeOutputs.add(inp); i++; j--;
		 * }
		 */

		for (char c : charArr) {
			palindromeOutputs.add(Character.toString(c));
		}

		return palindromeOutputs.size();
	}

	public static List<String> centerCombinations(String string, int center) {
		List<String> result = new ArrayList<>();

		while (string.charAt(center - 1) == string.charAt(center + 1)) {
			result.add(string.substring(center - 1, center + 2));
			center++;
		}
		return result;
	}

	public static List<String> rightCombinations(String string, int right) {
		List<String> result = new ArrayList<>();

		while (string.charAt(right) == string.charAt(right + 1)) {
			result.add(string.substring(right, right + 2));
			right++;
		}
		return result;
	}

	/**
	 * Given an array with elements, can you sort this array in ascending order
	 * using only one of the following operations?
	 *
	 * Swap two elements OR Reverse one sub-segment.
	 *
	 * @param arr
	 * @param size
	 */
	private static String almostSorted(int[] a, int size) {
		int i, j;
		List<Integer> unsortedList = new ArrayList<>();
		i = j = 0;
		int temp;
		int sorted = 0;
		int unSorted = 0;
		int[] unSortArr = new int[size];
		int broken = 0;
		int count = 0;
		while (i < size) {
			while (a[i] < a[i + 1]) {
				sorted++;
				i++;
			}
			j = i;
			while (a[i] > a[i + 1]) {
				unSorted++;
				unSortArr[i] = a[i];
				unsortedList.add(a[i]);
				if (i >= (size - 2))
					break;
				else
					i++;
			}
			// if (unSorted > 0)
			// unSorted++;
			while (((j + 1) != (i - 1)) && (unSorted > 0)) {
				if (a[j] > a[i]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					unSorted -= 2;
				}
				j++;
				i--;
			}
			if (!unsortedList.isEmpty())
				unsortedList.add(a[i]);
			broken++;
			Collections.reverse(unsortedList);
			// for (int k = 0; k<size-1; k++) {
			// if (a[k] < a[k+1])
			// count++;
			// }
			int total = sorted + unSorted;
			if (size == count)
				return "YES";
		}
		return "NO";
	}

	/**
	 * A Discrete Mathematics professor has a class of students. Frustrated with
	 * their lack of discipline, he decides to cancel class if fewer than K
	 * students are present when class starts.
	 *
	 * Given the arrival time of each student, determine if the class is
	 * canceled.
	 *
	 * @param students
	 * @param threshold
	 */
	private static String angryProf(int[] students, int threshold) {
		List<Integer> earlyStudents = new ArrayList<>();
		List<Integer> lateStudents = new ArrayList<>();

		for (int i : students) {
			if (i > 0)
				lateStudents.add(i);
			else
				earlyStudents.add(i);
		}

		if (earlyStudents.size() < threshold)
			return "YES";
		return "NO";
	}

	/**
	 * The Utopian Tree goes through 2 cycles of growth every year. Each spring,
	 * it doubles in height. Each summer, its height increases by 1 meter.
	 *
	 * Laura plants a Utopian Tree sapling with a height of 1 meter at the onset
	 * of spring. How tall will her tree be after growth cycles?
	 *
	 * @param cycles
	 */
	private static int utopianTree(int cycles) {
		int height = 1;
		// Laura plants a Utopian Tree sapling with a height of 1 meter at the
		// onset of Spring. So, the initial height () of the tree remains
		// unchanged.
		if (cycles == 0)
			return 1;
		while (cycles > 0) {
			// Each spring it doubles it's height
			if (cycles > 0) {
				height *= 2;
				cycles--;
			}
			// Each summer it's height increases by 1m
			if (cycles > 0) {
				height += 1;
				cycles--;
			}
		}
		return height;
	}

	/**
	 * Get all the possible combinations of words from a given string
	 *
	 * @param str
	 */
	private static Set<String> stringPermutations(String str, int start, int end, Set<String> output) {
		if (start == end) {
			output.add(str);
			System.out.println(str);
		} else {
			for (int i = start; i <= end; i++) {
				str = swap(str, start, i);
				stringPermutations(str, start + 1, end, output);
				// str = swap(str, start, i);
			}
		}
		return output;
	}

	/**
	 * Swap characters
	 *
	 * @param str
	 * @param start
	 *            position 1
	 * @param i
	 *            position 2
	 * @return swapped string
	 */
	private static String swap(String str, int start, int i) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[start];
		charArray[start] = temp;
		return String.valueOf(charArray);
	}

	/**
	 * You are given a square map of size . Each cell of the map has a value
	 * denoting its depth. We will call a cell of the map a cavity if and only
	 * if this cell is not on the border of the map and each cell adjacent to it
	 * has strictly smaller depth. Two cells are adjacent if they have a common
	 * side (edge).
	 *
	 * You need to find all the cavities on the map and depict them with the
	 * uppercase character X.
	 */
	private static void cavityMap() {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int j = 0;
		String[] grid = new String[n];
		int[][] gridArr = new int[n][n];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			grid[grid_i] = in.next();
			for (int i = 0; i < n; i++) {
				String parts = grid[grid_i].substring(i, i + 1);
				gridArr[j][i] = Integer.parseInt(parts);
				// System.out.println("Parts are"+parts);
			}
			j++;
		}

		for (int i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (i != 0 && i != n - 1 && j != 0 && j != n - 1) {
					if (gridArr[i][j] > gridArr[i + 1][j] && gridArr[i][j] > gridArr[i - 1][j]
							&& gridArr[i][j] > gridArr[i][j + 1] && gridArr[i][j] > gridArr[i][j - 1])
						gridArr[i][j] = 111;
				}
			}
			// System.out.println();
		}

		String[][] outputStr = new String[n][n];
		int aa = outputStr.length;

		for (int i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				outputStr[i][j] = Integer.toString(gridArr[i][j]);
				// System.out.print(gridArr[i][j]+" ");
				if (gridArr[i][j] == 111)
					outputStr[i][j] = "X";
			}
			// System.out.println();
		}

		for (int i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(outputStr[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Write a program which prints the time in words for the input given in the
	 * format mentioned above.
	 *
	 * @param hh
	 *            Represents the hours
	 * @param mm
	 *            Represents the minutes
	 * @return Time in a human readable string
	 */

	public static String getTime(int hh, int mm) {

		String[] lowDigits = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		// 678
		String output = "";
		if (mm == 15 || mm == 30 || mm == 45 || mm == 00) {
			switch (mm) {
			case 15:
				output += "quarter past " + lowDigits[hh];
				break;
			case 30:
				output += "half past " + lowDigits[hh];
				break;
			case 45:
				output += "quarter to " + lowDigits[hh + 1];
				break;
			case 00:
				output += lowDigits[hh] += " o' clock";
				break;
			default:
				output += "ERROR";
				break;
			}
		} else if (mm < 20) {
			int rmn = mm % 10;
			if (mm == 1)
				output += lowDigits[mm] + " minute past " + lowDigits[hh];
			else
				output += lowDigits[mm] + " minutes past " + lowDigits[hh];
		} else if (mm < 30 && mm > 20) {
			int div = mm / 10;
			if (div > 0)
				output += tens[div] + " ";
			int rmn = mm % 10;
			output += lowDigits[rmn];
			output += " minutes past " + lowDigits[hh];
		} else if (mm > 30 && mm < 60) {
			mm = 60 - mm;
			if (mm < 20) {
				int rmn = mm % 10;
				output += lowDigits[mm];
				output += " minutes to " + lowDigits[hh + 1];
				return output;
			}
			int div = mm / 10;
			if (div > 0)
				output += tens[div] + " ";
			int rmn = mm % 10;
			output += lowDigits[rmn];
			output += " minutes to " + lowDigits[hh + 1];
		}
		// System.out.println("Ouput is "+output);
		return output;
	}

	/**
	 * Converts the given number to its readable English text in the range of
	 * 1-1000.
	 *
	 * @param num
	 */
	private static String convertNumberToWord(int num) {
		String[] lowDigits = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", " nine", " ten",
				" eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen",
				" nineteen" };
		String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		// 678
		String output = "";
		if (num > 100 && num < 1000) {
			int div = num / 100;
			output = lowDigits[div] + " hundred ";
			int rem = num % (div * 100);
			int mo = rem / 10;
			if (mo > 0)
				output += tens[mo] + " ";

			int ld = rem % 10;
			output += lowDigits[ld];
			System.out.println(output);
		} else if (num < 100 && num > 0) {
			int div = num / 10;
			if (div > 1)
				output += tens[div] + " ";
			int rmn = num % 20;
			output += lowDigits[rmn] + " ";
			System.out.println("Output is " + output);
		} else if (num == 100 || num == 0) {
			switch (num) {
			case 100:
				output += "one hundred";
				break;
			case 0:
				output += "zero";
				break;
			default:
				output += "none";
				break;
			}
		}
		System.out.println("Output is " + output);
		return output;
	}

	/**
	 * Sort the array using counting sort algorithm. <br>
	 * Time complexity - O(n + k)
	 *
	 * @param arr Array to be sorted
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int[] countingSort(int[] arr) {
		int max = 7;
		int size = arr.length;
		// Create an empty array to store indexes count
		int[] indexesCount = new int[max + 1];
		for (int i : indexesCount) {
			indexesCount[i] = 0;
		}

		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
			++indexesCount[arr[j]];
		}

		// int[] sumCount = new int[max + 1];
		for (int k = 1; k < max + 1; k++) {
			// sumCount[k] = indexesCount[k] + sumCount[k - 1];
			indexesCount[k] += indexesCount[k - 1];
		}

		int[] outArr = new int[size];
		for (int l = 0; l < arr.length; l++) {
			System.out.print("--->Index is = " + indexesCount[arr[l]]);
			outArr[indexesCount[arr[l]] - 1] = arr[l];
			indexesCount[arr[l]]--;
		}
		int var = 4;
		System.out.println("Variable value is = " + Integer.toString(var));
		for (int m : outArr) {
			System.out.println(m);
		}

		return outArr;
	}
	
}
