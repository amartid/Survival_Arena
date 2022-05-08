import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int count = 0;
    //spawn speed low then faster
    int spawnSpeed=50;
    int randomSpawn;
    public Player mainPlayer = new Player();
    int[][] levels = {
        {10,50,0,7*50,1},
        {30,35,1,7*30,3},
        {100,30,2,7*20,4},
        {150,15,3,7*10,6}
    };
    int current;
    int zombieSpeed;
    //public ScoreBoard scoreboard = new ScoreBoard(0); 
    Counter counter = new Counter();
    LevelCounter levecounter = new LevelCounter();
    HealthBar healthbar = new HealthBar(counter);
    WeaponButton weaponButton = new WeaponButton(counter);
    HealthPack healthPack = new HealthPack();
    public GreenfootSound backgroundMusic = new GreenfootSound("Rising Tide.mp3");
    public void started()
    {
        backgroundMusic.playLoop();
    }
    
    public void stopped()
    {
        backgroundMusic.pause();
    }
    
    public MyWorld()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        started();
        this.spawnSpeed=levels[current][1];
        levecounter.zss=levels[current][1];
        levecounter.levelind=current+1;
        levecounter.goal=levels[current][0];
        addObject(levecounter, 200,700);
        //setBackground(new GreenfootImage("world.png"));
        mainPlayer = new Player(weaponButton);
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 130,100);
        addObject(healthbar,130,50);
        addObject(weaponButton, 900,100);
        
    }
    public Player getPlayer()
    {
        return mainPlayer;
    }
    public void act()
    {
        count++;
        spawnZombies();
        
    }
    public void spawnZombies()
    {
        if (count % spawnSpeed == 0)
            {
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch (randomSpawn)
            {
                case 0 : addObject(new Zombie(mainPlayer,counter,zombieSpeed), 0, 0); break;
                case 1 : addObject(new Zombie(mainPlayer,counter,zombieSpeed), getWidth()/2, 0); break;
                case 2 : addObject(new Zombie(mainPlayer,counter,zombieSpeed), getWidth(), 0); break;
                case 3 : addObject(new Zombie(mainPlayer,counter,zombieSpeed), 0, getHeight()/2); break;
                case 4 : addObject(new Zombie(mainPlayer,counter,zombieSpeed), getWidth(), getHeight()/2); break;
                case 5 : addObject(new Zombie(mainPlayer,counter,zombieSpeed), 0, getHeight()); break;
                case 6 : addObject(new Zombie(mainPlayer,counter,zombieSpeed), getWidth()/2, getHeight()); break;
                case 7 : addObject(new Zombie(mainPlayer,counter,zombieSpeed), getWidth(), getHeight()); break;
            }
        }
        if (count % this.levels[current][3]==0){
            addObject(healthPack,600,600);
        }
    }
    public HealthBar getHealthBar()
    {
        return healthbar;
    }
    public Counter getCounter()
    {
        return counter;
    }
    public void levelIncrease(){
        Greenfoot.playSound("special.mp3");
        if(levels[current][2]<levels.length-1){
            this.spawnSpeed=levels[current][1];
            this.zombieSpeed=levels[current][4];
            healthbar.heal();
            //this.levelview();
            this.current=current+1;
            levecounter.zss=levels[current][1];
            levecounter.levelind=current+1;
            levecounter.goal=levels[current][0];
        }else{
            healthbar.setWonText();
            healthbar.health=0;
        }
    }
    //public void levelview(){
       // GreenfootImage L = getBackground();
      //  Font font = L.getFont();
       // L.setColor(Color.BLACK);
       // L.setFont(font.deriveFont(40));
        //L.drawString("Level : "+ (this.levels[current][2]+1) + "\n\n Goal :"+levels[current][0]+"\n\nZombie Spawn Speed :"+levels[current][1], 100, 200);
    //}
    public int[][] getLevels(){
        return levels;
    }
    public int getCurrent(){
        return current;
    }
}