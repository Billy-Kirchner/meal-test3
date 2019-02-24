package org.launchcode.mealplanner.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Day extends AbstractEntity{

/*    @Id
    @GeneratedValue
    private int id;*/

    @NotNull
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
    private String name;

    @ManyToMany
    private List<Meal> meals;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double calories;
    private double saturatedFat;
    private double polyUnsaturatedFat;
    private double monoUnsaturatedFat;
    private double transFat;
    private double totalFat;
    private double cholesterol;
    private double sodium;
    private double potassium;
    private double totalCarbohydrate;
    private double dietaryFiber;
    private double sugar;
    private double netCarbohydrate;
    private double protein;

    public Day(String name) {
        this.name = name;
    }

    public Day() {

    }

/*    public int getId() {
        return id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
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

    public double getNetCarbohydrate() {
        return netCarbohydrate;
    }

    public void setNetCarbohydrate(double netCarbohydrate) {
        this.netCarbohydrate = netCarbohydrate;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void removeMeal(Meal meal) {
        meals.remove(meal);
    }

    public void calculateTotals() {
        calories = 0;
        saturatedFat = 0;
        polyUnsaturatedFat = 0;
        monoUnsaturatedFat = 0;
        transFat = 0;
        totalFat = 0;
        cholesterol = 0;
        sodium = 0;
        potassium = 0;
        totalCarbohydrate = 0;
        dietaryFiber = 0;
        sugar = 0;
        netCarbohydrate = 0;
        protein = 0;

        for (Meal meal : meals) {
            calories += meal.getCalories();
            saturatedFat += meal.getSaturatedFat();
            polyUnsaturatedFat += meal.getPolyUnsaturatedFat();
            monoUnsaturatedFat += meal.getMonoUnsaturatedFat();
            transFat += meal.getTransFat();
            totalFat += meal.getTotalFat();
            cholesterol += meal.getCholesterol();
            sodium += meal.getSodium();
            potassium += meal.getPotassium();
            totalCarbohydrate += meal.getTotalCarbohydrate();
            dietaryFiber += meal.getDietaryFiber();
            sugar += meal.getSugar();
            netCarbohydrate += meal.getNetCarbohydrate();
            protein += meal.getProtein();
        }

    }
}