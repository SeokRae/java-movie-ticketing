package com.example.ticketing.benefit.condition;

import com.example.ticketing.Screening;
import com.example.ticketing.WhenScreened;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
	private final DayOfWeek dayOfWeek;
	private final LocalTime startTime;
	private final LocalTime endTime;
	
	public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	@Override
	public boolean isSatisfiedBy(Screening screening) {
		WhenScreened whenScreened = screening.whenScreened();
		return whenScreened.isDayOfWeek(dayOfWeek) && whenScreened.isRange(startTime, endTime);
	}
}