package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();

		for(int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + ": ");
			System.out.print("Outsourced (y/n)? ");
			char outSourced = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nameEmployee = sc.nextLine();
			System.out.print("Hours: ");
			Integer hoursEmployee = sc.nextInt();
			System.out.print("Value per hour: ");
			Double valuePerHourEmployee = sc.nextDouble();
			if(outSourced == 'y') {
				System.out.print("Additional charge: ");
				Double additional = sc.nextDouble();
				list.add(new OutsourcedEmployee(nameEmployee, hoursEmployee, valuePerHourEmployee, additional));
			}
			else {
				list.add(new Employee(nameEmployee, hoursEmployee, valuePerHourEmployee));
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS: ");
		
		//utilizando method reference para imprimir pelo toString
		list.forEach(System.out::println);
		
		//sem toString na classe Employee poderia fazer usando lambad
		//list.forEach(c -> System.out.println(c.getName() + " - $ " + c.getPayment()));
		
		sc.close();

	}

}
