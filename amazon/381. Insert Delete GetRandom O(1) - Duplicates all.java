/*
381. Insert Delete GetRandom O(1) - Duplicates allowed

Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
*/

class RandomizedCollection {
    /*
    use two maps. One tracks the index of the element, so that we can quickly insert and remove.
    The other maps tracks the order of each inserted element, so that we can randomly access any element in time O(1).
   */
    Map<Integer,Set<Integer>> valIndMap;
    Map<Integer,Integer> indValMap;
    
  /** Initialize your data structure here. */
    public RandomizedCollection() {
        valIndMap =  new HashMap<>();
        indValMap =  new HashMap<>();
       
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        //add to index=>Val Map
        int size = indValMap.size();
        indValMap.put(size+1, val);
 
        if(valIndMap.containsKey(val)){
            valIndMap.get(val).add(size+1);
            return false;
        }else{
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(size+1);
            valIndMap.put(val, set);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(valIndMap.containsKey(val)){
            Set<Integer> set = valIndMap.get(val);
            int toRemove = set.iterator().next();
 
 
            //remove from set of valIndMap
            set.remove(toRemove);
 
            if(set.size()==0){
                valIndMap.remove(val);
            }
 
            if(toRemove == indValMap.size()){
                indValMap.remove(toRemove);
                return true;
            }
 
            int size2 = indValMap.size();
            int key = indValMap.get(size2);
 
            Set<Integer> setChange = valIndMap.get(key);
            setChange.remove(size2);
            setChange.add(toRemove);
 
 
 
            indValMap.remove(size2);
            indValMap.remove(toRemove);
 
            indValMap.put(toRemove, key);
 
            return true;
        }
 
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
       if(valIndMap.size()==0)
            return -1;
 
         if(indValMap.size()==1){
            return indValMap.get(1);    
        }    
 
        return indValMap.get(new Random().nextInt(indValMap.size())+1); // nextInt() returns a random number in [0, n).
     
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
