package Task13.coffee.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders;
    private int nextOrderNumber;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
        nextOrderNumber = 1;
    }

    public void add(Order order) {
        order.setOrderNumber(nextOrderNumber);
        orders.add(order);
        nextOrderNumber++;
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            System.out.println("No orders to deliver.");
            return null;
        }

        Order nextOrder = orders.get(0);
        orders.remove(0);
        return nextOrder;
    }

    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                return order;
            }
        }

        System.out.println("Order with number " + orderNumber + " not found.");
        return null;
    }

    public void draw() {
        System.out.println("=============");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }
    }
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        Order order1 = new Order();
        order1.setCustomerName("Alen");
        board.add(order1);

        Order order2 = new Order();
        order2.setCustomerName("Yoda");
        board.add(order2);

        Order order3 = new Order();
        order3.setCustomerName("Obi-van");
        board.add(order3);

        Order order4 = new Order();
        order4.setCustomerName("John Snow");
        board.add(order4);

        board.draw();

        System.out.println("Delivering next order:");
        Order deliveredOrder = board.deliver();
        System.out.println("Delivered order: " + deliveredOrder.getOrderNumber() + " | " + deliveredOrder.getCustomerName());

        System.out.println("Delivering order with number 3:");
        Order specificDeliveredOrder = board.deliver(3);
        if (specificDeliveredOrder != null) {
            System.out.println("Delivered order: " + specificDeliveredOrder.getOrderNumber() + " | " + specificDeliveredOrder.getCustomerName());
        }

        board.draw();
    }
}
