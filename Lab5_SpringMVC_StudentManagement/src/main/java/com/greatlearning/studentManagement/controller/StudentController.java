package com.greatlearning.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentManagement.entity.Student;
import com.greatlearning.studentManagement.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String studentList(Model theModel) {

		List<Student> theStudents = studentService.findAll();

		theModel.addAttribute("students", theStudents);

		return "student-list";
	}

	@RequestMapping("/showFormForAdd")
	public String addStudent(Model theModel) {

		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String updateStudent(@RequestParam("studentId") int theId, Model theModel) {

		// get the student from the service
		Student theStudent = studentService.findById(theId);

		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(id);
		Student theStudent;
		// update student
		if(id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		// add student
		} else {
			theStudent = new Student(firstName, lastName, department, country);
		}

		// save the student
		studentService.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {

		// delete the student
		studentService.deleteById(theId);

		// redirect to /students/list
		return "redirect:/students/list";
	}

}
