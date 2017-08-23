package com.zz.unti;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {

	/*
	 * Junit参数化设置：如果要为逻辑相同，但只是参数不同的方法创建多个，
	 * 或者多次修改某方法的参数，就会显得特别繁杂，Junit提供Parameterized.class
	 * 运行器来提供参数化设置（使用该运行器的测试类，所有测试方法都会执行
	 * 预先提供的参数的数量的次数，无论是否使用了该参数）
	 * 
	 * Junit参数化设置
	 * 1、更改默认的测试运行器为RunWith(Parameterized.class)
	 * 2、声明变量来存放预期值和结果值
	 * 3、声明一个返回值为Collection的公共静态方法，并使用@Parameters进行修饰
	 * 4、为测试类声明一个带有参数的公共构造方法，并在其中为之声明变量赋值
	 */
	int expected = 0;
	int input1 = 0;
	int input2 = 0;
	@Parameters
	public static Collection<Object[]> t(){
		return Arrays.asList(new Object[][]{
			{3,1,2},
			{4,2,2}
		});
	}
	
	public ParameterTest(int expected,int input1,int input2){
		this.expected = expected;
		this.input1 = input1;
		this.input2 = input2;
	}
	@Test
	public void testAdd(){
		assertEquals(expected, new Calculate().add(input1, input2));
	}
}
