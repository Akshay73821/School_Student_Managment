package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index";
    }

//    @GetMapping("/showNewStudentForm")
//    public String showNewStudentForm(Model model) {
//        Student student = new Student();
//        model.addAttribute("student", student);
//        return "new_student";
//    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm1(Model model) {
        System.out.println("Entering showNewStudentForm method");
        Student student = new Student();
        model.addAttribute("student", student);
        System.out.println("Exiting showNewStudentForm method");
        return "new_student";
    }

//    @PostMapping("/saveStudent")
//    public String saveStudent1(@ModelAttribute("student") Student student) {
//        System.out.println("Entering saveStudent method");
//        System.out.println("Student to save: " + student);
//        studentService.saveStudent(student);
//        System.out.println("Student saved successfully");
//        return "redirect:/";
//    }
}