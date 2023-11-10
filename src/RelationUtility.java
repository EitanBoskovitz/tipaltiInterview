import java.util.*;

public class RelationUtility {
    private Map<Person, List<Person>> people;

    public void init(Person[] people){
        this.people = new HashMap<>();

        for (Person person : people) {
            ArrayList<Person> neighbors = new ArrayList<>();

            for (Person other : people) {
                if (areRelated(person, other) && !person.equals(other)) {
                    neighbors.add(other);
                }
            }

            this.people.put(person, neighbors);
        }

   }

    public int findMinRelationLevel(Person personA, Person personB){
        if (people == null || people.isEmpty()) {
            throw new IllegalStateException("Utility not initialized.");
        }

        if (personA == personB) {
            return 0; // They are the same person.
        }

        if (areRelated(personA, personB)) {
            return 1; // They are directly related.
        }

        Queue<Person> queue = new LinkedList<>();
        Set<Person> visited = new HashSet<>();
        Map<Person, Integer> relationLevel = new HashMap<>();

        queue.offer(personA);
        visited.add(personA);
        relationLevel.put(personA, 0);


        while (!queue.isEmpty()) {
            Person current = queue.poll();
            int currentLevel = relationLevel.get(current);

                if (areRelated(current, personB)) {
                    return currentLevel + 1;
                }

                for (Person neighbor : this.people.get(current)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                        relationLevel.put(neighbor, currentLevel + 1);
                    }
                }

        }

        return -1; // No path found between personA and personB.
    }

    private boolean areRelated(Person personA, Person personB){
        return personA.getFullName().equals(personB.getFullName()) || personA.getAddress().equals(personB.getAddress());
    }
}
