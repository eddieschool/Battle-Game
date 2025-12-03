import java.util.Random;
/**
 * Write a description of class Fighter here.
 * The fighter class will be used to represent our two fighters, with the
 * instance variables being health points, attack dmg, and healing amount
 * Each figher can deal a random amount of dmg, take damage, or choose to
 * heal themselves on a given turn 
 *
 * @author (Eddie Kaake)
 * @version (A-Level) 
 */
public class Fighter
{
    // instance variables - replace the example below with your own
    private String name;
    private int healthPoints;
    private int attackDamage;
    private Random rng; 
    private int healAmount; //added in level B 

    /**
     * Constructor for objects of class Fighter
     * this is the constructor for Fighter class ^^^ that sets the
     * values of our variables. This means that it makes a fighter
     * (I named mine Ed) and gives them 100 health, 30 attack damage
     * note that attack dmg will be randomized
     * and also 15 as their healing amount 
     */
    //default constructor 
    public Fighter()
    {
        // initialise instance variables
        name = "Ed";
        healthPoints = 100;
        healAmount = 15; 
        attackDamage = 30;
        rng = new Random();
    }
    //below is the parameterized constructor 
    /**
     * this is a parameterized version of the class. This creates a fighter
     * with custom values
     */
    public Fighter(String n, int hp, int ad, int ha) 
    {
        name = n; 
        healthPoints = hp;
        attackDamage = ad;
        healAmount = ha; 
        rng = new Random();
    }
    
    /**
     * Getter methods (accessor) ;d
     * get the fighters name 
     */
    public String getName()
    {
        return name; 
    }
    /**
     * Accessor method to get the fighters health  points
     */
    public int getHealthPoints()
    {
        return healthPoints;
    }
    
    /**
     * Accessor to get the fighter's attack damage 
     */
    public int getAttackDamage()
    {
        return attackDamage; 
    }
    
    /**
     * Accessor to get the fighter's healing amount 
     */
    public int getHealAmount()
    {
        return healAmount;
    }
    
    //Damage dealer method * 
    /** 
     * deals a random amount of damage between 1 and the attack damage
     * defined in the fighter. then prints the damage dealt & returns
     * the amount
     */
    public int dealDamage()
    {
        int randomDamage = rng.nextInt(attackDamage) + 1;
        System.out.println(name + " deals " + randomDamage + " damage.");
        return randomDamage;
    }
    
    //Damage taker method 
    /**
     * Reduces the defending fighters health points by the amount specified
     * in the damage dealing method 
     */
    public void takeDamage(int amount)
    {
        healthPoints = healthPoints - amount; 
        System.out.println(name + " was attacked. Now has " + healthPoints + " health.");
    }
    
    //Heal method 
    /**
     * Heals the fighter by a random number between 1 and the
     * healing amount defined in the fighter 
     */
    public void heal()
    {
        int randomHeal = rng.nextInt(healAmount) + 1; //randomizes
        healthPoints = healthPoints + randomHeal;
        System.out.println(name + " healed " + randomHeal + " damage. Now has " + healthPoints + " health.");
        
    }

    /**
     * returns a string that tells us the details of the fighter
     * includes their name, how much health, how much dmg they can do
     * and how much they can heal 
     */
    public String toString()
    {
        return name + " has " + healthPoints + " health, can deal " + attackDamage + " damage, and can heal " + healAmount + ".";
            
    }
    //hoi hoi 
}
