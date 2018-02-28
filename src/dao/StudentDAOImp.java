package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Student;

public class StudentDAOImp implements StudentDAO {

	private EntityManager entityManager;
		
	// Dýþarýdan entityManager nesnesini alýyoruz.
	
	public StudentDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	/**
	 * Veritabanýna kaydetme, silme ve güncelleme iþlemlerinde transaction kullanýlmalý. 
	 * Kullanýlmaz ise yaptýðýmýz iþler veritabanýna yansýmayacak.
	 * Yapýlan iþ(ekleme, silme, güncelleme vs.) begin ve commit metodlarý arasýnda olmalý.
	 */
	
	@Override
	public void insertStudent(Student student) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// Persist metodu bize JPA'nýn saðladýðý Sql sorgusu yazmadan veritabanýna ekleme imkaný sunmakta.
		entityManager.persist(student);
		transaction.commit();
	}

	@Override
	public void deleteStudent(int id) {
		// Silmek için ilk önce verilen id'ye göre öðrenci bulunmasý gerekmekte.
		Student student = getStudentId(id);
		EntityTransaction transaction = entityManager.getTransaction();
		// Daha sonra Remove metodu ile veritabanýmýzdan kayýtý silme iþlemini gerçekleþtiriyoruz.
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
		// Find metodu verilen id bilgisine göre veritabanýnda arama yapmamýza olanak saðlamakta.
		// bu metodda transaction açmadýk çünkü sadece okuma iþlemi yaptýk.
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public List<Student> allStudent() {
		// En basit þekilde bir sorgu oluþturup veritabanýmýzdaki tüm Öðrencileri getirip,
		// getResultList metodu ile bize sonucu liste þeklinde döndürmesini saðlýyoruz.
		return entityManager.createQuery("select e from Student e", Student.class).getResultList();
	}

}
