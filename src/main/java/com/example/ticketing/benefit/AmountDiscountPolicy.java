package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.movie.Money;

public class AmountDiscountPolicy implements DiscountPolicy {
	private final Money discountAmount;
	
	public AmountDiscountPolicy(Money discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
