import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter
{
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0)
        {
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - 0.05));
            int green = (int) (c.getGreen() * (1 - 0.05));
            int blue = (int) (c.getBlue() * (1 - 0.05));

            setColor(new Color(red, green, blue));
            return;
        }
        int r = (int) (Math.random() * n);
        Actor other = actors.get(r);
        setColor(other.getColor());
    }
    
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
    
    public ArrayList<Actor> getActors()
    {
        return getGrid().getNeighbors(getLocation());
    }
}
