package com.example.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.Employee;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.EmpService;

@Controller

public class EmpController {
	@Autowired
	private EmpService service;

	public int setlog=0;

	@GetMapping(value={"/","/home"})
	public String home() {
		return "redirect:/login";
	}
	@GetMapping("/home1")
	public String home2(Model m) {
		if(setlog==1)
		{
			return "home";
		}
		else
		{
			return "redirect:/login";
		}
	}
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,RedirectAttributes redirectAttributes) {//, HttpSession session) {
		String action = "register";
		service.addEmp(e, action);
		redirectAttributes.addFlashAttribute("msg", "Emp Data Update Sucessfully..");	
		return "redirect:/page";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		if(setlog==1)
		{
		Employee e = service.getEMpById(id);
		m.addAttribute("emp", e);
		return "edit";
		}
		else
		{
			return "redirect:/login";
		}
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,Model m) {
		String action = "Update";
		service.addEmp(e, action);
		m.addAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/page";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id,Model m) {
		
		Employee emp = service.getEMpById(id);
		service.deleteEMp(id, emp);
		m.addAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/page";
	}

	@RequestMapping("/page")
	public String findPaginated( Model m) {
		if(setlog==1)
		{
		List<Employee> employeeList=service.getAllEmp();
		m.addAttribute("emp",employeeList);
		return "index";
		}
		{
			return "redirect:/login";
		}
	}
	
	@Autowired
	private UserRepository userRepository;
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	@GetMapping("/signup")
	public String showSignupForm(Model m) {
		setlog=0;
		return "signup";
	}
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user){
		userRepository.save(user);
		return "login";
		
	}
	@GetMapping("/login")
	public String loginForm(Model m) {
		
		return "login";
	}
	
	@PostMapping("/index")
	public String login(@RequestParam String username, @RequestParam String password) {
		User u=userRepository.findByUsername(username);
		if(u!=null) {
			
			System.out.println(u.getUsername()+" "+u.getPassword());
			if(password.equals(u.getPassword()))
			{
				setlog=1;
				return "redirect:/home1";
			}
			else
			{
				
				return "login";
			}
		}
		else {
			return "login";
		}
	}
	
}

