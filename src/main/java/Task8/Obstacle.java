package Task8;

public abstract class Obstacle {
    protected int difficulty;

    public Obstacle(int difficulty) {
        this.difficulty = difficulty;
    }

    public abstract void overcome(Participant participant);
}