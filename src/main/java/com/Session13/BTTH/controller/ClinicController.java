package com.Session13.BTTH.controller;

import com.Session13.BTTH.model.Appointment;
import com.Session13.BTTH.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    private AppointmentService service;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("appointments", service.getWaitingList());
        model.addAttribute("newAppointment", new Appointment());
        return "clinic-page";
    }

    @PostMapping("/add")
    public String addAppointment(@Valid @ModelAttribute("newAppointment") Appointment a,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("appointments", service.getWaitingList());
            return "clinic-page";
        }
        service.addAppointment(a);
        return "redirect:/clinic/list";
    }

    @GetMapping("/call/{id}")
    public String callPatient(@PathVariable Long id) {
        service.callPatient(id);
        return "redirect:/clinic/list";
    }
}
