package com.example.demo.controller;

import com.example.demo.model.Habitacion;
import com.example.demo.service.HabitacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionServicio;
    
}