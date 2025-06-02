package marcos.psp.examen.trivialQuiz.model;

import java.util.List;

public class Result {
    private String type;
    private Difficult difficulty;
    private Categoria category;
    private String question;
    private String correctAnswer;
    private List<String>incorrectAnswers;


    public Result() {
    }
    public Result(String type, Difficult difficulty, Categoria category, String question, String correctAnswer, List<String> incorrectAnswers) {
        this.type = type;
        this.difficulty = difficulty;
        this.category = category;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }


    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    public Difficult getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(Difficult difficulty) {
        this.difficulty = difficulty;
    }


    public Categoria getCategory() {
        return category;
    }
    public void setCategory(Categoria category) {
        this.category = category;
    }


    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }


    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }
    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }


    @Override
    public String toString() {
        return "Result:\n " +
                "\ttype: " + type + '\n' +
                "\tdifficulty: " + difficulty +"\n"+
                "\tcategory: " + category +"\n"+
                "\tquestion: " + question + "\n" +
                "\tcorrectAnswer='" + correctAnswer + '\n' +
                "\tincorrectAnswers " + incorrectAnswers +"\n";
    }
}
