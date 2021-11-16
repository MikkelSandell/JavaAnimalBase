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

    public void sortBy(String sort, String direction) {
        System.out.println("Sort the list of animals by: " + sort);
        if (sort.equals("name")){
            animals.sort(new SuperFlexibleComperator("name",direction));
        }else if (sort.equals("age")){
            animals.sort(new SuperFlexibleComperator("age",direction));
        }else if (sort.equals("type")){
            animals.sort(new SuperFlexibleComperator("type",direction));
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

