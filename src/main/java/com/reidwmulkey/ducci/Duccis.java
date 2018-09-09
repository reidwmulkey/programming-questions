package com.reidwmulkey.ducci;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Duccis {

	private List<Ducci> duccis = new ArrayList<>();

	// constructors

	public Duccis(List<Integer> numbers) {
		duccis.add(new Ducci(numbers));
		generateAllDuccis();
	}

	// business methods

	public Ducci getLastDucci() {
		return duccis.get(duccis.size() - 1);
	}

	private void generateAllDuccis() {

		boolean sequenceEnded = false;

		do {
			Ducci ducci = new Ducci(getLastDucci());

			if (duccis.contains(ducci) || ducci.isTerminated()) {
				getDuccis().add(ducci);
				return;
			}
			getDuccis().add(ducci);
			
		} while (!sequenceEnded);
	}

}
