// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Logger Rate Limiter
// https://leetcode.com/problems/logger-rate-limiter/
// 

class Logger {
    LogTime[] bucket;
    /** Initialize your data structure here. */
    public Logger() {
        bucket = new LogTime[10];
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
       int index = (timestamp - 1) % 10;
       if (bucket[index] == null || bucket[index].timestamp != timestamp) {
           bucket[index] = new LogTime(timestamp);
           
       }
        
        for (LogTime log : bucket) {
            if (log != null && timestamp - log.timestamp < 10 && log.set.contains(message) ) {
                return false;
            }
        }
         bucket[index].set.add(message);
       return true;
        
    }
}

class LogTime {
    int timestamp;
    Set<String> set;
    public LogTime(int timestamp) {
        this.timestamp = timestamp;
        set = new HashSet<>();
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

