package com.example.Vaccination;

import com.example.Vaccination.User;

/**
  This class is an implementation of a User Interface based on the selection 
  in the console the user type is selected.You need to complete this class 
  based on the following tasks.
    
   Tasks:
 a.Override the methods of User Interface.
 b.Adding common attributes:
    1. String name
    2. Integer age
    3. boolean isVaccinated
    4. TimeAndLocation(class), vaccine(interface), both are injected by the constructor method.
    5. The arguments of the constructor for all users should be like "public User(TimeAndLocation timeAndLocation, Vaccine vaccine)"
 c.Build the logic for all the methods based on the description mentioned in the User Interface.
 
**/
public class Spouse implements User {

	String name;
	Integer age;
	boolean isVaccinated;
	TimeAndLocation tal;
	Vaccine vaccine;
	
	public Spouse(TimeAndLocation tal, Vaccine vaccine) {
		this.tal=tal;
		this.vaccine=vaccine;
	}
	
	
    /** This method returns Vaccine object which is selected by the user in console. **/
	@Override
	public Vaccine getVaccineDetails() {
		return this.vaccine;
	}


    /** This function sets user details such as name, age, and timeAndLocation. **/
	@Override
    public void setUserDetails(String name, int age, TimeAndLocation timeAndLocation) {
    	this.name=name;
    	this.age=age;
    	tal=timeAndLocation;
    }

    /** This function updates vaccination status of the user and prints appointment details in the console with includes user name , Vaccine name and lastly timeAndLocation class based details 
        For example:  "Hello John your appointment has been fixed for Covid Vaccine on  12 Pm at Mumbai  on 2023-05-10". 
     **/
	@Override
    public void setAppointment() {
    	isVaccinated=true;
    	System.out.println("Hello "+name+" your appointment has been fixed for "+vaccine.getType()+" Vaccine on "+tal.getDetails());
    }

    /** This function returns a boolean type indicating the vaccination status of a user. If the user is vaccinated it should return true else false. **/
	@Override
	public boolean IsVaccinated() {
    	return isVaccinated;
    }

}
