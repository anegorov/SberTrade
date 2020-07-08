package com.sber.trade;

import com.sber.trade.model.Deposit;
import com.sber.trade.model.DepositAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DepositTests {

	@Autowired
	private Deposit deposit;

	@Test
	void balance() {

		assertThat(deposit).isNotNull();

		assertThat(deposit.getBalance()).isEqualTo(0.01F);
		deposit.add(1.5F);
		assertThat(deposit.getBalance()).isEqualTo(1.51F);

	}

	@Test
	void close() {

		deposit.close();
		assertThat(deposit.getBalance()).isEqualTo(0.0F);

	}

}
