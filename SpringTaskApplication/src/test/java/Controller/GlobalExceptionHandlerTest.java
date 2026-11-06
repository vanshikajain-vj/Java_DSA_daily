package Controller;

import Exception.GlobalExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class GlobalExceptionHandlerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders
                .standaloneSetup(new RequestDemoController())
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void shouldReturn404WhenEmployeeNotFound() throws Exception {

        mockMvc.perform(get("/demo/error/101"))

                .andExpect(status().isNotFound())

                .andExpect(content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_PROBLEM_JSON))

                .andExpect(content().json("""
                        {
                            "type": "about:blank",
                            "title": "Employee Not Found",
                            "status": 404,
                            "detail": "Employee with ID 101 does not exist",
                            "instance": "/demo/error/101"
                        }
                        """, true));
    }

    @Test
    void shouldReturn500ForUnexpectedError() throws Exception {

        mockMvc.perform(get("/demo/server-error"))

                .andExpect(status().isInternalServerError())

                .andExpect(content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_PROBLEM_JSON))

                .andExpect(content().json("""
                        {
                            "type": "about:blank",
                            "title": "Internal Server Error",
                            "status": 500,
                            "detail": "Something went wrong",
                            "instance": "/demo/server-error"
                        }
                        """, true));
    }
}