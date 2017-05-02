
package statistics;

import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;
import statistics.matcher.or;


public class QueryBuilder {
    
//    QueryBuilder rakenna = new QueryBuilder();
//
//    Query pino = rakenna.pino();
    Matcher matcher;
    
    public QueryBuilder() {
        this.matcher= new And();
    }
    public QueryBuilder PlaysIn(String team) {
        this.matcher= new And(matcher, new PlaysIn(team));
        return this;
    }
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher=new And(matcher, new HasAtLeast(value,category));
        return this;
    }
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher=new And(matcher, new HasFewerThan(value,category));
        return this;
    }
    public QueryBuilder oneOf(Matcher a, Matcher b) {
        this.matcher=new or(a,b);
        return this;
    }
    public void reset() {
        this.matcher = new And();
    }

    public Matcher build(){
        return matcher;
    }


}
