package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Oluþturduðumuz modeli Entity olarak iþaretliyoruz.

@Entity
public class Student {

	// Sýnýfýmýza Entity özelliði kazandýrabilmek için Primary key bilgisi vermek zorundayýz.
	// Bunu @Id annotationý ile yapýyoruz.
	// @GeneratedValue kýsýmýnda GenerationType.AUTO yaptýðýmýz için eklenen her kayýtýn otomatik olarak id deðerini arttýrýmýný saðlar.
	// Auto Increment gibi düþünülebilir bu mantýk.
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String isim;
	private String soyisim;
	private String bolum;
	private double ortalama;

	// Sýnýfýmýzýn Entity özelliði kazanabilmesi için public no-arg constructor 'a sahip olmasý gerekmekte!
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
