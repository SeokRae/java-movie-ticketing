package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.movie.Money;

@FunctionalInterface
public interface DiscountPolicy {
	Money calculateDiscountAmount(Screening screening);
}
