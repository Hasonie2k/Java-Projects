public class Gorilla extends Mammal {
    private int energyLevel;

    public Gorilla() {
        this.energyLevel = 100;
    }

    public void throwSomething() {
        System.out.println("The gorilla has thrown something!");
        decreaseEnergy(5);
    }

    public void eatBananas() {
        System.out.println("The gorilla ate the bananas!");
        increaseEnergy(10);
    }

    public void climb() {
        System.out.println("The gorilla has climbed a tree!");
        decreaseEnergy(10);
    }

    private void decreaseEnergy(int amount) {
        energyLevel -= amount;
    }

    private void increaseEnergy(int amount) {
        energyLevel += amount;
    }

    public int displayEnergy() {
        System.out.println("Energy Level: " + energyLevel);
        return energyLevel;
    }
}
