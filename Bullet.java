import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Player p = new Player();
    public Bullet(int speed,Player p)
    {   
        Greenfoot.playSound("gun.mp3");
        setImage(new GreenfootImage( 5, 5));
        getImage().setColor(Color.RED);
        getImage().fillRect(0,0,5,5);
        this.setRotation(p.getRotation());
        //setImage("fire.png"); //an thelw na fainetai h eikona
    }
    public void act()
    {
        move(20);
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
