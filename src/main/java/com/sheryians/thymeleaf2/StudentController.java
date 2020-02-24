package com.sheryians.thymeleaf2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sheryians.thymeleaf2.Student;

@Controller

public class StudentController {
	@Autowired
	StudentService std;

	@GetMapping("/")
	public String getAllStudents(Model model) {
		model.addAttribute("students", std.getAllStudents());
		return "home";
	}

	@GetMapping("/students/add")
	public String addStudent() {
//		  model.addAttribute("newStudent",std.addStudent(student));
		return "add";

	}

	@GetMapping("/delete/{rollno}")
	public String deleteStudent(@PathVariable int rollno) {
		std.removeStudent(rollno);
		return "redirect:/";
	}

	@PostMapping("/register")
	public String updateStudent(@ModelAttribute(name = "student") Student student) {
		std.addStudent(student);
		return "redirect:/";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute(name = "student") Student student) {
		std.updateStudent(student, student.getRollNo());
		return "redirect:/";
	}

	@GetMapping("update/{rollno}")
	public String updateStudentt(Model model, @PathVariable int rollno) {
		model.addAttribute("student", std.getStudent(rollno));
		return "update";
	}

}
