package com.reidwmulkey.airplane;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Airplanes {

	private List<Airplane> airplanes = new ArrayList<>();

	// business methods

	public Airplane getClosestAirplane(BigDecimal latitude, BigDecimal longitude) {
		return airplanes.stream().sorted((a, b) -> a.getDistanceFromPoint(latitude, longitude)
				.compareTo(b.getDistanceFromPoint(latitude, longitude))).collect(Collectors.toList()).get(0);
	}

}
