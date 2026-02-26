package com.smartcampus.controller;

import com.smartcampus.model.Lecturer;
import com.smartcampus.service.DepartmentService;
import com.smartcampus.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * LecturerController.java
 * URL base: /lecturers
 */
@Controller
@RequestMapping("/lecturers")
public class LecturerController {

    @Autowired private LecturerService   service;
    @Autowired private DepartmentService departmentService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("lecturers", service.getAll());
        return "lecturer/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("lecturer",    new Lecturer());
        model.addAttribute("departments", departmentService.getAll());
        return "lecturer/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Lecturer lecturer, RedirectAttributes ra) {
        try {
            service.save(lecturer);
            ra.addFlashAttribute("success", "Lecturer added successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/lecturers/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Lecturer l = service.getById(id);
        if (l == null) return "redirect:/lecturers/list";
        model.addAttribute("lecturer", l);
        return "lecturer/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Lecturer l = service.getById(id);
        if (l == null) return "redirect:/lecturers/list";
        model.addAttribute("lecturer",    l);
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("editMode",    true);
        return "lecturer/form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Lecturer lecturer, RedirectAttributes ra) {
        try {
            service.update(lecturer);
            ra.addFlashAttribute("success", "Lecturer updated successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/lecturers/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("success", "Lecturer record deleted.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "Cannot delete: " + e.getMessage());
        }
        return "redirect:/lecturers/list";
    }
}
