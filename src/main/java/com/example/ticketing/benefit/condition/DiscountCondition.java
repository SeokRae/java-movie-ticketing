package com.example.ticketing.benefit.condition;

import com.example.ticketing.Screening;

@FunctionalInterface
public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}