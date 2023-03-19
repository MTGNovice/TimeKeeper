
public class LaborLine {
	private String reasonForVisit = "";
	private double flatRate = 1.0;
	private boolean hasReasonForVisit = false;
	private boolean hasFlatRate = false;
	
	public LaborLine(String reasonForVisit, double flatRate) {
		setReasonForVisit(reasonForVisit);
		setFlatRate(flatRate);
	}
	
	public LaborLine(String reasonForVisit) {
		setReasonForVisit(reasonForVisit);		
	}
	
	public LaborLine(double flatRate) {
		setFlatRate(flatRate);
	}
	
	public void setReasonForVisit(String labor) {
		
		if(!labor.isBlank()) {
			this.reasonForVisit = labor;
			hasReasonForVisit = true;
		}
		
	}
	
	public String getReasonForVisit() {
		if(hasReasonForVisit) {
			return this.reasonForVisit;
		}
		return "";
	}
	
	public void setFlatRate(double flatRate) {
		if(flatRate > -1) {
			this.flatRate = flatRate;
			hasFlatRate = true;
		}
	}
	
	public double getFlatRate() {
		if(hasFlatRate) {
			return this.flatRate;
		}
		return 0.0;
	}
	
	public void print() {
		if(hasReasonForVisit) {
			System.out.println(reasonForVisit);
		}
		
		if(hasFlatRate) {
			System.out.println(flatRate);
		}
		
	}
}
