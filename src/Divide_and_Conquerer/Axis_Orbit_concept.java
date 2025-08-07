package Divide_and_Conquerer;

public class Axis_Orbit_concept {
    public static void main(String[] args) {

        //-------------- Palindromic Substrings ----------------

        String str = "nitin";
        System.out.println(palindromeSubstring(str));
    }
    public static int palindromeSubstring(String str) {
        int n = str.length();

        // "odd" length substrings
        int odd = 0;
        for (int axis = 0; axis < n; axis++) {
            for (int orbit = 0; axis-orbit >= 0 && axis+orbit < n; orbit++) {
                if (str.charAt(axis-orbit) != str.charAt(axis+orbit))
                    break;
                odd++;
            }
        }

        // "even" length substrings
        int even = 0;
        for (double axis = 0.5; axis < n; axis++) {
            for (double orbit = 0.5; axis-orbit >= 0 && axis+orbit < n; orbit++) {
                if (str.charAt((int)(axis-orbit)) != str.charAt((int)(axis+orbit)))
                    break;
                even++;
            }
        }

        return odd + even;
    }
}
