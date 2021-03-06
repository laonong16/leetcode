// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Smallest Range
// https://leetcode.com/problems/smallest-range/
// 

class Solution {
    /*
    pq内每次poll出当前最小值，max保存当前已访问的最大值，当前pq中的所有值一定在这个区间内（满足该区间覆盖所有数组条件），只要看这个区间是否为更小的那个区间即可
    */
    public int[] smallestRange(List<List<Integer>> nums) {
    int start = -1;
        int end = -1;
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        PriorityQueue<Element> queue = new PriorityQueue(new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                return e1.val - e2.val;
            }
        });
        for (int i = 0; i < nums.size(); i++) {
            Element e = new Element(nums.get(i).get(0), 0, i);
            queue.offer(e);
            max = Math.max(max, e.val);
        }
        while (queue.size() == nums.size()) {
            Element e = queue.poll();
            if (max - e.val < range) {
                range = max - e.val;
                start = e.val;
                end = max;
            }
            if (e.index + 1 < nums.get(e.row).size()) {
                e.index = e.index + 1;
                e.val = nums.get(e.row).get(e.index);
                queue.offer(e);
                if (e.val > max) {
                    max = e.val;
                }
            }
        }
        return new int[]{start, end};
    }
    class Element {
        int index;
        int row;
        int val;
        public Element(int val, int index, int row) {
            this.val = val;
            this.index = index;
            this.row = row;
        }
    }


}

