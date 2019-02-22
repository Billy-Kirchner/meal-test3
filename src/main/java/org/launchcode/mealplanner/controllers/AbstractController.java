package org.launchcode.mealplanner.controllers;

import org.launchcode.mealplanner.models.User;
import org.launchcode.mealplanner.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AbstractController {

    @Autowired
    protected UserDoa userDoa;

    @Autowired
    protected IngredientDao ingredientDao;

    @Autowired
    protected ComponentDao componentDao;

    @Autowired
    protected MealDao mealDao;

    @Autowired
    protected DayDao dayDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDoa.findById(userId).orElse(null);
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    @ModelAttribute("user")
    public User getUserForModel(HttpServletRequest request) {
        return getUserFromSession(request.getSession());
    }


}
