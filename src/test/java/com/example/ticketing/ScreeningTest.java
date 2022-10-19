package com.example.ticketing;

import com.example.ticketing.benefit.AmountDiscountPolicy;
import com.example.ticketing.benefit.DiscountPolicy;
import com.example.ticketing.benefit.NoneDiscountPolicy;
import com.example.ticketing.benefit.condition.PeriodCondition;
import com.example.ticketing.movie.Money;
import com.example.ticketing.movie.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상영 정보 클래스")
class ScreeningTest {
	
	private final DiscountPolicy noneDiscountPolicy = new NoneDiscountPolicy();
	
	@DisplayName("상영 정보 생성 및 요금 확인 테스트")
	@Test
	void testCase1() {
		// given
		
		Movie movie = new Movie("어벤져스", Money.wons(10000), noneDiscountPolicy);
		LocalDateTime whenScreened = LocalDateTime.of(2022, 10, 18, 21, 30);
		
		// when
		Screening screening = new Screening(movie, whenScreened);
		Money fee = screening.fee();
		
		// then
		assertThat(fee).isEqualTo(Money.wons(10000));
	}
	
	@DisplayName("상영 정보 생성 및 할인 요금 확인 테스트")
	@Test
	void testCase2() {
		// given
		
		PeriodCondition periodCondition = new PeriodCondition(LocalDate.now().getDayOfWeek(), LocalTime.of(22, 0), LocalTime.of(23, 59));
		AmountDiscountPolicy discountPolicy = new AmountDiscountPolicy(Money.wons(1000), periodCondition);
		Movie movie = new Movie("어벤져스", Money.wons(10000), discountPolicy);
		
		LocalDateTime whenScreened = LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 30));
		
		// when
		Screening screening = new Screening(movie, whenScreened);
		Money fee = screening.fee();
		
		// then
		assertThat(fee).isEqualTo(Money.wons(9000));
	}
}