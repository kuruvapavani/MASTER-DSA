public class CountSetBits {
  public static void main(String[] args) {
    System.out.println(countSetBits(0));
  }

  public static int countSetBits(int n){
      int count = 0;
      while(n >0){
        n = n & (n-1);
        count++;
      }
      return count;
  }
}
