package Task8;

public abstract class Participant {
    protected String name;
    protected int maxRunDistance;
    protected int maxJumpHeight;

    public Participant(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " ran " + distance + " meters.");
        } else {
            System.out.println(name + " couldn't run " + distance + " meters.");
        }
    }

    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " jumped " + height + " meters.");
        } else {
            System.out.println(name + " couldn't jump " + height + " meters.");
        }
    }
}