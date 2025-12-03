import java.util.Scanner; //adding scanner to battle (B level) 

/**
 * The battle class manages the turn-based battles between the two
 * objects of the fighter class. it runs turns, swaps attack and defense
 * , tacks the # of rounds played, and checks the attackers health
 * to determine when the battle has ended.
 */

public class Battle
{
    // instance variables - replace the example below with your own
    private Fighter attacker;
    private Fighter defender;
    private int numRounds;
    private Scanner scan; 
    private boolean battleOver;

   
    //parameterized constructor 
    /**
     * Parameterized constructor to create a battle between 2
     * Fighter objects. It starts the battle with the first
     * attacker as (a) and the defender is the second Fighter, (b)
     */
    public Battle(Fighter a, Fighter b)
    {
        
        attacker = a;
        defender = b;
        numRounds = 0; 
        scan = new Scanner(System.in); //initialize scanner
        battleOver = false; //since the battle is just starting 
    }
    
    //getter methods (accessor)
    /**
     * An accessor method to return the attacker Fighter
     */
    public Fighter getAttacker() 
    {
        return attacker; 
    }
    
    /**
     * An accessor method to return the defender Fighter
     */
    public Fighter getDefender()
    {
        return defender;
    }
    /**
     * An accessor method to get the amount of rounds played 
     */
    //getter for numRounds (C)
    public int getNumRounds()//int because numRounds isn't a class like fighter
    {
        return numRounds; 
    }
    /**
     * An accessor method to check if the battle should end 
     */
    public boolean getBattleOver()
    {
        return battleOver; 
    }
    
    //takeTurn method UPDATED for B 
    /**
     * Take turn method that handles a turn in the battle, this prompts
     * the attacker to choose their action (attack or heal) and executes
     * the chosen action. If an attacker chooses to attack and the defender
     * health drops to or below 0, the battle will end
     */
    public void takeTurn()
    {
        System.out.println(attacker.getName() + ", do you want to attack or heal? ");
        String choice = scan.nextLine();
        
        if (choice.equals("attack"))
        {
            int amount = attacker.dealDamage();
            defender.takeDamage(amount);
            
            if (defender.getHealthPoints() <= 0 )
            {
                battleOver = true; 
            }
        }
        else if (choice.equals("heal"))
        {
            attacker.heal();
        }
        else {
            System.out.println("That was not a valid choice, you have lost your turn.");
        }
        
        numRounds = numRounds + 1; //adds round number after turn*
    }
    
    //swap fighters method
    /**
     * the swapFighters method switches Fighter a and b from attacking to
     * defending, using a temp Fighter to store the data of one before
     * it is switched (elsewise, data would be erased and the program
     * would not work) 
     */
    public void swapFighters()
    {
        //
        Fighter temp = attacker; //we need temp variable so we don't erase..
        attacker = defender; //    ..the original attacker
        defender = temp; 
    }
    
    //round update method 
    /**
     * The printRoundUpdate is mainly for aesthetics, but prints the number
     * of rounds and both fighter a and b's health points 
     */
    
    public void printRoundUpdate()
    {
        System.out.println("ROUND " + numRounds);
        System.out.println("------"); //this is to make it look like the sample code
        System.out.println(attacker.getName() + ":" + attacker.getHealthPoints() + "    " + defender.getName() + ":" + defender.getHealthPoints());
        
    }

    //printStartInfo method 
    /**
     * This prints the starting info at the beginning of a battle 
     * includes a welcome message and stats of both figures 
     */
    public void printStartInfo()
    {
        System.out.println("Welcome to a fight between " + attacker.getName() + " and " + defender.getName() + ".");
        System.out.println(attacker); //this automatically calls the toString method
        System.out.println(defender); // I'm not 100% on what that means :)
        System.out.println(); //empty line for format
    }
    
    //printEndInfo method
    /**
     * prints the ending information for the battle, the health points
     * of each fighter, and which fighter won 
     */
    public void printEndInfo()
    {
        System.out.println("Battle over!");
        System.out.println(attacker.getName() + ":" + attacker.getHealthPoints() + "    " + defender.getName() + ":" + defender.getHealthPoints());
        
        if (attacker.getHealthPoints() > defender.getHealthPoints())
        {
            System.out.println(attacker.getName() + " won!");
            
        }
        else {
            System.out.println(defender.getName() + " won!");
        }
    }
}
