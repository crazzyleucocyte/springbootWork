package com.study.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//@data를 입력하면 getter, setter, constructor, toString, hashCode까지 다 만들어준다. 이거는 outline을 열어보면 알 수 있다.

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@NonNull
	private int boardno;
	private String title;
	private String writer;
	private String content;
	
}
