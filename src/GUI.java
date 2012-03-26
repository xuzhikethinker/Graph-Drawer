import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.*;


public class GUI extends JPanel{
	JFrame frame;
	
	private Color dotColor = Color.BLACK;
	private int x, y; //Setup x and y coordinates for the dots
	private Dot[] dots = new Dot[1000];
	private int numOfDots = 0;
	private boolean isAnErase;
	private int dotToErase;
	Graphics g;
	
	public GUI(){  //Setup the basic GUI
		frame = new JFrame();

		frame.setTitle("Graph Drawer");
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		setBackground(Color.WHITE);
		setSize(400,300);
		
		frame.getContentPane().add(this);
		frame.setVisible(true);
	}
	
		public void paint(Graphics g){
			
			int i = 0; //The counter that will count through and draw all the dots in dots[]
			if(!isAnErase){
				g.setColor(dotColor);
				while(i < 1000){  //inte <=, då kollar den 1000, vilket inte finns (0-999)
					if(dots[i] != null){
						g.fillRect(dots[i].getX(), dots[i].getY(), 2, 2);
						i++;
					}
					else{
						i++;
					}
				}
			
			}
			
			else{ //Erase the dot
				Color c = g.getColor();
				g.setColor(Color.WHITE);
				g.fillRect(dots[dotToErase].getX(), dots[dotToErase].getY(), 2, 2);
				g.setColor(c); //Restore the color before erase
				
				System.out.println("Erased dot at: " + dots[dotToErase].getX() + ", " + dots[dotToErase].getY());
			}
			
		}
		
		public void setDotColor(Color col){
			dotColor = col;
		}
		
		public void eraseDot(int dotNumber){
			dotToErase = dotNumber;
			isAnErase = true;
		}
		
		public void paintDot(int x, int y){
			this.x = x;//Sets the x and y coordinates where the dot will be drawn
			this.y = y;
			dots[numOfDots] = new Dot(x,y); //Creates a new dot with the coordinates
			numOfDots++; //This is the index counter for the dots[] so that we wont create try to create an object where there already is one :P
			
			isAnErase = false; //This is not an erase, if this is set to true, it will paint a white dot at the coordinates...
			
			this.repaint();//Hopefully calls the paint method
			
			System.out.println("Painting dot at: " + x + ", " + y);
		}
}
