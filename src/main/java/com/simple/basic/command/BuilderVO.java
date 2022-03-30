package com.simple.basic.command;

public class BuilderVO {
	//빌더 패턴(디자인 패턴)
	//1. 멤버변수
	private String name;
	private int age;
	
	//3. 외부에서 객체 생성을 요구할 때 메서드를 통해 내부클래스 반환
	public static Builder builder() {
		return new Builder();
	}
	
	//5. BuilderVO의 생성자는 Builder클래스를 매개변수로 받습니다.
	private BuilderVO(Builder builder) {
		this.name = builder.name; //빌더의 name을 vo에 저장
		this.age = builder.age;
	}
	
	//7. toString메서드 오버라이드
	@Override
	public String toString() {
		return "BuilderVO [name=" + name + ", age=" + age + "]";
	}
	
	//2. 내부클래스
	public static class Builder {
		
		private String name;
		private int age;
		//생성자 제한
		private Builder() {}
			
		//4. set메서드를 통해 값을 저장시키고 자신을 반환.
		public Builder name(String name) {
			this.name= name;
			return this; //자신
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
			
		//6. build라는 메서드를 통해서 5번에서 만든 생성자를 실행시킴
		public BuilderVO build() {
			return new BuilderVO(this);
		}
	}
	
}
