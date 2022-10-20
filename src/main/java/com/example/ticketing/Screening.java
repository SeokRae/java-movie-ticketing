package com.example.ticketing;

import com.example.ticketing.movie.Money;
import com.example.ticketing.movie.Movie;

import java.time.LocalDateTime;

/**
 * 영화 예매를 위한 상영정보 클래스
 */
public class Screening {
	private final Movie movie;
	private final LocalDateTime whenScreened;
	
	public Screening(Movie movie, LocalDateTime whenScreened) {
		this.movie = movie;
		this.whenScreened = whenScreened;
	}
	
	public Ticketing reserve() {
		return new Ticketing(this, calculateFee());
	}
	
	private Money calculateFee() {
		return movie.calculateMovieFee(this);
	}
	
	public LocalDateTime whenScreened() {
		return whenScreened;
	}
	
	public Money fee() {
		return movie.price();
	}
}
