package com.cperez.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cperez.example.bean.Car;

@Service
public class CarService implements ICarService{

	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	public Car findById(Long id) {
		String sqlFinById = "SELECT * FROM cars WHERE id = ?";
		Car consultById = (Car) jdbcTemplate.queryForObject(sqlFinById, new Object[]{id}, BeanPropertyRowMapper.newInstance(Car.class));
		return consultById;
	}

	public List<Car> findAll() {
		String sqlFindAll  = "SELECT * FROM cars";
		List<Car> consultAllCars = jdbcTemplate.query(sqlFindAll, BeanPropertyRowMapper.newInstance(Car.class));
		return consultAllCars;
	}

	public void addCar(Car car) {
		String sqlAdd = "INSERT INTO cars (id, name, price) VALUES (?,?,?)"; 
		int i = jdbcTemplate.update(sqlAdd, car.getId(), car.getName(), car.getPrice());
		if(i==1) System.out.println("Car Add");
		else	System.out.println("Car not Add");
		
	}

	public void editCar(Car car, Long id) {
		String sqlEditCar = "UPDATE cars SET name = ?, price = ? WHERE id = ?";
		int i = jdbcTemplate.update(sqlEditCar, car.getName(), car.getPrice(), id); 
		if(i==1) System.out.println("Car " + car.getId() + " edit");
		else	System.out.println("Car not Edit");
	}

	public void deleteCar(Long id) {
		String sqlDeleteCar = "DELETE FROM cars WHERE id = ?"; 
		jdbcTemplate.update(sqlDeleteCar, id);
		
	}
	

}
