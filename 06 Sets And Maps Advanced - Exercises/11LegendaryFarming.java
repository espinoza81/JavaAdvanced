import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, Integer> legendaryMaterials = new TreeMap<>();
        legendaryMaterials.put("shards", 0);
        legendaryMaterials.put("fragments", 0);
        legendaryMaterials.put("motes", 0);

        Map <String, String> legendaryItem = new LinkedHashMap<>();
        legendaryItem.put("shards", "Shadowmourne");
        legendaryItem.put("fragments", "Valanyr");
        legendaryItem.put("motes", "Dragonwrath");

        Map <String, Integer> materials = new LinkedHashMap<>();

        boolean haveWinner = false;
        while (!haveWinner){
            String[] input = console.nextLine().split("\\s+");
            for(int i=0; i<input.length; i+=2){
                int quantity = Integer.parseInt(input[i]);
                String material = input[i+1].toLowerCase(Locale.ROOT);
                if (legendaryMaterials.containsKey(material)){
                    if(legendaryMaterials.get(material)+quantity >=250) {
                        legendaryMaterials.put(material, legendaryMaterials.get(material) + quantity - 250);
                        haveWinner = true;
                        System.out.println(legendaryItem.get(material) + " obtained!");
                        break;
                    }
                    else {
                        legendaryMaterials.put(material, legendaryMaterials.get(material) + quantity);
                    }
                }
                else {
                    materials.putIfAbsent(material, 0);
                    materials.put(material, materials.get(material)+quantity);
                }
            }
        }
        legendaryMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach( s -> System.out.println(s.getKey() + ": " + s.getValue()));
        materials.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach( s -> System.out.println(s.getKey() + ": " + s.getValue()));
    }
}
