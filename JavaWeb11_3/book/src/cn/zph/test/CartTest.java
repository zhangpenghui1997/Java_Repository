package cn.zph.test;

import cn.zph.pojo.Cart;
import cn.zph.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(2,"C++程序设计",1,new BigDecimal(63),new BigDecimal(63)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(2,"C++程序设计",1,new BigDecimal(63),new BigDecimal(63)));
        System.out.println(cart);
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(2,"C++程序设计",1,new BigDecimal(63),new BigDecimal(63)));
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {

        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(1,"java程序设计",1,new BigDecimal(56),new BigDecimal(56)));
        cart.addItem(new CartItem(2,"C++程序设计",1,new BigDecimal(63),new BigDecimal(63)));
        System.out.println(cart);
        cart.updateCount(1,3);
        System.out.println(cart);
    }


    @Test
    public void test(){
        Map<Integer,CartItem> map=new HashMap<>();
        map.put(1,new CartItem(1,"java",1,new BigDecimal(10),new BigDecimal(10)));
        CartItem cartItem = map.get(1);
        cartItem.setCount(2);
        System.out.println(map);

        System.out.println(UUID.randomUUID().toString());
    }

}