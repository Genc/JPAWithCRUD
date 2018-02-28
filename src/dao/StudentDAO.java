package dao;

import java.util.List;

import model.Student;

public interface StudentDAO {

	// Veritabanımıza kayıt yapmak için kullandığımız metod
	public void insertStudent(Student student);

	// Veritabanımızdan kayıt silmek için kullandığımız metod
	public void deleteStudent(int id);

	// Öğrencinin ortalamasını güncellememizi sağlayan metod
	public void updateAverage(int id, double average);
	
	// Öğrencinin id bilgisini dönderen metod
	public Student getStudentId(int id);
	
	// // Veritabanımızda bulunan tüm öğrencileri listelemek için kullandığımız metod
	public List<Student> allStudent();

}
