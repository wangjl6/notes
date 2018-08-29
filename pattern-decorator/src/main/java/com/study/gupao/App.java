package com.study.gupao;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Food food = new Food();
        System.out.println(food.getName()+"_"+food.getPrice());
        Food mFood = new Meat(food);
        System.out.println(mFood.getName()+"_"+mFood.getPrice());
        Food vFood = new Vegetables(mFood);
        System.out.println(vFood.getName()+"_"+vFood.getPrice());
        Food rFood = new Reic(vFood);
        System.out.println(rFood.getName()+"_"+rFood.getPrice());

    }
}
