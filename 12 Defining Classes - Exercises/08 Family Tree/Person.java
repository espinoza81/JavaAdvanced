package FamilyTree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Person {
    private static int id;
    String name;
    String birthday;
    Map<String, Person> parents = new LinkedHashMap<>();
    Map<String, Person> children = new LinkedHashMap<>();

    @Override
    public String toString() {
        return  this.name + " " + this.birthday + System.lineSeparator() +
                "Parents:" + System.lineSeparator() +
                ((this.parents.isEmpty()) ? "" : this.parents.values().stream().map(Person::printParentsEndChildren).collect(Collectors.joining(System.lineSeparator()))+ System.lineSeparator()) +
                "Children:" + System.lineSeparator() +
                ((this.children.isEmpty()) ? "" : this.children.values().stream().map(Person::printParentsEndChildren).collect(Collectors.joining(System.lineSeparator())));
     }

    public String printParentsEndChildren() {
        return this.name + " " + this.birthday;
    }
    public void addChild(Person child){
        this.children.putIfAbsent(child.getName(), child);
    }

    public void addParent(Person parent){
        this.parents.putIfAbsent(parent.getName(), parent);
    }

    public Person(String name, String birthday) {
        id++;
        this.name = name;
        this.birthday = birthday;
    }

    public Person(String data) {
        id++;
        if(data.contains("/")) this.birthday = data;
        else this.name = data;
    }

    public int getId() {
        return id;
    }

    public static void setId(int id) {
        Person.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Map<String, Person> getParents() {
        return parents;
    }

    public void setParents(Map<String, Person> parents) {
        this.parents = parents;
    }

    public Map<String, Person> getChildren() {
        return children;
    }

    public void setChildren(Map<String, Person> children) {
        this.children = children;
    }
}
