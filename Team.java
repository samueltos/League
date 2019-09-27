import java.util.ArrayList;

public class Team<T extends Player>implements Comparable<Team<T>> {
    private String name;
    int win = 0;
    int draw = 0;
    int lose = 0;
    int playedGames =0;

    private ArrayList<T> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(players.contains(player)){
            System.out.println(player.getName() +" is in the team already");
            return false;
        }else{
            players.add(player);
            System.out.println(player.getName() + " picked for "+this.name + " team");
            return true;
        }
    }

    public int numPlayers(){
        return players.size();
    }

    public void teamResults(Team<T> OpponentName, int ourScore, int theirScore){
        String message = "";

        if(ourScore > theirScore){
            message = this.name+" Won";
            win++;
        }else if(ourScore == theirScore){
            message = "the game is tied";
            draw++;
        }else{
            message = this.name+" lost to";
            lose++;
        }
        playedGames++;

        if(OpponentName != null){
            System.out.println(message + " "+ OpponentName.getName());
            OpponentName.teamResults(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (this.win * 3) + this.draw;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
