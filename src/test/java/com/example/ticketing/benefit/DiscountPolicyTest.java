package com.example.ticketing.benefit;

import com.example.ticketing.Screening;
import com.example.ticketing.benefit.condition.DiscountCondition;
import com.example.ticketing.movie.Money;
import com.example.ticketing.movie.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyTest {
	
	@DisplayName("할인 정책 미적용 테스트")
	@Test
	void testCase1() {
		// given
		DiscountPolicy discountPolicy = new NoneDiscountPolicy();
		
		// when
		Money actual = discountPolicy.calculateDiscountAmount(null);
		
		// then
		assertThat(actual).isEqualTo(Money.ZERO);
	}
	
	@DisplayName("할인 정책 & 조건 미적용 테스트")
	@Test
	void testCase2() {
		// given
		DiscountPolicy discountPolicy = new AmountDiscountPolicy(Money.wons(1000));
		
		// when
		Money actual = discountPolicy.calculateDiscountAmount(null);
		
		// then
		assertThat(actual).isEqualTo(Money.ZERO);
	}
	
	@DisplayName("고정 금액 할인 정책 & 조건 적용 시 할인 가격 검증 테스트")
	@Test
	void testCase3() {
		// given
		DiscountPolicy discountPolicy = new AmountDiscountPolicy(Money.wons(1000), screening -> true);
		
		// when
		Money actual = discountPolicy.calculateDiscountAmount(null);
		
		// then
		assertThat(actual).isEqualTo(Money.wons(1000));
	}
	
	@DisplayName("비율 할인 정책 & 조건 적용 시 할인 가격 검증 테스트")
	@Test
	void testCase4() {
		// given
		DiscountPolicy discountPolicy = new PercentDiscountPolicy(0.5, screening -> true);
		Money originPrice = Money.wons(1000);
		Screening screening = new Screening(new Movie(null, originPrice, null), null);
		
		// when
		Money actual = discountPolicy.calculateDiscountAmount(screening);
		
		// then
		Money expectedFee = Money.wons(500);
		assertThat(actual).isEqualTo(expectedFee);
	}
}