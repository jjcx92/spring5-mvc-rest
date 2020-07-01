package guru.springfamework.service;

import guru.springfamework.api.v1.Mapper.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Juerghens castro on 07-01-20 and  10:14 AM to 2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";

    CategoryService categoryService;
    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);

    }


    @Test
    public void getAllCateoories() throws Exception{

        //given
        List<Category> categories = Arrays.asList(new Category(), new Category, new Category());

        when(categoryRepository.findAll()).thenReturn(categories);

        //when
        List<CategoryDTO> categoryDTOS=categoryService.getAllCateoories();

        //then
        assertEquals(3,categoryDTOS.size());


    }


    @Test
    public void getCategoryName() throws Exception {

        //given
        Category category= new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        //when
        CategoryDTO categoryDTO=categoryService.getCategoryByName(NAME);

        //then
        assertEquals(ID,categoryDTO.getId());
        assertEquals(NAME,categoryDTO.getName());

    }
}
