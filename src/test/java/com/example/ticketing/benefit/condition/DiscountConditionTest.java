package com.example.ticketing.benefit.condition;

import com.example.ticketing.Screening;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountConditionTest {
	
	@DisplayName("할인 조건 생성(false) 테스트")
	@Test
	void testCase1() {
		// given
		DiscountCondition discountCondition = screening -> false;
		
		// when
		boolean actual = discountCondition.isSatisfiedBy(null);
		
		// then
		assertThat(actual).isFalse();
	}
	
	@DisplayName("할인 조건 생성(true) 테스트")
	@Test
	void testCase2() {
		// given
		DiscountCondition discountCondition = screening -> true;
		
		// when
		boolean actual = discountCondition.isSatisfiedBy(null);
		
		// then
		assertThat(actual).isTrue();
	}
	
	@DisplayName("할인 조건 생성(시간) 테스트")
	@Test
	void testCase3() {
		// given
		DayOfWeek today = LocalDate.now().getDayOfWeek();
		LocalTime start = LocalTime.of(22, 0);
		LocalTime endTime = LocalTime.of(23, 59);
		DiscountCondition discountCondition = new PeriodCondition(today, start, endTime);
		
		// when
		LocalDateTime whenScreened = LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 30));
		boolean actual = discountCondition.isSatisfiedBy(new Screening(null, whenScreened));
		
		// then
		assertThat(actual).isTrue();
	}
}