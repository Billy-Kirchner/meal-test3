package org.launchcode.mealplanner.models;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Meal extends AbstractEntity{

/*    @Id
    @GeneratedValue
    private int id;*/

    @NotNull
    @Size(min=3, max=30,message= "Name must be between 3 and 30 characters")
    private String name;

    @OneToMany
    private List<Component> components = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

/*    @ManyToMany
    private List<Ingredient> ingredients;*/

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

    @ManyToMany(mappedBy = "meals")
    private List<Day> days;

    public Meal (String name) {
        this.name = name;

    }

    public Meal () {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public HashMap<Ingredient, Double> getComponents() {
        return components;
    }

    public void setComponents(HashMap<Ingredient, Double> components) {
        this.components = components;
    }*/


    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
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

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public double getPolyUnsaturatedFat() {
        return polyUnsaturatedFat;
    }

    public double getMonoUnsaturatedFat() {
        return monoUnsaturatedFat;
    }

    public double getTransFat() {
        return transFat;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public double getSodium() {
        return sodium;
    }

    public double getPotassium() {
        return potassium;
    }

    public double getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    public double getDietaryFiber() {
        return dietaryFiber;
    }

    public double getSugar() {
        return sugar;
    }

    public double getNetCarbohydrate() {
        return netCarbohydrate;
    }

    public double getProtein() {
        return protein;
    }

/*    public void addIngredient (Ingredient ingredient) {
        ingredients.add(ingredient);
    }*/

    public void addComponent (Component component) {
        components.add(component);
    }

    public void removeComponent (Component component) {
        components.remove(component);
    }


    public void calculateTotals () {
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



/*        for( Ingredient ingredient : ingredients) {
            calories += ingredient.getCalories();
            saturatedFat += ingredient.getSaturatedFat();
            polyUnsaturatedFat += ingredient.getPolyUnsaturatedFat();
            monoUnsaturatedFat += ingredient.getMonoUnsaturatedFat();
            transFat += ingredient.getTransFat();
            totalFat += ingredient.getTotalFat();
            cholesterol += ingredient.getCholesterol();
            sodium += ingredient.getSodium();
            potassium += ingredient.getPotassium();
            totalCarbohydrate += ingredient.getTotalCarbohydrate();
            dietaryFiber += ingredient.getDietaryFiber();
            sugar += ingredient.getSugar();
            netCarbohydrate += ingredient.getNetCarbohydrate();
            protein += ingredient.getProtein();
        }*/

        for( Component component : components) {
            Ingredient ingredient = component.getIngredient();
            Double servings = component.getServings();

/*            calories += ingredient.getCalories();
            saturatedFat += ingredient.getSaturatedFat();
            polyUnsaturatedFat += ingredient.getPolyUnsaturatedFat();
            monoUnsaturatedFat += ingredient.getMonoUnsaturatedFat();
            transFat += ingredient.getTransFat();
            totalFat += ingredient.getTotalFat();
            cholesterol += ingredient.getCholesterol();
            sodium += ingredient.getSodium();
            potassium += ingredient.getPotassium();
            totalCarbohydrate += ingredient.getTotalCarbohydrate();
            dietaryFiber += ingredient.getDietaryFiber();
            sugar += ingredient.getSugar();
            netCarbohydrate += ingredient.getNetCarbohydrate();
            protein += ingredient.getProtein();*/

            calories += (ingredient.getCalories() * servings);
            saturatedFat += (ingredient.getSaturatedFat() * servings);
            polyUnsaturatedFat += (ingredient.getPolyUnsaturatedFat() * servings);
            monoUnsaturatedFat += (ingredient.getMonoUnsaturatedFat() * servings);
            transFat += (ingredient.getTransFat() * servings);
            totalFat += (ingredient.getTotalFat() * servings);
            cholesterol += (ingredient.getCholesterol() * servings);
            sodium += (ingredient.getSodium() * servings);
            potassium += (ingredient.getPotassium() * servings);
            totalCarbohydrate += (ingredient.getTotalCarbohydrate() * servings);
            dietaryFiber += (ingredient.getDietaryFiber() * servings);
            sugar += (ingredient.getSugar() * servings);
            netCarbohydrate += (ingredient.getNetCarbohydrate() * servings);
            protein += (ingredient.getProtein() * servings);
        }

/*        Iterator it = components.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            calories += (pair.getKey().getCalories * pair.getValue());
            saturatedFat += (pair.getKey().getSaturatedFat * pair.getValue());
        }*/


    }
}
