/*
287. Find the Duplicate Number
iven an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/
class Solution {
    /*
    方法一：二分
        我们知道，这总共n + 1 个数每个数x都满足  1 <= x <= n
        所以，我们二分答案为   mid = (L+R )/2 其中 L=1  R= n
        然后扫描整个数组进行统计 ，设cnt为满足不大于mid的元素个数，则有：cnt <= mid  则说明重复的应该在 [mid , R] ，否则，应该在[L,mid]
        总的时间复杂度为O(nlogn)
    */
    public int findDuplicate(int[] nums) {
         int start = 1, end = nums.length -1;
        
        while(start < end) {
            int mid = start + (end - start) /2;
            int count = 0;
             for(int num: nums){
                if(num<=mid){
                    count++;
                }
             }
            if(count>mid){
                end=mid;
            }else{
                start=mid+1;
            }
        }
      return end;
      
    }
    /*
    方法二： 双指针
        如果数组中元素不重复，那么,任意下标i和数组中该下标的值一一对应，如 对于数组 3,4,1,2，有如下对应关系：（注意，值从1~n）
        0 – > 2
        1  -> 4
        2  -> 1
        3  -> 3
        设这个对应关系的运算函数为f(n) ，那么，我们从下标0出发，每次根据f取出下标i对应的值x，并将这个x作为下一次的下标，直到下标越界。
        如3，4，1，2这个数组，那么有 0 – > 2-> 1-> 4
        但如果有重复的话，中间就会产生多个映射，如3,4,1,2,3
        0 – > 2
        1  -> 4
        2  -> 1
        3  -> 3
        4  ->3
        继续这么做的话，会发生 0 – > 2-> 1-> 4  -> 3 -> 3->3……
        也就是最后一定是那个重复的元素。
    */
     public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int find = 0;

        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
     }
}