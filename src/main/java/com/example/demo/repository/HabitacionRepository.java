package com.example.demo.repository;

import com.example.demo.model.Habitacion;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Iterator;

public interface HabitacionRepository extends CrudRepository<Habitacion, Long> {

}