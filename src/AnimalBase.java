import java.util.ArrayList;
import java.util.Collections;

public class AnimalBase implements Comparable {

    private ArrayList<Animal> animals;

    public AnimalBase() {
        animals = new ArrayList<>();
    }

    public void start() {
        UserInterface ui = new UserInterface(this);
        createNewAnimal("snifles","smalle", "cat",8);
        createNewAnimal("buttens","medium","doge",9);
        createNewAnimal("abelone", "large", "elephant",7);
        ui.start();
    }

    public static void main(String[] args) {
        AnimalBase app = new AnimalBase();
        app.start();
    }

    public Iterable<Animal> getAllAnimals() {
        return animals;
    }

    public void sortBy(String sort) {
        System.out.println("Sort the list of animals by: " + sort);
        switch (sort) {
            case "name" -> animals.sort(new NameComperator());
            case "age" -> animals.sort(new AgeComperator());
            case "type" -> animals.sort(new TypeComerator());
        }
    }

    public void createNewAnimal(String name, String description, String type, int age) {
        Animal animal = new Animal(name,description,type,age);
        animals.add(animal);
    }

    public void deleteAnimal(String name) throws NonExistingAnimalException {
        // find animal with this name
        Animal animal = findAnimalByName(name);
        if(animal == null) {
            throw new NonExistingAnimalException();
        } else {
            animals.remove(animal);
        }
    }

    private Animal findAnimalByName(String name) {
        for(Animal animal : animals) {
            if(animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }


    public void loadDatabase() {
        System.err.println("LOAD not yet implemented!");
    }

    public void saveDatabase() {
        System.err.println("SAVE not yet implemented!");
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

