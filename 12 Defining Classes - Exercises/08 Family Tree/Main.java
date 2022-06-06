package FamilyTree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Person> personList = new LinkedHashMap<>();//name, Person
        Map<String, String> personBirthdayList = new HashMap<>(); //birthday, name
        String peopleRootOfTree = console.nextLine();

        Person tempPerson = new Person(peopleRootOfTree);
        if(peopleRootOfTree.contains("/")) {
            personList.put(String.valueOf(tempPerson.getId()), tempPerson);
            personBirthdayList.put(peopleRootOfTree, String.valueOf(tempPerson.getId()));
        }
        else personList.put(peopleRootOfTree, tempPerson);

        String inputLine;
        while (!"End".equals(inputLine= console.nextLine())){
            String[] token = inputLine.split("\\s+");
            if(token.length ==5) {
                //"{FirstName} {LastName} – {FirstName} {LastName}"
                String parentName = token[0] + " " + token[1];
                String childName = token[3] + " " + token[4];
                Person tempParent = new Person(parentName);
                Person tempChild = new Person(childName);
                personList.putIfAbsent(parentName, tempParent);
                personList.putIfAbsent(childName, tempChild);
                personList.get(parentName).addChild(tempChild);
                personList.get(childName).addParent(tempParent);
            }
            if(token.length ==4) {
                if(token[2].equals("-")){
                    //"{FirstName} {LastName} – {day/month/year}"
                    String parentName = token[0] + " " + token[1];
                    String childBirthday = token[3];
                    Person tempParent = new Person(parentName);
                    personList.putIfAbsent(parentName, tempParent);
                    Person tempChild = new Person(childBirthday);
                    if(personBirthdayList.containsKey(childBirthday)) {
                        tempChild = personList.get(personBirthdayList.get(childBirthday));
                    } else {
                        personList.put(String.valueOf(tempChild.getId()), tempChild);
                        personBirthdayList.put(childBirthday, String.valueOf(tempChild.getId()));
                    }
                    tempChild.addParent(personList.get(parentName));
                    personList.get(parentName).addChild(tempChild);
                }
                else {
                    //"{day/month/year} – {FirstName} {LastName}"
                    String parentBirthday = token[0];
                    String childName = token[2] + " " + token[3];
                    Person tempChild = new Person(childName);
                    personList.putIfAbsent(childName, tempChild);
                    Person tempParent = new Person(parentBirthday);
                    if(personBirthdayList.containsKey(parentBirthday)) {
                        tempParent = personList.get(personBirthdayList.get(parentBirthday));
                    } else {
                        personList.put(String.valueOf(tempParent.getId()), tempParent);
                        personBirthdayList.put(parentBirthday, String.valueOf(tempParent.getId()));
                    }
                    tempParent.addChild(personList.get(childName));
                    personList.get(childName).addParent(tempParent);
                }

            }
            if(token.length ==3) {
                if(token[1].equals("-")) {
                    //"{day/month/year} – {day/month/year}"
                    String parentBirthday = token[0];
                    String childBirthday = token[2];
                    Person tempParent = new Person(parentBirthday);
                    if(personBirthdayList.containsKey(parentBirthday)) {
                        tempParent = personList.get(personBirthdayList.get(parentBirthday));
                    } else {
                        personList.put(String.valueOf(tempParent.getId()), tempParent);
                        personBirthdayList.put(parentBirthday, String.valueOf(tempParent.getId()));
                    }
                    Person tempChild = new Person(childBirthday);
                    if(personBirthdayList.containsKey(childBirthday)) {
                        tempChild = personList.get(personBirthdayList.get(childBirthday));
                    } else {
                        personList.put(String.valueOf(tempChild.getId()), tempChild);
                        personBirthdayList.put(childBirthday, String.valueOf(tempChild.getId()));
                    }
                    tempChild.addParent(tempParent);
                    tempParent.addChild(tempChild);
                } else {
                    //"{FirstName} {LastName} {day/month/year}"
                    String personName = token[0] + " " + token[1];
                    String personBirthday = token[2];
                    tempPerson = personList.get(personBirthdayList.get(personBirthday));
                    if(personList.containsKey(personName)) {
                        personList.get(personName).setBirthday(personBirthday);
                        if(tempPerson!=null) {
                            tempPerson.setName(personName);
                            Person personWithName = personList.get(personName);
                            Map<String, Person> tempPersonParents = tempPerson.getParents();
                            tempPersonParents.putAll(personWithName.getParents());
                            Map<String, Person> tempPersonChildren = tempPerson.getChildren();
                            tempPersonChildren.putAll(personWithName.getChildren());
                            personWithName.setParents(tempPersonParents);
                            personWithName.setChildren(tempPersonChildren);
                            personList.remove(personBirthdayList.get(personBirthday));
                        }
                    } else {
                        personList.remove(personBirthdayList.get(personBirthday));
                        tempPerson.setName(personName);
                        personList.put(personName, tempPerson);
                    }
                    personBirthdayList.put(personBirthday, personName);
                }
            }
        }
        if(peopleRootOfTree.contains("/")) {
            System.out.println(personList.get(personBirthdayList.get(peopleRootOfTree)));
        } else {
            System.out.println(personList.get(peopleRootOfTree));
        }
    }
}
