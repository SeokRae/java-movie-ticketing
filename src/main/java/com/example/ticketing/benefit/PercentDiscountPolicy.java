package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.movie.Money;

public class PercentDiscountPolicy extends AbstractDiscountPolicy {
	private final double percent;
	
	public PercentDiscountPolicy(double percent) {
		this.percent = percent;
	}
	
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return screening.fee().times(percent);
	}
}
