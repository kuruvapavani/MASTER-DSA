
import java.util.HashMap;
import java.util.HashSet;

public class Hashing {
  public static void main(String[] args) {
    String s = "leetcode";
    System.out.println(firstUniqChar(s));
  }
  public static boolean containsDuplicate(int[] nums){
      HashSet<Integer> set = new HashSet<>();
      for(int num:nums){
        if(set.contains(num)) return true;
        set.add(num);
      }
      return false;
  }

  public static int[] twoSum(int[] nums, int target){
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<nums.length;i++){
        if(map.containsKey(target-nums[i])){
          return new int[]{map.get(target-nums[i]),i};
        }
        map.put(nums[i],i);
    }
    return new int[]{-1,-1};
  }

  public static int firstUniqChar(String s){
    int[] freq = new int[26];
    for(int i=0;i<s.length();i++){
      freq[s.charAt(i)-'a']++;
    }
    for(int i=0;i<s.length();i++){
      if(freq[s.charAt(i)-'a'] == 1){
        return i;
      }
    }
    return -1;
  }
}

/*  
----------------------------------------
      🌟 DAY 4 — HASHING NOTES
----------------------------------------

🔥 What is Hashing?
Hashing gives O(1) average time for insert, lookup, delete.
Used to check if something exists or count frequencies instantly.

----------------------------------------
      💡 When to Use HashSet
----------------------------------------
• Check duplicates in O(1)
• Check if an element exists
• Remove unnecessary repeats
• Fast membership checking

----------------------------------------
      💡 When to Use HashMap
----------------------------------------
Map Key → Value
Examples:
• Count frequencies (char, number, word)
• Last seen index of character (sliding window)
• Two-sum problem
• Store mapping relationships

----------------------------------------
      ⚙️ Time Complexity
----------------------------------------
HashSet / HashMap:
• Insert: O(1)
• Search: O(1)
• Delete: O(1)

Worst case O(n) but rare.

----------------------------------------
      🛠️ Common Templates
----------------------------------------
HashMap<K, V> map = new HashMap<>();
map.put(key, value);
map.get(key);
map.getOrDefault(key, 0);
map.containsKey(key);

HashSet<T> set = new HashSet<>();
set.add(x);
set.contains(x);

----------------------------------------
      🎯 Typical Hashing Use Cases
----------------------------------------
✔ Finding duplicates
✔ Counting occurrences
✔ Two Sum in linear time
✔ First non-repeating character
✔ Check if two strings are anagrams
✔ Sliding window (store last seen indices)

----------------------------------------
*/
