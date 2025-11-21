
class TwoPointer {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        // moveZeroes(nums);
        System.out.println(reverseVowels("hello"));
    }

    public boolean hasPairWithSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }

        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left < right){
          if(!isVowel(arr[left])){
            left++;
          }
          if(!isVowel(arr[right])){
            right--;
          }
          if(isVowel(arr[left]) && isVowel(arr[right])){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
          }
        }
        return new String(arr);
    }


    public static boolean isVowel(Character ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}


/*
================== TWO POINTERS PATTERN ==================

Intuition:
- Use two indices (pointers) to scan an array or string simultaneously.
- Usually used to reduce O(n^2) brute-force solutions to O(n) or O(n log n).

When to use:
1. Array/string is sorted (or can be logically treated as sorted)
2. Looking for a pair or combination of elements satisfying a condition
3. Problems that involve comparing ends, shrinking/expanding a window
4. Palindrome checking, reversing substrings, moving elements in-place
5. Sliding window / sum / subarray problems

Common Patterns:
- Left and Right pointers moving inward (palindrome, sum pairs)
- Slow and Fast pointers (cycle detection, speed-based problems)
- Single pointer scanning + “placement pointer” (move zeros, partitioning)
- Shrinking/expanding windows for substring/subarray problems

Complexity:
- Time: O(n) in most cases (each pointer moves at most n steps)
- Space: O(1) extra space

Tips:
- Always clarify pointer movement rules: when to move left/right
- Ensure loop termination (usually left < right)
- For in-place modifications, a separate slow/placement pointer can be handy
- Works best when array is sorted or order matters

Example Problems:
1. Check if sorted array has a pair with given sum
2. Move all zeros to the end of array in-place
3. Reverse vowels of a string
4. Palindrome check in a string
5. Sliding window max/sum problems (next topic)
*/
