package br.com.treinaweb.designPatterns.creational.multiton;

import java.util.HashMap;

public class Camera {
	private long hardwareId; 
	private String location;
	
	private static HashMap<Long, Camera> instance = new HashMap<Long, Camera>();
	
	static{
		Camera camera1 = new Camera();
		camera1.setHardwareId(1234);
		camera1.setLocation("Left Store");
		
		Camera camera2 = new Camera();
		camera2.setHardwareId(4321);
		camera2.setLocation("Right Store");

		instance.put(camera1.getHardwareId(), camera1);
		instance.put(camera2.getHardwareId(), camera2);
	}
	
	private Camera() {}

	public static Camera getInstance(long hardwareId) {
		return Camera.instance.get(hardwareId);
	}

	public long getHardwareId() {
		return hardwareId;
	}

	public void setHardwareId(long hardwareId) {
		this.hardwareId = hardwareId;
	}
	
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
