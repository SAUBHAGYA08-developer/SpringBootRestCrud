package com.restcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restcrudapi.exception.CarNotFoundException;
import com.restcrudapi.model.Car;
import com.restcrudapi.service.ICarService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private ICarService service;
	
	//for save a new car
	@PostMapping("/save")
	@ApiOperation("This is for saving Car")
	public ResponseEntity<String> saveCar(@RequestBody Car car)
	{
		ResponseEntity<String> resp=null;
		try {
		Integer id=service.saveCar(car);
		resp = new ResponseEntity<String>(
				new StringBuffer()
				.append("Car")
				.append(id)
				.append("Saved").toString(),
				HttpStatus.CREATED);		
		return resp;
		}catch (Exception e) {
			resp=new ResponseEntity<String>(
				"Unable to save Product",
				HttpStatus.INTERNAL_SERVER_ERROR); //500
		
			e.printStackTrace();
		}
		return resp;
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation("This is for Update Car by Id")
	public ResponseEntity<String> updateCar(
			@PathVariable Integer id,
			@RequestBody Car car
			)
	{
		ResponseEntity<String> resp = null;
		try {
			Car db=service.getOneCar(id);
			service.updateCar(db);
			
			//resp = ResponseEntity.ok("Product updated");
			resp = new ResponseEntity<String>("Car Updated",
					HttpStatus.RESET_CONTENT); //205
			
		}catch (CarNotFoundException cnfe) {
			throw cnfe;
		}catch (Exception e) {
			resp=new ResponseEntity<String>(
					"Unable to update product",
					HttpStatus.INTERNAL_SERVER_ERROR);
			
			e.printStackTrace();
		}
		
		return resp;
			
	}
	
	@ApiOperation("This is for Get All Cars")
	@GetMapping("/all")
	public ResponseEntity<List<Car>>getAllCars(){
		ResponseEntity<List<Car>> resp=null;
		
		try {
			List<Car> list=service.getAllCars();
			resp = new ResponseEntity<List<Car>>(list,HttpStatus.OK);
		} catch (Exception e) {
			//BODY is optional but httpstatus is mandatory
			resp = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	@ApiOperation("This is for Delete Car")
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteCar(
			@PathVariable Integer id
			)
	{
		ResponseEntity<String> resp = null;
		try {
			service.deleteCar(id);
			resp = ResponseEntity.ok("Car Deleted");
			
		}catch (CarNotFoundException cnfe) {
			throw cnfe;
		} catch (Exception e) {
			resp = new ResponseEntity<String>(
					"Unable to delete",
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	
}
