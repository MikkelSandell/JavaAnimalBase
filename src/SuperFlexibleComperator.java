import java.util.Comparator;

public class SuperFlexibleComperator implements Comparator<Animal> {
    private String direction;
    private  String type;

    public SuperFlexibleComperator(String type ,String direction){
        this.direction = direction;
        this.type = type;
    }
    @Override
    public int compare(Animal o1, Animal o2) {
        int resultat =0;
        if (type.equals("age")){
            resultat = Integer.compare(o1.getAge(), o2.getAge());
        } else if (type.equals("name")){
            resultat = o1.getName().compareTo(o2.getName());
        }else if (type.equals("type")){
            resultat = o1.getType().compareTo(o2.getType());
        }

        if (direction.equals("DESC")) {
            resultat = resultat * -1;
        }
        return resultat;
    }
}
