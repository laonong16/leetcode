// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Kth Largest Element in a Stream
// https://leetcode.com/problems/kth-largest-element-in-a-stream/
// 

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    int[] nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        pq  = new PriorityQueue<>(k);
        initPQ();
    }
    
    public int add(int val) {
        if(pq.isEmpty() || pq.size() < k) {
            pq.offer(val);
            return pq.peek();
        }
       if (pq.peek() > val) {
           return pq.peek();
       } else {
           pq.poll();
           pq.offer(val);
           return pq.peek();
       } 
    }
    public void initPQ() {
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.offer(nums[i]);
            } else {
                if(nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

