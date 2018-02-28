package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Olu�turdu�umuz modeli Entity olarak i�aretliyoruz.

@Entity
public class Student {

	// S�n�f�m�za Entity �zelli�i kazand�rabilmek i�in Primary key bilgisi vermek zorunday�z.
	// Bunu @Id annotation� ile yap�yoruz.
	// @GeneratedValue k�s�m�nda GenerationType.AUTO yapt���m�z i�in eklenen her kay�t�n otomatik olarak id de�erini artt�r�m�n� sa�lar.
	// Auto Increment gibi d���n�lebilir bu mant�k.
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String isim;
	private String soyisim;
	private String bolum;
	private double ortalama;

	// S�n�f�m�z�n Entity �zelli�i kazanabilmesi i�in public no-arg constructor 'a sahip olmas� gerekmekte!
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
