package com.restcrudapi.service;

import java.util.List;

import com.restcrudapi.model.Car;

public interface ICarService {
	
	Integer saveCar(Car car);
	
	List<Car> getAllCars();

	public Car getOneCar(Integer id);
	
	void deleteCar(Integer id);
	
	boolean isCarExists(Integer id);
	
	void updateCar(Car car);

}
