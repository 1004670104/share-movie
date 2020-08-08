package com.cn.share.movie.web.designPattern.Builder;


class Director{
    private AbstractBuilder abstractBuilder;

    public Director(AbstractBuilder abstractBuilder){
        this.abstractBuilder = abstractBuilder;
    }

    public Product returnProduct(){
        abstractBuilder.buildA();
        abstractBuilder.buildB();
        abstractBuilder.buildC();
        return abstractBuilder.getProduct();
    }
}

abstract class AbstractBuilder{

    protected Product product = new Product();
    public abstract void buildA();
    public abstract void buildB();
    public abstract void buildC();

    public Product getProduct(){
        return product;
    }
}

class Builder1 extends AbstractBuilder{

    @Override
    public void buildA() {
        product.setPartA("A1");
    }

    @Override
    public void buildB() {
        product.setPartB("B1");
    }

    @Override
    public void buildC() {
        product.setPartC("C1");
    }
}

class Builder2 extends AbstractBuilder{

    @Override
    public void buildA() {
        product.setPartA("A2");
    }

    @Override
    public void buildB() {
        product.setPartB("B2");
    }

    @Override
    public void buildC() {
        product.setPartC("C2");
    }
}

class Product{
    private String partA;
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}

public class BuilderPattern {

    public static void main(String[] args) {
        Director director = new Director(new Builder1());
        Product product = director.returnProduct();
        System.out.println(product.toString());

    }
}
