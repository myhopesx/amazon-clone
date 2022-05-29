package com.example.amazonclone.service;


import com.example.amazonclone.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {


     ArrayList<User> users = new ArrayList<>();

     public ArrayList<User> getAllUser() {
          return this.users;
     }

     public boolean addUser(User user) {
          return users.add(user);
     }

     public boolean updateUser(User user) {
          if (users.set(getUser(user.getId()), user) != null) {
               return true;
          }
          return false;
     }

     public boolean deleteUser(String id) {
          Integer index = getUser(id);

          if (index == null) {
               return false;
          }

          users.remove((int) index);
          return true;
     }

     public Integer getUser(String id) {
          for (int i = 0; i < users.size(); i++) {
               if (users.get(i).getId().equals(id)) {
                    return i;
               }

          }
          return null;

     }
}
