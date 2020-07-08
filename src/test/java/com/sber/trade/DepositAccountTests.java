package com.sber.trade;

import com.sber.trade.model.DepositAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DepositAccountTests {

	@Autowired
	private DepositAccount depositAccount1;

	@Autowired
	private DepositAccount depositAccount2;

	@Test
	void balance() {

		assertThat(depositAccount1).isNotNull();
		assertThat(depositAccount1).isNotNull();

		assertThat(depositAccount1.getBalance()).isEqualTo(0.01F);
		depositAccount1.add(1.5F);
		assertThat(depositAccount1.getBalance()).isEqualTo(1.51F);

		depositAccount2.add(10.11F);
		assertThat(depositAccount2.getBalance()).isEqualTo(10.12F);

	}

	@Test
	void name() {

		assertThat(depositAccount1.getName()).isEqualTo("deposit");

	}

	@Test
	void currency() {

		assertThat(depositAccount1.getCurrency()).isEqualTo("RUB");

	}

}
