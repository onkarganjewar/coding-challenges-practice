import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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

}
