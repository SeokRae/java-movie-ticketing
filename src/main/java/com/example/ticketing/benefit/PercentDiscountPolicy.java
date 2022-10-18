package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.movie.Money;

public class PercentDiscountPolicy implements DiscountPolicy {
	private final double percent;
	
	public PercentDiscountPolicy(double percent) {
		this.percent = percent;
	}
	
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return screening.fee().times(percent);
	}
}
