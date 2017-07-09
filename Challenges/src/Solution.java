import java.io.*;
import java.math.BigInteger;
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
	private static int getOddOccurringElement(int[] arr) {
		int result = 0;
		// int res[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			// int num = arr[i];
			result ^= arr[i];
			// res[i] = result;
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
		Set<String> palindromeOutputs = new HashSet<String>();
		int len = str.length();
		int i = 0;
		char[] charArr = new char[str.length()];
		charArr = str.toCharArray();
		for (i = 0; i < len; i++) {
			// Check with keeping current char at center
			if (i > 0)
				palindromeOutputs.addAll(centerCombinations(str, i));
			if (i < (len - 1))
				palindromeOutputs.addAll(rightCombinations(str, i));
		}

		for (char c : charArr) {
			palindromeOutputs.add(Character.toString(c));
		}

		return palindromeOutputs.size();
	}

	public static List<String> centerCombinations(String string, int center) {
		List<String> result = new ArrayList<>();

		while (((center - 1) >= 0) && ((center + 1) < string.length())
				&& (string.charAt(center - 1) == string.charAt(center + 1))) {
			result.add(string.substring(center - 1, center + 2));
			center++;
		}
		return result;
	}

	public static List<String> rightCombinations(String string, int right) {
		List<String> result = new ArrayList<>();

		while (((right + 1) < string.length()) && (string.charAt(right) == string.charAt(right + 1))) {
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
	 * @param arr
	 *            Array to be sorted
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

	/**
	 * Gaming array challenge on HackerRank.
	 *
	 * @param arr
	 *            Initial gaming array
	 * @return False, if Andy wins the game <br>
	 *         True, if Bob wins the game
	 */
	@SuppressWarnings("unused")
	private static boolean gamingArray(Integer[] arr) {
		int maxSoFar = 0;
		int maxChange = 0;

		for (int k = 0; k < arr.length; k++) {
			if (arr[k] > maxSoFar) {
				maxSoFar = arr[k];
				// Count how many times the max has changed
				maxChange++;
			}
		}
		// System.out.println("Max changed thus far " + maxChange);
		return ((maxChange % 2 == 0) ? false : true);
	}

	/**
	 * 2 <br>
	 * 8 <br>
	 * 5 1 2 3 7 8 6 4 <br>
	 * 8 <br>
	 * 1 2 5 3 7 8 6 4 <br>
	 *
	 * There are people queued up, and each person wears a sticker indicating
	 * their initial position in the queue (i.e.: 1,2, .. n-1, n with the first
	 * number denoting the frontmost position).
	 *
	 * Any person in the queue can bribe the person directly in front of them to
	 * swap positions. If two people swap positions, they still wear the same
	 * sticker denoting their original place in line. One person can bribe at
	 * most two other persons.
	 *
	 * Fascinated by this chaotic queue, you decide you must know the minimum
	 * number of bribes that took place to get the queue into its current state!
	 *
	 * @param arr
	 *            Person queue
	 * @return
	 */

	private static int calcBribeCount(Integer[] arr) {
		int bribeCount = 0;
		int n = arr.length;
		int currentVal = n;

		while (currentVal != 1) {
			int j = currentVal - 1;
			// Find index of current value
			while (arr[j] != currentVal && (j >= 0)) {
				j--;
			}
			int cvIndex = j;
			int cvBribe = 0;
			// If current person out of place
			while (cvIndex != (currentVal - 1)) {
				// swap (arr[cvIndex], arr[cvIndex+1]);
				int temp;
				temp = arr[cvIndex];
				arr[cvIndex] = arr[cvIndex + 1];
				arr[cvIndex + 1] = temp;

				cvBribe++;
				cvIndex++;
				// One person can bribe at most two other persons.
				if (cvBribe > 2)
					return -1; // Too chaotic
			}
			currentVal--;
			bribeCount += cvBribe;
		}
		return bribeCount;
	}

	/**
	 * A binary gap within a positive integer N is any maximal sequence of
	 * consecutive zeros that is surrounded by ones at both ends in the binary
	 * representation of N. <br>
	 *
	 * For example, number 9 has binary representation 1001 and contains a
	 * binary gap of length 2. <br>
	 *
	 * Write a function returns the length of its longest binary gap. The
	 * function should return 0 if N doesn't contain a binary gap. <br>
	 *
	 * For example, given N = 1041 the function should return 5, <br>
	 * because N has binary representation 10000010001 and so its longest binary
	 * gap is of length 5. <br>
	 *
	 * <br>
	 * Sample test cases: <br>
	 * 328, 16, 1024, 6, 20, 51712, 561892, 5, 7, 9 <br>
	 * <br>
	 * Assume that: <br>
	 *
	 * N is an integer within the range [1..2,147,483,647]. <br>
	 * <br>
	 * Complexity: <br>
	 *
	 * expected worst-case time complexity is O(log(N)). <br>
	 * expected worst-case space complexity is O(1). <br>
	 *
	 * @param num
	 *            Input decimal number
	 * @return length of the longest binary gap
	 */
	@SuppressWarnings("unused")
	private static int binaryGap(int N) {

		String binRep = Integer.toBinaryString(N);
		int prevIndex, nextIndex, maxCount;
		int count = maxCount = prevIndex = nextIndex = 0;
		if (binRep.indexOf("0") != -1) {
			while (true) {
				// Find the next occurrence of "1" to calculate end point of
				// binary gap
				nextIndex = binRep.indexOf("1", prevIndex + 1);
				if (nextIndex != -1) {
					count = nextIndex - prevIndex;
					if (count > maxCount)
						maxCount = count;
				} else
					break;
				prevIndex = nextIndex;
			}
		}
		return ((maxCount != 0) ? --maxCount : maxCount);
	}

	// Extra Long Factorials
	public static BigInteger factorial(int n) {
		BigInteger inp = BigInteger.valueOf(n);
		if (inp.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		// BigInteger one = new BigInteger("1");
		BigInteger prev = inp.subtract(BigInteger.ONE);
		return inp.multiply(factorial((prev.intValue())));
	}

	/**
	 * Returns the minimum number of delete operations required to have all the
	 * array's elements same.
	 *
	 * @param arr
	 *            Input array
	 * @return The number of deletions required
	 */
	private static int equalizeArray(int[] arr) {

		TreeMap<Integer, Integer> freqMap = new TreeMap<Integer, Integer>();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		List<Integer> arrList = new ArrayList<Integer>();
		Integer[] aa = new Integer[arrList.size()];
		Arrays.sort(arrList.toArray(aa));
		int maxCount = 0;
		int arrSize = arr.length;
		for (int i = 0; i < arrSize; i++) {
			int count = 0;
			if (freqMap.containsKey(arr[i]))
				count = freqMap.get(arr[i]);
			freqMap.put(arr[i], ++count);
			if (maxCount < count)
				maxCount = count;
		}
		// In order to equalize an array we would have to delete all the
		// elements except the highest occurring elements of the array
		int maxDel = arrSize - maxCount;
		return maxDel;
	}

	/**
	 * Function to calculate the run length encoded string for the given string.
	 *
	 * @param input
	 *            Input string
	 * @return Run length encoded string
	 */
	private static String runLengthEncoding(String str) {

		char first = str.charAt(0);
		StringBuffer sb = new StringBuffer();
		// System.out.println("Input String = " + str);
		int counter = 1;
		if (str.length() < 2) {
			sb.append(first);
			sb.append(counter);
			return sb.toString();
		}
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == first)
				++counter;
			else {
				sb.append(str.charAt(i - 1));
				sb.append(counter);
				first = str.charAt(i);
				counter = 1;
			}
		}
		sb.append(str.charAt(str.length() - 1));
		sb.append(counter);

		return sb.toString();
	}

	/**
	 * Returns a string lexicographically bigger than input string.
	 *
	 * @param str
	 *            Input string
	 * @return Lexicographically higher string
	 */
	private static String findNextHighestPerm(String str) {
		// Consider input = d, k, h, c ==>> 4, 11, 8, 3
		char[] strChars = str.toCharArray();
		int end = strChars.length - 1;
		// Iterate the longest increasing suffix from the end
		// i.e. 11<--8<--3
		// Get the index of smallest character after the sequence such that
		// char[smallest] < char[smallest + 1]
		// i.e. 4 < 11
		while ((end > 0) && (strChars[end] <= strChars[end - 1])) {
			end--;
		}
		// If string is already in descending order then return
		if (end <= 0)
			return "no answer";

		// pivot becomes index of second smallest character i.e d or 4
		int pivot = end - 1;
		int i = str.length() - 1;
		// d, k, h, c
		// Find the second highest character after pivot
		while (str.charAt(i) <= str.charAt(pivot)) {
			i--;
		}

		// Swap pivot with the next highest element than it from the end i.e. 4
		// <--> 8
		// 4, 11, 8, 3 --> d, k, h, c
		char temp = strChars[pivot];
		strChars[pivot] = strChars[i];
		strChars[i] = temp;
		// 8, 11, 4, 3 --> h, k, d, c

		// Sort the characters after pivot(0) --> k, d, c in ascending order
		// Reverse the suffix sequence
		i = str.length() - 1;
		while (end < i) {
			temp = strChars[end];
			strChars[end] = strChars[i];
			strChars[i] = temp;
			end++;
			i--;
		}
		// output string ==>> h, c, d, k
		return new String(strChars);
	}

	/**
	 * Reverses the words in the given string and capitalize first letter of
	 * each word. <br>
	 * For ex. "Hello World" --> "OlleH DlroW"
	 *
	 * @param string
	 *            Input sequence of words
	 * @return String with reversed words
	 */
	private static String reverseWordsInText(String string) {
		String[] splits = string.split(" ");
		StringBuffer sb = new StringBuffer();
		// Preserve the order of input words
		for (String string2 : splits) {
			// Capitalize first letter of reversed string ==> OlleH
			sb.append((reverseString(string2).substring(0, 1).toUpperCase()));
			// Append the remaining characters keeping the order(lower/upper) of
			// letters as is ==> lleH
			sb.append(reverseString(string2).substring(1));
			sb.append(" ");
		}

		// If we want to reverse the order of words as well in the output string
		// for (int s=splits.length-1 ; s>=0; s--) {
		// sb.append(reverseString(splits[s]));
		// sb.append(" ");
		// }
		return sb.toString();
	}

	/**
	 * Reverse the given string in O(n) time.
	 *
	 * @param str
	 *            Input string
	 * @return Reversed string
	 */
	private static String reverseString(String str) {

		char[] strChars = str.toCharArray();
		int l = 0;
		int r = strChars.length - 1;

		while (l < r) {
			// swap (strChars[l], strChars[r]);
			char temp = strChars[l];
			strChars[l] = strChars[r];
			strChars[r] = temp;
			l++;
			r--;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(strChars);
		return sb.toString();
	}

	/**
	 * Sherlock and the valid string<br>
	 * <b>INCOMPLETE SOLUTION <br>
	 * Failed 4 test cases out of 15 on Hackerrank</b> <blockquote>Failing for
	 * test case "aabcd" ==> should return "NO" instead of "YES"</blockquote>
	 *
	 * @param s
	 *            Input string
	 * @return "YES" or "NO"
	 */
	private static String isValid(String s) {

		String sToLower = s.toLowerCase();
		char[] letters = sToLower.toCharArray();
		int[] count = new int[124];
		for (int i : count) {
			count[i] = 0;
		}

		for (char l : letters) {
			int ascii = l;
			++count[ascii];
		}

		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 97; i < 123; i++) {
			if (count[i] != 0) {
				numbers.add(count[i]);
			}
		}

		Set<Integer> uniqKeys = new TreeSet<Integer>(numbers);
		Integer[] intArr = new Integer[uniqKeys.size()];
		if (uniqKeys.size() == 2) {
			intArr = uniqKeys.toArray(intArr);
			int diff = Math.abs(intArr[0] - intArr[1]);
			if (diff > 1)
				return "NO";
		}

		return (uniqKeys.size() > 2) ? "NO" : "YES";
	}

	/**
	 * Check whether given parenthesis expression is balanced or not.
	 *
	 * @param exp
	 *            Input expression string
	 * @return "YES", if it is balanced <br>
	 *         "NO", if it is not
	 */
	private static String parenthesisChecker(String exp) {
		StringBuilder sb = new StringBuilder();
		sb.append(exp);
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < sb.length(); i++) {
			Character c = sb.charAt(i);
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			}

			else if (c == '}' || c == ')' || c == ']') {
				if (stack.isEmpty()) {
					return "NO";
				} else if (!matchOpeningPair(c, stack.pop())) {
					return "NO";
				} else
					continue;
			}
		}
		if (stack.isEmpty())
			return "YES";
		return "NO";
	}

	private static boolean matchOpeningPair(Character c, Character peek) {

		if (c == '}' && peek == '{') {
			return true;
		} else if (c == ')' && peek == '(') {
			return true;
		} else if (c == ']' && peek == '[') {
			return true;
		} else
			return false;
	}

	/**
	 * Get the maximum element from the stack. <br>
	 * Hackerrank Problem: <br>
	 * 3 choices -- <br>
	 * 1. Push element <br>
	 * 2. Pop element <br>
	 * 3. Print max element of stack at that point
	 *
	 */
	public static void stackMaxElement() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> maxStack = new Stack<Integer>();

		while (n > 0) {
			int choice = sc.nextInt();
			if (choice == 1) {
				Integer val = sc.nextInt();
				if (val >= getStackMax(maxStack))
					maxStack.push(val);
				stack.push(val);
			} else if (choice == 2) {
				Integer value = stack.pop();
				if (value == getStackMax(maxStack))
					maxStack.pop();
			} else if (choice == 3) {
				if (!maxStack.isEmpty()) {
					System.out.println(getStackMax(maxStack));
				}
			}
			n--;
		}
		sc.close();
	}

	private static Integer getStackMax(Stack<Integer> s) {
		if (s.isEmpty())
			return Integer.MIN_VALUE;
		return s.peek();
	}

	/**
	 * <b>Calculate no of operations required to make two strings anagrams.</b>
	 * <br>
	 * Split the given string in half, compare two halves (S1, S2) <br>
	 * <br>
	 * For ex. abcb == ab + cb <br>
	 * changes required = 1 (replace a from S1 with c) <br>
	 * <br>
	 * xaxbbbxx == "xaxb" + "bbxx". <br>
	 * changes required = 1 (Replace 'a' from S1 with 'b' so that S1 = "xbxb"
	 * <br>
	 * and we can rearrange its letter to "bbxx" in order to get S2.)
	 *
	 * @param s
	 * @return
	 */
	public static int anagram(String s) {
		// Remove the matching characters from both strings.
		// Distinct(remaining) characters from first string will be the answer
		// (i.e. no of changes required).
		int count = 0;
		if (s.length() % 2 != 0) { // If the string is of odd length then it's
									// not anagram ==> aba
			return -1;
		}
		int half = s.length() / 2;

		// "aaabbb" == "aaa" + "bbb"
		String S1 = s.substring(0, half);
		String S2 = s.substring(half, s.length());
		int[] charCount = new int[26];
		// Increment the index of character count
		// "aaa" --> charCount[96] = 3
		for (char c : S1.toCharArray())
			++charCount[c - 'a'];
		// Decrement the character count index only when it's already present
		// i.e. greater than 0
		// "bbb" --> charCount[97] = 0
		for (char c : S2.toCharArray())
			// Decrement only when character has appeared before
			charCount[c - 'a'] = (charCount[c - 'a'] > 0) ? charCount[c - 'a'] - 1 : 0;
		// Count the charCount array == 3 + 0 = 3
		for (int i : charCount)
			count += i;
		return count; // 3
	}

	/**
	 * Left rotate the given array for k no of times
	 *
	 * @param a
	 *            Input array
	 * @param n
	 *            Length of array
	 * @param k
	 *            Rotate count
	 * @return Rotated array
	 */
	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		// Iterate for k no of rotations
		for (int i = 0; i < k; i++) {
			int ii = 0;
			// Store first element of array before rotation
			int temp = a[ii];
			int j = 0;
			// Rotate elements one time except the last element
			while (j < n - 1) {
				a[j] = a[j + 1];
				j++;
			}
			// Replace the last element of array with first
			a[n - 1] = temp;
			ii++;
		}
		return a;
	}

	/**
	 * Check if two string contains anything in them common.
	 *
	 * @param s1
	 *            String 1
	 * @param s2
	 *            String 2
	 * @return "YES", if there's any character common in them <br>
	 *         "NO", if there's nothing common in two strings
	 */
	@SuppressWarnings("unused")
	private static String twoStrings(String s1, String s2) {

		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();
		int[] indexes = new int[127];
		for (int j : indexes)
			j = 0;
		for (int i = 0; i < s1Arr.length; i++)
			indexes[s1Arr[i]]++;

		for (int j = 0; j < s2Arr.length; j++) {
			if (indexes[s2Arr[j]] > 0)
				indexes[s2Arr[j]] = indexes[s2Arr[j]] - 2;
		}

		for (int k = 0; k < indexes.length; k++) {
			if (indexes[k] < 0)
				return "YES";
		}

		return "NO";
	}

	/**
	 * Check if the given number is prime or not in O(N ^ 1/2) time. <b> The
	 * algorithm determines whether or not a single number, n, is prime or not.
	 * Each time the algorithm is run, its runtime is <i>with respect to n.</i>
	 * <b>
	 *
	 * @param n
	 *            Input number
	 * @return true, if given no is prime
	 */
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Find out the no of deletions required to make two strings anagrams
	 *
	 * @param s1
	 * @param s2
	 * @return No of deletions required
	 */
	static int makingAnagrams(String s1, String s2) {
		int charCount[] = new int[26];
		for (int i = 0; i < s1.length(); i++)
			charCount[s1.charAt(i) - 97]++; // charCount[s1.charAt(i) - 'a']++
		// (since letters are all lower cases)
		// To store the count of letter a means subtract 97
		// from character and
		// add one to it's array values
		for (int i = 0; i < s2.length(); i++)
			charCount[s2.charAt(i) - 97]--;
		int count = 0;
		for (int i = 0; i < 26; i++)
			count += Math.abs(charCount[i]);
		return count;
	}

	/**
	 * Given a string, find the length of the longest substring without
	 * repeating characters.
	 *
	 * @param s
	 *            Input string
	 * @return Length of substring
	 */
	public static int lengthOfLongestSubstring(String s) {
		int ins = 0, del = 0, max = 0;
		Set<Character> set = new HashSet<>();
		while (ins < s.length()) {
			// If char not present in the set
			if (!set.contains(s.charAt(ins))) {
				// Add the char and increment the insert pointer
				set.add(s.charAt(ins++));
				max = Math.max(max, set.size());
			} else {
				// Remove the char from start in the set and
				// increment the deletion pointer
				set.remove(s.charAt(del++));
			}
		}
		return max;
	}

	/**
	 * Find the longest palindromic substring in s. <br>
	 * Explanation:
	 * https://discuss.leetcode.com/topic/21848/ac-relatively-short-and-very-clear-java-solution
	 * <br>
	 * Editorial:
	 * <b>https://leetcode.com/articles/longest-palindromic-substring/#approach-4-expand-around-center-accepted</b>
	 * 
	 * @param s
	 *            Input string
	 * @return Longest palindromic substring
	 */
	public static String longestPalindrome(String s) {
		String res = "";
		int currLength = 0;
		for (int i = 0; i < s.length(); i++) {
			// Expand with keeping char as center (odd length substring)
			if (isPalindrome(s, i - currLength - 1, i)) {
				res = s.substring(i - currLength - 1, i + 1);
				currLength = currLength + 2;
			} else if (isPalindrome(s, i - currLength, i)) {
				// right combinations (even length substring)
				res = s.substring(i - currLength, i + 1);
				currLength = currLength + 1;
			}
		}
		return res;

		/// Alternative solution [Editorial]
		// int start = 0, end = 0;
		// for (int i = 0; i < s.length(); i++) {
		// int len1 = expandAroundCenter(s, i, i);
		// int len2 = expandAroundCenter(s, i, i + 1);
		// int len = Math.max(len1, len2);
		// if (len > end - start) {
		// start = i - (len - 1) / 2;
		// end = i + len / 2;
		// }
		// }
		// return s.substring(start, end + 1);
	}

	public static boolean isPalindrome(String s, int begin, int end) {
		if (begin < 0)
			return false;
		while (begin < end) {
			if (s.charAt(begin++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	/**
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * <blockquote> Time Complexity = O(n), Space Complexity = O(1)
	 * </blockquote>
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1])
				nums[j++] = nums[i];
		}
		return j;
	}

	/**
	 * Search an element in a sorted rotated array.
	 * 
	 * @param nums
	 *            Array
	 * @param target
	 *            Search key
	 * @return index of the given key
	 */
	public static int search(int[] nums, int target) {
		return searchUtil(nums, 0, nums.length - 1, target);
	}

	public static int searchUtil(int[] a, int lo, int hi, int key) {
		if (lo > hi)
			return -1;
		int mid = (lo + hi) / 2;
		if (a[mid] == key)
			return mid;

		if (a[lo] <= a[mid]) {
			if ((key <= a[mid]) && (key >= a[lo]))
				return searchUtil(a, lo, mid - 1, key);
			else
				return searchUtil(a, mid + 1, hi, key);
		}

		if ((key >= a[mid]) && (key <= a[hi]))
			return searchUtil(a, mid + 1, hi, key);
		return searchUtil(a, lo, mid - 1, key);
	}

	/**
	 * Find minimum in rotated sorted array
	 * 
	 * @param nums
	 *            Input array
	 * @return Minimum key value
	 */
	public int findMin(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			// [1, 2, 3, 4, 5]
			if (nums[start] < nums[end])
				return nums[start];

			int mid = (start + end) / 2;
			// [4, 5, 6, 7, 1, 2, 3]
			if (nums[mid] > nums[end])
				start = mid + 1;
			else
				// [4, 5, 1, 2, 3]
				end = mid;
		}
		return nums[start];
	}

	/**
	 * Given an integer n, generate the nth term of the count-and-say sequence.
	 * The count-and-say sequence is the sequence of integers with the first
	 * five terms as following:<br>
	 * <b> 1. 1 <br>
	 * </b> <code> 1 is read off as "one 1" or 11. </code> <br>
	 * <b> 2. 11 <br>
	 * </b> <code> 11 is read off as "two 1s" or 21. </code> <br>
	 * <b> 3. 21 <br>
	 * </b> <code> 21 is read off as "one 2, then one 1" or 1211. </code> <br>
	 * <b> 4. 1211 <br>
	 * </b>
	 * <code> 1211 is read off as "one 1, one 2, then two 1" or 111221. </code>
	 * <br>
	 * <b> 5. 111221 </b> <br>
	 * 
	 * @param n
	 * @return Nth count-and-say sequence string
	 */
	public static String countAndSay(int n) {
		String s = "1";
		if (n == 1)
			return "1";
		StringBuilder res = new StringBuilder();
		char prev = '1';
		int count = 0;
		for (int i = 1; i < n; i++) {
			count = 0;
			res.setLength(0);
			for (int jj = 0; jj < s.length(); jj++) {
				if (s.charAt(jj) == prev)
					count++;
				else {
					if (count == 0) {
						prev = s.charAt(jj);
						count = 1;
						continue;
					}
					res.append(count).append(prev);
					count = 1;
					prev = s.charAt(jj);
				}
			}
			res.append(count).append(prev);
			// System.out.println(res);
			s = res.toString();
		}
		return s;
	}

	/**
	 * Given an unsorted integer array, find the first missing positive integer.
	 * 
	 * @param nums
	 * @return
	 */
	public static int firstMissingPositive(int[] nums) {
		int i = 0;
		int n = nums.length;
		// 3, 4, -1, 1
		for (i = 0; i < n; ++i) {
			// Iterate until array elements are in their position
			// 1, -1, 3, 4 i.e. 1, 2, 3, 4
			while ((nums[i] <= n) && (nums[i] > 0) && (nums[i] != nums[nums[i] - 1])) {
				swap(nums, i, nums[i] - 1);
			}
		}
		i = 0;
		for (i = 0; i < n; i++) {
			if ((nums[i] != i + 1)) {
				break;
			}
		}
		return i + 1;
	}

	private static void swap(int[] a, int n1, int n2) {
		int temp = a[n1];
		a[n1] = a[n2];
		a[n2] = temp;
	}

	/**
	 * Check if there exists a pair of squares that equals the given number.
	 * <br>
	 * For ex. <br>
	 * num1*num1 + num2*num2 = c <br>
	 * <b>1*1 + 2*2 = 5 </b><br>
	 * 
	 * @param c
	 *            Given number
	 * @return true, if there exists a pair of such squares
	 */
	public boolean judgeSquareSum(int c) {
		double sqrt = Math.sqrt(c);
		int x = (int) sqrt;

		// Check if given number is a perfect square
		if (Math.pow(sqrt, 2) == Math.pow(x, 2)) {
			return true;
		}

		int limit = (int) Math.sqrt(c);
		int[] squares = new int[limit];

		// Calculate squares of all the numbers until squareroot digit
		for (int i = 0; i < limit; i++) {
			squares[i] = (i + 1) * (i + 1);
		}

		for (int i = limit - 1; i >= 0; i--) {
			int target = c - squares[i];
			// Scan and compare if remainder exists in squares array
			int pos = Arrays.binarySearch(squares, 0, i + 1, target);
			if (pos >= 0) {
				return true;
			}
		}
		return false;

		// Alternate solution
		// int i = 0;
		// int j = (int) Math.sqrt(c);
		// while (i <= j) {
		// if ((i * i + j * j) < c)
		// i++;
		// else if ((i * i + j * j) > c)
		// j--;
		// else
		// return true;
		// }
		// return false;

	}

	/**
	 * Find the maximum product of 3 numbers in an array of mixed(+/-) integers.
	 * 
	 * @param nums
	 *            Integer array
	 * @return Max product
	 */
	public static int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		Integer pSum = 1, nSum = 1;
		// All positive numbers
		pSum = nums[len - 1] * nums[len - 2] * nums[len - 3];
		// Positive and/or negative numbers
		nSum = nums[0] * nums[1] * nums[len - 1];
		return Math.max(pSum, nSum);
	}

	/**
	 * Given a column title as appear in an Excel sheet, return its
	 * corresponding column number.
	 * 
	 * For example:
	 * 
	 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
	 * 
	 * @param s
	 * @return
	 */
	public static int titleToNumber(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res *= 26;
			res += (s.charAt(i) - 65) + 1;
		}
		return res;
	}

	/**
	 * Given a positive integer, return its corresponding column title as appear
	 * in an Excel sheet. For example:
	 * 
	 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
	 * 
	 * @param n
	 * @return
	 */
	public static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			n--;
			sb.append((char) (65 + (n % 26)));
			n /= 26;
		}
		return sb.reverse().toString();
	}

	/**
	 * Given an array of n integers where n > 1, nums, return an array output
	 * such that output[i] is equal to the product of all the elements of nums
	 * except nums[i].
	 * 
	 * Solve it without division and in O(n).
	 * 
	 * For example, given [1,2,3,4], return [24,12,8,6].
	 * 
	 * @param nums
	 * @return
	 */
	public static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		int temp = 1;

		// Scan array to right and store results
		for (int i = 0; i < nums.length; i++) {
			res[i] = temp;
			temp *= nums[i];
		}

		temp = 1;
		// Scan array to left and update results
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= temp;
			temp *= nums[i];
		}
		return res;
	}

	/**
	 * Given an array of integers sorted in ascending order, find the starting
	 * and ending position of a given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];

		res[0] = binarySearchFirst(nums, 0, nums.length - 1, target);
		res[1] = binarySearchLast(nums, 0, nums.length - 1, target);
		return res;
	}

	public static int binarySearchFirst(int[] arr, int lo, int hi, int key) {
		if (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			if (arr[mid] == key && (mid == 0 || arr[mid - 1] < key))
				return mid;
			else if (key > arr[mid])
				return binarySearchFirst(arr, mid + 1, hi, key);
			else
				return binarySearchFirst(arr, lo, mid - 1, key);
		}
		return -1;
	}

	public static int binarySearchLast(int[] arr, int lo, int hi, int key) {
		if (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			if (arr[mid] == key && (mid == arr.length - 1 || arr[mid + 1] > key))
				return mid;
			else if (key < arr[mid])
				return binarySearchLast(arr, lo, mid - 1, key);
			else
				return binarySearchLast(arr, mid + 1, hi, key);
		}
		return -1;
	}

	/**
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * 
	 * @param digits
	 * @return
	 */
	public static List<String> letterCombinations(String digits) {
		String[] mappings = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		LinkedList<String> queue = new LinkedList<String>();
		if (digits.length() < 1)
			return queue;

		queue.add("");
		for (int i = 0; i < digits.length(); i++) {
			int num = Character.getNumericValue(digits.charAt(i));
			if (num < 2) {
				queue.clear();
				return queue;
			}

			// Iterate until each char is appended to the last combination
			while (queue.peek().length() == i) {
				// Get the front of the queue
				String temp = queue.poll();

				// Append the chars to front of the queue
				for (char c : mappings[num].toCharArray()) {
					queue.offer(temp + c);
				}
			}
		}
		return queue;
	}

	/**
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous
	 * subarray [4,-1,2,1] has the largest sum = 6.
	 * 
	 * @param nums
	 * @return
	 */
	public static int maxSumSubArray(int[] nums) {
		int maxSoFar = nums[0], maxEndingHere = nums[0];

		for (int i = 1; i < nums.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	/**
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest product.
	 * 
	 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3]
	 * has the largest product = 6.
	 * 
	 * @param nums
	 * @return
	 */
	public static int maxProduct(int[] nums) {
		int prevMax, max = nums[0];
		int currMax = nums[0], currMin = nums[0];

		for (int i = 1; i < nums.length; i++) {
			// carry on previous max product
			prevMax = currMax;
			currMax = Math.max(Math.max(prevMax * nums[i], currMin * nums[i]), nums[i]);

			// product of previous max and current number can be minimum when
			// negative integers are present
			// [-2, 1, -3, 4]
			currMin = Math.min(Math.min(currMin * nums[i], prevMax * nums[i]), nums[i]);
			max = Math.max(max, currMax);
		}
		return max;
	}

	/**
	 * Calculate the sum of two integers a and b, but you are not allowed to use
	 * the operator + and - i.e. w/o arithmetic operators
	 * 
	 * @param a
	 *            Number 1
	 * @param b
	 *            Number 2
	 * @return Sum of both the numbers
	 */
	public static int getSumWOarithmeticOps(int a, int b) {
		while (b != 0) {
			// generate all the carry
			int c = a & b; // 0001 --> TT for AND is
			// 0&0 = 0, 0&1 = 0, 1&0 = 0, 1&1 = 1

			// add all the bits & store the sum in a
			a = a ^ b; // 0110 --> TT for XOR is
			// 0^0 = 0, 0^1 = 1, 1^0 = 1, 1^1 = 0

			// shift the carry one bit to left
			b = c << 1;
		}
		return a;
	}

	/**
	 * The Hamming distance between two integers is the number of positions at
	 * which the corresponding bits are different.
	 * 
	 * Given two integers x and y, calculate the Hamming distance.
	 * 
	 * @param x
	 *            Integer 1
	 * @param y
	 *            Integer 2
	 * @return
	 */
	public static int hammingDistance(int x, int y) {
		int xor = x ^ y; // it will set off all the ones in result
		// count the 1s in the result
		int count = Integer.bitCount(xor);
		// String bin = Integer.toBinaryString(x ^ y);
		return count;
	}

	/**
	 * Given an 2D board, count how many battleships are in it. The battleships
	 * are represented with 'X's, empty slots are represented with '.'s. You may
	 * assume the following rules:
	 * 
	 * <li>You receive a valid board, made of only battleships or empty slots.
	 * 
	 * <li>Battleships can only be placed horizontally or vertically. <br>
	 * In other words, they can only be made of the shape <code><b>1xN (1 row, N
	 * columns)</b> or <b>Nx1 (N rows, 1 column),</b>
	 * where N can be of any size.</code>
	 * <li>At least one horizontal or vertical cell separates between two
	 * battleships - <strong>
	 * <ul>
	 * there are no adjacent battleships.
	 * </ul>
	 * </strong>
	 * 
	 * @param board
	 * @return
	 */
	public static int countBattleships(char[][] board) {

		int rows = board.length;
		int cols = board[0].length;
		int count = 0;
		// iterate over all the cells
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// Search for the head of the battleship
				if (board[i][j] == 'X') {
					// there should not be another ship before the head i.e.
					// nothing should be on the left or up of the head

					if ((i == 0 || board[i - 1][j] != 'X') // up
							&& (j == 0 || board[i][j - 1] != 'X')) // left
						count++;
				}
			}
		}
		return count;
	}

	/**
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
	 * islands. <br>
	 * An island is surrounded by water and is formed by connecting adjacent
	 * lands <b>horizontally or vertically</b>. <br>
	 * You may assume all four edges of the grid are all surrounded by water.
	 * 
	 * <br>
	 * <br>
	 * Example 1: <br>
	 * 11110<br>
	 * 11010<br>
	 * 11000<br>
	 * 00000<br>
	 * Answer: 1
	 * 
	 * @param grid
	 * @return
	 */
	public static int numIslands(char[][] grid) {
		int rows = grid.length;
		if (rows == 0)
			return 0;
		int cols = grid[0].length;
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// Check for island
				if (grid[i][j] == '1') {
					checkIslandsDFS(grid, i, j);
					++count;
				}
			}
		}
		return count;
	}

	// Visit all the connected islands of the given/found island recursively
	public static void checkIslandsDFS(char[][] grid, int i, int j) {
		// if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||
		// grid[i][j] != '1')
		// return;
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
			// Mark the visited neighbor as false/water
			grid[i][j] = '0';
			checkIslandsDFS(grid, i, j + 1); // right
			checkIslandsDFS(grid, i + 1, j); // down
			checkIslandsDFS(grid, i - 1, j); // up
			checkIslandsDFS(grid, i, j - 1); // left
		}
	}

	/**
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index. <br>
	 * For example: A = [2,3,1,1,4], return true. <br>
	 * A = [3,2,1,0,4], return false.
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {
		int currFarthest = 0;
		// Loop through an entire array
		for (int i = 0; i < nums.length; i++) {
			// If current/last location is unreachable from max jump
			// then return false
			// Consider case --> [3,2,1,0,4]
			if (i > currFarthest) {
				return false;
			}
			// Check the max jump from current location
			currFarthest = Math.max(currFarthest, i + nums[i]);
		}
		return true;
	}

	/**
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Your goal is to reach the last index in the minimum number of jumps. <br>
	 * {@code For example: Given array A = [2,3,1,1,4]
	 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
	 * from index 0 to 1, then 3 steps to the last index.)
	 * }
	 * 
	 * <b>Note: You can assume that you can always reach the last index.</b>
	 * 
	 * @param nums
	 * @return
	 */
	public static int jump(int[] nums) {
		int currJump = 0, maxJump = 0, count = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			// check how far can you jump from current position
			currJump = Math.max(currJump, i + nums[i]);

			// once you have reached the farthest point
			// initiate the jump count
			if (i == maxJump) {
				count++; // make another jump
				maxJump = currJump;
			}
		}
		return count;
	}

	/**
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible <b>unique</b> permutations.
	 * 
	 * <br>
	 * For example, <b>[1,1,2]</b> have the following unique permutations: <br>
	 * <b>[ [1,1,2],<br>
	 * [1,2,1], <br>
	 * [2,1,1] ]</b>
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = permuteDFS(nums, new HashSet<List<Integer>>(), 0, nums.length - 1);
		res.addAll(set);
		return res;
	}

	private static Set<List<Integer>> permuteDFS(int[] arr, Set<List<Integer>> tempSet, int begin, int end) {
		if (begin >= end) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i : arr) {
				list.add(i);
			}
			tempSet.add(list);
		}

		for (int i = begin; i <= end; i++) {
			swap(arr, begin, i);
			permuteDFS(arr, tempSet, begin + 1, end);
			swap(arr, begin, i);
		}
		return tempSet;
	}

}
