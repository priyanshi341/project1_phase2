package out.simplilearnproject.com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admintable")
public class AdminTable {
@Id
@Column(name="id")
private Integer aid;

@Column(name="uid")
private String uid;

@Column(name="password")
private String password;
public AdminTable()
{	}

public AdminTable(int aid, String uid, String password) {
	super();
	this.aid = aid;
	this.uid = uid;
	this.password = password;
}

public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
