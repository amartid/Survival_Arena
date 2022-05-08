import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 52.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    int score;
    public String text= "Game Over";
    
    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score)
    {   
        World world =getWorld();
        MyWorld myWorld = (MyWorld)world;
        this.score=score;
    }
    public void changeText(){
        text= "You Win";
    }
    public void updateScore(int score){
        this.score=score;
        makeImage(text, "Score: ", score);
    }
    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 200);
        setImage(image);
    }
}
