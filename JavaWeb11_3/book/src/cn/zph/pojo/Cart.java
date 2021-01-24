package cn.zph.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    // private Integer totalCount;
    //private BigDecimal totalPrice;
    /*
     * key是商品编号，value是商品信息
     * */
    private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();


    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

/*    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }*/

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
           totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

/*
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }*/

    public Cart() {
    }

    public Cart(Integer totalCount, BigDecimal totalPrice, Map<Integer, CartItem> items) {
        // this.totalCount = totalCount;
        // this.totalPrice = totalPrice;
        this.items = items;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    /**
     * 添加商品数量
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        //先查看购物车中是否已经添加过此商品，如果已经添加，数量金额累加，没有添加之家添加到集合
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            //之前没添加
            items.put(cartItem.getId(), cartItem);
        } else {
            //之前已经添加过
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除商品数量
     *
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);

    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 修改商品数量
     *
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count) {
        //先查看购物车是否有此商品，如果有修改商品数量，更新总金额
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(count)));
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
