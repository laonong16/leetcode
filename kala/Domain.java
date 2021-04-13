import java.util.*;

class Domain {
    /*
    We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains,
    (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
    Example 1:
    Input:
    ["9001 discuss.leetcode.com"]
    Output:
    ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]

    Example 2:
    Input:
    ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
    Output:
    ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
     */
    public static String[] countDomain1(String[] domains) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String domain : domains) {
            String[] temp = domain.split(" ");
            int fre = Integer.parseInt(temp[0]);
            String[] subdomains = temp[1].split("\\.");
            String cur = "";
            for (int i = subdomains.length - 1; i >= 0; i--) {
                cur = subdomains[i] + (cur.length() == 0 ? "" : ".") + cur;
                frequency.put(cur, frequency.getOrDefault(cur, 0) + fre);
            }
        }
        String[] result = new String[frequency.keySet().size()];
        int i = 0;
        for (String domain : frequency.keySet()) {
            result[i++] = frequency.get(domain) + " " + domain;
        }
        return result;
    }
/*
Pt.2 Longest Continuous Common History: Given visiting history of each user,
find the longest continuous common history between two users. (LeetCode 718, dp)

input :
[
  ["3234.html", "xys.html", "7hsaa.html"], // user1
  ["3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2
]
output :
["xys.html", "7hsaa.html"]

 */
public static String[] LCS(String[] s1, String[] s2) {
    if(s1 ==null||s2 ==null||s1.length ==0||s2.length ==0)
    {
        return new String[0];
    }

    int l1 = s1.length;
    int l2 = s2.length;
    int max = 0;
    int endIndex = -1;
    int[][] dp = new int[l1 + 1][l2 + 1];
    for(int i = 1; i <=l1; i++) {
        for(int j = 1; j <= l2; j++) {
            if (s1[i - 1].equals(s2[j - 1])) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    endIndex = i - 1;
                }
            }
        }
    }
    if(max ==0)
        return new String[0];
    String[] result = new String[max];
    int start = endIndex - max + 1;
    for( int i = 0; i<max;i++)
    {
        result[i] = s1[start++];
    }
   return result;
}
/*

Pt.3 (Map)The people who buy ads on our network don't have enough data about how ads are working for their business.
They've asked us to find out which ads produce the most purchases on their website.
Our client provided us with a list of user IDs of customers who bought something on a landing page
after clicking one of their ads:

Each user completed 1 purchase.
completed_purchase_user_ids = [
"3123122444","234111110", "8321125440", "99911063"]
And our ops team provided us with some raw log data from our ad server showing every time a user clicked on one of our ads:
ad_clicks = [
#"IP_Address,Time,Ad_Text",
"122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
"96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
"122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
"82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
"92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
"92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens",
]
The client also sent over the IP addresses of all their users.
all_user_ips = [
#"User_ID,IP_Address",
"2339985511,122.121.0.155",
"234111110,122.121.0.1",
"3123122444,92.130.6.145",
"39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
"8321125440,82.1.106.8",
"99911063,92.130.6.144"
]
Write a function to parse this data, determine how many times each ad was clicked,
then return the ad text, that ad's number of clicks, and how many of those ad clicks were from users who made a purchase.
Expected output:
Bought Clicked Ad Text
1 of 2  2017 Pet Mittens
0 of 1  The Best Hollywood Coats
3 of 3  Buy wool coats for your pets


 */

    public static String[] AdsConversion(String[] completedUserId, String[] adClicks, String[] allUserIp) {
        HashSet<String> userIdSet = new HashSet<>();
        for (String user : completedUserId) {
            userIdSet.add(user);
        }
        Map<String, List<String>> adIPMap = new HashMap<>();
        Map<String, String> ipUserMap = new HashMap<>();
        for (String adClick : adClicks) {
            String[] parsed = adClick.split(",");
            String text = parsed[2];
            String ip = parsed[0];
            adIPMap.putIfAbsent(text, new ArrayList<>());
            adIPMap.get(text).add(ip);
        }

        for (String userIp : allUserIp) {
            String[] userAndIp = userIp.split(",");
            ipUserMap.putIfAbsent(userAndIp[1], userAndIp[0]);
        }

        String[] result = new String[adIPMap.keySet().size()];
        int i = 0;
        for (String text : adIPMap.keySet()) {
            List<String> clicks = adIPMap.get(text);
            int buyer = 0;
            for (String user : clicks) {
                if (userIdSet.contains(ipUserMap.get(user))) {
                    buyer++;
                }
            }
            result[i++] = buyer + " of " + clicks.size() + " " + text;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] completedId = { "3123122444", "234111110", "8321125440", "99911063" };
        String[] adClicks = { "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
                "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
                "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
                "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
                "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
                "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens" };
        String[] allUser = { "User_ID,IP_Address", "2339985511,122.121.0.155", "234111110,122.121.0.1",
                "3123122444,92.130.6.145", "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
                "8321125440,82.1.106.8", "99911063,92.130.6.144" };
        String[] result3 = AdsConversion(completedId, adClicks, allUser);
        System.out.println("[");
        for (String s : result3) {
            System.out.println(s);
        }
        System.out.println("]");
        String[] s1 = { "3234.html", "xys.html", "7hsaa.html" }; // user1
        String[] s2 = { "3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html" }; // user2
        String[] result2 = LCS(s1, s2);
        System.out.println("[");
        for (String s : result2) {
            System.out.println(s + " ,");
        }
        System.out.println("]");
        String[] domains = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
        String[] result = countDomain1(domains);
        System.out.println("[");
        for (String s : result) {
            System.out.println(s + ", ");
        }
        System.out.println("]");
    }
}