public class Bat extends Mammal {
    private int energyLevel;

    public Bat() {
        this.energyLevel = 300;
    }

    public void fly() {
        System.out.println("The bat takes off and flies!");
        decreaseEnergy(50);
    }

    public void eatHumans() {
        System.out.println("Well, never mind. The bat is busy eating humans!");
        increaseEnergy(25);
    }

    public void attackTown() {
        System.out.println("The town is on fire!");
        decreaseEnergy(100);
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
