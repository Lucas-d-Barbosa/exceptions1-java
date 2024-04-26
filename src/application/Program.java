package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;
public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = fmt1.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
				Date checkOut = fmt1.parse(sc.next());
				
				Reservation reservation1 = new Reservation(roomNumber, checkIn, checkOut);
				System.out.println(reservation1);
				
				System.out.println();
				System.out.println("Enter date to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = fmt1.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = fmt1.parse(sc.next());
			
			
			reservation1.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation1);	
		}
		catch(ParseException e){			
			System.out.println("Invalid date format");
		}
		
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e){	
			System.out.println("Unexpected error!");
		}
	
		sc.close();
	}

}
