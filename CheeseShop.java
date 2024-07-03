import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CheeseShop {
    private List<Cheese> cheeses = new ArrayList<>();
    private List<Cheese> cart = new ArrayList<>();

    // Access for shop owner to add different cheeses
    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    // Access for shop owner to remove different cheeses
    public void removeCheese(int id) {
        cheeses.removeIf(cheese -> cheese.getId() == id);
    }

    // Access for customer to buy different cheeses (add to cart)
    public void addCheeseToCart(int id) {
        cheeses.stream().filter(cheese -> cheese.getId() == id).findFirst().ifPresent(cart::add);
    }

    // Access for customer to remove cheese from cart
    public void removeCheeseFromCart(int id) {
        cart.removeIf(cheese -> cheese.getId() == id);
    }

    // Get all cheeses in the cart
    public List<Cheese> getCart() {
        return cart;
    }

    // Get all available cheeses in the store
    public List<Cheese> getCheeses() {
        return cheeses;
    }

    // Checkout - get the total cost of cheeses in the cart
    public int checkout() {
        int sum = cart.stream().mapToInt(Cheese::getCost).sum();
        cart.clear();
        return sum;
    }
}
