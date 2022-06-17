package Iterators;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    @Override
    public String toString() {
        return name + " " + age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(Person otherPerson) {
        if(this.getName().equals(otherPerson.getName())){
            return Integer.compare(this.getAge(), otherPerson.getAge());
        }
        return this.getName().compareTo(otherPerson.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
