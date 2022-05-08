import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends MyWorld
{

    /**
     * Constructor for objects of class LevelOne.
     * 
     */
    int time_per_zombie_spawn;
    int score_to_start;
    int number_of_level;
    
    public Level()
    {
    }
    public Level(int score_to_start, int time_per_zombie_spawn,int number_of_level)
    {
        this.score_to_start = score_to_start;
        this.time_per_zombie_spawn = time_per_zombie_spawn;
        this.number_of_level = number_of_level;
    }

}
