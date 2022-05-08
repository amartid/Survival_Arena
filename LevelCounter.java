import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lv here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCounter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int levelind;
    int goal;
    int zss;
    public void LevelCounter()
    {   
        setImage(new GreenfootImage("Level: " + levelind
                                    +"\n Goal: "+ goal
                                    +"\n ZombieSpawnSpeed: " + zss ,40, Color.BLACK, new Color (0,0,0,0)));
    }
    public void act()
    {   
        setImage(new GreenfootImage("Level: " + levelind
                                    +"\n Goal: "+ goal
                                    +"\n ZombieSpawnSpeed: " + zss ,40, Color.BLACK, new Color (0,0,0,0)));
    } 
}
