package guru.springframework.api.v1.Mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Juerghens castro on 07-01-20 and  08:55 AM to 2020
 */
@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    //Mapping (source = "get_id", target="Id")
    CategoryDTO categoryToCategoryDTO(Category category);
}
