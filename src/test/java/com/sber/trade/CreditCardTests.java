package com.sber.trade;

import com.sber.trade.exception.OutOfBalanceException;
import com.sber.trade.model.CreditCard;
import com.sber.trade.model.DebitCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class CreditCardTests {

	@Autowired
	private	CreditCard creditCard;

	@Test
	void cardBalance() {

		assertThat(creditCard).isNotNull();

		assertThat(creditCard.getBalance()).isEqualTo(0.01F);
		creditCard.add(1000.5F);
		assertThat(creditCard.getBalance()).isEqualTo(1000.51F);

		creditCard.withdraw(10.11F);
		assertThat(creditCard.getBalance()).isEqualTo(990.40F);

		assertThatThrownBy(() -> { creditCard.withdraw(1000.00F); }).isInstanceOf(OutOfBalanceException.class)
				.hasMessageContaining("Не достаточно средств на счету: 990.4");

	}

	@Test
	void cardInterestRate() {

		assertThat(creditCard.getInterestRate()).isEqualTo(10.5F);

	}

	@Test
	void cardDebt() {

		assertThat(creditCard.getDebt()).isEqualTo(210.5F);

	}

}
