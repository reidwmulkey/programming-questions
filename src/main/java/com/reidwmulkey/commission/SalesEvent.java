package com.reidwmulkey.commission;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalesEvent {

	private SalesAccount salesAccount;
	
	private Date timestamp;
	
	private BigDecimal revenue;
	private BigDecimal expense;
	
}
