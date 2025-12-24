
import java.util.*;

public class ReinitializePermutation {

    public int reinitializePermutation(int n) {
        int count = 0;
        int i = 1;
        do {
            if (i % 2 == 0) {
                i = i / 2;
            } else {
                i = n / 2 + (i - 1) / 2;
            }
            count++;
        } while (i != 1);
        return count;
    }
}
