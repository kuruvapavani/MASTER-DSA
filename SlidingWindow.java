
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlidingWindow {

    public static void main(String[] args) {
        System.out.println("hii");
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(11, nums));
    }

    public static int maxSumSubarray(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return -1;
        }
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int maxSum = windowSum;
        for (int i = k; i < n; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    // target = 7, nums = [2,3,1,2,4,3]
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();

        if (n < k) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] count = new int[26];

        for (int i = 0; i < k; i++) {
            count[p.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }

        if (isAnagram(count)) {
            ans.add(0);
        }

        int left = 0;

        for (int right = k; right < n; right++) {
            count[s.charAt(left) - 'a']++;
            left++;
            count[s.charAt(right) - 'a']--;

            if (isAnagram(count)) {
                ans.add(left);
            }
        }

        return ans;
    }

    private boolean isAnagram(int[] count) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}



/*
    📌 What is Sliding Window?
    A technique to process contiguous subarrays/substrings efficiently by expanding & shrinking a window instead of using nested loops.

    📌 Why is it useful?
    Because it removes repeated work → reduces O(n²) brute force to O(n).

    Examples:
    Longest substring without repeating characters
    Maximum/minimum subarray problems
    Count of subarrays with property
    Shortest window satisfying condition

    📌 Types of Sliding Windows
    ✔ 1. Fixed-size window
    Used when window size k is known.
    Steps:
    Build first window of size k
    Slide window by 1 step:
    Add new element
    Remove old element

    Example problems:
    Max sum subarray of size k
    Average of subarray of size k

    ✔ 2. Variable-size window
    Window grows/shrinks based on a condition.
    Used when:
    You want longest/shortest subarray with some property
    Need to remove elements when condition breaks
    Common pattern:
    int left = 0;
    for (int right = 0; right < n; right++) {
        // expand with right
        while (condition is broken) {
            // shrink with left
            left++;
        }
    }

    Example problems:
    Longest substring without repeating characters
    Minimum window to reach target sum
    Count distinct elements in window

    📌 Where Sliding Window is Used?

    Use it when:
    // 1) The problem asks for subarray or substring
    // 2) The window is continuous (no skipping)
    // 3) You need max/min/shortest/longest something
    // 4) Condition can be checked by expanding/shrinking
    // 5) Prefix sum approach doesn’t fit the logic

 */
