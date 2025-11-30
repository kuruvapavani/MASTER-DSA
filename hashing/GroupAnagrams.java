import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {
  public static void main(String[] args) {
    String[] arr = {"eat","tea","tan","ate","nat","bat"};
    System.out.println(groupAnagrams(arr));
  }
  public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs){
      ArrayList<ArrayList<String>> ans = new ArrayList<>();
      HashMap<String,Integer> map = new HashMap<>();
      for(int i=0;i<strs.length;i++){
        int[] freq = new int[26];
        for(int j=0;j<strs[i].length();j++){
          freq[strs[i].charAt(j)-'a']++;
        }
        StringBuilder str = new StringBuilder("");
        for(int num:freq){
          str.append(num);
          str.append('-');
        }
        String s = str.toString();
        if(!map.containsKey(s)){
          map.put(s,ans.size());
          ans.add(new ArrayList<>());
        }
        ans.get(map.get(s)).add(strs[i]);
      }
      return ans;
  }
}