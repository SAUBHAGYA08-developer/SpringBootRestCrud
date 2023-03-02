package com.restcrudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restcrudapi.model.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

}
