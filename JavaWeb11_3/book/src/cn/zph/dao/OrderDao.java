package cn.zph.dao;

import cn.zph.pojo.Order;

import java.util.List;

public interface OrderDao {
    public void saveOrder(Order order);

    public List<Order> queryOrders();

    public void changeOrderStatus(String orderId, Integer status);

    public List<Order> queryOrdersByUserId(Integer userId);
}
