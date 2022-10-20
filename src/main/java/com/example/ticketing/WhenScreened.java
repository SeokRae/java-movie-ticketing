package com.example.ticketing;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class WhenScreened {
	private final LocalDateTime whenScreened;
	
	public WhenScreened(LocalDateTime whenScreened) {
		this.whenScreened = whenScreened;
	}
	
	public boolean isRange(LocalTime start, LocalTime end) {
		return start.compareTo(whenScreened.toLocalTime()) <= 0
			&& end.compareTo(whenScreened.toLocalTime()) >= 0;
	}
	
	public boolean isDayOfWeek(DayOfWeek dayOfWeek) {
		return whenScreened.getDayOfWeek().equals(dayOfWeek);
	}
	
	public LocalDateTime getWhenScreened() {
		return whenScreened;
	}
}
