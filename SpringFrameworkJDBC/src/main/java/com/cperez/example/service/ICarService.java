package com.cperez.example.service;

import java.util.List;

import com.cperez.example.bean.Car;

public interface ICarService {
	
	public Car findById(Long id); 
	public List<Car> findAll();
	public void addCar(Car car); 
	public void editCar(Car car, Long id );
	public void deleteCar(Long id);	
	
}
