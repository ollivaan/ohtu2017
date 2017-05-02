package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstatistics.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m1 = query.PlaysIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();
        query.reset();
        
        Matcher m2 = query.PlaysIn("NYR")
                     .hasAtLeast(10, "goals")
                     .hasFewerThan(25, "assists").build();
        query.reset();
        
        Matcher m = query.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
