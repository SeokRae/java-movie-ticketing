package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.movie.AbstractDiscountPolicy;
import com.example.ticketing.movie.DiscountCondition;
import com.example.ticketing.movie.Money;

public class PercentDiscountPolicy extends AbstractDiscountPolicy {
	private final double percent;
	
	public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
		super(conditions);
		this.percent = percent;
	}
	
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return screening.fee().times(percent);
	}
}
