package com.example.demo.controller;

import com.example.demo.model.Reserva;
import com.example.demo.service.ReservaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ReservaController {

    @Autowired
    private ReservaService reservaServicio;

    @Transactional
    @GetMapping("/reservas/id/{id}")
    public ResponseEntity<Reserva> getReservaId(@PathVariable("id") String idStr){
        Long id = Long.parseLong(idStr);
        Reserva reserva = reservaServicio.getReservabyId(id);
        if(reserva != null){
            return ResponseEntity.ok().body(reserva);
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @GetMapping("/reservas/nif/{nif}")
    public ResponseEntity<List<Reserva>> getReservasNif(@PathVariable("nif") String nif){
        List<Reserva> reservas = reservaServicio.getReservasbyNif(nif);
        return ResponseEntity.ok().body(reservas);
    }

    @Transactional
    @GetMapping("/reservas/destino/{destino}")
    public ResponseEntity<List<Reserva>> getReservasDestino(@PathVariable("destino") String destino){
        List<Reserva> reservas = reservaServicio.getReservasbyDestino(destino);
        return ResponseEntity.ok().body(reservas);
    }

    @Transactional
    @GetMapping("/reservas/hotel/{hotel}")
    public ResponseEntity<List<Reserva>> getReservasHotel(@PathVariable("hotel") String hotel){
        List<Reserva> reservas = reservaServicio.getReservasbyHotel(hotel);
        return ResponseEntity.ok().body(reservas);
    }

    @Transactional
    @GetMapping("/reservas/hotel-fecha/{hotel}/{fechaEntrada}")
    public ResponseEntity<List<Reserva>> getReservasHotelFechaEntrada(@PathVariable("hotel") String hotel,@PathVariable("fechaEntrada") String fechaEntradaStr){
        LocalDate fechaEntrada = LocalDate.parse(fechaEntradaStr);
        List<Reserva> reservas = reservaServicio.getReservasbyHotelFechaEntrada(hotel, fechaEntrada);
        return ResponseEntity.ok().body(reservas);
    }

    @Transactional
    @GetMapping("/reservas")
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> reservas = reservaServicio.getReservas();
        return ResponseEntity.ok().body(reservas);
    }

    @Transactional
    @GetMapping("/reservas/update/{id}/{hotel}/{destino}/{huespedes}/{habitaciones}/{fechaEntrada}/{fechaSalida}")
    public ResponseEntity<Reserva> updateReservaId(@PathVariable("id") String idStr,@PathVariable("hotel") String hotel,@PathVariable("destino") String destino,@PathVariable("huespedes") String huespedesStr,@PathVariable("habitaciones") String habitacionesStr,@PathVariable("fechaEntrada") String fechaEntradaStr,@PathVariable("fechaSalida") String fechaSalidaStr){
        Long id = Long.parseLong(idStr);
        Long huespedes = Long.parseLong(huespedesStr);
        Long habitaciones = Long.parseLong(habitacionesStr);
        LocalDate fechaEntrada = LocalDate.parse(fechaEntradaStr);
        LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr);
        Reserva reserva = reservaServicio.updateReservabyId(id, hotel, destino, huespedes, habitaciones, fechaEntrada, fechaSalida);
        if(reserva != null){
            return ResponseEntity.ok().body(reserva);
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @GetMapping("reservas/insert/{id}/{nif}/{hotel}/{destino}/{huespedes}/{habitaciones}/{fechaEntrada}/{fechaSalida}")
    public ResponseEntity<String> insertCompareReserva(@PathVariable("id") String idStr, @PathVariable("nif") String nif, @PathVariable("hotel") String hotel,@PathVariable("destino") String destino,@PathVariable("huespedes") String huespedesStr,@PathVariable("habitaciones") String habitacionesStr,@PathVariable("fechaEntrada") String fechaEntradaStr,@PathVariable("fechaSalida") String fechaSalidaStr){
        Long id = Long.parseLong(idStr);
        Long huespedes = Long.parseLong(huespedesStr);
        Long habitaciones = Long.parseLong(habitacionesStr);
        LocalDate fechaEntrada = LocalDate.parse(fechaEntradaStr);
        LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr);
        String resultado = reservaServicio.insertAndCompareReserva(id, nif, hotel, destino, huespedes, habitaciones, fechaEntrada, fechaSalida);
        return ResponseEntity.ok().body(resultado);
    }

    @Transactional
    @GetMapping("/reservas/delete/{id}")
    public ResponseEntity<String> deleteReservaId(@PathVariable("id") String idStr){
        Long id = Long.parseLong(idStr);
        String resultado = reservaServicio.deleteReservabyId(id);
        return ResponseEntity.ok().body(resultado);
    }

}