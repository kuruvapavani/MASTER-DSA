public class IsPrime {
  public static void main(String[] args) {
    System.out.println(isPrime(4));
  }

  public static boolean isPrime(int n){
    if(n <= 1) return false;
    if(n<=3) return true;
    for(int i=2;i*i <= n; i++){
      if(n%i == 0) return false;
    }
    return true;
  }
}
