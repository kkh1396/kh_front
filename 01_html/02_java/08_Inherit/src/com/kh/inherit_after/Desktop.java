package com.kh.inherit_after;

public class Desktop extends Product {

	private String cpu ;
	private int memory ;
	private String gpu ;
	
	
	public Desktop() {}

	
	public Desktop(String brand, String name, String model, String serial, int price, String cpu, int memory,
			String gpu) {
		super(brand, name, model, serial, price);
		this.cpu = cpu;
		this.memory = memory;
		this.gpu = gpu;
	}


	public String information() {
		return super.information() + " cpu :" + cpu + " 메모리 : "+ memory + " 그래픽 : "+ gpu;
	}


	public String getCpu() {
		return cpu;
	}


	public void setCpu(String cpu) {
		this.cpu = cpu;
	}


	public int getMemory() {
		return memory;
	}


	public void setMemory(int memory) {
		this.memory = memory;
	}


	public String getGpu() {
		return gpu;
	}


	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	
	
}
