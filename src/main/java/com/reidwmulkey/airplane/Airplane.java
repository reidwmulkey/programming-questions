package com.reidwmulkey.airplane;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Airplane {

	private String id;
	private String callSign;
	private String country;

	private BigDecimal latitude;
	private BigDecimal longitude;

	// business methods

	public BigDecimal getDistanceFromPoint(BigDecimal latitude, BigDecimal longitude) {
		return new BigDecimal(Math.sqrt(
				getLatitude().subtract(latitude).pow(2).add(getLongitude().subtract(longitude).pow(2)).doubleValue()));
	}
}
