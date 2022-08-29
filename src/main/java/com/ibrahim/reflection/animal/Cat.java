package com.ibrahim.reflection.animal;

public class Cat {
    private final String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void meow(){
        System.out.println("meoww!!");
    }

    private void heyThisIsPrivate(){
        System.out.println("private method log");
    }

    public static void thisIsAPublicStaticMethod(){
        System.out.println("public static method log");
    }

    private static void thisIsAPrivateStaticMethod(){
        System.out.println("private static method log");
    }
}
