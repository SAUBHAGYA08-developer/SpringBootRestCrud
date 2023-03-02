package com.restcrudapi.util;

import com.restcrudapi.model.Car;

public interface CarUtil {
	
	public static void copyNonNullValues(
			Car db,Car request) 
	{
		if(request.getBrand()!=null)
			db.setBrand(request.getBrand());
		if(request.getColor()!=null)
			db.setColor(request.getColor());
		if(request.getModel()!=null)
			db.setModel(request.getModel());
		if(request.getOwnerSerial()!=null)
			db.setOwnerSerial(request.getOwnerSerial());
		if(request.getRegNumber()!=null)
			db.setOwnerSerial(request.getOwnerSerial());
	}

}
