package pl.edu.agh.project.drill.manager;

public class PointCounterWithSubstracting implements ICounter {

    private int score = 0;

    public int getScore() {
        return score;
    }

    public void addPoint() {
        score++;
    }

    public void subtractPoint() {
        score--;
    }
}
