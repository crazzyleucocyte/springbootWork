package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
	@Entity : 해당 클래스가 JPA의 엔티티임을 의미(테이블과매핑되는 JPA)
	@Id : 식별자 - primary key
	@GeneratedValue : 자동생성 sequence
	@column : 테이블과 매핑될 컬럼명 지정. 이 어노테이션이 없으면 필드명==컬럼명
*/

//entity를 붙이면 해당 클래스의 정보대로 테이블을 만들라는 뜻
@Entity
@Table(name="jpaMember1")
public class Member1 {
	@Id					//@Id는 primary key를 의미
	@GeneratedValue		//@GeneratedValue 는 자동생성 시퀀스이다.
	private Long id;	//null인지 아닌지 확인하기 위해 wrapper 클래스인 Long을 사용
	
	private String username;
	
	@Column(name="create_date")		//db와 java의 표현방식이 다를때 @Column(name="")의 ""안에 컬럼명을 넣어 매핑해준다 
	private LocalDate createDate;

	public Member1() {
	}

	public Member1(String username, LocalDate createDate) {
		super();
		this.username = username;
		this.createDate = createDate;
	}
	
	
	
	
	
}
