	import java.awt.Image;
	import javax.swing.ImageIcon;

	public class Boxes extends Actor {

	    public Boxes(int x, int y) {
	        super(x, y);
	        initBaggage();
	    }
	    private void initBaggage() {   
	        ImageIcon iicon = new ImageIcon("src/resources/baggage.png");
	        Image image = iicon.getImage();
	        setImage(image);
	    }
	    public void move(int x, int y) {   
	        int dx = M() + x;
	        int dy = N() + y;
	        setM(dx);
	        setN(dy);
	    }
}
