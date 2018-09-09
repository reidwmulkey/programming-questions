package com.reidwmulkey.airplane;

import java.math.BigDecimal;

public class App {
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Airplanes airplanes = (new AirplaneRepository()).getAllAirborneAirplanes();
        System.out.println(airplanes.getClosestAirplane(new BigDecimal(32), new BigDecimal(-97)));
    }
}
