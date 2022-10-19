package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.benefit.condition.DiscountCondition;
import com.example.ticketing.movie.Money;

public class AmountDiscountPolicy extends AbstractDiscountPolicy {
	private final Money discountAmount;
	
	public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}
	
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
