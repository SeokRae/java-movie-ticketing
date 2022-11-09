package com.example.ticketing.movie;

import com.example.ticketing.Screening;

import java.util.List;

public abstract class AbstractDiscountPolicy implements DiscountPolicy {
	private final List<DiscountCondition> conditions;
	
	protected AbstractDiscountPolicy(DiscountCondition... conditions) {
		this.conditions = List.of(conditions);
	}
	
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		for(DiscountCondition condition : conditions) {
			if(condition.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}
		return Money.ZERO;
	}
	
	protected abstract Money getDiscountAmount(Screening screening);
}
