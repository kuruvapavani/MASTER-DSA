
import java.util.HashMap;
import java.util.Map;

public class PrefixSum {

    public static void main(String[] args) {
      System.out.println("Prefix sum");
    }

    private int[] prefixSum;

    public void RangeSumQuery(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int query(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int count = 0;
        for (int num : nums) {
            prefix += num;
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

    public static int longestSubarrayWithSumK(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (map.containsKey(prefix - k)) {
                ans = Math.max(ans, i - map.get(prefix - k));
            }
            map.putIfAbsent(prefix, i);
        }
        return ans;
    }

}


/*
  Summary — Prefix Sum
  📌 Core Idea

  Prefix Sum is a technique where you precompute an array prefix[i] that stores the sum of elements from index 0 to i.
  This lets you answer range sum queries in O(1) after an initial O(n) preprocessing.

  📘 Why It’s Useful
  Fast range-sum queries
  Used in many patterns (subarrays, counting, difference arrays)
  Helps convert nested loops → single pass

  🧠 Formula
  prefix[i] = prefix[i-1] + nums[i]

  To get the sum of any subarray l...r:
  sum = prefix[r] - prefix[l-1]
  if l == 0 → sum = prefix[r]

  🧩 Key Applications
  1. Range Sum Query
      Quickly answer many sum(l, r) queries.
  2. Counting Subarrays With Target Sum
      Works especially well with prefix-sum + hashmap.
  3. Difference Array Trick
      Enable fast updates on ranges.
  4. 2D Prefix Sum
      For fast matrix region queries.
      🧰 Common Variants
      Normal prefix sum
      Prefix max/min
      Prefix XOR
      2D prefix sum (matrix)
      Prefix count / frequency prefix
 */
