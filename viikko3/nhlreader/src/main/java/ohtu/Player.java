
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private int goals;
    private int assists;
    private String team;

    public void setName(String name, int goals, int assists, String team) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    @Override
    public String toString() {
        return name + "\t \t" + team + "\t" + goals + " + " + assists + " = " + (goals + assists);
    }

    @Override
    public int compareTo(Player a) {
        return (a.getGoals() + a.getAssists()) - (this.getGoals() + this.getAssists());
    }
}
