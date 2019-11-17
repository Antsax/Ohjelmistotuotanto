
package ohtu;

public class Player {
    private String name;
    private String goals;
    private String assists;

    public void setName(String name, String goals, String assists) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", goals: " + goals + ", assists: " + assists;
    }
      
}
