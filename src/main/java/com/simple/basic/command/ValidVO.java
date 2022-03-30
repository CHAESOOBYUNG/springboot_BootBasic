package com.simple.basic.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidVO {
	/*
	 * 1. 스프링부트 JPA라이브러리를 사용하면 기본타입은 null을 가질 수 없기 때문에 값에 맵핑이 안됩니다.	   
	 * 그래서 wrapper형으로 반드시 선언합니다.
	 * 
	 * 2. 유효성 검사에 필요한 멤버변수에 어노테이션 설정
	 * 규제 @NotBlank > @NotEmpty > @NotNull
	 * 
	 * - @NotNull : null을 허용하지 않는다 (String, Long 등에 적용가능)
	 * - @NotBlank : null, "", " " 허용하지 않는다. (String에 적용)
	 * - @NotEmpty : null, "" 허용하지 않는다. (String, Array 등에 적용가능)
	 * - @Pattern : 정규표현 형식에 문자열로 정의할 수 있다( String에 적용가능 )
	 * - @Email : 이메일 형식만 이용
	 */
	
	//문자는 NotBlank
	@NotBlank(message = "이름은 공백일 수 없습니다" ) 
	public String name;
	
	//숫자는 NotNull
	@NotNull(message = "급여는 필수입니다") 
	private Integer salary;
	
	//형식 지정시
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호는 000-0000-0000형식입니다")
	private String phone;
	
	//동시에 사용가능
	@NotBlank
	@Email(message = "이메일 형식이어야 합니다") //공백을 허용
	private String email;
	
	
}
