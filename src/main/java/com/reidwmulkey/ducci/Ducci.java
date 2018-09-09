package com.reidwmulkey.ducci;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ducci {

	List<Integer> numbers = new ArrayList<>();

	// constructors

	public Ducci(Ducci input) {

		for (int i = 0; i < input.getNumbers().size() - 1; i++) {
			getNumbers().add(Math.abs(input.getNumbers().get(i) - input.getNumbers().get(i + 1)));
		}
		getNumbers().add(Math.abs(input.getNumbers().get(input.getNumbers().size() - 1) - input.getNumbers().get(0)));
	}

	// business methods

	public boolean isTerminated() {
		return getNumbers().stream().filter(n -> n <= 0).collect(Collectors.toList()).size() == getNumbers().size();
	}

	public boolean equals(Ducci d) {
		return d.getNumbers().equals(getNumbers());
	}

}
