package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.movie.Money;

public abstract class AbstractDiscountPolicy implements DiscountPolicy {
	
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return getDiscountAmount(screening);
	}
	
	protected abstract Money getDiscountAmount(Screening screening);
}
