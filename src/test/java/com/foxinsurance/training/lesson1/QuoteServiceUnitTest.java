package com.foxinsurance.training.lesson1;

import com.foxinsurance.training.domain.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QuoteServiceUnitTest {
	@Test
	void unitTestUsesMockitoWithoutSpring() {
		var calc = mock(PremiumCalculator.class);
		var request = new QuoteRequest("Ava", InsuranceType.AUTO, 50000, true);
		when(calc.calculate(request)).thenReturn(1234.0);
		var service = new QuoteService(calc);
		assertEquals(1234.0, service.createQuote(request).annualPremium());
		verify(calc).calculate(request);
	}
}
