/*
380. Insert Delete GetRandom O(1)
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();

*/

class RandomizedSet {

    //use a list to store the value;
    //use map to store the value  and  index pair
    
    /** Initialize your data structure here. */
    private Map<Integer, Integer> map ;
    private List<Integer> data ;
    
    public RandomizedSet() {
        map = new HashMap<>();
        data = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    // check if the  map contains the value  if it is return false  else  add to list and put to map 
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        data.add(val);
        map.put(val, data.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    /*find if it is in the map  
      if not  return false;
      else  find the index from map,
            remove it from map
            put the last element from  list to the index position
            update the last element  index value in the map
    */public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        //remove val from map  and  get index of val
        int index = map.remove(val);
        // get the last value from  list and get the value
        int last = data.remove(data.size() - 1);
        if (last != val) {
            // move lastVal to  thie indexval in list
            data.set(index, last);
            //set the map
            map.put(last, index);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index =  new Random().nextInt(data.size());
        return data.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */