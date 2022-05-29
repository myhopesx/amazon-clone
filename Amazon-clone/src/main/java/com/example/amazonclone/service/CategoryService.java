package com.example.amazonclone.service;

import com.example.amazonclone.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {


     ArrayList<Category> categories = new ArrayList<>();

     public ArrayList<Category> getAllCategory() {
          return this.categories;
     }

     public boolean addCategory(Category category) {
          return categories.add(category);
     }

     public boolean updateCategory(Category category) {
          if (categories.set(getCategory(category.getId()), category) != null) {
               return true;
          }
          return false;
     }

     public boolean deleteCategory(String id) {
          Integer index = getCategory(id);

          if (index == null) {
               return false;
          }

          categories.remove((int) index);
          return true;
     }

     public Integer getCategory(String id) {
          for (int i = 0; i < categories.size(); i++) {
               if (categories.get(i).getId().equals(id)) {
                    return i;
               }

          }
          return null;

     }
}
