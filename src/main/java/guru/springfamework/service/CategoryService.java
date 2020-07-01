package guru.springfamework.service;


import guru.springfamework.api.v1.model.CategoryDTO;

import java.util.List;

/**
 * Juerghens castro on 07-01-20 and  10:07 AM to 2020
 */
public interface CategoryService {

    List<CategoryDTO> getAllCateoories();
    CategoryDTO getCategoryByName(String name);

}
