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


}
