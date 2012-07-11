import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class GUI extends JComponent{
	private JFrame f = new JFrame();
	private JPanel p = new JPanel();
	private Canvas c = new Canvas();
	private JButton button_add = new JButton();
	private static JTextField input = new JTextField();
	
	private Color dotColor = Color.WHITE;
	private int x, y; //Setup x and y coordinates for the dots
	private Dot[] dots = new Dot[1000];
	private int numOfDots = 0;
	private boolean isAnErase;
	private int dotToErase;
	
	final private int WIDTH = 400;
	final private int HEIGTH = 300;
	
	
	//This is some change from little comp
	public GUI(){  //Setup the basic GUI
	
		//Manage JFrame 
		f.setTitle("Graph Drawer");
		f.setSize(WIDTH,HEIGTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setResizable(true);
		f.setVisible(true);
		
		//Manage JPanel
		p.setBackground(Color.WHITE);
		p.setBounds(0,0,WIDTH,HEIGTH);
		p.setLayout(null);
		p.setVisible(true);
		f.getContentPane().add(p);
		
		//Manage Canvas
		c.setBackground(Color.YELLOW);
		c.setSize(WIDTH-100,HEIGTH -30);
		p.add(c);
		
		//Manage JTextField
		input.setText("x coordinates");
		input.setBounds(320,150,60,20);
		p.add(input);
		
		//Manage JButtons
		button_add.setText("Add");
		button_add.setBounds(320, 200, 60, 20);
		button_add.addActionListener(new ComponentListener());
		p.add(button_add);
	}
	
		public void paint(Graphics g){
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 100, 100);
			int i = 0; //The counter that will count through and draw all the dots in dots[]
			if(!isAnErase){
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
			
			repaint();//Hopefully calls the paint method
			
			System.out.println("Painting dot at: " + x + ", " + y);
		}
		
		public static String getInputText(){
			return input.getText();
		}
}
