package Two_Pointers;

public class Compare_Version_Numbers {
    public static void main(String[] args) {
        String version1 = "02.056.3.4";
        String version2 = "2.56.03";
        System.out.println(compare(version1,version2));
    }
    public static int compare(String v1,String v2){
        int i=0;
        int j=0;
        while(i<v1.length() || j<v2.length()){
            int n1 = 0;
            int n2 = 0;
            while(i<v1.length() && v1.charAt(i)!='.'){
                n1 = n1*10 + (v1.charAt(i)-'0');
                i++;
            }
            while(j<v2.length() && v2.charAt(j)!='.'){
                n2 = n2*10 + (v2.charAt(j)-'0');
                j++;
            }
            if(n1>n2)
                return 1;
            if(n1<n2)
                return -1;
            i++;
            j++;
        }
        return 0;
    }
}
