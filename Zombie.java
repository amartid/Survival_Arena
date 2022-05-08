import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int animateImage = 0;
    int count;
    int health = 2;
    Player player;
    Counter counter;

    MyWorld myworld = (MyWorld) getWorld();
    int speed;
    public Zombie(Player mainPlayer,Counter counter, int speed)
        {
        this.counter=counter;
        player = mainPlayer;
        setImage("walk0031.png");
        getImage().scale(160,160);
        this.speed = speed;
    }
    public void act()
    {
        count++;
        animate();
        moveAround();
        hitByBullet();
    }
    //animate our zombie
    public void animate()
    {
        if(count % 5 == 0)
        {   
            if (animateImage >31)
                animateImage = 0;
            if (animateImage < 10)
            {
                setImage("walk000"+ animateImage +".png");
            }
            if (animateImage >= 10)
            {
                setImage("walk00"+ animateImage +".png");
            }
            animateImage++;
        }
    }
    public void moveAround()
    {
        move(1);
        turnTowards(player.getX(),player.getY());  
    }
    public void hitByBullet()
    {
        Actor tile = getOneIntersectingObject(Bullet.class);
        if(tile != null)
        {
            health--;
            getWorld().removeObject(tile);
        }
        if (health == 0)
        {
            counter.score+=2;
            World world =getWorld();
            MyWorld myworld = (MyWorld)world;
            if(myworld.getLevels()[myworld.getCurrent()][0]<= this.counter.score){
                myworld.levelIncrease();
            }
            counter.money+=10;
            getWorld().removeObject(this);
        }
    }
}
