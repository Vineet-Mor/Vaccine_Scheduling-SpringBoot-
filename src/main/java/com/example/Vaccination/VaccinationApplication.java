package com.example.Vaccination;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import java.util.Scanner;
@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */
    	ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	Scanner s=new Scanner(System.in);
    	User user;
    	Vaccine vaccine;
    	TimeAndLocation timeAndLocation;
    	System.out.println("Welcome to the Vaccination Application");
    	boolean decision=true;
    	while(decision){
    		System.out.println("Please choose your vaccine preference:\n 1. Covid\n 2. Polio\n 3. Typhoid ");
    		int vacChoice=s.nextInt();
    		switch(vacChoice) {
    		case 1:{
    			vaccine=context.getBean("covid",Covid.class);
    			break;
    		}
    		case 2:{
    			vaccine=context.getBean("polio",Polio.class);
    			break;
    		}
    		case 3:{
    			vaccine=context.getBean("typhoid",Typhoid.class);
    			break;
    		}
    		default:{
    			System.out.println("Invalid Choice");
    			System.exit(-1);
    		}
    		}
    		System.out.println("Whom do you want to vaccinate:\n 1. Father\n 2. Mother\n 3. Self\n 4. Spouse\n 5. Exit");
    		int vaccId=s.nextInt();
    		switch(vaccId) {
    		case 1:{
    			if(vacChoice==1) {
    				user=context.getBean("fatherCovid",Father.class);
    			}
    			else if(vacChoice==2) {
    				user=context.getBean("fatherPolio",Father.class);
    			}
    			else{//(vacChoice==3) {
    				user=context.getBean("fatherTyphoid", Father.class);
    			}
    			if(user.IsVaccinated()) {
    				System.out.println("User is already vaccinated");
    			}
    			else {
    			System.out.println("Please enter Father details:\n Name: ");
    			s.nextLine();
    			String name=s.nextLine();
    			System.out.println("Age: ");
    			int age=s.nextInt();
    			System.out.println("Appointment date (YYYY-MM-DD): ");
    			s.nextLine();
    			String appointmentDate=s.nextLine();
    			System.out.println("Appointment time (HH:MM AM/PM) ");
    			String appointmentTime=s.nextLine();
    			System.out.println("Appointment location: ");
    			String appointmentLocation=s.nextLine();
    			timeAndLocation=context.getBean("timeAndLocation",TimeAndLocation.class);
    			user.setUserDetails(name, age, timeAndLocation);
    			timeAndLocation.setDetails(appointmentTime, appointmentLocation, appointmentDate);
    			user.setAppointment();
    			}
    			System.out.println("Do you want to register for someone else\n 1. Yes\n 2. No");
    			if(s.nextInt()!=1) {
    				decision=false;
    			}
    			break;
    		}
    		case 2:{
    			if(vacChoice==1) {
    				user=context.getBean("motherCovid",Mother.class);
    			}
    			else if(vacChoice==2) {
    				user=context.getBean("motherPolio",Mother.class);
    			}
    			else {
    				user=context.getBean("motherTyphoid", Mother.class);
    			}
    			if(user.IsVaccinated()) {
    				System.out.println("User is already vaccinated");
    			}
    			else {
    			System.out.println("Please enter Mother details:\n Name: ");
    			s.nextLine();
    			String name=s.nextLine();
    			System.out.println("Age: ");
    			int age=s.nextInt();
    			System.out.println("Appointment date (YYYY-MM-DD): ");
    			s.nextLine();
    			String appointmentDate=s.nextLine();
    			System.out.println("Appointment time (HH:MM AM/PM) ");
    			String appointmentTime=s.nextLine();
    			System.out.println("Appointment location: ");
    			String appointmentLocation=s.nextLine();
    			timeAndLocation=context.getBean("timeAndLocation",TimeAndLocation.class);
    			user.setUserDetails(name, age, timeAndLocation);
    			timeAndLocation.setDetails(appointmentTime, appointmentLocation, appointmentDate);
    			user.setAppointment();
    			}
    			System.out.println("Do you want to register for someone else\n 1. Yes\n 2. No");
    			if(s.nextInt()!=1) {
    				decision=false;
    			}
    			break;
    		}
    		case 3:{
    			if(vacChoice==1) {
    				user=context.getBean("selfCovid",Self.class);
    			}
    			else if(vacChoice==2) {
    				user=context.getBean("selfPolio",Self.class);
    			}
    			else {
    				user=context.getBean("selfTyphoid", Self.class);
    			}
    			if(user.IsVaccinated()) {
    				System.out.println("User is already vaccinated");
    			}
    			else {
    			System.out.println("Please enter your details:\n Name: ");
    			s.nextLine();
    			String name=s.nextLine();
    			System.out.println("Age: ");
    			int age=s.nextInt();
    			System.out.println("Appointment date (YYYY-MM-DD): ");
    			s.nextLine();
    			String appointmentDate=s.nextLine();
    			System.out.println("Appointment time (HH:MM AM/PM) ");
    			String appointmentTime=s.nextLine();
    			System.out.println("Appointment location: ");
    			String appointmentLocation=s.nextLine();
    			timeAndLocation=context.getBean("timeAndLocation",TimeAndLocation.class);
    			user.setUserDetails(name, age, timeAndLocation);
    			timeAndLocation.setDetails(appointmentTime, appointmentLocation, appointmentDate);
    			user.setAppointment();
    			}
    			System.out.println("Do you want to register for someone else\n 1. Yes\n 2. No");
    			if(s.nextInt()!=1) {
    				decision=false;
    			}
    			break;
    		}
    		case 4:{
    			if(vacChoice==1) {
    				user=context.getBean("spouseCovid",Spouse.class);
    			}
    			else if(vacChoice==2) {
    				user=context.getBean("spousePolio",Spouse.class);
    			}
    			else {
    				user=context.getBean("spouseTyphoid", Spouse.class);
    			}
    			if(user.IsVaccinated()) {
    				System.out.println("User is already vaccinated");
    			}
    			else {
    			System.out.println("Please enter Spouse details:\n Name: ");
    			s.nextLine();
    			String name=s.nextLine();
    			System.out.println("Age: ");
    			int age=s.nextInt();
    			System.out.println("Appointment date (YYYY-MM-DD): ");
    			s.nextLine();
    			String appointmentDate=s.nextLine();
    			System.out.println("Appointment time (HH:MM AM/PM) ");
    			String appointmentTime=s.nextLine();
    			System.out.println("Appointment location: ");
    			String appointmentLocation=s.nextLine();
    			timeAndLocation=context.getBean("timeAndLocation",TimeAndLocation.class);
    			user.setUserDetails(name, age, timeAndLocation);
    			timeAndLocation.setDetails(appointmentTime, appointmentLocation, appointmentDate);
    			user.setAppointment();
    			}
    			System.out.println("Do you want to register for someone else\n 1. Yes\n 2. No");
    			if(s.nextInt()!=1) {
    				decision=false;
    			}
    			break;
    		}
    		case 5:{
    			break;
    		}
    		default:{
    			System.out.println("Invalid Choice");
    			System.exit(-1);
    		}
    		}
    	}
    	
    }
}