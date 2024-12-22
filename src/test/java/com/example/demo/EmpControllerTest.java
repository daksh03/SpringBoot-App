package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.example.controller.EmpController;
import com.example.entity.Employee;
import com.example.repository.UserRepository;
import com.example.service.EmpService;

@WebMvcTest(EmpController.class)

public class EmpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpService empService;

    @MockBean
    private  UserRepository userRepository;

    @Test
    void testHome() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/login"));
    }

    @Test
    void testAddEmpForm() throws Exception{
        mockMvc.perform(get("/addemp"))
               .andExpect(status().isOk())
               .andExpect(view().name("add_emp"));
    }

   @Test
void testRegister() throws Exception {
    
    mockMvc.perform(post("/register") 
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                    .param("id", "123") 
                    .param("name", "Daksh")
                    .param("address", "Choudhary Puram")
                    .param("email", "Daksh@gmail.com")
                    .param("phno", "9876543210")
                    .param("salary", "246000")) 
            .andExpect(status().is3xxRedirection())
            .andExpect(flash().attribute("msg", "Emp Data Update Sucessfully.."))
            .andExpect(redirectedUrl("/page"));

    verify(empService, times(1)).addEmp(any(Employee.class));
}
    
}
