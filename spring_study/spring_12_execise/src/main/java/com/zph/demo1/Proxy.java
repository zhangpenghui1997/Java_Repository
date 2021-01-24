package com.zph.demo1;

public class Proxy implements Rent {
    private Host host;

    public void setHost(Host host) {
        this.host = host;
    }

    public  void lookHouse(){
        System.out.println("看房子");
    }
    public void rent() {
        lookHouse();
        host.rent();
        contract();
        fee();
    }
    public void contract(){
        System.out.println("签合同");
    }
    public void fee(){
        System.out.println("收取中介费");
    }
}
