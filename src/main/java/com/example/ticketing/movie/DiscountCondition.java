package com.example.ticketing.movie;

import com.example.ticketing.Screening;

@FunctionalInterface
public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}