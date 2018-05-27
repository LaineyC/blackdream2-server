package pers.laineyc.blackdream.framework.dao.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LaineyC
 */
public class Order implements Serializable {

    private List<OrderItem> orderItemList = new ArrayList<>();

    public Order(String property, Direction direction){
        this.by(property, direction);
    }

    public void by(String property, Direction direction){
        orderItemList.add(new Order.OrderItem(direction, property));
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public static class OrderItem{

        private  Order.Direction direction;

        private String property;

        public OrderItem(Order.Direction direction, String property) {
            this.direction = direction;
            this.property = property;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

    }

    public static enum Direction{
        ASC,

        DESC
    }

}