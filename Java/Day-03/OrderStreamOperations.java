import java.util.*;
import java.util.stream.Collectors;

class Order {
    int orderId;
    String customerName;
    String product;
    String category;
    double amount;
    String status;
    String city;

    Order(int orderId, String customerName, String product,
          String category, double amount, String status, String city) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.category = category;
        this.amount = amount;
        this.status = status;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                ", Customer: " + customerName +
                ", Product: " + product +
                ", Category: " + category +
                ", Amount: " + amount +
                ", Status: " + status +
                ", City: " + city;
    }
}

public class OrderStreamOperations {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order(101, "Ravi", "Laptop", "Electronics", 75000, "Delivered", "Hyderabad"),
            new Order(102, "Kiran", "Shoes", "Fashion", 4500, "Pending", "Chennai"),
            new Order(103, "Raj", "Mobile", "Electronics", 30000, "Delivered", "Bangalore"),
            new Order(104, "Arjun", "Watch", "Fashion", 8000, "Cancelled", "Hyderabad"),
            new Order(105, "Sai", "Headphones", "Electronics", 2500, "Delivered", "Chennai"),
            new Order(106, "Manoj", "Table", "Furniture", 12000, "Delivered", "Bangalore"),
            new Order(107, "Rahul", "Chair", "Furniture", 6500, "Pending", "Hyderabad"),
            new Order(108, "Varun", "Shirt", "Fashion", 3500, "Delivered", "Bangalore"),
            new Order(109, "Ajay", "Monitor", "Electronics", 18000, "Pending", "Chennai"),
            new Order(110, "Pavan", "Sofa", "Furniture", 25000, "Delivered", "Hyderabad")
        );

        // 1. Filter orders by amount and delivery status
        System.out.println("\n===== FILTERED ORDERS =====");
        orders.stream()
                .filter(o -> o.amount > 5000 && o.status.equals("Delivered"))
                .forEach(System.out::println);

        // 2. Sort orders by amount
        System.out.println("\n===== ORDERS SORTED BY AMOUNT =====");
        orders.stream()
                .sorted(Comparator.comparingDouble(o -> o.amount))
                .forEach(System.out::println);

        // 3. Find highest and lowest order
        System.out.println("\n===== HIGHEST ORDER =====");
        orders.stream()
                .max(Comparator.comparingDouble(o -> o.amount))
                .ifPresent(System.out::println);

        System.out.println("\n===== LOWEST ORDER =====");
        orders.stream()
                .min(Comparator.comparingDouble(o -> o.amount))
                .ifPresent(System.out::println);

        // 4. Calculate total sales
        System.out.println("\n===== TOTAL SALES =====");
        double totalSales = orders.stream()
                .mapToDouble(o -> o.amount)
                .sum();
        System.out.println("Total Sales: " + totalSales);

        // 5. Count orders
        System.out.println("\n===== TOTAL ORDERS =====");
        long orderCount = orders.stream().count();
        System.out.println("Number of Orders: " + orderCount);

        // 6. Group orders by category
        System.out.println("\n===== GROUP BY CATEGORY =====");
        Map<String, List<Order>> categoryGroups = orders.stream()
                .collect(Collectors.groupingBy(o -> o.category));
        categoryGroups.forEach((category, orderList) -> {
            System.out.println("\nCategory: " + category);
            orderList.forEach(System.out::println);
        });

        // 7. Group orders by city
        System.out.println("\n===== GROUP BY CITY =====");
        Map<String, List<Order>> cityGroups = orders.stream()
                .collect(Collectors.groupingBy(o -> o.city));
        cityGroups.forEach((city, orderList) -> {
            System.out.println("\nCity: " + city);
            orderList.forEach(System.out::println);
        });

        // 8. Group by category and then city
        System.out.println("\n===== GROUP BY CATEGORY AND CITY =====");
        Map<String, Map<String, List<Order>>> categoryCityGroups = orders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.category,
                        Collectors.groupingBy(o -> o.city)
                ));
        categoryCityGroups.forEach((category, cityMap) -> {
            System.out.println("\nCategory: " + category);
            cityMap.forEach((city, orderList) -> {
                System.out.println("City: " + city);
                orderList.forEach(System.out::println);
            });
        });

        // 9. Calculate average order amount
        System.out.println("\n===== AVERAGE ORDER AMOUNT =====");
        double averageAmount = orders.stream()
                .mapToDouble(o -> o.amount)
                .average()
                .orElse(0.0);
        System.out.println("Average Order Amount: " + averageAmount);

        // 10. flatMap: flatten product and category details into one stream
        System.out.println("\n===== FLATMAP: PRODUCT AND CATEGORY =====");
        orders.stream()
                .map(o -> Arrays.asList(o.product, o.category))
                .flatMap(List::stream)
                .forEach(System.out::println);

        // 11. limit: display only the first five orders
        System.out.println("\n===== LIMIT: FIRST FIVE ORDERS =====");
        orders.stream()
                .limit(5)
                .forEach(System.out::println);

        // Sort once so takeWhile and dropWhile work on an ordered amount sequence
        List<Order> amountSorted = orders.stream()
                .sorted(Comparator.comparingDouble(o -> o.amount))
                .collect(Collectors.toList());

        // 12. takeWhile: take orders from the start while amount is below 10000
        System.out.println("\n===== TAKEWHILE: AMOUNT BELOW 10000 =====");
        amountSorted.stream()
                .takeWhile(o -> o.amount < 10000)
                .forEach(System.out::println);

        // 13. dropWhile: skip orders from the start while amount is below 10000
        System.out.println("\n===== DROPWHILE: REMAINING ORDERS FROM 10000 =====");
        amountSorted.stream()
                .dropWhile(o -> o.amount < 10000)
                .forEach(System.out::println);
    }
}
