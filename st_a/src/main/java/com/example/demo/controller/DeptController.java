package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.DeptDAO_JPA;
import com.example.demo.dao.DeptDAO_MB;
import com.example.demo.entity.Dept;

import lombok.Setter;

@Controller
@Setter
public class DeptController {
	@Autowired
	private DeptDAO_JPA dao_JPA;
	@Autowired
	private DeptDAO_MB dao_MB;
	
	@GetMapping("/dept/insert")
	public void insert() {
	}
	
	
	@PostMapping("/dept/insert")
	public String insert(Dept d) {
		dao_JPA.save(d);
		return "redirect:/dept/list";
	}
	
	
	@GetMapping("/dept/list")
	public void list(Model model) {
		model.addAttribute("list", dao_JPA.findAll());
	}
	
	@GetMapping("/dept/detail/{dno}")
	public String detail(@PathVariable("dno") int dno, Model model) {
		model.addAttribute("d", dao_MB.findByDno(dno));
		return "/dept/detail";
	}
	
	
	
}








