package Oops_2;

public class Abstract_Demo_1_Client {
    public static void main(String[] args) {

        /* ----------------- Before Java 8 ------------------ */

        //  Abstract_Demo_1 ab = new Abstract_Demo_1();

        Payment_Method pm = new Payment_Method();
        pm.pay();
        int a = pm.amount;
        pm.checkAccount();
        pm.viewBalance();



        /* ----------------- After Java 8 ------------------- */

        Abstract_Demo_1 ab1 = new Abstract_Demo_1() {     // "Anonymous-Way" to make an object of abstract class is to override methods each time
            @Override
            public void pay() {

            }
        };
        ab1.pay();
        int b = ab1.amount;
        ab1.viewBalance();
        ab1.checkScore();

        Abstract_Demo_1 ab2 = new Abstract_Demo_1() {
            @Override
            public void pay() {

            }
        };
    }
}
