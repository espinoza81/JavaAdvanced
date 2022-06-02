package PokemonTrainer;

public class Pokemon {
    private String name;
    private final String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public void looseHealth(){
        this.health -= 10;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }
}
