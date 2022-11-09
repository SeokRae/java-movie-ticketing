package com.example.ticketing;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof WhenScreened)) return false;
		WhenScreened that = (WhenScreened) o;
		return Objects.equals(whenScreened, that.whenScreened);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(whenScreened);
	}
}
