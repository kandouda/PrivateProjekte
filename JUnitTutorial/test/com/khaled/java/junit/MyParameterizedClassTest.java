package com.khaled.java.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyParameterizedClassTest {

	private int multiplier;

	public MyParameterizedClassTest(int testParameter) {
		this.multiplier = testParameter;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		Object [][] data = new Object[][]{
				{ 1	}, {998}, {121}
		};
		
		return Arrays.asList(data);
		
	}
	
	@Test
	public void testMultiplyException() {
		MyClass tester = new MyClass();
		assertEquals("Result", multiplier * multiplier, tester.multiply(multiplier, multiplier));
	}

}
