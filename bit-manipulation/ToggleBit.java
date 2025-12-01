public class ToggleBit {
  public static void main(String[] args) {
    System.out.println(toggleBit(1, 1));
  }

  public static int toggleBit(int num,int i){
    return num ^ (1 << i);
  }
}

