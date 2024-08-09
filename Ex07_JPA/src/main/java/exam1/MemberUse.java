package exam1;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MemberUse {
	
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
		transaction.begin(); //여기부터 commit할때까지 시작이다
		Member1 user = new Member1("홍길동1",LocalDate.now());
		//. persist는 영속성으로 객체에 대이터 입력(메모리에 insert해주는 부분)
		entityManager.persist(user);
		transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
			emf.close();
		}
		
	}
}
