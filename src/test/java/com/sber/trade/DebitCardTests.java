package com.sber.trade;

import com.sber.trade.exception.OutOfBalanceException;
import com.sber.trade.model.DebitCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class DebitCardTests {

	@Autowired
	private	DebitCard debitCard;

	@Test
	void cardBalance() {

		assertThat(debitCard).isNotNull();

		assertThat(debitCard.getBalance()).isEqualTo(0.01F);
		debitCard.add(1000.5F);
		assertThat(debitCard.getBalance()).isEqualTo(1000.51F);

		debitCard.withdraw(10.11F);
		assertThat(debitCard.getBalance()).isEqualTo(990.40F);

		assertThatThrownBy(() -> { debitCard.withdraw(1000.00F); }).isInstanceOf(OutOfBalanceException.class)
				.hasMessageContaining("Не достаточно средств на счету: 990.4");

	}

}
