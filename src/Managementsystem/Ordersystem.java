package Managementsystem;

import java.util.*;

// Order Processing System
class Order {
    String customerName;
    String orderDetails;

    public Order(String customerName, String orderDetails) {
        this.customerName = customerName;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return customerName + ": " + orderDetails;
    }
}

class OrderList extends AbstractList<Order> {
    private List<Order> orders = new ArrayList<>();

    @Override
    public Order get(int index) {
        return orders.get(index);
    }

    @Override
    public int size() {
        return orders.size();
    }

    @Override
    public boolean add(Order order) {
        orders.add(order);
        return true;
    }

    @Override
    public Order remove(int index) {
        return orders.remove(index);
    }

    @Override
    public String toString() {
        return orders.toString();
    }
}

// Delivery Routing System
class DeliveryPoint {
    String location;

    public DeliveryPoint(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return location;
    }
}

class DeliveryRoute extends AbstractSequentialList<DeliveryPoint> {
    private List<DeliveryPoint> route = new LinkedList<>();

    @Override
    public DeliveryPoint get(int index) {
        return route.get(index);
    }

    @Override
    public int size() {
        return route.size();
    }

    @Override
    public boolean add(DeliveryPoint point) {
        route.add(point);
        return true;
    }

    @Override
    public DeliveryPoint remove(int index) {
        return route.remove(index);
    }

    @Override
    public String toString() {
        return route.toString();
    }

	@Override
	public ListIterator<DeliveryPoint> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}

// Cache System for Inventory Management
class InventoryItem {
    String item;
    int quantity;

    public InventoryItem(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return item + " - Quantity: " + quantity;
    }
}

class InventoryCache extends CustomLinkedList<InventoryItem> {
    private int capacity;

    public InventoryCache(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean add(InventoryItem item) {
        if (size() >= capacity) {
            remove(0);
        }
        super.add(item);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data.toString());
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

// Custom LinkedList for Inventory Management
class CustomLinkedList<E> extends AbstractSequentialList<E> {
    protected Node head;
    protected int size;

    protected class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    @Override
    public E get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        Node current = head;
        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        return current.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data.toString());
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

	@Override
	public ListIterator<E> listIterator(int index) {
		
		return null;
	}
}

// Critical Analysis Report
public class Ordersystem {
    public static void main(String[] args) {
        // Order Processing System
        OrderList orderList = new OrderList();
        orderList.add(new Order("shobha", "Order for 5 items"));
        orderList.add(new Order("maya", "Order for 3 items"));
        System.out.println("Order List: " + orderList);

        // Delivery Routing System
        DeliveryRoute deliveryRoute = new DeliveryRoute();
        deliveryRoute.add(new DeliveryPoint("Location 1"));
        deliveryRoute.add(new DeliveryPoint("Location 2"));
        System.out.println("Delivery Route: " + deliveryRoute);

        // Cache System for Inventory Management
        InventoryCache inventoryCache = new InventoryCache(3);
        inventoryCache.add(new InventoryItem("Item 1", 5));
        inventoryCache.add(new InventoryItem("Item 2", 3));
        inventoryCache.add(new InventoryItem("Item 3", 2));
        System.out.println("Inventory Cache: " + inventoryCache);
    }
}
