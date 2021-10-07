package com.jcpdev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {
	//Customer 정보 중에 session 객체에 저장하고 싶은것들.
	private int idx;
	private String name;
	private String email;
	private int age;
}
