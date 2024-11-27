package HashMap;

public class Client_HashMap {
    public static void main(String[] args) {
        Implementation_HashMap<String, Integer> map = new Implementation_HashMap<String, Integer>();

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
