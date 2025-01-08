package com.example.controller;
//import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.security.crypto.password.PasswordEncoder;
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
//import org.springframework.stereotype.Controller;

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
		service.addEmp(e);
		//session.setAttribute("msg", "Emplyoee Added Sucessfully..");
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
	public String updateEmp(@ModelAttribute Employee e,Model m) {//, HttpSession session) {
		service.addEmp(e);
		//session.setAttribute("msg", "Emp Data Update Sucessfully..");
		m.addAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/page";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id,Model m) {//, HttpSession session) {

		service.deleteEMp(id);
		//session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		m.addAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/page";
	}

	@RequestMapping("/page")
	public String findPaginated( Model m) {
		if(setlog==1)
		{
		List<Employee> employeeList=service.getAllEmp();
		m.addAttribute("emp",employeeList);
		/*
		 * Page<Employee> emplist = service.getEMpByPaginate(pageno, 2);
		 * m.addAttribute("emp", emplist); m.addAttribute("currentPage", pageno);
		 * m.addAttribute("totalPages", emplist.getTotalPages());
		 * m.addAttribute("totalItem", emplist.getTotalElements());
		 */
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
	public String signup(@ModelAttribute User user){//@RequestParam String username,@RequestParam String password) {
		//User user=new User(username,password);
		//user.setUsername(username);
		//user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		return "login";
		
	}
	@GetMapping("/login")
	public String loginForm(Model m) {
		
		return "login";
	}
	
	@PostMapping("/index")
	public String login(@RequestParam String username, @RequestParam String password) {
		//System.out.println(username+" "+password);
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

