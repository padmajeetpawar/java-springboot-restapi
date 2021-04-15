package com.springboot.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    public static List<User> userDetails = new ArrayList();
    private static int userIdCount = 0;

    public User findOne(@PathVariable Integer id) {
        for(User user : userDetails) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        if(user.getId() == null){
            user.setId(++userIdCount);
        }
        userDetails.add(user);
        return user;
    }


    public User deleteOneById(Integer id) {
        Iterator<User> itr = userDetails.iterator();
        while(itr.hasNext()) {
            User user = itr.next();
            if(user.getId() == id) {
                itr.remove();
                return user;
            }
        }
        return null;
    }

    public void deleteAll() {
        userDetails = new ArrayList();
    }
}
