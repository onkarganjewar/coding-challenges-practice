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

}
