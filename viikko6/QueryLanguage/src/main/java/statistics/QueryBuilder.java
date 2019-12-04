package statistics;

import java.util.Stack;

import statistics.matcher.*;

public class QueryBuilder {
    
    Stack<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new Stack<>();
    }

    public Matcher build() {
        Matcher matcher = new And(matchers.toArray(new Matcher[matchers.size()]));
        matchers.clear();
        return matcher;
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }
}