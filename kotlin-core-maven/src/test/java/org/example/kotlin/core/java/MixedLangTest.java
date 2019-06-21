package org.example.kotlin.core.java;

import org.example.kotlin.core.java.model.FooBean;
import org.example.kotlin.core.kotlin.model.BarBean;
import org.junit.Test;

public class MixedLangTest {
	
	@Test
	public void test() throws ClassNotFoundException {
		FooBean foo = new FooBean();
		foo.setName("java222-foo");

		System.out.println(foo);

		System.out.println(Class.forName("org.example.kotlin.core.kotlin.model.BarBean"));

		BarBean barBean = new BarBean();
		System.out.println(barBean.toString());
		System.out.println(barBean.getText1());

	}

}
