package bean;

import java.io.Serializable;

public class people implements Serializable {
	private int id;
	private String name;
	private int age;
	private String des;//	private transient String des;transient����Ĭ�ϱ����л�
	
	public people(){
	}
	public people(int id, String name, int age, String des) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.des = des;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "people [id=" + id + ", name=" + name + ", age=" + age + ", des=" + des + "]";
	}	
}
