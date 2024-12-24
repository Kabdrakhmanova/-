import java.util.ArrayList;
import java.util.List;

interface OrderPrototype {
    OrderPrototype clone();
}

class Order implements OrderPrototype {
    private String clientName;
    private List<String> items;
    private String deliveryCondition;
    private double discount;
    private String paymentMethod;

    public Order(String clientName, List<String> items, String deliveryCondition, double discount, String paymentMethod) {
        this.clientName = clientName;
        this.items = new ArrayList<>(items);
        this.deliveryCondition = deliveryCondition;
        this.discount = discount;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public OrderPrototype clone() {
        return new Order(this.clientName, this.items, this.deliveryCondition, this.discount, this.paymentMethod);
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void addItem(String item) {
        this.items.add(item);
    }

    public void removeItem(String item) {
        this.items.remove(item);
    }

    public void setDeliveryCondition(String deliveryCondition) {
        this.deliveryCondition = deliveryCondition;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Заказ{" +
                "Имя клиента='" + clientName + '\'' +
                ", Товары=" + items +
                ", Условия доставки='" + deliveryCondition + '\'' +
                ", Скидка=" + discount +
                ", Способ оплаты='" + paymentMethod + '\'' +
                '}';
    }
}

public class OrderManagementSystem {
    public static void main(String[] args) {
        Order prototypeOrder = new Order(
                "Корпоративный клиент",
                List.of("Ноутбук", "Мышь"),
                "Экспресс-доставка",
                10.0,
                "Кредитная карта"
        );

        System.out.println("Исходный заказ: " + prototypeOrder);

        Order clonedOrder = (Order) prototypeOrder.clone();
        clonedOrder.addItem("Клавиатура");
        clonedOrder.setDiscount(15.0);
        clonedOrder.setClientName("Частный клиент");

        System.out.println("Клонированный и изменённый заказ: " + clonedOrder);

        Order anotherClonedOrder = (Order) prototypeOrder.clone();
        anotherClonedOrder.removeItem("Мышь");
        anotherClonedOrder.setPaymentMethod("PayPal");

        System.out.println("Ещё один клонированный и изменённый заказ: " + anotherClonedOrder);
    }
}
