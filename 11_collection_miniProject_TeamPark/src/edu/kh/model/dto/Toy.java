package edu.kh.model.dto;

import java.util.Objects;
import java.util.Set;

public class Toy implements Comparable<Toy> {

	private String name;
	private int age;
	private int price;
	private String color;
	private int date;
	private Set<String> subs;

	public Toy() {

	}

	public Toy(String name, int age, int price, String color, int date, Set<String> subs) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
		this.color = color;
		this.date = date;
		this.subs = subs;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Set<String> getSubs() {
		return subs;
	}

	public void setSubs(Set<String> subs) {

		this.subs = subs;

	}

	@Override
	public String toString() {

		return " 이름 : " + name + " / 가격 : " + price + " / 색상 : " + color + " / 사용가능연령 : " + age + " / 제조년월일 : " + date
				+ " / 재료 : " + subs;

	}

	@Override
	public int hashCode() {
		return Objects.hash(age, color, date, name, price, subs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return age == other.age && Objects.equals(color, other.color) && date == other.date
				&& Objects.equals(name, other.name) && price == other.price && Objects.equals(subs, other.subs);
	}

	@Override
	public int compareTo(Toy o) {

		return this.date - o.date;
	}

}
