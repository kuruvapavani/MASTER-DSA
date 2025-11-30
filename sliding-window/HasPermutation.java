public class HasPermutation {
  public static void main(String[] args) {
    System.out.println(isPermutation("ab", "eidbaooo"));
  }

  public static boolean isPermutation(String s1,String s2){
    int[] freq = new int[26];
    int m = s1.length();
    int n = s2.length();
    if(n<m) return false;
    for(int i=0;i<m;i++){
      freq[s1.charAt(i)-'a']++;
      freq[s2.charAt(i)-'a']--;
    }
    if(isZero(freq)) return true;
    int left =0;
    for(int i=m;i<n;i++){
      freq[s2.charAt(left)-'a']++;
      freq[s2.charAt(i)-'a']--;
      if(isZero(freq)) return true;
      left++;
    }
    return false;
  }

  private static boolean isZero(int[] nums){
    for(int num:nums){
      if(num!=0) return false;
    }
    return true;
  }
}
