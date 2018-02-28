package dao;

import java.util.List;

import model.Student;

public interface StudentDAO {

	// Veritaban�m�za kay�t yapmak i�in kulland���m�z metod
	public void insertStudent(Student student);

	// Veritaban�m�zdan kay�t silmek i�in kulland���m�z metod
	public void deleteStudent(int id);

	// ��rencinin ortalamas�n� g�ncellememizi sa�layan metod
	public void updateAverage(int id, double average);
	
	// ��rencinin id bilgisini d�nderen metod
	public Student getStudentId(int id);
	
	// // Veritaban�m�zda bulunan t�m ��rencileri listelemek i�in kulland���m�z metod
	public List<Student> allStudent();

}
