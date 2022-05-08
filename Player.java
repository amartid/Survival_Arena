import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int  p_size = 50;
    int speed = 2;
    int time = 0;
    int animateImage = 0;
    int count;
    WeaponButton weaponButton;
    public void eatHealthPack()
    {
        Actor actor = getOneObjectAtOffset(0, 0, HealthPack.class);
        if (actor != null) 
        {
            getWorld().removeObject(actor);
            World world =getWorld();
            MyWorld myworld = (MyWorld)world;
            myworld.getHealthBar().heal();
        }
    }
    public Player()
    {
        //GreenfootImage image = getImage();
        //image.scale(image.getWidth() - 10, image.getHeight() - 10);
        //setImage(image);
        //setImage(new GreenfootImage( p_size+20, p_size));
        //getImage().setColor(Color.MAGENTA); 
        //getImage().fillOval( 0, 0, p_size, p_size);
        //getImage().setColor(Color.BLUE);
        //getImage().fillRect(50, 20,60,10);
        setImage("survivor0.png");
        
    }
    public Player(WeaponButton weaponButton)
    {
        this.weaponButton = weaponButton;
        setImage("survivor0.png");
        
    }
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireBullet();
        hitByZombie();
        eatHealthPack();
    }
    public void animate()
    {
        if((count % 30 == 0))
        {   
            if (animateImage >8)
                animateImage = 0;
            if (animateImage <=8 )
            {
                setImage("survivor"+ animateImage +".png");
            }
            animateImage++;
        }
    }
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() !=null)
            turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
    }
    public void moveAround()
    {   
        
        if(Greenfoot.isKeyDown("w"))
            setLocation(getX(),getY()-speed);
        if(Greenfoot.isKeyDown("a"))
            setLocation(getX()-speed,getY());
        if(Greenfoot.isKeyDown("s"))
            setLocation(getX(),getY()+speed);
        if(Greenfoot.isKeyDown("d"))
            setLocation(getX()+speed,getY());
        //Move ARROW KEYS
        if(Greenfoot.isKeyDown("Up"))
            setLocation(getX(),getY()-speed);
        if(Greenfoot.isKeyDown("Left"))
            setLocation(getX()-speed,getY());
        if(Greenfoot.isKeyDown("Down"))
            setLocation(getX(),getY()+speed);
        if(Greenfoot.isKeyDown("Right"))
            setLocation(getX()+speed,getY());
    }
    private int ultratime = 0;
    public void fireBullet()
        {
            if ("space".equals(Greenfoot.getKey()))
            {             
                if(weaponButton.weaponUpgrade == 1)
                {
                    Bullet bullet = new Bullet(10,this);
                    getWorld().addObject(bullet,getX(), getY());
                }else if (weaponButton.weaponUpgrade == 2)
                {                    
                    Bullet bullet = new Bullet(10,this);
                    getWorld().addObject(bullet,getX(), getY());
                    Bullet slowBullet = new Bullet(20,this);
                    getWorld().addObject(slowBullet,getX(), getY());
                }
            }
            if (Greenfoot.isKeyDown("space"))
            {
                if(weaponButton.weaponUpgrade == 3 && (ultratime <= 115))
                {   ultratime--;
                    Bullet multiple = new Bullet(30,this);
                    getWorld().addObject(multiple,getX(), getY());
                    if (ultratime <=  0)
                    {
                        weaponButton.weaponUpgrade = 2 ;
                    }
                }
            }
        }
    public boolean hitByZombie()
    {
        Actor zombie = getOneObjectAtOffset(0, 0, Zombie.class);
        if(zombie!=null)
        {
            return true;
        }
        else
        return false;
        }
    }


  