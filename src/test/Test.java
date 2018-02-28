package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.StudentDAO;
import dao.StudentDAOImp;
import model.Student;

public class Test {

	public static void main(String[] args) {

		/**
		 * Persistence-unit bilgilerine yani veritabaný bilgilerimize ulaþmak için
		 * öncelikle EntityManagerFactoy oluþturuyoruz. persistence.xml dosyamýzda
		 * <persistence-unit name="JPAtest"> olan kýsýmdaki ismi buraya veriyor,
		 * sonrasonda bu fabrikadan da bir EntityManager oluþturuyoruz.
		 */

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAtest");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Sonrasýnda oluþturduðumuz entityManager'ý metodlarý çalýþtýracak olan sýnýfa
		// veriyoruz.

		StudentDAO studentDAO = new StudentDAOImp(entityManager);

		Student student1 = new Student("Yusuf", "Genç", "Bilgisayar", 2.5);
		Student student2 = new Student("Ömer", "Genç", "Yazýlým", 2.8);
		Student student3 = new Student("Faruk", "Genç", "Kamu", 3.0);

		System.out.println(" --- Öðrenciler Eklendi ---");
		System.out.println();

		studentDAO.insertStudent(student1);
		studentDAO.insertStudent(student2);
		studentDAO.insertStudent(student3);

		List<Student> studentList = studentDAO.allStudent();
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println();
		System.out.println(" --- 1 numaralý öðrenci silindi. ---");
		System.out.println();

		studentDAO.deleteStudent(1);

		List<Student> studentList2 = studentDAO.allStudent();
		for (Student student : studentList2) {
			System.out.println(student);
		}
		System.out.println();
		System.out.println(" --- 2 numaralý öðrencinin ortalamasý 3.5 olarak güncellendi. ---");
		System.out.println();

		studentDAO.updateAverage(2, 3.5);

		List<Student> studentList3 = studentDAO.allStudent();
		for (Student student : studentList3) {
			System.out.println(student);
		}

		System.out.println("");

	}

}
