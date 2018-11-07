	import java.awt.Image;
	import javax.swing.ImageIcon;

	public class Player extends Actor {

	    public Player(int m, int n) {
	        super(m, n);

	        initPlayer();
	    }

	    private void initPlayer() {

	        ImageIcon Icon = new ImageIcon("src/resources/sokoban.png");
	        Image image = Icon.getImage();
	        setImage(image);
	    }

	    public void move(int m, int n) {

	        int dx = M() + m;
	        int dy = N() + n;
	        
	        setM(dx);
	        setN(dy);
	    }
}
