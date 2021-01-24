package cn.zph.service;

import cn.zph.pojo.Cart;
import cn.zph.pojo.Order;
import cn.zph.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);

    public List<Order> showAllOrders();

    public void sendOrder(String orderId);

    public List<OrderItem> showOrderDetail(Integer userId);

    public List<Order> showMyOrders(Integer userId);

    public void receiveOrder(String orderId);
}
