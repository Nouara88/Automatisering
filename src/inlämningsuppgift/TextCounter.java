package inlämningsuppgift;

public class TextCounter {

    private String input;

    public TextCounter(String myInput) {
        input = myInput;

    }

    public int charactersCounter() {
        return input.length();
    }

    public int linesCounter() {
        String[] lines = input.split("\n");
        return lines.length;

    }

    public void countPrinter() {
        int characters = charactersCounter();
        int lines = linesCounter();

        System.out.println("Antal tecken är: " + characters);
        System.out.println("Antal rader är: " + lines);

    }


}








