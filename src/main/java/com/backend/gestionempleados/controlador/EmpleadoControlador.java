package com.backend.gestionempleados.controlador;


import com.backend.gestionempleados.modelo.Empleado;
import com.backend.gestionempleados.repositorio.EmpleadoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

   @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return repositorio.save(empleado);
   }

}
