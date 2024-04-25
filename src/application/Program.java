package application;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.entities.Reservation;
import java.util.Date;
public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = fmt1.parse(sc.next());
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = fmt1.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
			
		}else {
			Reservation reservation1 = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation1);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = fmt1.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = fmt1.parse(sc.next());
			
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reervation: Reservation dates for update must be future dates.");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date.");
			}
			else {
				reservation1.updateDates(checkIn, checkOut);
				System.out.println(reservation1);
			}
			
			
			
		}
		
		
		
		sc.close();
	}

}
