import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponButton extends Actor
{
    /**
     * Act - do whatever the weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Counter counter;
    int weaponUpgrade =1;
    public WeaponButton(Counter counter)
    {
        this.counter = counter;
        setImage(new GreenfootImage("Weapon \n Upgrade", 25, Color.BLUE , new Color(0,0,0,0)));    
    }
    public void act()
    {
        if (Greenfoot.mousePressed(this) && counter.money > 100)
        {   if (weaponUpgrade<3){
                counter.money -= 50;
                weaponUpgrade++;}
        }
    }
}