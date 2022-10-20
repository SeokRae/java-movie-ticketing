package com.example.ticketing.benefit.condition;

import com.example.ticketing.Screening;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
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
		LocalDateTime localDateTime = screening.whenScreened();
		return localDateTime.getDayOfWeek().equals(dayOfWeek)
			&& startTime.compareTo(localDateTime.toLocalTime()) <= 0
			&& endTime.compareTo(localDateTime.toLocalTime()) >= 0;
	}
}