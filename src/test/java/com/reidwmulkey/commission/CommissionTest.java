package com.reidwmulkey.commission;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

public class CommissionTest {

	@Test
	public void happyPath() {
		
		SalesEvent event1 = SalesEvent.builder().revenue(new BigDecimal(225)).expense(new BigDecimal(100)).salesAccount(SalesAccount.Coffee).build();
		SalesEvent event2 = SalesEvent.builder().revenue(new BigDecimal(50)).expense(new BigDecimal(100)).salesAccount(SalesAccount.Coffee).build();
		SalesEvent event3 = SalesEvent.builder().revenue(new BigDecimal(50)).expense(new BigDecimal(100)).salesAccount(SalesAccount.Tea).build();
		
		SalesPerson bob = new SalesPerson();
	
		bob.getSalesEvents().add(event1);
		bob.getSalesEvents().add(event2);
		bob.getSalesEvents().add(event3);
		
		Assert.assertEquals(new BigDecimal(75), bob.getProfitForSalesAccount(SalesAccount.Coffee));
		Assert.assertEquals(new BigDecimal(0), bob.getProfitForSalesAccount(SalesAccount.Tea));

		Assert.assertEquals(new BigDecimal(75), bob.getProfitForSalesAccount(SalesAccount.Coffee));
	}
}
