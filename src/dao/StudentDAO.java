package dao;

import java.util.List;

import model.Student;

public interface StudentDAO {

	// Veritabanýmýza kayýt yapmak için kullandýðýmýz metod
	public void insertStudent(Student student);

	// Veritabanýmýzdan kayýt silmek için kullandýðýmýz metod
	public void deleteStudent(int id);

	// Öðrencinin ortalamasýný güncellememizi saðlayan metod
	public void updateAverage(int id, double average);
	
	// Öðrencinin id bilgisini dönderen metod
	public Student getStudentId(int id);
	
	// // Veritabanýmýzda bulunan tüm öðrencileri listelemek için kullandýðýmýz metod
	public List<Student> allStudent();

}
