package com.reidwmulkey.airplane;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class AirplaneRepository {

	private static final String ALL_AIRBORNE_AIRPLANES = "https://opensky-network.org/api/states/all";

	public Airplanes getAllAirborneAirplanes() {
		AllAirborneAirplaneResponse response = new RestRepository().getForObject(ALL_AIRBORNE_AIRPLANES,
				AllAirborneAirplaneResponse.class);

		return AirplaneFactory.build(response);
	}

	@Data
	public static class AllAirborneAirplaneResponse {

		private Integer time;
		private List<List<String>> states = new ArrayList<>();

	}
}
