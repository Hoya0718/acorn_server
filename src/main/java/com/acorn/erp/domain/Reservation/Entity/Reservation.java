package com.acorn.erp.domain.Reservation.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class Reservation {

    private String id;

    private String name;

    private String reservationDate;  // 카멜 케이스 사용

    private String requests;

    private String payment;

    private String phone;

    public Reservation(String id, String name, String reservationDate, String requests, String payment, String phone,
			String gender, int rsCount) {
		super();
		this.id = id;
		this.name = name;
		this.reservationDate = reservationDate;
		this.requests = requests;
		this.payment = payment;
		this.phone = phone;
		this.gender = gender;
		this.rsCount = rsCount;
	}



	private String gender;

    private int rsCount;



    // Getters and Setters

    public String getId() {

        return id;

    }



    public void setId(String id) {

        this.id = id;

    }



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public String getReservationDate() {

        return reservationDate;

    }



    public void setReservationDate(String reservationDate) {

        this.reservationDate = reservationDate;

    }



    public String getRequests() {

        return requests;

    }



    public void setRequests(String requests) {

        this.requests = requests;

    }



    public String getPayment() {

        return payment;

    }



    public void setPayment(String payment) {

        this.payment = payment;

    }



    public String getPhone() {

        return phone;

    }



    public void setPhone(String phone) {

        this.phone = phone;

    }



    public String getGender() {

        return gender;

    }



    public void setGender(String gender) {

        this.gender = gender;

    }



    public int getRsCount() {

        return rsCount;

    }



    public void setRsCount(int rsCount) {

        this.rsCount = rsCount;

    }

}

