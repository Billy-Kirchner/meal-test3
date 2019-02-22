/*package org.launchcode.mealplanner;

import org.launchcode.mealplanner.controllers.AbstractController;
import org.launchcode.mealplanner.models.User;
import org.launchcode.mealplanner.models.data.UserDoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserDoa userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //Allowed to see these pages without being logged in
        List<String> publicPages = Arrays.asList("/login", "/register");

        //Requires login for other pages
        if (!publicPages.contains(request.getRequestURL())) {

            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                User user = userDao.findById(userId).orElse(null);

                if (user != null) {
                    return true;
                }
            }

            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}*/
