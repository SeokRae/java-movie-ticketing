package com.example.ticketing.benefit.condition;

import com.example.ticketing.Screening;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}