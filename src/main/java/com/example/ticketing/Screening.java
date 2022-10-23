package com.example.ticketing;

import com.example.ticketing.movie.Money;
import com.example.ticketing.movie.Movie;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 영화 예매를 위한 상영정보 클래스
 */
public class Screening {
	private final Movie movie;
	private final WhenScreened whenScreened;
	
	public Screening(Movie movie, LocalDateTime whenScreened) {
		this.movie = movie;
		this.whenScreened = new WhenScreened(whenScreened);
	}
	
	public Ticketing reserve() {
		return new Ticketing(this, calculateFee());
	}
	
	private Money calculateFee() {
		return movie.calculateMovieFee(this);
	}
	
	public WhenScreened whenScreened() {
		return whenScreened;
	}
	
	public Money fee() {
		return movie.price();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Screening)) return false;
		Screening screening = (Screening) o;
		return Objects.equals(movie, screening.movie)
			&& Objects.equals(whenScreened, screening.whenScreened);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(movie, whenScreened);
	}
}
