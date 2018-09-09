package com.reidwmulkey.commission;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SalesPerson {

	private List<SalesEvent> salesEvents = new ArrayList<>();

	// business methods

	public BigDecimal getRevenueForSalesAccount(SalesAccount salesAccount) {
		return salesEvents.stream().filter(e -> e.getSalesAccount().equals(salesAccount)).map(e -> e.getRevenue())
				.reduce(BigDecimal::add).get();
	}

	public BigDecimal getExpenseForSalesAccount(SalesAccount salesAccount) {
		return salesEvents.stream().filter(e -> e.getSalesAccount().equals(salesAccount)).map(e -> e.getExpense())
				.reduce(BigDecimal::add).get();
	}

	public BigDecimal getProfitForSalesAccount(SalesAccount salesAccount) {

		BigDecimal revenue = getRevenueForSalesAccount(salesAccount);
		BigDecimal expense = getExpenseForSalesAccount(salesAccount);
		BigDecimal profit = revenue.subtract(expense);

		if (profit.compareTo(BigDecimal.ZERO) > 0) {
			return profit;
		}

		return BigDecimal.ZERO;
	}

	public BigDecimal getTotalProfit() {

		BigDecimal profit = BigDecimal.ZERO;

		for (SalesAccount salesAccount : SalesAccount.values()) {
			profit.add(getProfitForSalesAccount(salesAccount));
		}

		return profit;
	}

}
