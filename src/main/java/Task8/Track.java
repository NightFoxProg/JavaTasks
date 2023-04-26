package Task8;

public class Track extends Obstacle {
    public Track(int length) {
        super(length);
    }

    @Override
    public void overcome(Participant participant) {
        participant.run(difficulty);
        if (participant.maxRunDistance < difficulty) {
            System.out.println(participant.name + " couldn't finish the track.");
            throw new RuntimeException(participant.name + " couldn't finish the track.");
        }
    }
}