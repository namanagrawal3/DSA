package Strings;

public class string_compression {
    public static void main(String[] args) {
        String st = "aabccaa";
        compress(st);
    }
    public static void compress(String st){
        int n=st.length();
        if(n==1)
            System.out.print(st+1);
        else{
            for(int i=0;i<n;i++){
                int count=1;
                for(int j=i+1;j<n;j++){
                    if(st.charAt(j)==st.charAt(i))
                        count++;
                    else
                        break;
                }
                System.out.print(st.charAt(i)+""+count);
                i = i+count-1;
            }
        }
    }
}
