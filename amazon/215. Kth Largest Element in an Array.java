/*
215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ? k ? array's length.
*/
class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(k);
//         for(int i = 0; i < nums.length; i++) {
//             if(i < k) {
//                 pq.offer(nums[i]);
//             }
//             else if(pq.peek() < nums[i]) {
//                 pq.poll();
//                 pq.offer(nums[i]);
//             }
//         }
//         return pq.peek();
        
//     }

    
    // quick select
    
 public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return 0;
        k--;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return nums[k];
        }
        return nums[lo];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (i < j) {
            while (nums[++i] > nums[lo]) if (i == hi) break;
            while (nums[--j] < nums[lo]) if (j == lo) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }    
}