package com.greatlearning.studentregistrationapplication.controller;

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
import com.greatlearning.studentregistrationapplication.model.Student;
import com.greatlearning.studentregistrationapplication.repository.StudentRepository;
import com.greatlearning.studentregistrationapplication.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@RequestMapping("/list")
	public String listStudent(Model model)
	{
		List<Student> studentlist = studentService.getAllStudent();	
		model.addAttribute("Students", studentlist);
		return "list_students";
		
	}
	
	@RequestMapping("/showFormForAdd")
	public String ShowForm(Model model)
	{
		Student student = new Student();
		model.addAttribute("Student", student);
		return "student_form";
	}


	
	@PostMapping("/save")
	public String ShowFormSave(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("country") String country, @RequestParam("course") String course)
	{
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setCourse(course);
		student.setCountry(country);
		studentService.saveRecord(student);
		return "redirect:/student/list";
	}

	
	
	
	
	@GetMapping("/students/edit/{id}")
	public String UpdateEmployee(Model model, @PathVariable("id") int id)
	{
		Student student = studentService.getStudentById(id);
		model.addAttribute("employee", student);
		return "student_form";
	}
	
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		studentService.deleteStudentById(id);
		return "redirect:/list";
	}

	@PostMapping("/list")
	public String saveNewStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveOrUpdate(student);
		return "redirect:/list";
	}
}







