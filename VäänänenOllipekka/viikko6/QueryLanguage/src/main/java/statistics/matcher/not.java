
package statistics.matcher;

import statistics.Player;


public class not implements Matcher {
//    private Matcher[] matchers;
    private Matcher matchers;

    public not(Matcher matchers) {
        this.matchers=matchers;
    }
    
    @Override
    public boolean matches(Player p) {
       
            if (!matchers.matches(p)) {
                
                return true;
            }
        

        return false;
    }
    
}
