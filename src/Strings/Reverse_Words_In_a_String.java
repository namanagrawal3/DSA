package Strings;
import java.util.*;

public class Reverse_Words_In_a_String {
    public static void main(String[] args) {
        String s = "  a good    example ";
        s = s.trim();

        String[] arr = s.split("\s+");                  // for multiple spaces also
        int n = arr.length;
        StringBuilder ans = new StringBuilder();

        for (int i = n-1; i > 0; i--) {
            ans.append(arr[i]);
            ans.append(" ");
        }
        ans.append(arr[0]);

        System.out.println(ans);
    }
}
