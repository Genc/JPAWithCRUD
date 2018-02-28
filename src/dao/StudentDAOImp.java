package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Student;

public class StudentDAOImp implements StudentDAO {

	private EntityManager entityManager;
		
	// D��ar�dan entityManager nesnesini al�yoruz.
	
	public StudentDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	/**
	 * Veritaban�na kaydetme, silme ve g�ncelleme i�lemlerinde transaction kullan�lmal�. 
	 * Kullan�lmaz ise yapt���m�z i�ler veritaban�na yans�mayacak.
	 * Yap�lan i�(ekleme, silme, g�ncelleme vs.) begin ve commit metodlar� aras�nda olmal�.
	 */
	
	@Override
	public void insertStudent(Student student) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// Persist metodu bize JPA'n�n sa�lad��� Sql sorgusu yazmadan veritaban�na ekleme imkan� sunmakta.
		entityManager.persist(student);
		transaction.commit();
	}

	@Override
	public void deleteStudent(int id) {
		// Silmek i�in ilk �nce verilen id'ye g�re ��renci bulunmas� gerekmekte.
		Student student = getStudentId(id);
		EntityTransaction transaction = entityManager.getTransaction();
		// Daha sonra Remove metodu ile veritaban�m�zdan kay�t� silme i�lemini ger�ekle�tiriyoruz.
		transaction.begin();
		entityManager.remove(student);
		transaction.commit();
	}

	@Override
	public void updateAverage(int id, double ortalama) {
		Student student = getStudentId(id);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		student.setOrtalama(ortalama);
		transaction.commit();

	}

	@Override
	public Student getStudentId(int id) {
		// Find metodu verilen id bilgisine g�re veritaban�nda arama yapmam�za olanak sa�lamakta.
		// bu metodda transaction a�mad�k ��nk� sadece okuma i�lemi yapt�k.
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public List<Student> allStudent() {
		// En basit �ekilde bir sorgu olu�turup veritaban�m�zdaki t�m ��rencileri getirip,
		// getResultList metodu ile bize sonucu liste �eklinde d�nd�rmesini sa�l�yoruz.
		return entityManager.createQuery("select e from Student e", Student.class).getResultList();
	}

}
