package com.backend.gestionempleados.controlador;


import com.backend.gestionempleados.modelo.Empleado;
import com.backend.gestionempleados.repositorio.EmpleadoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoControlador {

    @Autowired
    private EmpleadoRepositorio repositorio;

    @GetMapping("/empleados")
    public List<Empleado> listarTodosEmpleados(){
        return this.repositorio.findAll();
    }
}
