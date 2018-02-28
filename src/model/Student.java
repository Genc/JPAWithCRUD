package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Oluşturduğumuz modeli Entity olarak işaretliyoruz.

@Entity
public class Student {

	// Sınıfımıza Entity özelliği kazandırabilmek için Primary key bilgisi vermek zorundayız.
	// Bunu @Id annotationı ile yapıyoruz.
	// @GeneratedValue kısımında GenerationType.AUTO yaptığımız için eklenen her kayıtın otomatik olarak id değerini arttırımını sağlar.
	// Auto Increment gibi düşünülebilir bu mantık.
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String isim;
	private String soyisim;
	private String bolum;
	private double ortalama;

	// Sınıfımızın Entity özelliği kazanabilmesi için public no-arg constructor 'a sahip olması gerekmekte!
	public Student() {
		super();
	}

	public Student(String isim, String soyisim, String bolum, double ortalama) {
		super();
		this.isim = isim;
		this.soyisim = soyisim;
		this.bolum = bolum;
		this.ortalama = ortalama;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public double getOrtalama() {
		return ortalama;
	}

	public void setOrtalama(double ortalama) {
		this.ortalama = ortalama;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", isim=" + isim + ", soyisim=" + soyisim + ", bolum=" + bolum + ", ortalama="
				+ ortalama + "]";
	}

}
