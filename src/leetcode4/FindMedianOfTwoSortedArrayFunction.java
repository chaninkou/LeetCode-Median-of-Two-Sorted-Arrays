package leetcode4;

public class FindMedianOfTwoSortedArrayFunction {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int a = nums1.length;
		int b = nums2.length;

		int low = 0;
		int high = a;

		while (low <= high) {
			int partitionA = (low + high) / 2;
			int partitionB = (a + b + 1) / 2 - partitionA;

			int maxLeftA = 0;
			int minRightA = 0;

			if (partitionA == 0) {
				maxLeftA = Integer.MIN_VALUE;
			} else {
				maxLeftA = nums1[partitionA - 1];
			}

			if (partitionA == a) {
				minRightA = Integer.MAX_VALUE;
			} else {
				minRightA = nums1[partitionA];
			}

			int maxLeftB = 0;
			int minRightB = 0;

			if (partitionB == 0) {
				maxLeftB = Integer.MIN_VALUE;
			} else {
				maxLeftB = nums2[partitionB - 1];
			}

			if (partitionB == b) {
				minRightB = Integer.MAX_VALUE;
			} else {
				minRightB = nums2[partitionB];
			}

			if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
				if ((a + b) % 2 == 0) {
					return ((double) Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
				} else {
					return (double) Math.max(maxLeftA, maxLeftB);
				}
			} else if (maxLeftA > minRightB) {
				high = partitionA - 1;
			} else {
				low = partitionA + 1;
			}

		}

		return 0.0;
	}
}
