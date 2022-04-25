package com.cperez.example;

import java.util.List;
import java.util.Scanner;

import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cperez.example.bean.Car;
import com.cperez.example.configuration.DBConfig;
import com.cperez.example.service.ICarService;

public class Main {
	
	public static void promptEnterKey(){
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		}

	public static void main(String[] args) {
		
		//Primer paso: Cargar el bean
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		//Segundo paso: Pedir bean al contenedor
		ICarService carService = context.getBean(ICarService.class);
		//Tercer paso: Usar el bean
		try {
			Car mazda = new Car(Long.valueOf(1),"Mazda", 140203);
			Car nissan = new Car(Long.valueOf(2), "nissan", 129394);
			Car chevrolet = new Car(Long.valueOf(3), "chevrolet", 150200);

			//Si ya los añadiste comentar estas lineas de codigo
			carService.addCar(mazda);
			carService.addCar(nissan);
			carService.addCar(chevrolet);
			
			promptEnterKey();
			System.out.println("Find All");
			List<Car> cars = carService.findAll(); 
			for (Car car : cars){
				System.out.println(car.getName() + car.getPrice());
			}
			promptEnterKey();
			System.out.println("Delete ID 3");
			carService.deleteCar(Long.valueOf(3));
			promptEnterKey();
			System.out.println("Update car ID=1");
			mazda.setName("Mazda Update");
			carService.editCar(mazda, Long.valueOf(1));
			promptEnterKey();
			System.out.println("Find by ID = 2");
			Car consultCar = carService.findById(Long.valueOf(2));
			System.out.println(consultCar.getName());
			promptEnterKey();
			System.out.println("Find All");
			cars = carService.findAll(); 
			for (Car car : cars){
				System.out.println(car.getName() + car.getPrice());
			}
			
		} catch (Exception e) {
			System.out.println("Sorry " + e.getMessage());	
		}
		//Cuarto paso: Cerrar el bean
		context.close();
	}
	
	

}
