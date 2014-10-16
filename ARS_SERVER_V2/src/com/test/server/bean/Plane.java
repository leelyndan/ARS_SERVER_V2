package com.test.server.bean;

public class Plane {
	
	private String number;
	private String beginCity;
	private String endCity;
	private String beginTime;
	private String endTime;
	private int firstClassPay;
	private int businessClassPay;
	private int economyClassPay;
	private String seatClass;
	private int passengerAdult;
	private int passengerChild;
	private int allPay;
	private int charge;
	private String departDate;
	private int totalAmount;
	private int payment;
	
	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBeginCity() {
		return beginCity;
	}

	public void setBeginCity(String beginCity) {
		this.beginCity = beginCity;
	}

	public String getEndCity() {
		return endCity;
	}

	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getFirstClassPay() {
		return firstClassPay;
	}

	public void setFirstClassPay(int firstClassPay) {
		this.firstClassPay = firstClassPay;
	}

	public int getBusinessClassPay() {
		return businessClassPay;
	}

	public void setBusinessClassPay(int businessClassPay) {
		this.businessClassPay = businessClassPay;
	}

	public int getEconomyClassPay() {
		return economyClassPay;
	}

	public void setEconomyClassPay(int economyClassPay) {
		this.economyClassPay = economyClassPay;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	
	public int getPassengerAdult() {
		return passengerAdult;
	}

	public void setPassengerAdult(int passengerAdult) {
		this.passengerAdult = passengerAdult;
	}

	public int getPassengerChild() {
		return passengerChild;
	}

	public void setPassengerChild(int passengerChild) {
		this.passengerChild = passengerChild;
	}

	public int getAllPay() {
		return allPay;
	}

	public void setAllPay(int allPay) {
		this.allPay = allPay;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	@Override
	public String toString() {
		return "Plane [number=" + number + ", beginCity=" + beginCity
				+ ", endCity=" + endCity + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", firstClassPay=" + firstClassPay
				+ ", businessClassPay=" + businessClassPay
				+ ", economyClassPay=" + economyClassPay + "]";
	}

}
