package com.kh.app.reflection.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		ReflectionMain main = new ReflectionMain();
//		main.test1();
//		main.test2();
		main.test3();
	}
	
	private void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		Class<Sample> clz = (Class<Sample>) Class.forName("com.kh.app.reflection.api.Sample");
		Sample sample = clz.getDeclaredConstructor(int.class, String.class).newInstance(123,"WOW");
		System.out.println(sample);
		
		Field num = clz.getDeclaredField("num"); // java.lang.Field
		System.out.println(num); // private int com.kh.app.reflection.api.Sample.num
		num.setAccessible(true); // private 필드도 그냥 바로 접근하게 비틀어버릴 수 있다(엄청 강력하다)
		Object value = num.get(sample); // 오류가 발생한다(private이라서 접근 불가능한데 직접접근하려 해서)
		System.out.println(value); // 123
	}
	

	// 객체 생성
	private void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Sample s1 = new Sample();
		Class clz1 = Sample.class;
		Class clz2 = s1.getClass();
		Class clz3 = Class.forName("com.kh.app.reflection.api.Sample");
		System.out.println(clz1 == clz2); // true
		System.out.println(clz2 == clz3); // true

		// 기본생성자 호출
		Constructor<Sample> const1 = clz1.getDeclaredConstructor(null);
		Sample s2 = const1.newInstance(null);
		System.out.println(s2); // Sample [num=0, str=null]

		// parameter 있는 애들
		Class[] parameterTypes = { int.class, String.class };
		Constructor<Sample> const2 = clz1.getDeclaredConstructor(parameterTypes);

		Object[] initArgs = { 100, "helloworld" };
		Sample s3 = const2.newInstance(initArgs);
		System.out.println(s3); // Sample [num=100, str=helloworld]

	}

	/*
	 * 메소드 제어하기
	 */
	private void test2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class clz = Sample.class;
		Method[] methods=clz.getDeclaredMethods(); // java.lang.reflect으로 기본 클래스중 하나.
		for(Method method : methods) {
			System.out.println(method);
		}
		
		// 하나의 메소드 가져오기. & 실행시키기
		Sample sample = (Sample) clz.getDeclaredConstructor(null).newInstance(null); // 반환타입이 Object이라서 형변환을 해준다.
		Method setNum = clz.getDeclaredMethod("setNum", int.class);
		Method getNum = clz.getDeclaredMethod("getNum");
		Object returnValueSet = setNum.invoke(sample, 123);
		Object returnValueGet = getNum.invoke(sample);
		System.out.println(sample); // Sample [num=123, str=null]
		System.out.println(returnValueSet); // null
		System.out.println(returnValueGet); // 123s
		
	}

}
