import java.util.*;

public class RepairOrder {
	private int roNumber;
	private int year = -1;
	private String manufacturer = "";
	private String make = "";
	private String reasonForVisit = "";
	private double flatRate = -1.0;
	private Vehicle currentVehicle;	
	private boolean hasVehicle = false;
	ArrayList<LaborLine> lines = new ArrayList<LaborLine>();
	
	
	
	
		public RepairOrder(int roNumber, int year, String manufacturer, String make, String reasonForVisit, double flatRate) {
			this.setRoNumber(roNumber);			
			this.setYear(year);
			this.setMake(make);
			this.setManufacturer(manufacturer);
			this.setReasonForVisit(reasonForVisit);
			this.setFlatRate(flatRate);					
			
			createLine(this.reasonForVisit, this.flatRate);
			createVehicle(this.manufacturer, this.make, this.year);
		}		
		
		public RepairOrder(int roNumber, String manufacturer, String make, String reasonForVisit, double flatRate) {
			this.setRoNumber(roNumber);
			this.setMake(make);
			this.setManufacturer(manufacturer);
			this.setReasonForVisit(reasonForVisit);
			this.setFlatRate(flatRate);			
			
			createLine(this.reasonForVisit, this.flatRate);
			createVehicle(this.manufacturer, this.make, -1);
		}
		
		public RepairOrder(int roNumber, int year, String make, String reasonForVisit, double flatRate) {
			this.setYear(year);
			this.setMake(make);			
			this.setReasonForVisit(reasonForVisit);
			this.setFlatRate(flatRate);			
			
			createLine(this.reasonForVisit, this.flatRate);
			createVehicle("", this.make, this.year);
		}
		
		public RepairOrder(int roNumber, String reasonForVisit, double flatRate) {
			this.setRoNumber(roNumber);			
			this.setReasonForVisit(reasonForVisit);
			this.setFlatRate(flatRate);
			
			createLine(this.reasonForVisit, this.flatRate);
		}
		
		
		public RepairOrder(int roNumber, double flatRate) {
			setRoNumber(roNumber);
			setFlatRate(flatRate);
			
			createLine("", this.flatRate);
		}
		
		
		public void setRoNumber(int roNumber) {
			if(roNumber > 0 && roNumber < 1000000) {
				this.roNumber = roNumber;
			}			
		}
		
		public void setYear(int year) {
			if(year > 0) {
				this.year = year;
			}
			
		}
		
		public void setManufacturer(String manufacturer) {
			if(!manufacturer.isBlank()) {
				this.manufacturer = manufacturer;
			}
		}
		
		public void setMake(String make) {
			this.make = make;
		}
		
		public void setReasonForVisit(String reasonForVisit) {
			this.reasonForVisit = reasonForVisit;
		}
		
		public void setFlatRate(double flatRate) {
			if(flatRate > 0) {
				this.flatRate = flatRate;
			}
		}
		
				
		public void print() {
			System.out.println(this.roNumber);			
			if(hasVehicle) {
				this.currentVehicle.print();
			}
			for(LaborLine i : lines) {
				i.print();
			}			
						
		}
		
		
		public void createLine(String reasonForVisit, double flatRate) {
			setReasonForVisit(reasonForVisit);
			setFlatRate(flatRate);
			
			LaborLine newLine = new LaborLine(this.reasonForVisit, this.flatRate);
			
			addLine(newLine);
		}
		
		private void createVehicle(String manufacturer, String make, int year) {
			boolean hasManufacturer = false;
			boolean hasMake = false;
			boolean hasYear = false;
			
			if(!manufacturer.isEmpty()) {
				hasManufacturer = true;
			}
			
			if(!make.isEmpty()) {
				hasMake = true;
			}
			
			if(year >  0) {
				hasYear = true;
			}
			
			if(hasManufacturer && hasMake && hasYear) {
				currentVehicle = new Vehicle(manufacturer, make, year);
				
			} else if(hasManufacturer && hasMake) {
				currentVehicle = new Vehicle(manufacturer, make);
				
			}else if(hasMake && hasYear) {
				currentVehicle = new Vehicle(make,year);
			}
			hasVehicle = true;
			return;
		}
		
		private void addLine(LaborLine newLine) {	
			lines.add(newLine);								
			
			
		}
		
		public double totalFlatRate() {
			double sum = 0.0;
			
			for(LaborLine i : lines) {
				sum += i.getFlatRate();			}
			
			return sum;
		}
		
		
		
}
