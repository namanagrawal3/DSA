package HashMap;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};

        HashSet<Integer> set = new HashSet<>();
        for (int ele: arr) {
            set.add(ele);
        }

        int maxLen = 0;
        for (int ele: arr) {
            if (set.contains(ele-1))
                continue;

            int len = 0;
            while (set.contains(ele)) {
                len++;
                ele++;
            }

            maxLen = Math.max(maxLen, len);
        }

        System.out.println(maxLen);
    }
}
