package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {

    private Matcher[] matches;

    public Or(Matcher... matches) {
        this.matches = matches;
    }

    @Override
    public boolean matches(Player p) {
        for(Matcher matcher : matches) {
            if(matcher.matches(p)) {
                return true;
            }
        }

        return false;
    }
}