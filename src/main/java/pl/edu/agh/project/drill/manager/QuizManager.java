package pl.edu.agh.project.drill.manager;

import java.util.ArrayList;
import pl.edu.agh.project.drill.model.*;
import java.util.Collections;

public class QuizManager implements IQuizManager {
    private ICounter pointCounter;

    public QuizManager() {
        this.pointCounter = new PointCounter(); // bo inaczej zle laduje
    }

    public void checkAnswers(ArrayList<String> answers, Question currentQuestion) {
        if (equalAnswers(answers, currentQuestion))
            pointCounter.addPoint();
        else
            pointCounter.subtractPoint();
    }

    public int getPoints() {
        return pointCounter.getScore();
    }

    private boolean equalAnswers(ArrayList<String> answers, Question currentQuestion) {
        if (answers == null && currentQuestion.getCorrectAnswers() == null) return true;
        if ((answers == null && currentQuestion.getCorrectAnswers() != null) || (answers != null && currentQuestion.getCorrectAnswers() == null) || answers.size() != currentQuestion.getCorrectAnswers().size())
            return false;

        ArrayList<String> sortedUserAnswers = new ArrayList<>(answers);
        ArrayList<String> sortedAnswers = new ArrayList<>(currentQuestion.getCorrectAnswers());

        Collections.sort(sortedUserAnswers);
        Collections.sort(sortedAnswers);

        return sortedUserAnswers.equals(sortedAnswers);
    }

    public void setOption(int counterOption) {
        if (counterOption == 1) {
            pointCounter = new PointCounterWithSubstracting();
        } else if (counterOption == 2) {
            pointCounter = new PointCounterWithPartialSub();
        } else {
            pointCounter = new PointCounter();
        }
    }
}
