	import java.awt.Image;
	public class Actor {

	    private final int SPACE = 20;

	    private int M;
	    private int N;
	    private Image image;

	    public Actor(int M, int N) {
	        
	        this.M = M;
	        this.N = N;
	    }

	    public Image getImage() {
	        return image;
	    }

	    public void setImage(Image img) {
	        image = img;
	    }

	    public int M() {
	        
	        return M;
	    }

	    public int N() {
	        
	        return N;
	    }

	    public void setM(int M) {
	        
	        this.M = M;
	    }

	    public void setN(int N) {
	        
	        this.N = N;
	    }

	    public boolean isLftColision(Actor actor) {
	        
	        return M() - SPACE == actor.M() && N() == actor.N();
	    }

	    public boolean isRghtColision(Actor actor) {
	        
	        return M() + SPACE == actor.M() && N() == actor.N();
	    }

	    public boolean istopcollsion(Actor actor) {
	        
	        return N() - SPACE == actor.N() && M() == actor.M();
	    }

	    public boolean isBottomCollision(Actor actor) {
	        
	        return N() + SPACE == actor.N() && M() == actor.M();
	    }
	
}
