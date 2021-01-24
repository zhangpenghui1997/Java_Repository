package cn.zph.test;

import cn.zph.dao.OrderDao;
import cn.zph.dao.impl.OrderDaoImpl;
import cn.zph.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class OrderDaoImplTest {

    OrderDao orderDao=new OrderDaoImpl();
    @Test
    public void saveOrder() {
        Order order=new Order("125",new Date(),new BigDecimal(1.2),1,1);
        orderDao.saveOrder(order);
    }

    @Test
    public void queryOrders() {
        List<Order> orders = orderDao.queryOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void changeOrderStatus() {
        Order order=new Order("125",new Date(),new BigDecimal(1.2),1,1);
        orderDao.changeOrderStatus(order.getOrderId(),2);
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> orders = orderDao.queryOrdersByUserId(1);
        for (Order order : orders) {
            System.out.println(order);
        }


    }
}