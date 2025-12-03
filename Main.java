/**
 * This is the main class. It creates 2 fighter objects, then initiates a
 * Battle between them. So fighter 1 and fighter 2 will continually take
 * turns until one of their has healthPoints = 0. 
 * Until then, it runs in a while(continuous) loop until battleOver = true
 */

public class Main
{
    /**
     * Main method that creates fighters, starts a battle, and then runs
     * until a fighters health reaches 0 or below
     */
    public static void main(String[] args) {
        //creating fighter out of default constructor  
        Fighter fighter1 = new Fighter(); 
        
        //creating a fighter with parameterized constructor UPDATED B
        Fighter fighter2 = new Fighter("Kyle", 100, 30, 20); 
        
        //create battle object with fighters
        Battle battle = new Battle(fighter1, fighter2); 
        
        //Call printStartInfo
        battle.printStartInfo();
        
        while (!battle.getBattleOver()) //don't fully see why we need ! here
        {
            battle.printRoundUpdate();
            battle.takeTurn();
            battle.swapFighters();
        }
        battle.printEndInfo();
    }
}
