package HashMap;

public class HashMap_Client {
    public static void main(String[] args) {
        HashMap_Implementation<String, Integer> map = new HashMap_Implementation<String, Integer>();

        map.put("naman", 45);
        map.put("raj", 90);
        map.put("sonu", 20);
        map.put("teena", 32);
        map.put("monu", 41);
        map.put("sam", -2);
        map.put("kirti", 0);
        map.put("naman", 100);

        System.out.println(map);
        System.out.println(map.get("naman"));
    }
}
