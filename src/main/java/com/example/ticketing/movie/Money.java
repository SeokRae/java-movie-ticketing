package com.example.ticketing.movie;

import java.util.Objects;

/**
 * 영화 예매 시 금액을 표현하는 클래스
 *
 */
public class Money {
	private final int amount;
	
	private Money(int amount) {
		this.amount = amount;
	}
	
	public static Money wons(int amount) {
		return new Money(amount);
	}
	
	public Money minus(Money money2) {
		return Money.wons(amount - money2.amount);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Money)) return false;
		Money money = (Money) o;
		return amount == money.amount;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
	
	@Override
	public String toString() {
		return "Money{" +
			"amount=" + amount +
			'}';
	}
}
