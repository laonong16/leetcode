4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len =  nums1.length + nums2.length ;
        if(len % 2 == 0) {
            return (findKth(nums1, 0, nums2,0, len / 2 ) + findKth(nums1,0,nums2,0, len/2+1)) / 2.0;
        } else {
            return findKth(nums1,0, nums2,0, len / 2 +1);
        }
    }
    public int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if(start1 >= nums1.length) {
            return  nums2[start2+ k-1] ;
        }
        if (start2 >= nums2.length) {
            return nums1[start1+ k-1];
        }
        if(k==1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int val1 = Integer.MAX_VALUE;
        if((start1+k/2 -1) < nums1.length) {
            val1 = nums1[start1+k/2 -1];
        }
        int val2 = Integer.MAX_VALUE;
        if((start2+k/2 -1) < nums2.length) {
            val2 = nums2[start2+k/2 -1 ];
        }
        
        if(val1 <= val2) {
            return findKth(nums1, start1+k/2, nums2, start2, k-k/2);
        } else {
            return findKth(nums1, start1, nums2, start2+k/2, k-k/2);
        }
    }
}