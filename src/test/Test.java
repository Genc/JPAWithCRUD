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
		 * Persistence-unit bilgilerine yani veritaban� bilgilerimize ula�mak i�in
		 * �ncelikle EntityManagerFactoy olu�turuyoruz. persistence.xml dosyam�zda
		 * <persistence-unit name="JPAtest"> olan k�s�mdaki ismi buraya veriyor,
		 * sonrasonda bu fabrikadan da bir EntityManager olu�turuyoruz.
		 */

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAtest");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Sonras�nda olu�turdu�umuz entityManager'� metodlar� �al��t�racak olan s�n�fa
		// veriyoruz.

		StudentDAO studentDAO = new StudentDAOImp(entityManager);

		Student student1 = new Student("Yusuf", "Gen�", "Bilgisayar", 2.5);
		Student student2 = new Student("�mer", "Gen�", "Yaz�l�m", 2.8);
		Student student3 = new Student("Faruk", "Gen�", "Kamu", 3.0);

		System.out.println(" --- ��renciler Eklendi ---");
		System.out.println();

		studentDAO.insertStudent(student1);
		studentDAO.insertStudent(student2);
		studentDAO.insertStudent(student3);

		List<Student> studentList = studentDAO.allStudent();
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println();
		System.out.println(" --- 1 numaral� ��renci silindi. ---");
		System.out.println();

		studentDAO.deleteStudent(1);

		List<Student> studentList2 = studentDAO.allStudent();
		for (Student student : studentList2) {
			System.out.println(student);
		}
		System.out.println();
		System.out.println(" --- 2 numaral� ��rencinin ortalamas� 3.5 olarak g�ncellendi. ---");
		System.out.println();

		studentDAO.updateAverage(2, 3.5);

		List<Student> studentList3 = studentDAO.allStudent();
		for (Student student : studentList3) {
			System.out.println(student);
		}

		System.out.println("");

	}

}
