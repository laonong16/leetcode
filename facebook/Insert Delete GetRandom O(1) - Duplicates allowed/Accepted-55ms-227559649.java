// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Insert Delete GetRandom O(1) - Duplicates allowed
// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
// 

class NumberAndIndex {
    public int number, index;
    public NumberAndIndex(int number, int index) {
        this.number = number;
        this.index = index;
    }
}
class RandomizedCollection {
// pair.number is the number, pair.index is the index in map value
    private List<NumberAndIndex> nums;
    // key is the number, value if the indices list in nums;
    private Map<Integer, List<Integer>> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean existed = map.containsKey(val);
        
        if (!existed) {
            map.put(val, new ArrayList<Integer>());
        }
        List<Integer> indices = map.get(val);
        indices.add(nums.size());
        nums.add(new NumberAndIndex(val, indices.size() - 1));

        return !existed;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
    
        List<Integer> indices = map.get(val);
        int index = indices.get(indices.size() - 1);
        
        NumberAndIndex numIndex = nums.get(nums.size() - 1);
        nums.set(index, numIndex);
        nums.remove(nums.size() - 1);
        map.get(numIndex.number).set(numIndex.index, index);
        
        indices.remove(indices.size() - 1);
        if (indices.size() == 0) {
            map.remove(val);
        }
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = rand.nextInt(nums.size());
        return nums.get(index).number;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
