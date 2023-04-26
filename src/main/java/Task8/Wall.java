package Task8;

public class Wall extends Obstacle {
    public Wall(int height) {
        super(height);
    }

    @Override
    public void overcome(Participant participant) {
        participant.jump(difficulty);
        if (participant.maxJumpHeight < difficulty) {
            System.out.println(participant.name + " couldn't jump over the wall.");
            throw new RuntimeException(participant.name + " couldn't jump over the wall.");
        }
    }
}