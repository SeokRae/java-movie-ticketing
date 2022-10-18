package com.example.ticketing.movie;

import com.example.ticketing.benefit.DiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.ticketing.movie.Money.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("영화 관련 테스트 모음")
class MovieTest {
	private final DiscountPolicy discountPolicy = screening -> ZERO;
	
	@DisplayName("영화 생성 테스트(가격은 변동이 가능하다.)")
	@Test
	void testCase1() {
		// given
		String title = "어벤져스";
		int amount = 10000;
		// when
		
		Movie movie = new Movie(title, Money.wons(amount), discountPolicy);
		// then
		assertThat(movie).isEqualTo(new Movie(title, null, discountPolicy));
	}
	
	@DisplayName("영화 가격 확인 테스트")
	@Test
	void testCase2() {
		// given
		String title = "어벤져스";
		int amount = 10000;
		// when
		Movie movie = new Movie(title, Money.wons(amount), discountPolicy);
		// then
		assertThat(movie.getPrice()).isEqualTo(Money.wons(amount));
	}
}