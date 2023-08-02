package com.exception;


// 사용자 정의 예외 클래스 ==> 예외발생시 try~catch 또는 throws 에 사용할 수 있다.
public class DuplicatedDeptnoException extends Exception{

	// 필요시 변수, 메서드 추가 가능
	
	public DuplicatedDeptnoException(String message) {
		super(message);
	}
}