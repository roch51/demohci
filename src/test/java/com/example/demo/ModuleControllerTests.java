package com.example.demo;

import com.example.demo.controllers.ModuleController;
import com.example.demo.dto.ModuleByUserDto;
import com.example.demo.repositories.UserModuleRepository;
import com.example.demo.services.ModuleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ModuleController.class)
//@SpringBootTest(classes = {DemoApplication.class,ModuleController.class})
public class ModuleControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserModuleRepository userModuleRepository;

    @MockBean
    private ModuleService moduleService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void find_module_by_user1_return_ok() throws Exception {
        String uri = "/api/v1/module/1";

        mockMvc.perform(get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void find_module_by_user1_return_modules() throws Exception {
        String uri = "/api/v1/module/1";

        Long userId = 1L;
        List<ModuleByUserDto> modules = userModuleRepository.findByUserId(userId);

        HashMap<String, Object> response = new HashMap<>();
        response.put("modules", modules);

        given(moduleService.findByUserId(userId)).willReturn(response) ;

        MvcResult result = mockMvc.perform(get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(response)))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString() ;
        assertThat(objectMapper.writeValueAsString(response)).isEqualToIgnoringWhitespace(actualResponse) ;

    }
}
