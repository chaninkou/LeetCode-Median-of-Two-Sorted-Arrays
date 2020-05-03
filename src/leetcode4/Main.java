package leetcode4;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] nums1 = {1,2,9,10,11,12};
		int[] nums2 = {3,4,5,6,7,13,14,15};
		
		System.out.println("num1: " +  Arrays.toString(nums1));
		System.out.println("num2: " +  Arrays.toString(nums2));
		
		FindMedianOfTwoSortedArrayFunction solution = new FindMedianOfTwoSortedArrayFunction();
		
		System.out.println("Solution: " + solution.findMedianSortedArrays(nums1, nums2));
	}
}
