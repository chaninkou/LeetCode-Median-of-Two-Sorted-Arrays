package leetcode4;

public class FindMedianOfTwoSortedArrayFunction {
	// time of O(log(m + n))
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// Pretending that nums2 have the longest length
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int a = nums1.length;
		int b = nums2.length;

		int low = 0;
		int high = a;

		while (low <= high) {
			// Base on paritionA, use the below formula to get same length from leftA/leftB and rightA/rightB
			int partitionA = (low + high) / 2;
			int partitionB = (a + b + 1) / 2 - partitionA;
			
			System.out.println("A : " + partitionA + " B: " + partitionB);

			int maxLeftA = 0;
			int minRightA = 0;
			
			// If 0, maxLeftA should be smaller than minRightB
			if (partitionA == 0) {
				maxLeftA = Integer.MIN_VALUE;
			} else {
				maxLeftA = nums1[partitionA - 1];
			}

			// If end of element, minRightA should be bigger than maxLeftB
			if (partitionA == a) {
				minRightA = Integer.MAX_VALUE;
			} else {
				minRightA = nums1[partitionA];
			}
			
			System.out.println("maxLeftA: " + maxLeftA);
			System.out.println("minRightA: " + minRightA);

			int maxLeftB = 0;
			int minRightB = 0;

			// If 0, maxLeftB should be smaller than minRightA
			if (partitionB == 0) {
				maxLeftB = Integer.MIN_VALUE;
			} else {
				maxLeftB = nums2[partitionB - 1];
			}

			// If end of element, minRightB should be bigger than maxLeftA
			if (partitionB == b) {
				minRightB = Integer.MAX_VALUE;
			} else {
				minRightB = nums2[partitionB];
			}
			
			System.out.println("maxLeftB: " + maxLeftB);
			System.out.println("minRightB: " + minRightB);

			// ideal formula
			if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
				// If the total number of both length add up to even, divided the two medians by 2
				if ((a + b) % 2 == 0) {
					return ((double) Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
				} else {
					// if odd, return one median
					return (double) Math.max(maxLeftA, maxLeftB);
				}
			} else if (maxLeftA > minRightB) { // Have to make maxLeft smaller
				high = partitionA - 1;
			} else { // Have to make minRight bigger
				low = partitionA + 1;
			}

		}

		return 0.0;
	}
}
