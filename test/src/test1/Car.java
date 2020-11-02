package test1;

public class Car implements LightListener {

	private Person[] passengers;
	public static Car instance;
	private static boolean driving = false;
	private LightListener listener;
	
	public Car() {
		passengers[6] = new Person();
		
	}
	public boolean turnLightOn() {
		return false;
		
	}
	
	public boolean drive() {
		return false;
		
	}
	
	public void add() {
	
	}
	
	@Override
	public void onLightOn(Light light) {
		
	}

	@Override
	public void onLightOff(Light light) {	
	}
	
	public void setListener(LightListener listener) {
		this.listener = listener;
	}

	
}
