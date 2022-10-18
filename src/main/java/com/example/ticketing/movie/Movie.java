package com.example.ticketing.movie;

import java.util.Objects;

/**
 * 영화 정보 클래스
 * 1. 타이틀, 가격 정보를 갖는다.
 *
 */
public class Movie {
	private final String title;
	private final Money price;
	
	public Movie(String title, Money price) {
		this.title = title;
		this.price = price;
	}
	
	public Money getPrice() {
		return price;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Movie)) return false;
		Movie movie = (Movie) o;
		return Objects.equals(title, movie.title);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(title);
	}
	
	@Override
	public String toString() {
		return "Movie{" +
			"title='" + title + '\'' +
			", price=" + price +
			'}';
	}
}
