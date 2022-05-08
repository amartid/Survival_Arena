import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{   
    Counter counter;
    /**
     * Act - do whatever the healthbar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld myworld = (MyWorld) getWorld();
    public int health = 100;
    public ScoreBoard scoreboard;
    public HealthBar(Counter counter)
    {
        setImage(new GreenfootImage(102,12));
        getImage().drawRect(0, 0, 101,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1 ,1 , health, 10);
        this.counter=counter;
        scoreboard=new ScoreBoard(counter.score);
    }
    public void act()
    {
        setImage(new GreenfootImage(102,12));
        getImage().drawRect(0, 0, 101,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1 ,1 , health, 10);
        loseHealth();
    }
    public void loseHealth()
    {
        World world =getWorld();
        MyWorld myworld = (MyWorld)world;
        if (myworld.getPlayer().hitByZombie())
        {
            health--;
        }
        if(health<=0)
        {   
            scoreboard.updateScore(counter.score);
            myworld.addObject(
                scoreboard,
                myworld.getWidth()/2,
                myworld.getHeight()/2
            );
            //getWorld().showText("You Lose! \n You Survived for " + (myWorld.getPlayer().time/60) + "seconds",
            //getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    public void heal()
    {
        health =+100;
        Greenfoot.playSound("heal.wav");
    }
    public void setWonText(){
        scoreboard.changeText();
    }
    public int getScore(){
        return this.counter.score;
    }
}
