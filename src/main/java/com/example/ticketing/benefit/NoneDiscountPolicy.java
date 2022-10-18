package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.movie.Money;

public class NoneDiscountPolicy implements DiscountPolicy {
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}
