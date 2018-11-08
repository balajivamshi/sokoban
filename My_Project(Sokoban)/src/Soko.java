	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.util.ArrayList;
	import javax.swing.JPanel;
	import javax.swing.JOptionPane;
	public class Soko extends JPanel {
	    private final int OFFSET = 30;
	    private final int SPACE = 20;
	    private final int LEFT_COLLISION = 1;
	    private final int RIGHT_COLLISION = 2;
	    private final int TOP_COLLISION = 3;
	    private final int BOTTOM_COLLISION = 4;
	    private ArrayList<Wall> walls;
	    private ArrayList<Boxes> baggs;
	    private ArrayList<Area> areas;
	    
	    private Player soko;
	    private int w = 0;
	    private int h = 0;
	    
	    private boolean isCmpltd = false;

	    private String level
	            = "##############\n"
	            + "### @    #   #\n"
	            + "##       #   #\n"
	            + "##       ##  #\n"
	            + "##     #   $ #\n"
	            + "#####        #\n"
	            + "## $   #  #  #\n"
	            + "##   $   ## $#\n"
	            + "####     ##..#\n"
	            + "##       ##..#\n"
	            + "##############\n";

	    public Soko() {

	        initBoard();
	    }
	    public int getBoardWidth() {
	        return this.w;
	    }
	    private void initBoard() {

	        addKeyListener(new TAdapter());
	        setFocusable(true);
	        initWorld();
	    }
	    public int getBoardHeight() {
	        return this.h;
	    }
	    
	    private void initWorld() {
	        
	        walls = new ArrayList<>();
	        baggs = new ArrayList<>();
	        areas = new ArrayList<>();

	        int x = OFFSET;
	        int y = OFFSET;

	        Wall wall;
	        Boxes b;
	        Area a;

	        for (int k = 0; k < level.length(); k++) {

	            char item = level.charAt(k);

	            switch (item) {

	                case '\n':
	                    y += SPACE;

	                    if (this.w < x) {
	                        this.w = x;
	                    }

	                    x = OFFSET;
	                    break;

	                case '#':
	                    wall = new Wall(x, y);
	                    walls.add(wall);
	                    x += SPACE;
	                    break;

	                case '$':
	                    b = new Boxes(x, y);
	                    baggs.add(b);
	                    x += SPACE;
	                    break;

	                case '.':
	                    a = new Area(x, y);
	                    areas.add(a);
	                    x += SPACE;
	                    break;

	                case '@':
	                    soko = new Player(x, y);
	                    x += SPACE;
	                    break;

	                case ' ':
	                    x += SPACE;
	                    break;

	                default:
	                    break;
	            }

	            h = y;
	        }
	    }

	    private void Buildworld(Graphics g) {

	        g.setColor(new Color( 0, 255, 0));
	        g.fillRect(0, 0, this.getWidth(), this.getHeight());

	        ArrayList<Actor> world = new ArrayList<>();

	        world.addAll(walls);
	        world.addAll(areas);
	        world.addAll(baggs);
	        world.add(soko);

	        for (int i = 0; i < world.size(); i++) {

	            Actor item = world.get(i);

	            if (item instanceof Player || item instanceof Boxes) {
	                
	                g.drawImage(item.getImage(), item.M() + 2, item.N() + 2, this);
	            } else {
	                
	                g.drawImage(item.getImage(), item.M(), item.N(), this);
	            }

	            if (isCmpltd) {
	                
	                g.setColor(new Color(64, 64, 64));
	               JOptionPane.showMessageDialog(null,"AWK!!...Game Over");
	               System.exit(1);
	            }

	        }
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        Buildworld(g);
	    }

	    private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyPressed(KeyEvent e) {

	            if (isCmpltd) {
	                return;
	            }

	            int key = e.getKeyCode();

	            switch (key) {
	                
	                case KeyEvent.VK_LEFT:
	                    
	                    if (checkWallCollision(soko,
	                            LEFT_COLLISION)) {
	                        return;
	                    }
	                    
	                    if (checkBagCollision(LEFT_COLLISION)) {
	                        return;
	                    }
	                    
	                    soko.move(-SPACE, 0);
	                    
	                    break;
	                    
	                case KeyEvent.VK_RIGHT:
	                    
	                    if (checkWallCollision(soko, RIGHT_COLLISION)) {
	                        return;
	                    }
	                    
	                    if (checkBagCollision(RIGHT_COLLISION)) {
	                        return;
	                    }
	                    
	                    soko.move(SPACE, 0);
	                    
	                    break;
	                    
	                case KeyEvent.VK_UP:
	                    
	                    if (checkWallCollision(soko, TOP_COLLISION)) {
	                        return;
	                    }
	                    
	                    if (checkBagCollision(TOP_COLLISION)) {
	                        return;
	                    }
	                    
	                    soko.move(0, -SPACE);
	                    
	                    break;
	                    
	                case KeyEvent.VK_DOWN:
	                    
	                    if (checkWallCollision(soko, BOTTOM_COLLISION)) {
	                        return;
	                    }
	                    
	                    if (checkBagCollision(BOTTOM_COLLISION)) {
	                        return;
	                    }
	                    
	                    soko.move(0, SPACE);
	                    
	                    break;
	                    
	                case KeyEvent.VK_R:
	                    
	                    ResetLvl();
	                    
	                    break;
	                    
	                default:
	                    break;
	            }

	            repaint();
	        }
	    }

	    private boolean checkWallCollision(Actor actor, int type) {

	        switch (type) {
	            
	            case LEFT_COLLISION:
	                
	                for (int i = 0; i < walls.size(); i++) {
	                    
	                    Wall wall = walls.get(i);
	                    
	                    if (actor.isLftColision(wall)) {
	                        
	                        return true;
	                    }
	                }
	                
	                return false;
	                
	            case RIGHT_COLLISION:
	                
	                for (int i = 0; i < walls.size(); i++) {
	                    
	                    Wall wall = walls.get(i);
	                    
	                    if (actor.isRghtColision(wall)) {
	                        return true;
	                    }
	                }
	                
	                return false;
	                
	            case TOP_COLLISION:
	                
	                for (int i = 0; i < walls.size(); i++) {
	                    
	                    Wall wall = walls.get(i);
	                    
	                    if (actor.istopcollsion(wall)) {
	                        
	                        return true;
	                    }
	                }
	                
	                return false;
	                
	            case BOTTOM_COLLISION:
	                
	                for (int i = 0; i < walls.size(); i++) {
	                    
	                    Wall wall = walls.get(i);
	                    
	                    if (actor.isBottomCollision(wall)) {
	                        
	                        return true;
	                    }
	                }
	                
	                return false;
	                
	            default:
	                break;
	        }
	        
	        return false;
	    }

	    private boolean checkBagCollision(int type) {

	        switch (type) {
	            
	            case LEFT_COLLISION:
	                
	                for (int i = 0; i < baggs.size(); i++) {

	                	Boxes bag = baggs.get(i);

	                    if (soko.isLftColision(bag)) {

	                        for (int j = 0; j < baggs.size(); j++) {
	                            
	                        	Boxes item = baggs.get(j);
	                            
	                            if (!bag.equals(item)) {
	                                
	                                if (bag.isLftColision(item)) {
	                                    return true;
	                                }
	                            }
	                            
	                            if (checkWallCollision(bag, LEFT_COLLISION)) {
	                                return true;
	                            }
	                        }
	                        
	                        bag.move(-SPACE, 0);
	                        isCmpltd();
	                    }
	                }
	                
	                return false;
	                
	            case RIGHT_COLLISION:
	                
	                for (int i = 0; i < baggs.size(); i++) {

	                	Boxes bag = baggs.get(i);
	                    
	                    if (soko.isRghtColision(bag)) {
	                        
	                        for (int j = 0; j < baggs.size(); j++) {

	                        	Boxes item = baggs.get(j);
	                            
	                            if (!bag.equals(item)) {
	                                
	                                if (bag.isRghtColision(item)) {
	                                    return true;
	                                }
	                            }
	                            
	                            if (checkWallCollision(bag, RIGHT_COLLISION)) {
	                                return true;
	                            }
	                        }
	                        
	                        bag.move(SPACE, 0);
	                        isCmpltd();
	                    }
	                }
	                return false;
	                
	            case TOP_COLLISION:
	                
	                for (int k = 0; k < baggs.size(); k++) {

	                	Boxes bag = baggs.get(k);
	                    
	                    if (soko.istopcollsion(bag)) {
	                        
	                        for (int l = 0; l < baggs.size(); l++) {

	                        	Boxes item = baggs.get(l);

	                            if (!bag.equals(item)) {
	                                
	                                if (bag.istopcollsion(item)) {
	                                    return true;
	                                }
	                            }
	                            
	                            if (checkWallCollision(bag, TOP_COLLISION)) {
	                                return true;
	                            }
	                        }
	                        
	                        bag.move(0, -SPACE);
	                        isCmpltd();
	                    }
	                }

	                return false;
	                
	            case BOTTOM_COLLISION:
	                
	                for (int k = 0; k < baggs.size(); k++) {

	                	Boxes bag = baggs.get(k);
	                    
	                    if (soko.isBottomCollision(bag)) {
	                        
	                        for (int l = 0; l < baggs.size(); l++) {

	                        	Boxes item = baggs.get(l);
	                            
	                            if (!bag.equals(item)) {
	                                
	                                if (bag.isBottomCollision(item)) {
	                                    return true;
	                                }
	                            }
	                            
	                            if (checkWallCollision(bag,BOTTOM_COLLISION)) {
	                                
	                                return true;
	                            }
	                        }
	                        
	                        bag.move(0, SPACE);
	                        isCmpltd();
	                    }
	                }
	                
	                break;
	                
	            default:
	                break;
	        }

	        return false;
	    }

	    public void isCmpltd() {

	        int No_ofBags = baggs.size();
	        int Finished_Bags = 0;

	        for (int k = 0; k< No_ofBags; k++) {
	            
	        	Boxes bag = baggs.get(k);
	            
	            for (int l = 0; l < No_ofBags; l++) {
	                
	                Area area =  areas.get(l);
	                
	                if (bag.M() == area.M() && bag.N() == area.N()) {
	                    
	                    Finished_Bags += 1;
	                }
	            }
	        }

	        if (Finished_Bags == No_ofBags) {
	            
	            isCmpltd = true;
	            repaint();
	        }
	    }

	    public void ResetLvl() {

	        areas.clear();
	        baggs.clear();
	        walls.clear();

	        initWorld();

	        if (isCmpltd) {
	            isCmpltd = false;
	        }
	    }
	}

