package com.kh.app.strategy.pattern;

public class Main {
	/*
	 * Person 클래스 설계
	 * 철수 person has a Dog
	 * 영희 person has a Cat
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Person p1 = new Person("철수",new Dog("구리구리"));
		Person p2 = new Person("영희",new Cat("냥냥냥이"));
		
		System.out.println(p1);
		System.out.println(p2);
		
		
		// person이 가질 수 있는 반려동물 Class는 이후에 추가될 수 있다.
		Person p3 = new Person("광수", new Snake("슈리하아"));
		System.out.println(p3);
		
		
	}

}
