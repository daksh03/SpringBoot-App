package com.example.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmpRepo;
import com.example.util.EmailUtils;
@Service
public class EmpService {
	@Autowired
	private EmpRepo repo;
	
	@Autowired
	private EmailUtils emailUtils;

	public void addEmp(Employee e, String action) {
		repo.save(e);
		if(action.equals("register")) {
			emailUtils.sendEmail(e.getEmail(), "Your Details were added to WorkForce", "New User Registered");
		} else {
			emailUtils.sendEmail(e.getEmail(), "Your Details were edited to WorkForce", "Edited Usaer Details");
		}
	}

	public List<Employee> getAllEmp() {
		return repo.findAll();
	}

	public Employee getEMpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEMp(int id) {
		repo.deleteById(id);
	}

	public Page<Employee> getEMpByPaginate(int currentPage, int size) {
		Pageable p = PageRequest.of(currentPage, size);
		return repo.findAll(p);
	}

}
