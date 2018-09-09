package com.reidwmulkey.airplane;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.reidwmulkey.airplane.AirplaneRepository.AllAirborneAirplaneResponse;

public class AirplaneFactory {

	public static Airplanes build(AllAirborneAirplaneResponse response) {

		List<Airplane> airplanes = new ArrayList<>();

		response.getStates().forEach(states -> {
			Airplane airplane = build(states);
			if (airplane != null) {
				airplanes.add(airplane);
			}
		});

		return new Airplanes(airplanes);
	}

	public static Airplane build(List<String> states) {

		try{
		Airplane airplane = new Airplane();

		airplane.setId(states.get(0));
		airplane.setCallSign(states.get(1));
		airplane.setCountry(states.get(2));

		airplane.setLatitude(new BigDecimal(states.get(6)));
		airplane.setLongitude(new BigDecimal(states.get(5)));

		return airplane;
		}
		catch(Exception e){
			return null;
		}

	}
}
