package com.cn.share.movie.web.designPattern.Factory;
// 工厂接口
interface AbstractFactory{
    AbstractProduct createProduct();
}

class Factory1 implements AbstractFactory{

    @Override
    public AbstractProduct createProduct() {
        AbstractProduct abstractProduct = new Product1();
        return abstractProduct;
    }
}

class Factory2 implements AbstractFactory{

    @Override
    public AbstractProduct createProduct() {
        AbstractProduct abstractProduct = new Product2();
        return abstractProduct;
    }
}

// 产品接口
interface AbstractProduct{
    void showProduct();
}

class Product1 implements AbstractProduct{

    @Override
    public void showProduct() {
        System.out.println("product1");
    }
}

class Product2 implements AbstractProduct{

    @Override
    public void showProduct() {
        System.out.println("product2");
    }
}

public class FactoryPattern {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new Factory1();
        AbstractProduct abstractProduct = abstractFactory.createProduct();
        abstractProduct.showProduct();
    }
}
