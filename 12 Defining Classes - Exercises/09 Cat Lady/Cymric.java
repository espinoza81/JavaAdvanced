package CatLady;

public class Cymric extends Hierarchy{
    double furLength;

    public Cymric(String name, double furLength) {
        super(name, "Cymric");
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", this.furLength);
    }
}
