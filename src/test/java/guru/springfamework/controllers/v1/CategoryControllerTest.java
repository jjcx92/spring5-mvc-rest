package guru.springfamework.controllers.v1;

import com.sun.java.swing.plaf.motif.MotifEditorPaneUI;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.service.CategoryService;
import guru.springfamework.service.ResourceNotFoundException;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Juerghens castro on 07-02-20 and  06:05 AM to 2020
 */


public class CategoryControllerTest {

    public static final String NAME = "Jim";

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        //mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler()).build();
    }


    @Test
    public void getAllCategories() throws Exception {
        //given
        CategoryDTO category1 = new CategoryDTO();
        category1.setId(1L);
        category1.setName(NAME);
        CategoryDTO category2 = new CategoryDTO();
        category2.setId(2L);
        category2.setName("noob");

        List<CategoryDTO> categories = Arrays.asList(category1, category2);

        //when
        when(categoryService.getAllCategories()).thenReturn(categories);

        //then
        //se utiliza la constante del controlador customer que contiene la url de la API
        mockMvc.perform(get(CategoryController.BASE_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories", hasSize(2)));


    }

    @Test
    public void getCategoryByName() throws Exception {

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName(NAME);

        when(categoryService.getCategoryByName(anyString())).thenReturn(categoryDTO);

        //then
        //mockMvc.perform(get("/api/v1/categories/Jim")
        mockMvc.perform(get(CategoryController.BASE_URL + "Jim")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", equalTo(NAME)));

    }

    @Test
    public void testGetByNameNotFound() throws Exception {

        when(categoryService.getCategoryByName(anyString())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get(CategoryController.BASE_URL + "/Foo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());


    }

}

