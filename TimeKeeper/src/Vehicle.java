import java.sql.Time;

public class Vehicle {
	private String manufacturer = "";
	private String model = "";
	private int year = -1;
	private int currentYear = 2022;
	private boolean hasManufacturer = false;
	private boolean hasModel = false;
	private boolean hasYear = false;
	
	public Vehicle(String manufacturer, String model, int year) {
		setManufacturer(manufacturer);
		setModel(model);
		setYear(year);
	}
	
	public Vehicle(String manufacturer, String model) {
		setManufacturer(manufacturer);
		setModel(model);
	}
	
	public Vehicle(String model, int year) {
		setModel(model);
		setYear(year);
	}
	
	public void setManufacturer(String manufacturer) {
		if(!manufacturer.isBlank()) {
			this.manufacturer = manufacturer;
			hasManufacturer = true;
		}
	}
	
	public void setModel(String model) {
		if(!model.isBlank()) {
			this.model = model;
			hasModel = true;
		}
				
	}
	
	public void setYear(int year) {
		if(year > 1910 && year < currentYear + 1) {
				this.year = year;
				hasYear = true;
		}
	}
	
	public void print() {
		if(hasYear) {
			System.out.println(this.year);
		}
		
		if(hasManufacturer) {
			System.out.println(this.manufacturer);
		}
		
		if(hasModel) {
			System.out.println(this.model);
		}
		
	}
}
