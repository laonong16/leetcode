/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/
class Solution {
    /*
     stright foward solution is  using PriorityQueue  it will be  O(nlog k) 
 . 用一个linkedlist保存进入窗口的数的index. 如果3出现, 则1没有可能是最大值. 所以可以移除1. 然后-1出现. 这个时候不能移除3. 因为 3可能是最大值.  也就是说如果后出现的数比先出现的数要大, 则可以删除之前的数. 当list顶部的index超出窗口时,则移除.   这样list中的数应该是降序排列, 分别是 
[最大的数, 第2大的数, 第3大的数, ....]
*/
    public int[] maxSlidingWindow(int[] nums, int k) {
        // A Dequeue (Double ended queue) based method for printing maixmum element of
        // all subarrays of size k
  
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e., 
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
       
       if(k==0) return new int[0];  
          
        LinkedList<Integer> q = new LinkedList<Integer>();  
  
        int[] res = new int[nums.length-k+1];  
          
        for(int i=0; i<nums.length; i++) {  
            while(!q.isEmpty() && nums[i]>=nums[q.getLast()]){  
                q.removeLast();  
            }  
            q.addLast(i);  
              
            if(i-q.getFirst()+1 > k) {  
                q.removeFirst();  
            }  
            if(i+1>=k) res[i-k+1] = nums[q.getFirst()];  
        }  
          
        return res;  
        
    }
}