	import java.awt.Image;
	import javax.swing.ImageIcon;

	public class Wall extends Actor {

	    private Image image;

	    public Wall(int m, int n) {
	        super(m, n);
	        
	        initWall();  
	    }
	    
	    private void initWall() {
	        
	        ImageIcon Icon = new ImageIcon("src/resources/wall.png");
	        image = Icon.getImage();
	        setImage(image);
	    }
	}

