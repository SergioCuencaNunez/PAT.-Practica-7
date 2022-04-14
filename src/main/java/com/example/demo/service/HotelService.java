package com.example.demo.service;

import com.example.demo.model.Hotel;

import java.util.List;

public interface HotelService {

    Hotel getHotelByNombre(String nombre);
    List<Hotel> getHotelesbyDestino(String destino);
    List<Hotel> getHotelesbyEstado(Boolean estado);
    List<Hotel> getHoteles();
    Hotel updateHotelCapacidadbyNombre(String nombre, Long capacidad);
    Hotel updateHotelOcupacionbyNombre(String nombre, Long ocupacion);
    Hotel updateHotelEstadobyNombre(String nombre, Boolean estado);
    String insertAndCompareHotel(String nombre, String destino, Long capacidad, Long ocupacion, Boolean estado);
    String deleteHotelbyNombre(String nombre);
}