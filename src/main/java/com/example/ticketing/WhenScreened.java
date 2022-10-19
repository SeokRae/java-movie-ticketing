package com.example.ticketing;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class WhenScreened {
	private final LocalDateTime dateTime;
	
	public WhenScreened(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public boolean isDayOfWeek(DayOfWeek dayOfWeek) {
		return dateTime.getDayOfWeek().equals(dayOfWeek);
	}
	
	public boolean compareToStart(LocalTime startTime) {
		return startTime.compareTo(dateTime.toLocalTime()) <= 0;
	}
	
	public boolean compareToEnd(LocalTime endTime) {
		return endTime.compareTo(dateTime.toLocalTime()) >= 0;
	}
}
