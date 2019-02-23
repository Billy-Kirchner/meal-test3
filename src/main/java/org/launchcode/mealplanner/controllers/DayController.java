package org.launchcode.mealplanner.controllers;


import org.launchcode.mealplanner.models.Day;
import org.launchcode.mealplanner.models.Meal;
import org.launchcode.mealplanner.models.data.DayDao;
import org.launchcode.mealplanner.models.data.MealDao;
import org.launchcode.mealplanner.models.forms.BuildDayForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("day")
public class DayController extends AbstractController{

/*    @Autowired
    private DayDao dayDao;

    @Autowired
    private MealDao mealDao;*/

    @RequestMapping(value = "")
    public String index (Model model) {

        model.addAttribute("title", "Day Planner");
        model.addAttribute("days", dayDao.findAll());

        return "day/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String displayCreateDayForm(Model model) {

        model.addAttribute("title", "Create New Day");
        model.addAttribute(new Day());

        return "day/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String processCreateDayForm(@ModelAttribute @Valid Day newDay, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create New Day");
            return "day/create";
        }

        dayDao.save(newDay);



        return "redirect:/day/build/" + newDay.getId();
    }

    @RequestMapping(value = "build/{id}", method = RequestMethod.GET)
    public String displayBuildDayForm (Model model, @PathVariable (value = "id") int id) {
        BuildDayForm buildDayForm = new BuildDayForm(dayDao.findById(id).orElse(null), mealDao.findAll());

        model.addAttribute("form", buildDayForm);
        model.addAttribute("title", "Plan Day: " + dayDao.findById(id).orElse(null).getName());

        return "day/build";
    }

    @RequestMapping(value = "build/{id}", method = RequestMethod.POST)
    public String processBuildDayForm (Model model, @ModelAttribute @ Valid BuildDayForm form, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Plan Day: " + dayDao.findById(form.getDayId()).orElse(null).getName());

            return "day/build";
        }

        Meal newMeal = mealDao.findById(form.getMealId()).orElse(null);
        Day currentDay = dayDao.findById(form.getDayId()).orElse(null);

        currentDay.addMeal(newMeal);
        currentDay.calculateTotals();

        dayDao.save(currentDay);

        return "redirect:/day/build/" + currentDay.getId();
    }

    @RequestMapping(value = "build/remove-meal/{id}", method = RequestMethod.POST)
    public String removeComponentFromMeal(Model model, @PathVariable(value="id") int id, @ModelAttribute @Valid BuildDayForm form) {


        Meal discardedMeal = mealDao.findById(id).orElse(null);
        Day currentDay = dayDao.findById(form.getDayId()).orElse(null);

        currentDay.removeMeal(discardedMeal);
        currentDay.calculateTotals();
        dayDao.save(currentDay);

        return "redirect:/day/build/" + currentDay.getId();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteDay( Model model, @PathVariable(value ="id") int id) {

        model.addAttribute("day", dayDao.findById(id).orElse(null));

       dayDao.deleteById(id);

        return "day/delete";
    }


}
