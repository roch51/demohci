package com.example.demo;

import com.example.demo.controllers.ModuleController;
import com.example.demo.services.ModuleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(ModuleController.class)
public class ModuleControllerTests {

    @Autowired
    private MockMvc mockMvc ;

    @MockBean
    private ModuleService moduleService ;


    @Test
    void find_module_by_user1() throws Exception {
        String uri = "/api/v1/module/1" ;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).
                accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
        .andReturn();


    }
}
