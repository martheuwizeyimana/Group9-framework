package com.smartcampus.controller;

import com.smartcampus.model.Department;
import com.smartcampus.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * DepartmentController.java
 *
 * URL base: /departments
 *
 * @Controller        - Spring MVC controller (returns view names)
 * @RequestMapping    - base URL prefix for all methods in this class
 * @GetMapping        - handles HTTP GET
 * @PostMapping       - handles HTTP POST
 * @PathVariable      - extracts {id} from the URL path
 * @ModelAttribute    - binds form fields automatically to a Java object
 * RedirectAttributes - passes flash messages after redirect
 */
@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    // ── LIST all departments ───────────────────────────────────────────────────
    // URL: GET /departments/list
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("departments", service.getAll());
        return "department/list";   // -> /WEB-INF/views/department/list.jsp
    }

    // ── SHOW create form ──────────────────────────────────────────────────────
    // URL: GET /departments/new
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("department", new Department()); // empty object for form binding
        return "department/form";   // -> /WEB-INF/views/department/form.jsp
    }

    // ── PROCESS create form ───────────────────────────────────────────────────
    // URL: POST /departments/save
    // Spring automatically maps form fields to Department object via @ModelAttribute
    @PostMapping("/save")
    public String save(@ModelAttribute Department department,
                       RedirectAttributes ra) {
        try {
            service.save(department);
            ra.addFlashAttribute("success", "Department created successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/departments/list";
    }

    // ── SHOW edit form ────────────────────────────────────────────────────────
    // URL: GET /departments/edit/3
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Department d = service.getById(id);
        if (d == null) return "redirect:/departments/list";
        model.addAttribute("department", d);
        model.addAttribute("editMode", true);
        return "department/form";
    }

    // ── PROCESS update ────────────────────────────────────────────────────────
    // URL: POST /departments/update
    @PostMapping("/update")
    public String update(@ModelAttribute Department department,
                         RedirectAttributes ra) {
        try {
            service.update(department);
            ra.addFlashAttribute("success", "Department updated successfully!");
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/departments/list";
    }

    // ── DELETE ────────────────────────────────────────────────────────────────
    // URL: GET /departments/delete/3
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("success", "Department deleted.");
        } catch (Exception e) {
            ra.addFlashAttribute("error", "Cannot delete: " + e.getMessage());
        }
        return "redirect:/departments/list";
    }
}

