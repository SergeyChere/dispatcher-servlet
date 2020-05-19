package lesson.model;

public class Cat {
    private String petName;
    private int petAge;

    public Cat(){}
    public Cat(String petName, int petAge){
        this.petName=petName;
        this.petAge=petAge;
    }

    public int getPetAge() {
        return petAge;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "petName='" + petName + '\'' +
                ", petAge=" + petAge +
                '}';
    }
}
