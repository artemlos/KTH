import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling            balls.getClass(i).draw(); and David J. Barnes
 * @version 2011.07.31
 */
import java.util.HashSet;

public class BallDemo   
{
    private Canvas myCanvas;
    
    private ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>();
    private ArrayList<BoxBall> balls2 = new ArrayList<>();

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    
    /**
     * Simulate two bouncing balls
     */
    public void bounce(int amountOfBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground        BoxBall a = new BoxBall(1,2,16, Color.BLUE, ground, 10, 20, myCanvas);
        myCanvas.drawLine(50, ground, 550, ground);

        for(int i = 0; i < amountOfBalls; i++)
        {
            balls.add(new BouncingBall(randInt(0,550) , randInt(0,ground), 16, Color.BLUE, ground, myCanvas));
            balls.get(i).draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            
            Iterator it = balls.iterator();
            
            while(it.hasNext())
            {
                ((BouncingBall)it.next()).move();
            }
            myCanvas.wait(50);           // small delay
          
            // stop once ball has travelled a certain distance on x axis
            
            Iterator it2 = balls.iterator();
            
            while(it2.hasNext() && !finished)
            {
                if(((BouncingBall)it2.next()).getXPosition() >= 550)
                {
                    finished=true;
                }
            }
        }
        
    }
    
    public void BoxBounce(int noOfBalls)
    {
        myCanvas.setVisible(true);
        myCanvas.setForegroundColor(Color.GREEN);
        myCanvas.setBackgroundColor(Color.GREEN);

        myCanvas.fillRectangle(10, 20 , 300, 200);
     
        

        for(int i = 0; i < noOfBalls; i++)
        {
            balls2.add(new BoxBall(randInt(30,300) , randInt(56,200), 16, RandomColour(), 0, 10,20, myCanvas));
            balls2.get(i).setSpeed(randInt(1, 10));
            balls2.get(i).draw();
        }

        // make them bounce
        boolean finished =  false;
        while(true) {
            
            Iterator it = balls2.iterator();
            
            while(it.hasNext())
            {
                ((BoxBall)it.next()).move();
            }
            myCanvas.wait(50);           // small delay
          
            // stop once ball has travelled a certain distance on x axis
            
            Iterator it2 = balls2.iterator();
            
            while(it2.hasNext())
            {
                BoxBall current = (BoxBall)it2.next();
                if( current.getYPosition() >= 200 || current.getYPosition() <= 56)
                {
                    current.setSpeed(current.getSpeed() * -1);
                }
            }
        }
    }
    
    public Color RandomColour()
    {
        Random rm = new Random();
        
        float r = rm.nextFloat();
        float g = rm.nextFloat();
        float b = rm.nextFloat();
        
        return new Color(r,g,b);
        
    }
    
    
    private int randInt(int min, int max)
    {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
