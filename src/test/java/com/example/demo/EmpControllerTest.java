package com.example.demo;

import com.example.controller.EmpController;
import com.example.entity.Employee;
import com.example.repository.UserRepository;
import com.example.service.EmpService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(EmpController.class)
public class EmpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpService empService;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private EmpController empController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @MockBean
    private EmpController empController;

    @Test
    void testHome() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/login"));
    }

    @Test
    void testAddEmpForm() throws Exception {
        mockMvc.perform(get("/addemp"))
               .andExpect(status().isOk())
               .andExpect(view().name("add_emp"));
    }

    @Test
    void testRegister() throws Exception {
        mockMvc.perform(post("/register")
                    .param("id", "123")
                    .param("name", "Daksh")
                    .param("address", "Choudhary Puram")
                    .param("email", "Daksh@gmail.com")
                    .param("phno", "9876543210")
                    .param("salary", "246000"))
            .andExpect(status().is3xxRedirection())
            .andExpect(flash().attribute("msg", "Emp Data Update Sucessfully.."))
            .andExpect(redirectedUrl("/page"));

<<<<<<< HEAD
    verify(empService, times(1)).addEmp(any(Employee.class));
}

@Test
void testEdit() throws Exception {
    mockMvc.perform(get("/edit/1"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/login"));
}

@Test
void testEdit1() throws Exception {
    empController.setlog = 1;
    Employee employee = new Employee();
    employee.setId(1);
    employee.setName("daksh");
    employee.setAddress("Choudhary Puram");
    employee.setEmail("Daksh@gmail.com");
    employee.setPhno("9876543210");
    employee.setSalary(246000);

    when(empService.getEMpById(1)).thenReturn(employee);

    mockMvc.perform(get("/edit/1"))
           .andExpect(status().isOk())
           .andExpect(view().name("edit"))
           .andExpect(model().attributeExists("emp"))
           .andExpect(model().attribute("emp", employee));
}
    
=======
        verify(empService, times(1)).addEmp(any(Employee.class));
    }

    @Test
    void testEdit_whenSetlogIs0() throws Exception {
        // Explicitly set setlog to 0
        empController.setlog = 0;

        mockMvc.perform(get("/edit/1"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/login"));
    }

    @Test
    void testEdit_whenSetlogIs1() throws Exception {
        // Explicitly set setlog to 1
        empController.setlog = 1;

        Employee employee = new Employee(1, "John Doe", "New York", "Doe@reddiffmail.com", "9876543210", 246000);
        when(empService.getEMpById(anyInt())).thenReturn(employee);

        mockMvc.perform(get("/edit/1"))
               .andExpect(status().isOk())
               .andExpect(view().name("edit"))
               .andExpect(model().attribute("emp", employee));
    }
>>>>>>> eeb225da2deb0b4560c7770de32ced483c6e1a4c
}
