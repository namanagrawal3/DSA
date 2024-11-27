package Math;

public class Count_Special_Integers {
    public static void main(String[] args) {
        int n = 6335;
        System.out.println(fun(n));
    }
    public static int fun(int num) {
        String st = String.valueOf(num);
        int len = st.length();
        if (len == 1)
            return num;
        int n = len - 1;
        int ans = 9;                            // for n == 1
        int curr = 9;
        int val = 9;
        for (int i = 2; i <= n; i++) {
            curr *= val;
            ans += curr;
            val--;
        }
        boolean[] used = new boolean[10];        // false -> not used, true -> used
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            int digit = st.charAt(i) - '0';
            int count = 0;
            for (int j = 0; j < digit; j++) {
                if (used[j] == false)
                    count++;
            }
            if (i == 0)
                count--;
            int c = count, rem = 10 - i - 1;
            for (int j = i+1; j < len; j++) {
                c *= rem;
                rem--;
            }
            ans += c;
            if (used[digit] == false)
                used[digit] = true;
            else {
                flag = false;               // means num has repeated digits
                break;
            }
        }
        if (flag)
            return ans + 1;
        return ans;
    }
}
