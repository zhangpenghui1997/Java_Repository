package cn.zph.test;

import cn.zph.dao.OrderItemDao;
import cn.zph.dao.impl.OrderItemDaoImpl;
import cn.zph.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {
    OrderItemDao orderItemDao=new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        OrderItem orderItem=new OrderItem(10,"abc",1,new BigDecimal(1.0),new BigDecimal(1),"125");
        orderItemDao.saveOrderItem(orderItem);
    }

    @Test
    public void queryOrderItemByUserId() {

        List<OrderItem> orderItems = orderItemDao.queryOrderItemByUserId(1);
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }

    }
}