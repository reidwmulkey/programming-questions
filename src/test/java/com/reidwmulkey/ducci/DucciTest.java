package com.reidwmulkey.ducci;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class DucciTest {

	//from: https://www.reddit.com/r/dailyprogrammer/comments/8sjcl0/20180620_challenge_364_intermediate_the_ducci/
	
	@Test
	public void happyPath() {

		Duccis duccis = new Duccis(Arrays.asList(0, 653, 1854, 4063));
		System.out.println(duccis.toString());
		Assert.assertEquals(24, duccis.getDuccis().size());

	}
}
