package org.launchcode.mealplanner.models.data;

import org.launchcode.mealplanner.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserDoa extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
