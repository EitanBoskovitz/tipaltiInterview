import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person graceHopper = new Person(new Name("Grace", "Hopper"), new Address("new", "york"));
        Person AlanTuring = new Person(new Name("Alan", "Turing"), new Address("bletchley", "park"));
        Person AnotherAlanTuring = new Person(new Name("Alan", "Turing"), new Address("cam", "bridge"));
        Person JoanClarke = new Person(new Name("Joan", "Clarke"), new Address("bletchley", "park"));
        Person AnotherJoanClarke = new Person(new Name("Joan", "Clarke"), new Address("lon", "don"));
        Person charlesDickens = new Person(new Name("Charles", "dickens"), new Address("lon", "don"));

        Person[] people = new Person[6];
        people[0] = graceHopper;
        people[1] = AlanTuring;
        people[2] = AnotherAlanTuring;
        people[3] = JoanClarke;
        people[4] = AnotherJoanClarke;
        people[5] = charlesDickens;


        RelationUtility relationUtility = new RelationUtility();
        relationUtility.init(people);
        int minRelation = relationUtility.findMinRelationLevel(AlanTuring, charlesDickens);
        System.out.println("min relation is: " + minRelation);

    }
}
