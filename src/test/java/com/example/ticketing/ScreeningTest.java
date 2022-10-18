package com.example.ticketing;

import com.example.ticketing.benefit.DiscountPolicy;
import com.example.ticketing.benefit.NoneDiscountPolicy;
import com.example.ticketing.movie.Money;
import com.example.ticketing.movie.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상영 정보 클래스")
class ScreeningTest {
	
	private final DiscountPolicy defaultDiscountPolicy = new NoneDiscountPolicy();
	
	@DisplayName("상영 정보 생성 및 요금 확인 테스트")
	@Test
	void testCase1() {
		// given
		
		Movie movie = new Movie("어벤져스", Money.wons(10000), defaultDiscountPolicy);
		LocalDateTime whenScreened = LocalDateTime.of(2022, 10, 18, 21, 30);
		
		// when
		Screening screening = new Screening(movie, whenScreened);
		Money fee = screening.fee();
		
		// then
		assertThat(fee).isEqualTo(Money.wons(10000));
	}
}