package com.backend.gestionempleados.controlador;


import com.backend.gestionempleados.excepciones.ResourceNotFoundException;
import com.backend.gestionempleados.modelo.Empleado;
import com.backend.gestionempleados.repositorio.EmpleadoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){

        Empleado empleado = repositorio.findById(id).orElseThrow(
                ()->    new ResourceNotFoundException("no existe el id "+id)
        );

        return ResponseEntity.ok(empleado);
    }


    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id,@RequestBody Empleado detallesEmpleado){

        Empleado empleado = repositorio.findById(id).orElseThrow(
                ()->    new ResourceNotFoundException("no existe el id "+id)
        );

        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEmail(detallesEmpleado.getEmail());


        Empleado empleadoActualizado = repositorio.save(empleado);

        return ResponseEntity.ok(empleadoActualizado);
    }



}
