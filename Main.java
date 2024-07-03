import java.util.Scanner;

public class Main {
    private static CheeseShop cheeseShop = new CheeseShop();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Cheese Shop");
            System.out.println("1. Add Cheese");
            System.out.println("2. Remove Cheese");
            System.out.println("3. Update Cheese");
            System.out.println("4. View Available Cheeses");
            System.out.println("5. Add Cheese to Cart");
            System.out.println("6. Remove Cheese from Cart");
            System.out.println("7. View Cart");
            System.out.println("8. Checkout");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> addCheese();
                case 2 -> removeCheese();
                case 3 -> updateCheese();
                case 4 -> viewAvailableCheeses();
                case 5 -> addCheeseToCart();
                case 6 -> removeCheeseFromCart();
                case 7 -> viewCart();
                case 8 -> checkout();
                case 9 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addCheese() {
        System.out.print("Enter cheese id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter cheese name: ");
        String name = scanner.nextLine();
        System.out.print("Enter cheese cost: ");
        int cost = scanner.nextInt();
        cheeseShop.addCheese(new Cheese(id, name, cost));
        System.out.println("Cheese added.");
    }

    private static void removeCheese() {
        System.out.print("Enter cheese id to remove: ");
        int id = scanner.nextInt();
        cheeseShop.removeCheese(id);
        System.out.println("Cheese removed.");
    }

    private static void updateCheese() {
        System.out.print("Enter cheese id to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new cheese name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new cheese cost: ");
        int cost = scanner.nextInt();
        cheeseShop.getCheeses().stream().filter(cheese -> cheese.getId() == id).findFirst().ifPresent(cheese -> {
            cheese.setName(name);
            cheese.setCost(cost);
        });
        System.out.println("Cheese updated.");
    }

    private static void viewAvailableCheeses() {
        System.out.println("Available Cheeses:");
        cheeseShop.getCheeses().forEach(System.out::println);
    }

    private static void addCheeseToCart() {
        System.out.print("Enter cheese id to add to cart: ");
        int id = scanner.nextInt();
        cheeseShop.addCheeseToCart(id);
        System.out.println("Cheese added to cart.");
    }

    private static void removeCheeseFromCart() {
        System.out.print("Enter cheese id to remove from cart: ");
        int id = scanner.nextInt();
        cheeseShop.removeCheeseFromCart(id);
        System.out.println("Cheese removed from cart.");
    }

    private static void viewCart() {
        System.out.println("Cheeses in Cart:");
        cheeseShop.getCart().forEach(System.out::println);
    }

    private static void checkout() {
        int totalCost = cheeseShop.checkout();
        System.out.println("Total cost: " + totalCost);
    }
}
