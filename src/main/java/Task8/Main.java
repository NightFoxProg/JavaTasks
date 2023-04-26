package Task8;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human("Alice", 500, 2),
                new Cat("Bob", 200, 3),
                new Robot("Charlie", 1000, 1)
        };

        Obstacle[] obstacles = {
                new Track(400),
                new Wall(2),
                new Track(800),
                new Wall(3)
        };

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                try {
                    obstacle.overcome(participant);
                    System.out.println(participant.name + " passed the obstacle.");
                } catch (RuntimeException e) {
                    System.out.println(participant.name + " failed the obstacle.");
                    break;
                }
            }
        }
    }
}