package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Member3Annotation {

	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
		
			Member3 user = new Member3("홍길동","1234");
			entityManager.persist(user);
			
			
			transaction.commit();
		}catch(Exception e) {
			//여기는 transaction안에서 오류가 발생했을때 커밋을 하지 않고 롤백을 시켜준다
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
			emf.close();
		}
	}

}
