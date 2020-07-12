package guru.springframework.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Juerghens castro on 07-04-20 and  08:37 AM to 2020
 */

public abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
