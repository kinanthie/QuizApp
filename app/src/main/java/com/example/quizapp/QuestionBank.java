package com.example.quizapp;

public class QuestionBank {

    private String textQuestion [] = {
            "1. Siapakah penemu jaringan 4G?",
            "2. Selain Mark Zuckerberg siapakah pendiri facebook dibawah ini, kecuali?",
            "3. Kapan Facebook didirikan?",
            "4. Dimanakah Bill gates mendirikan Microsoft?"

    };

    private String multipleChoice [][] = {
            {"Khoirul Anwar", "Khoirul", "Bill gates", "Anwar Khoirul"},
            {"Andrew McCollum", "Eduardo", "Dustin", "Kris"},
            {"2002", "2004", "2003", "2001"},
            {"New York", "Australia", "New Mexico", "Berlin"}

    };

    private String mCorrectAnswers[] = {"Khoirul Anwar", "Kris", "2004", "New Mexico"};


    public int getLength() { return textQuestion.length;}

    public String getQuestion(int a) {
        String question = textQuestion[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index] [num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
