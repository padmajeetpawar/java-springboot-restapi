package com.springboot.webservices.restfulwebservices.user;

import jdk.dynalink.beans.StaticClass;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    public static List<User> userDetails = new ArrayList();
    static {
        userDetails.add(new User(1, "Padmajeet", "04/24/1994"));
        userDetails.add(new User(2, "Priyanka", "01/15/1996"));
    }
    private static int userIdCount = 2;

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
