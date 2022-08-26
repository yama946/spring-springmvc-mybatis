package com.mybatis.crud.testDemo;

/**
 * 接口之间可以继承而且支持多继承
 * 当父类实现了接口子类也就继承到父类实现的接口方法，也可以看作一个接口实现类，
 * 其子类可以添加关键字implements声明自己实现，也可以不添加，
 * 继承到的接口方法，与从父类直接继承普通方法相同，可以继续重写自定义。
 */
public class InterfaceTest {
    public static void main(String[] args) {
        SpeakEnglish test = new BasketBallPlayer();
    }
}
//学习说英语
interface SpeakEnglish {
    public abstract void speak();
}

//运动员
class Player extends Person implements SpeakEnglish{
    //学习
    public void study() {
        System.out.println("运动员爱学习");
    }

    public void speak() {
        System.out.println("我是运动员");
    }
}

class BasketBallPlayer extends Player{

    @Override
    public void study() {
        System.out.println("学扣篮");
    }

}
class Person {
    String name;//姓名
    int age;//年龄
    String gender;//性别

    //无参构造
    public Person() {}

    //有参构造
    public Person(String name,int age,String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //吃
    public void eat() {
        System.out.println("吃饭");
    }

    //睡
    public void sleep() {
        System.out.println("睡觉");
    }
}