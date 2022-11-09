package com.example.ticketing.movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("금액에 대한 테스트")
class MoneyTest {
	
	@DisplayName("금액 생성 테스트")
	@Test
	void testCase1() {
		// given
		int amount = 10000;
		
		// when
		Money money = Money.wons(amount);
		
		// then
		assertThat(money).isNotNull();
	}
	
	/**
	 * hashCode의 주석
	 * <p>
	 * If two objects are equal according to the equals method,
	 * then calling the hashCode method on each of the two objects must produce the same integer result.
	 */
	@DisplayName("금액 비교 테스트")
	@Test
	void testCase2() {
		// given
		int amount = 10000;
		// when
		Money money = Money.wons(amount);
		// then
		assertThat(money).isEqualTo(Money.wons(amount));
	}
	
	@DisplayName("금액 차감 테스트")
	@Test
	void testCase3() {
		// given
		int amount = 10000;
		int amount2 = 3000;
		// when
		Money money = Money.wons(amount);
		Money money2 = Money.wons(amount2);
		// then
		assertThat(money.minus(money2)).isEqualTo(Money.wons(amount - amount2));
	}
	
	@DisplayName("금액 차감 동시성 테스트")
	@Test
	void testCase4() {
		// given
		int nThreads = 100;
		ExecutorService executorService = newFixedThreadPool(nThreads);
		CountDownLatch countDownLatch = new CountDownLatch(nThreads);
		int amount = 10000;
		final Money[] money = {Money.wons(amount)};
		
		// when
		for (int i = 0; i < nThreads; i++) {
			executorService.execute(() -> {
				money[0] = money[0].minus(Money.wons(100));
				countDownLatch.countDown();
			});
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		// then
		assertThat(money[0]).isEqualTo(Money.wons(0));
	}
}