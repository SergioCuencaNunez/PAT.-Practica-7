package com.example.demo.service.impl;

import com.example.demo.model.Cliente;
import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    @Transactional
    public Hotel getHotelbyNombre(String nombre) {
        Hotel hotel = null;
        Optional<Hotel> ohotel = hotelRepository.findById(nombre);
        if(ohotel.isPresent()){
            hotel = ohotel.get();
            return hotel;
        }
        return hotel;
    }

    @Override
    @Transactional
    public List<Hotel> getHotelesbyDestino(String destino) {
        return hotelRepository.getHotelesByDestino(destino);
    }

    @Override
    @Transactional
    public List<Hotel> getHotelesbyEstado(Boolean estado) {
        return hotelRepository.getHotelesByEstado(estado);
    }

    @Override
    @Transactional
    public List<Hotel> getHoteles() {
        return StreamSupport.stream(hotelRepository.findAll().spliterator(), false).collect(Collectors.toUnmodifiableList());
    }

    @Override
    @Transactional
    public Hotel updateHotelCapacidadbyNombre(String nombre, Long capacidad) {
        Hotel hotel = null;
        Optional<Hotel> ohotel = hotelRepository.findById(nombre);
        if(ohotel.isPresent()){
            hotel = ohotel.get();
            hotel.setCapacidad(capacidad);
            hotelRepository.updateHotelCapacidadByNombre(hotel.getCapacidad(), hotel.getNombre());
            return hotel;
        }
        return hotel;
    }

    @Override
    @Transactional
    public Hotel updateHotelOcupacionbyNombre(String nombre, Long ocupacion) {
        Hotel hotel = null;
        Optional<Hotel> ohotel = hotelRepository.findById(nombre);
        if(ohotel.isPresent()){
            hotel = ohotel.get();
            hotel.setOcupacion(ocupacion);
            hotelRepository.updateHotelOcupacionByNombre(hotel.getOcupacion(), hotel.getNombre());
            return hotel;
        }
        return hotel;
    }

    @Override
    @Transactional
    public Hotel updateHotelEstadobyNombre(String nombre, Boolean estado) {
        Hotel hotel = null;
        Optional<Hotel> ohotel = hotelRepository.findById(nombre);
        if(ohotel.isPresent()){
            hotel = ohotel.get();
            hotel.setEstado(estado);
            hotelRepository.updateHotelEstadoByNombre(hotel.getEstado(), hotel.getNombre());
            return hotel;
        }
        return hotel;
    }

    @Override
    @Transactional
    public String insertAndCompareHotel(String nombre, String destino, Long capacidad, Long ocupacion, Boolean estado){
        Optional<Hotel> ohotel = hotelRepository.findById(nombre);
        if(ohotel.isPresent()) {
            return "El hotel " + nombre + " ya está registrado en Meliá Hotels International";
        }else{
            Hotel hotel = new Hotel();
            hotel.setNombre(nombre);
            hotel.setDestino(destino);
            hotel.setCapacidad(capacidad);
            hotel.setOcupacion(ocupacion);
            hotel.setEstado(estado);
            hotelRepository.insertHotel(hotel.getNombre(), hotel.getDestino(), hotel.getCapacidad(), hotel.getOcupacion(),hotel.getEstado());
            return "El hotel " + nombre + " se ha registrado correctamente en Meliá Hotels International";
        }
    }

    @Override
    @Transactional
    public String deleteHotelbyNombre(String nombre) {
        Optional<Hotel> ohotel = hotelRepository.findById(nombre);
        if(ohotel.isPresent()) {
            hotelRepository.deleteById(nombre);
            return "El hotel " + nombre + " se ha eliminado correctamente de los activos de Meliá Hotels International";
        }else{
            return "No hay ningún hotel llamado " + nombre + " en los activos de Meliá Hotels International";
        }
    }
}