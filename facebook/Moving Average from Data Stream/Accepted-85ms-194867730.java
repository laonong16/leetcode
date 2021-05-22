// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Moving Average from Data Stream
// https://leetcode.com/problems/moving-average-from-data-stream/
// 

class MovingAverage {

    /** Initialize your data structure here. */
    int sum;
    int count;
    int[] window;
    int firstIndex;
    public MovingAverage(int size) {
       sum = 0;
        count = 0;
        window = new int[size];
        firstIndex= 0;
    }
    
    public double next(int val) {
        if(count >= window.length) {
           sum = sum + val - window[firstIndex];
            window[firstIndex++] = val;
            firstIndex %= window.length;
            return  (double)sum / window.length;
        } else {
            window[count++] = val;
            sum += val;
            return  (double)sum / count;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
