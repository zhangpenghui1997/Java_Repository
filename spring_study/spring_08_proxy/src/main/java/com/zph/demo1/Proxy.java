package com.zph.demo1;

public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void introduceHouse(){
        System.out.println("看房");
    }

    public void rent() {
      host.rent();
    }

    public void contract(){
        System.out.println("签合同");
    }

    public void fare(){
        System.out.println("收取中介费");
    }


}
