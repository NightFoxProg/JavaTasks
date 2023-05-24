package Task14;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Product {
    private int id;
    private String type;
    private double price;
    private boolean discount;
    private LocalDate creationDate;

    public Product(int id, String type, double price, boolean discount, LocalDate creationDate) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public static List<Product> getBookProductsWithPriceGreaterThan250(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedBookProducts(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .peek(p -> {
                    if (p.hasDiscount()) {
                        p.price *= 0.9; // Застосовуємо знижку 10%
                    }
                })
                .collect(Collectors.toList());
    }

    public static Product findCheapestBookProduct(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
    }

    public static List<Product> getLastThreeAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreationDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static double calculateTotalPriceOfBooksInCurrentYear(List<Product> products) {
        int currentYear = LocalDate.now().getYear();
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getCreationDate().getYear() == currentYear)
                .filter(p -> p.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Book", 200, true, LocalDate.of(2022, 1, 1)));
        products.add(new Product(2, "Book", 300, false, LocalDate.of(2022, 2, 1)));
        products.add(new Product(3, "Toy", 150, true, LocalDate.of(2022, 3, 1)));
        products.add(new Product(4, "Book", 400, true, LocalDate.of(2023, 4, 1)));
        products.add(new Product(5, "Book", 100, false, LocalDate.of(2023, 5, 1)));




        List<Product> expensiveBooks = Product.getBookProductsWithPriceGreaterThan250(products);
        System.out.println("Expensive Books:");
        expensiveBooks.forEach(System.out::println);
        System.out.println();


        List<Product> discountedBooks = Product.getDiscountedBookProducts(products);
        System.out.println("Discounted Books:");
        discountedBooks.forEach(System.out::println);
        System.out.println();


        try {
            Product cheapestBook = Product.findCheapestBookProduct(products);
            System.out.println("Cheapest Book:");
            System.out.println(cheapestBook);
            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }


        List<Product> lastThreeProducts = Product.getLastThreeAddedProducts(products);
        System.out.println("Last Three Added Products:");
        lastThreeProducts.forEach(System.out::println);
        System.out.println();


        double totalPrice = Product.calculateTotalPriceOfBooksInCurrentYear(products);
        System.out.println("Total Price of Books in Current Year: $" + totalPrice);
        System.out.println();


        Map<String, List<Product>> groupedProducts = Product.groupProductsByType(products);
        System.out.println("Grouped Products:");
        groupedProducts.forEach((type, productList) -> {
            System.out.println(type + ":");
            productList.forEach(System.out::println);
            System.out.println();
        });
    }
}