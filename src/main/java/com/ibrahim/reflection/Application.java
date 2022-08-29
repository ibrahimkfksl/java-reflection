package com.ibrahim.reflection;

import com.ibrahim.reflection.animal.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] args) throws Exception{
        Cat myCat = new Cat("Şaziye",6);
        Field[] catFields = myCat.getClass().getDeclaredFields();

        //you can access field name in class
        for (Field field : catFields){
            System.out.println(field.getName());
        }

        //you can not set private field and this block throws illegal access exception
        /*
        for (Field field : fields){
            if(field.getName().equals("name")){
                field.set(myCat, "Duman");
            }
        }
        */

        //if you change private field accessible with java reflection, you can access and modified it
        for(Field field : catFields){
            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(myCat, "Duman");
                String typeValue = (String) field.get(myCat); //private field value
                System.out.println(typeValue);
            }
        }


        //you can access method in class
        Method[] declaredMethods = myCat.getClass().getDeclaredMethods();
        for (Method method : declaredMethods){
            System.out.println(method.getName());
        }

        //you can trigger method name in class
        for (Method method : declaredMethods){
            if (method.getName().equals("meow")){
                method.invoke(myCat); //any parameters on meow method
            }
        }

        //you can trigger private method in class
        for (Method method : declaredMethods){
            if (method.getName().equals("heyThisIsPrivate")){
                method.setAccessible(true);
                method.invoke(myCat);
            }
        }

        //you can trigger public static method in class
        for (Method method : declaredMethods){
            if (method.getName().equals("thisIsAPublicStaticMethod")){
                method.invoke(null);
            }
        }

        //you can trigger public static method in class
        for (Method method : declaredMethods){
            if (method.getName().equals("thisIsAPrivateStaticMethod")){
                method.setAccessible(true);
                method.invoke(null);
            }
        }



    }
}
