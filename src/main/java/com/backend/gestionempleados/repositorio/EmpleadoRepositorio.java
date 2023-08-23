package com.backend.gestionempleados.repositorio;

import com.backend.gestionempleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado,Long> {

}
