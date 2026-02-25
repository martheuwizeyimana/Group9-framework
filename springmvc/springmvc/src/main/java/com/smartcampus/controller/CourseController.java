package com.smartcampus.controller;

import com.smartcampus.model.Course;
import com.smartcampus.service.CourseService;
import com.smartcampus.service.DepartmentService;
import com.smartcampus.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * CourseController.java
 * URL base: /courses
 */
@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired private CourseService     service;
    @Autowired private DepartmentService departmentService;
    @Autowired private LecturerService   lecturerService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("courses", service.getAll());
        return "course/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("course",      new Course());
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("lecturers",   lecturerService.getAll());
        return "course/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Course course, RedirectAttributes ra) {
        try {
            service.save(course);
            ra.addFlashAttribute("success", "Course created successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/courses/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Course c = service.getById(id);
        if (c == null) return "redirect:/courses/list";
        model.addAttribute("course", c);
        return "course/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Course c = service.getById(id);
        if (c == null) return "redirect:/courses/list";
        model.addAttribute("course",      c);
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("lecturers",   lecturerService.getAll());
        model.addAttribute("editMode",    true);
        return "course/form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Course course, RedirectAttributes ra) {
        try {
            service.update(course);
            ra.addFlashAttribute("success", "Course updated successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/courses/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("success", "Course deleted.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "Cannot delete: " + e.getMessage());
        }
        return "redirect:/courses/list";
    }
}
