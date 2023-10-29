package com.restcrudapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restcrudapi.exception.CarNotFoundException;
import com.restcrudapi.model.Car;
import com.restcrudapi.repository.CarRepo;
import com.restcrudapi.service.ICarService;
import com.restcrudapi.util.RtoLocationFinder1;

@Service
public class CarServiceImpl implements ICarService {

	@Autowired
	private CarRepo repo;

	@Override
	public Integer saveCar(Car car) {
		String regNumber = car.getRegNumber().replaceAll("\\s+", "").trim();
		String[] location = RtoLocationFinder1.getLocationFromRtoCode(regNumber.substring(0, 4));
		car.setRegState(location[0]);
        car.setRegCity(location[1]);
		repo.save(car);
		return car.getId();
	}

	@Override
	public List<Car> getAllCars() {
		List<Car> list=repo.findAll();
		system.out.println("Test");
		return list;
	}

	@Override
	public Car getOneCar(Integer id) {
		return repo.findById(id).orElseThrow(
				() -> new CarNotFoundException(
						"Car " + id + " Not found"
						)
				);
	}

	@Override
	public void deleteCar(Integer id) {
		Car car= getOneCar(id);
		repo.delete(car);
	}

	@Override
	public boolean isCarExists(Integer id) {
		return repo.existsById(id);
	}

	@Override
	public void updateCar(Car car) {
		repo.save(car);
		
	}
	

}
