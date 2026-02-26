package com.smartcampus.controller;

import com.smartcampus.model.Student;
import com.smartcampus.service.DepartmentService;
import com.smartcampus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * StudentController.java
 * URL base: /students
 */
@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired private StudentService    service;
    @Autowired private DepartmentService departmentService;

    // ── LIST ──────────────────────────────────────────────────────────────────
    @GetMapping("/list")
    public String list(@RequestParam(required = false) String search, Model model) {
        if (search != null && !search.isBlank()) {
            model.addAttribute("students", service.search(search));
            model.addAttribute("search", search);
        } else {
            model.addAttribute("students", service.getAll());
        }
        return "student/list";
    }

    // ── CREATE FORM ───────────────────────────────────────────────────────────
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student",     new Student());
        model.addAttribute("departments", departmentService.getAll());
        return "student/form";
    }

    // ── SAVE ──────────────────────────────────────────────────────────────────
    @PostMapping("/save")
    public String save(@ModelAttribute Student student, RedirectAttributes ra) {
        try {
            service.save(student);
            ra.addFlashAttribute("success", "Student registered successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/students/list";
    }

    // ── VIEW DETAIL ───────────────────────────────────────────────────────────
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Student s = service.getById(id);
        if (s == null) return "redirect:/students/list";
        model.addAttribute("student", s);
        return "student/view";
    }

    // ── EDIT FORM ─────────────────────────────────────────────────────────────
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Student s = service.getById(id);
        if (s == null) return "redirect:/students/list";
        model.addAttribute("student",     s);
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("editMode",    true);
        return "student/form";
    }

    // ── UPDATE ────────────────────────────────────────────────────────────────
    @PostMapping("/update")
    public String update(@ModelAttribute Student student, RedirectAttributes ra) {
        try {
            service.update(student);
            ra.addFlashAttribute("success", "Student updated successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/students/list";
    }

    // ── DELETE ────────────────────────────────────────────────────────────────
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("success", "Student record deleted.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "Cannot delete: " + e.getMessage());
        }
        return "redirect:/students/list";
    }
}

