package cn.zph.dao.impl;

import cn.zph.dao.OrderItemDao;
import cn.zph.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public void saveOrderItem(OrderItem orderItem) {
           System.out.println("OrderItemDaoImpl程序在"+Thread.currentThread().getName()+"线程中");
           String sql="insert into t_orderItem(name,count,price,totalPrice,orderId) values(?,?,?,?,?)";
           update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemByUserId(Integer userId) {
        String sql="select t_orderItem.id,t_orderItem.name,t_orderItem.count,t_orderItem.price,t_orderItem.totalPrice,t_orderItem.orderId from t_order ,t_orderItem where t_order.orderId=t_orderItem.orderId and userId=? ";
        return queryForList(OrderItem.class,sql,userId);
    }
}
