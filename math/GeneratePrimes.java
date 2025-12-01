
import java.util.ArrayList;
import java.util.Arrays;

public class GeneratePrimes {
  public static void main(String[] args) {
      System.out.println(generatePrimes(13));
  }

  public static ArrayList<Integer> generatePrimes(int n){
    ArrayList<Integer> ans = new ArrayList<>();
    boolean[] isPrime = new boolean[n+1];
    Arrays.fill(isPrime, true);
    isPrime[0] =isPrime[1] = false;
    for(int i=2;i*i<=n;i++){
      if(isPrime[i]){
          for(int j=i*i;j<=n;j+=i){
            isPrime[j] = false;
          }
      }
    }
    for(int i=0;i<n+1;i++){
      if(isPrime[i]) ans.add(i);
    }
    return ans;
  }
}
