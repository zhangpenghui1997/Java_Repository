package cn.zph.dao;

import cn.zph.pojo.OrderItem;

import java.util.List;


public interface OrderItemDao {
    public void saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItemByUserId(Integer userId);
}
