import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class StartScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public StartScreen()
    {    
        super(1000, 800, 1); 
        instructions();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("Space"))
            Greenfoot.setWorld(new MyWorld());
    }
    public void instructions()
    {
        String text = "Welcome to Survival Arena!";
        text += "\n\nUse ARROWS / WASD on Keyboard to MOVE";
        text += "\n\nMove the MOUSE to AIM";
        text += "\n\nPress SPACE to SHOOT";
        text += "\n\nIf a zombie toutches you, you will lose health";
        text += "\n\nCollect enough money and get improvements on your weapon";
        text += "\n\nTry to eliminate all the zombies to advance to the next level";
        text += "\n\nPress Space to start. Good Luck!";
        GreenfootImage textImg = new GreenfootImage(text, 24, Color.BLACK, new Color(0, 0, 0, 0));
        getBackground().drawImage(textImg, (getWidth()-textImg.getWidth())/2, (getHeight()-textImg.getHeight())/2);
    }
}