package Iterators;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;


    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if(this.name.equals(otherPerson.name)){
            if(this.age == otherPerson.age){
                return this.town.compareTo(otherPerson.town);
            }
            return Integer.compare(this.age, otherPerson.age);
        } else return this.name.compareTo(otherPerson.name);
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
