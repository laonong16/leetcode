/*
88. Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
 class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int ind1 = m -1;
        int ind2 = n -1;
        while(ind1 >= 0 && ind2 >= 0) {
            if(nums1[ind1] >= nums2[ind2]) {
                nums1[index] = nums1[ind1--];
            } else {
                nums1[index] = nums2[ind2--];
            }
            index--;
        }
        while(ind2 >= 0) {
            nums1[index--] = nums2[ind2--];
        }
        
    }
}