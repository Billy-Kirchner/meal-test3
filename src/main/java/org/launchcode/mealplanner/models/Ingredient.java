package org.launchcode.mealplanner.models;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Ingredient extends AbstractEntity{

/*    @Id
    @GeneratedValue
    private int id;*/

    @NotNull
    @Size(min=3, max=30, message = "Name must be between 3 and 30 characters")
    private String name;
    @NotNull
    private double calories;
    @NotNull
    private double saturatedFat;
    @NotNull
    private double polyUnsaturatedFat;
    @NotNull
    private double monoUnsaturatedFat;
    @NotNull
    private double transFat;
    private double totalFat;
    @NotNull
    private double cholesterol;
    @NotNull
    private double sodium;
    @NotNull
    private double potassium;
    @NotNull
    private double totalCarbohydrate;
    @NotNull
    private double dietaryFiber;
    @NotNull
    private double sugar;
    private double netCarbohydrate;
    @NotNull
    private double protein;

/*    @ManyToMany(mappedBy = "ingredients")
    private List<Meal> meals;*/

/*    @OneToMany
    private List<Component> components = new ArrayList<>();*/

    public Ingredient (String name, double calories, double saturatedFat, double polyUnsaturatedFat, double monoUnsaturatedFat, double transFat,
                       double cholesterol, double sodium, double potassium, double totalCarbohydrate, double dietaryFiber, double sugar, double protein) {
        this.name =  name;
        this.calories = calories;
        this.saturatedFat = saturatedFat;
        this.polyUnsaturatedFat = polyUnsaturatedFat;
        this.monoUnsaturatedFat = monoUnsaturatedFat;
        this.transFat = transFat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.potassium = potassium;
        this.totalCarbohydrate = totalCarbohydrate;
        this. dietaryFiber = dietaryFiber;
        this. sugar = sugar;
        this.protein = protein;
    }

    public Ingredient () { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public double getPolyUnsaturatedFat() {
        return polyUnsaturatedFat;
    }

    public void setPolyUnsaturatedFat(double polyUnsaturatedFat) {
        this.polyUnsaturatedFat = polyUnsaturatedFat;
    }

    public double getMonoUnsaturatedFat() {
        return monoUnsaturatedFat;
    }

    public void setMonoUnsaturatedFat(double monoUnsaturatedFat) {
        this.monoUnsaturatedFat = monoUnsaturatedFat;
    }

    public double getTransFat() {
        return transFat;
    }

    public void setTransFat(double transFat) {
        this.transFat = transFat;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    public void setTotalCarbohydrate(double totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    public double getDietaryFiber() {
        return dietaryFiber;
    }

    public void setDietaryFiber(double dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public double getNetCarbohydrate() {
        return netCarbohydrate;
    }

/*    public int getId() {
        return id;
    }*/

    public void calculateTotalFat () {
        totalFat = saturatedFat+polyUnsaturatedFat+monoUnsaturatedFat+transFat;
    }

    public void calculateNetCarbohydrate () {

       if ((totalCarbohydrate - dietaryFiber - sugar) < 0) {
           netCarbohydrate = 0;
       }
       else {
           netCarbohydrate = totalCarbohydrate - dietaryFiber - sugar;
       }

    }

}
