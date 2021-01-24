package cn.zph.dao.impl;

import cn.zph.dao.OrderDao;
import cn.zph.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public void saveOrder(Order order) {
        //System.out.println("OrderDaoImpl程序在"+Thread.currentThread().getName()+"线程中");
        String sql = "insert into t_order(orderId,createTime,price,status,userId) values(?,?,?,?,?)";
        update(sql,order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select * from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public void changeOrderStatus(String  orderId, Integer status) {
        String sql = "update t_order set status=? where orderId=?";
        update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "select * from t_order where userId=?";
        return queryForList(Order.class,sql,userId);
    }
}
