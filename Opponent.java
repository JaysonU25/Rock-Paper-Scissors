package RPS;

public class Opponent {
    private String name;
    private rpsChoice choice;

    public Opponent(){
        name = "Challenger";
        choice = choose();
    }

    public Opponent(String name1, rpsChoice choice1){
        name = name1;
        choice = choice1;
    }

    public String getName(){
        return name;
    }

    public rpsChoice getChoice(){
        return choice;
    }

    public void setName(String name1){
        name = name1;
    }

    public void setChoice(rpsChoice choice1){
        choice = choice1;
    }

    public rpsChoice choose(){
        double throwChance = (Math.random() * 100) + 0;

        if(throwChance < 35.4){
            return rpsChoice.ROCK;
        } else if (throwChance < 70.4){
            return rpsChoice.PAPER;
        } else {
            return rpsChoice.SCISSORS;
        }
    }
}
