package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    public Company company;
    private final List<Pokemon> pokemonList = new ArrayList<>();
    private final List<Parent> parents = new ArrayList<>();
    private final List<Children> children = new ArrayList<>();
    public Car car;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name + System.lineSeparator() +
                "Company:" + System.lineSeparator() +
                (company == null ? "" : company + System.lineSeparator()) +
                "Car:" + System.lineSeparator() +
                (car == null ? "" : car + System.lineSeparator()) +
                "Pokemon:" + System.lineSeparator() +
                ((pokemonList.isEmpty()) ? "" : pokemonList.stream().map(Pokemon::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()) +
                "Parents:" + System.lineSeparator() +
                ((parents.isEmpty()) ? "" : parents.stream().map(Parent::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()) +
                "Children:" + System.lineSeparator() +
                ((children.isEmpty()) ? "" : children.stream().map(Children::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon (Pokemon pokemon){
        this.pokemonList.add(pokemon);
    }

    public void addChild (Children child){
        this.children.add(child);
    }

    public void addParent (Parent parent){
        this.parents.add(parent);
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
