/*
347. Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            if(freqMap.get(num) == null) {
                freqMap.put(num, 1);
            } else {
                freqMap.put(num, freqMap.get(num) + 1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> ent1, Map.Entry<Integer,Integer> ent2) {
                return ent1.getValue() - ent2.getValue();
            }
        });
        int count = 0;
        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()) {
            if(count < k) {
                pq.offer(entry);
            }else {
                if(entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }
            }
            count++;
        }
        while(!pq.isEmpty()) {
            result.add(pq.peek().getKey());
            pq.poll();
        }
        return result;
    }
}