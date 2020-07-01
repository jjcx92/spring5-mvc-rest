package guru.springfamework.api.v1.Mapper;

import guru.springfamework.api.v1.model.CategoryDTO;

/**
 * Juerghens castro on 07-01-20 and  08:55 AM to 2020
 */
@Mapper
public class CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(category category);
}
