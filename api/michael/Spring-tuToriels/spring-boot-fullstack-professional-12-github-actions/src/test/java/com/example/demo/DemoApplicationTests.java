package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

class DemoApplicationTests {

	Calculator underTest = new Calculator() {
	};

	@Test
	void itShouldAddNumbers() {
		// given
		int numberOne = 20;
		int numberTwo = 30;

		// when
		int result = underTest.add(numberOne, numberTwo);

		// then
		//assertThat(result,result==50));
		assertThat(result, is(equalTo(50)));
	}

	class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}
}
