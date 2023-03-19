import java.io.*;
import java.util.*;

public class test {
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr =  new Scanner(System.in);
		ArrayList<RepairOrder> listRo = new ArrayList<RepairOrder>();
		int roNumber;
		String manufacturer;
		int year;
		String model;
		String visit;	
		double time;
		double sum = 0;		
		
		System.out.println("Please enter RO number: ");
		roNumber = scnr.nextInt();		
		scnr.nextLine();
		
		System.out.println("Manufacturer: ");
		manufacturer = scnr.nextLine();
		
		System.out.println("year: ");
		year = scnr.nextInt();
		scnr.nextLine();
		
		System.out.println("Model: ");
		model = scnr.nextLine();
		
		System.out.println("Initial visit: ");
		visit = scnr.nextLine();
				
		System.out.println("Flat rate time: ");
		time = Double.valueOf(scnr.nextLine());	
				
		//RepairOrder R1 = new RepairOrder(roNumber, visit, time);
		RepairOrder R1 = new RepairOrder(roNumber, year, manufacturer, model, visit, time);
		
		System.out.println("repair: ");
		visit = scnr.nextLine();
				
		System.out.println("Flat rate time: ");
		time = Double.valueOf(scnr.nextLine());	
			
		R1.createLine(visit, time);
		RepairOrder R2 = new RepairOrder(roNumber, time);
		
		listRo.add(R1);
		
		//RO2
		System.out.println("Please enter RO number: ");
		roNumber = scnr.nextInt();		
		scnr.nextLine();
		
		System.out.println("Manufacturer: ");
		manufacturer = scnr.nextLine();
		
		System.out.println("year: ");
		year = scnr.nextInt();
		scnr.nextLine();
		
		System.out.println("Model: ");
		model = scnr.nextLine();
		
		System.out.println("Initial visit: ");
		visit = scnr.nextLine();
		
		
		System.out.println("Flat rate time: ");
		time = Double.valueOf(scnr.nextLine());	
		
		
		//RepairOrder R1 = new RepairOrder(roNumber, visit, time);
		RepairOrder R2 = new RepairOrder(roNumber, year, manufacturer, model, visit, time);
		
		System.out.println("repair: ");
		visit = scnr.nextLine();
		
		
		System.out.println("Flat rate time: ");
		time = Double.valueOf(scnr.nextLine());	
		
		R2.createLine(visit, time);
		//RepairOrder R1 = new RepairOrder(roNumber, time);
		
		listRo.add(R2);
		
		for(RepairOrder i:listRo) {
			sum += i.totalFlatRate();
		}
		
		for(RepairOrder i:listRo) {
			i.print();
			System.out.println("RO total flat rate: " + i.totalFlatRate());
		}
					
		System.out.println("Daily total flat rate: " + sum);	
		
		scnr.close();
	}
	
	

}
