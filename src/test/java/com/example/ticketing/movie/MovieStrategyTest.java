package com.example.ticketing.movie;

import com.example.ticketing.Screening;
import com.example.ticketing.benefit.AmountDiscountPolicy;
import com.example.ticketing.benefit.NoneDiscountPolicy;
import com.example.ticketing.benefit.PercentDiscountPolicy;
import com.example.ticketing.benefit.condition.DiscountCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class MovieStrategyTest {
	
	private final DiscountCondition discountConditionTrue = condition -> true;
	
	@DisplayName("영화 가격 할인 미적용 테스트")
	@Test
	void testCase1() {
		// given
		String title = "어벤져스";
		int amount = 10000;
		// when
		Movie movie = new Movie(title, Money.wons(amount), new NoneDiscountPolicy());
		// then
		assertThat(movie.price()).isEqualTo(Money.wons(amount));
	}
	
	@DisplayName("영화 가격 고정 할인 적용 테스트")
	@Test
	void testCase2() {
		// given
		String title = "어벤져스";
		int amount = 10000;
		// when
		
		AmountDiscountPolicy discountPolicy = new AmountDiscountPolicy(Money.wons(1000), discountConditionTrue);
		Movie movie = new Movie(title, Money.wons(amount), discountPolicy);
		Money actual = movie.calculateMovieFee(new Screening(movie, LocalDateTime.now()));
		// then
		assertThat(actual).isEqualTo(Money.wons(9000));
	}
	
	@DisplayName("영화 가격 비율 할인 적용 테스트")
	@Test
	void testCase3() {
		// given
		String title = "어벤져스";
		int amount = 10000;
		// when
		PercentDiscountPolicy discountPolicy = new PercentDiscountPolicy(0.5, discountConditionTrue);
		Movie movie = new Movie(title, Money.wons(amount), discountPolicy);
		Money actual = movie.calculateMovieFee(new Screening(movie, LocalDateTime.now()));
		// then
		assertThat(actual).isEqualTo(Money.wons(5000));
	}
}