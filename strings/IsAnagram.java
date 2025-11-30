public class IsAnagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("abcdef", "fabced"));
  }

  public static boolean isAnagram(String s1,String s2){
    int m = s1.length();
    int n = s2.length();
    if(m!=n) return false;
    int[] freq = new int[26];
    for(int i=0;i<m;i++){
      freq[s1.charAt(i)-'a']++;
      freq[s2.charAt(i)-'a']--;
    }
    for(int num:freq){
      if(num!=0) return false;
    }
    return true;
  }
}
