package com.example.ticketing;


import com.example.ticketing.movie.Money;

public class Ticketing {
	private final Screening screening;
	private final Money fee;
	
	public Ticketing(Screening screening, Money money) {
		this.screening = screening;
		this.fee = money;
	}
	
	public Money getFee() {
		return fee;
	}
	
}
