//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.smartcampus.controller;

import com.smartcampus.service.CourseService;
import com.smartcampus.service.DepartmentService;
import com.smartcampus.service.LecturerService;
import com.smartcampus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping({"/dashboard"})
    public String home(Model model) {
        model.addAttribute("studentCount", this.studentService.count());
        model.addAttribute("lecturerCount", this.lecturerService.count());
        model.addAttribute("courseCount", this.courseService.count());
        model.addAttribute("departmentCount", this.departmentService.count());
        return "home";
    }
}
