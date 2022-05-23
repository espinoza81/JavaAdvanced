import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ProductShop {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        Map <String, LinkedHashMap<String, Double>> shops = new TreeMap<>();
        while (!"Revision".equals(input= console.nextLine())){
            String[] attribute = input.split(",\\s+");
            String shop = attribute[0];
            String product = attribute[1];
            double price = Double.parseDouble(attribute[2]);
            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).put(product, price);
        }
        System.out.println(shops.entrySet()
                .stream()
                .map(shop ->
                        String.format("%s->%n%s", shop.getKey(),
                                shop.getValue()
                                        .entrySet()
                                        .stream()
                                        .map(product ->
                                                String.format("Product: %s, Price: %.1f",
                                                        product.getKey(),
                                                        product.getValue()))
                                        .collect(Collectors.joining(System.lineSeparator()))
                        )
                )
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
