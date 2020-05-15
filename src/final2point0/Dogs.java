package final2point0;

public class Dogs {

    private int dogID;
    private String name;
    private int age;
    private String color;
    private double weight;
    private boolean fixed;
    private boolean adopted;

    public Dogs() { }

    public Dogs(int dogID, String name, int age, String color, double weight, boolean fixed, boolean adopted) {
        this.dogID = dogID;
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.fixed = fixed;
        this.adopted = adopted;
    }

    // Getters
    public int getDogID() {
        return dogID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public boolean getFixed() {
        return fixed;
    }

    public boolean getAdopted() {
        return adopted;
    }
    // End Getters

    // Setters
    public void setDogID(int dogID) {
        this.dogID = dogID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }
    // End setters

    @Override
    public String toString() {
        return dogID + "\t" + name + "\t" + age + "\t" + color + "\t" + weight + "lbs\t" + fixed + "\t" + adopted;
    }

}
