package out.simplilearnproject.com;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdata")
public class UserData {
@Id
@GeneratedValue(strategy=GenerationType. IDENTITY)
private long id;

private String name;
private long age;
private LocalDate dateofbirth;
private String address;
private String mobilno;


public UserData() {

}
public UserData(String name, long age, LocalDate dateofbirth, String address, String mobilno) {
	super();
	this.name = name;
	this.age = age;
	this.dateofbirth = dateofbirth;
	this.address = address;
	this.mobilno = mobilno;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getAge() {
	return age;
}
public void setAge(long age) {
	this.age = age;
}
public LocalDate getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(LocalDate dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getMobilno() {
	return mobilno;
}
public void setMobilno(String mobilno) {
	this.mobilno = mobilno;
}

}
