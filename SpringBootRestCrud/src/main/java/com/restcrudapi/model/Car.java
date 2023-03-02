package com.restcrudapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="car_tab")
public class Car {
	
	@Id
	@GeneratedValue
	//@Column(name="car_id_col")
	private Integer id;
	
	@Column(name="car_brand_col")
	private String brand;
	
	@Column(name="car_id_col")
	private String model;
	
	@Column(name="car_year_col")
	private Integer year;
	
	@Column(name="car_regstate_col")
	private String regState;
	
	@Column(name="car_regcity_col")
	private String regCity;
	
	@Column(name="car_regnumber_col")
	private String regNumber;
	
	@Column(name="car_color_col")
	private String color;
	
	@Column(name="car_ownerserial_col")
	private Integer ownerSerial;


}
