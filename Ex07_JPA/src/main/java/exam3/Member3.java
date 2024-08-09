package exam3;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="JpaMember3")
public class Member3 {
	@Id
	@SequenceGenerator(
			//아래에 제너레이터 밸류로 만들어준 시퀀스의 이름을 적어주고 db에 적용할 시퀀스 이름을 새로 적어주었다
			name="mySequence01",
			sequenceName="seq_JpaMem3",
			initialValue=1,		// 초기값
			allocationSize=5	// 증가값
			)
	@GeneratedValue(generator="mySequence01")
	private Long id;
	
	//맴버변수를 통해 데이터에 접근(그냥 가져오고
	@Access(AccessType.FIELD)	//기본값 : 필드(맴버변수)를 통해 데이터에 접근
	private String username;
	
	@Access(AccessType.PROPERTY)	// getter/setter메소드를 통해 데이터에 접근
	private String password;
	
	
	//db에 넣고싶지 않은 값들은 이렇게 표시해준다
	@Transient
	private long timestamp1;
								//영속성에서 제외 시키는 방법1. 어노테이션으로
								//				   방법2. 지시자를 이용하여
	transient private long timestamp2;
	
	public Member3() {
		super();
	}
	public Member3(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
