package com.example.proyIntegradorFinal.controller;

import com.example.proyIntegradorFinal.dto.TurnoDto;
import com.example.proyIntegradorFinal.exceptions.BadRequestException;
import com.example.proyIntegradorFinal.exceptions.ResourceNotFoundException;
import com.example.proyIntegradorFinal.model.Paciente;
import com.example.proyIntegradorFinal.model.Turno;
import com.example.proyIntegradorFinal.service.PacienteService;
import com.example.proyIntegradorFinal.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
public class TurnoController {
    private final TurnoService turnoService;

    @GetMapping("/turnos")
    public List<Turno> listarTurnos(){
        return turnoService.listarTurnos();
    }

    @GetMapping("/turnos/{id}")
    public Turno getById(@PathVariable Integer id) throws ResourceNotFoundException {
        return turnoService.buscarTurno(id);
    }

    @PostMapping("/turnos/agregar")
    public void agregarTurno(@RequestBody TurnoDto turnoDto) throws ResourceNotFoundException {
        turnoService.agregarDTO(turnoDto);
    }

    @DeleteMapping("/turnos/borrar/{id}")
    public void eliminarTurno(@RequestBody Integer id) throws ResourceNotFoundException {
        turnoService.borrarTurno(id);
    }

    @PutMapping("/turnos/actualizar")
    public void actualizarTurno(@RequestBody Turno turno) throws ResourceNotFoundException {
        turnoService.actualizarTurno(turno);
    }

}
