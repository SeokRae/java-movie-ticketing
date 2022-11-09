package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.movie.AbstractDiscountPolicy;
import com.example.ticketing.movie.DiscountPolicy;
import com.example.ticketing.movie.Money;

import java.util.List;

public class OverlappedDiscountPolicy extends AbstractDiscountPolicy {
	private final List<DiscountPolicy> discountPolicies;
	
	public OverlappedDiscountPolicy(DiscountPolicy... discountPolicies) {
		this.discountPolicies = List.of(discountPolicies);
	}
	
	@Override
	protected Money getDiscountAmount(Screening screening) {
		Money result = Money.ZERO;
		for (DiscountPolicy discountPolicy : discountPolicies) {
			result = result.plus(discountPolicy.calculateDiscountAmount(screening));
		}
		return result;
	}
}
