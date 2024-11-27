package Strings;

public class Count_and_Say {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fun(n));
    }
    public static String fun(int n){
        if(n == 1)
            return "1";
        if(n == 2)
            return "11";
        String st = "11";
        for(int i=3;i<=n;i++){
            StringBuilder s = new StringBuilder();
            int count = 1;
            int j=1;
            while(j<st.length()){
                if(st.charAt(j)==st.charAt(j-1)){
                    count++;
                    j++;
                }
                else{
                    s.append(count);
                    s.append(st.charAt(j-1));
                    count = 1;
                    j++;
                }
            }
            s.append(count);
            s.append(st.charAt(j-1));
            st = s.toString();
        }
        return st;
    }
}
