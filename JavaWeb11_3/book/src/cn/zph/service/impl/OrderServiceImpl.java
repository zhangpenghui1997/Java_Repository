package cn.zph.service.impl;

import cn.zph.dao.BookDao;
import cn.zph.dao.OrderDao;
import cn.zph.dao.OrderItemDao;
import cn.zph.dao.impl.BookDaoImpl;
import cn.zph.dao.impl.OrderDaoImpl;
import cn.zph.dao.impl.OrderItemDaoImpl;
import cn.zph.pojo.*;
import cn.zph.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), userId, 0);
        orderDao.saveOrder(order);
        //System.out.println("OrderServiceImpl程序在"+Thread.currentThread().getName()+"线程中");
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            orderItemDao.saveOrderItem(new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId));
            //更新库存和销量
            Book book = bookDao.queryById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }

        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 1);
    }

    @Override
    public List<OrderItem> showOrderDetail(Integer userId) {

        return orderItemDao.queryOrderItemByUserId(userId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 2);
    }
}
