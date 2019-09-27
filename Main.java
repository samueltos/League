package Generics;

public class Main {
    public static void main(String[] args) {
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer Beckham = new SoccerPlayer("Beckham");
        SoccerPlayer Oscar = new SoccerPlayer("Oscar");
        SoccerPlayer Hazard = new SoccerPlayer("Hazard");
        SoccerPlayer Pogba = new SoccerPlayer("Pogba");
        FootballPlayer Brady = new FootballPlayer("Brady");
        FootballPlayer Mckensine = new FootballPlayer("Mckensine");

        Team<FootballPlayer> Patriot = new Team<>("Patriot");
        Patriot.addPlayer(Brady);

        Team<FootballPlayer> Falcons = new Team<>("Falcons");
        Falcons.addPlayer(Mckensine);

        Team<SoccerPlayer> sam = new Team<>("Chelsea");
        //sam.addPlayer(pat);       we cant add this anymore cos type is selected in the diamond
        sam.addPlayer(Beckham);
        sam.addPlayer(Oscar);

        Team<SoccerPlayer> pet = new Team<>("Man U");
        pet.addPlayer(Pogba);
        pet.addPlayer(Hazard);

        sam.teamResults(pet, 3, 2);
        pet.teamResults(sam, 2, 5);

        System.out.println("Ranking: ");
        System.out.println(sam.getName()+": " +sam.ranking());
        System.out.println(pet.getName()+": " +pet.ranking());
        System.out.println(Falcons.getName()+": " +Falcons.ranking());



    }
}
