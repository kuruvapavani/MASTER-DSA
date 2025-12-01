public class FastPower {
  public static void main(String[] args) {
    
  }

  public static long fastPower(long x,long n){
    long ans = 1;
    while(n > 0){
      if((n&1)==1) ans*=x;
      x = x*x;
      n>>=1;
    }
    return ans;
  }
}
