package cn.zph.test;

import cn.zph.pojo.Cart;
import cn.zph.pojo.CartItem;
import cn.zph.pojo.Order;
import cn.zph.pojo.OrderItem;
import cn.zph.service.OrderService;
import cn.zph.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    private OrderService orderService=new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(2,"C++程序设计",1,new BigDecimal(63),new BigDecimal(63)));
        orderService.createOrder(cart,1);
    }

    @Test
    public void showAllOrders() {
        List<Order> orders =orderService.showAllOrders();
        for (Order order : orders) {
            System.out.println(order);

        }
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("ba128951-b968-461f-b18d-252c3e9c4b38");
    }

    @Test
    public void showOrderDetail() {
        List<OrderItem> orderItems = orderService.showOrderDetail(1);
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }

    @Test
    public void showMyOrders() {
        List<Order> orders = orderService.showMyOrders(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void receiveOrder() {
        orderService.receiveOrder("ba128951-b968-461f-b18d-252c3e9c4b38");

    }
}