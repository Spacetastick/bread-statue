package miscellaneous;
//Noah Cil
public class FCConverter {	
	
	private double F, C;
	
	public void setFahrenheit(double deg) {
		F = deg;
	}
	
	public void setCelsius(double deg) {
		C = deg;
	}
	
	public double getCelsius() {
		return ((F-32) * 5) / 9;
	}
	
	public double getFahrenheit() {
		return ((C * 9) / 5) + 32;
	}
}
