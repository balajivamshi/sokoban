import java.awt.Image;
import javax.swing.ImageIcon;
	public class Area extends Actor
	{
	    public Area(int X, int Y)
	    {
	        super(X, Y);
	        initialArea();
	    }
	    private void initialArea() {
	        ImageIcon Icon = new ImageIcon("src/resources/area.png");
	        Image image = Icon.getImage();
	        setImage(image);
	    }
	}