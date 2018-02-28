package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Student;

public class StudentDAOImp implements StudentDAO {

	private EntityManager entityManager;
		
	// Dışarıdan entityManager nesnesini alıyoruz.
	
	public StudentDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	/**
	 * Veritabanına kaydetme, silme ve güncelleme işlemlerinde transaction kullanılmalı. 
	 * Kullanılmaz ise yaptığımız işler veritabanına yansımayacak.
	 * Yapılan iş(ekleme, silme, güncelleme vs.) begin ve commit metodları arasında olmalı.
	 */
	
	@Override
	public void insertStudent(Student student) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// Persist metodu bize JPA'nın sağladığı Sql sorgusu yazmadan veritabanına ekleme imkanı sunmakta.
		entityManager.persist(student);
		transaction.commit();
	}

	@Override
	public void deleteStudent(int id) {
		// Silmek için ilk önce verilen id'ye göre öğrenci bulunması gerekmekte.
		Student student = getStudentId(id);
		EntityTransaction transaction = entityManager.getTransaction();
		// Daha sonra Remove metodu ile veritabanımızdan kayıtı silme işlemini gerçekleştiriyoruz.
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
		// Find metodu verilen id bilgisine göre veritabanında arama yapmamıza olanak sağlamakta.
		// bu metodda transaction açmadık çünkü sadece okuma işlemi yaptık.
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public List<Student> allStudent() {
		// En basit şekilde bir sorgu oluşturup veritabanımızdaki tüm Öğrencileri getirip,
		// getResultList metodu ile bize sonucu liste şeklinde döndürmesini sağlıyoruz.
		return entityManager.createQuery("select e from Student e", Student.class).getResultList();
	}

}
