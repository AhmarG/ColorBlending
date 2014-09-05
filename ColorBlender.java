
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * ColorBlender.java
 * 
 * The ColorBlender class demonstrates the blending of the primary
 * colors red, green, and blue using a GUI.
 * 
 * @author Drew Morton, Ahmar Gordon
 * @version 1.5
 */
public class ColorBlender
{
	private JLabel labelR  = new JLabel("Red" ,SwingConstants.CENTER);
	private JLabel labelB  = new JLabel("Blue" ,SwingConstants.CENTER);
	private JLabel labelG  = new JLabel("Green",SwingConstants.CENTER);
	private JTextField Red = new JTextField();
	private JTextField Blue = new JTextField();
	private JTextField Green = new JTextField();
	private JFrame frame = new JFrame("Mixing Colors");
	private int x = 0;
	private int y = 0;
	private int z = 0;
	private ArrayList<Integer> lastColor = new ArrayList<Integer>();

	/**
	 * Constructor for the ColorBlender class.
	 * 
	 * It initializes the keyboard listener for user interaction 
	 * and adds it to the frame.
	 */
	public ColorBlender()
	{

		KeyListener listener = new MyKeyListener();
		frame.addKeyListener(listener);
		frame.setVisible(true);
		frame.setFocusable(true);

	}

	/**
	 * makeUI method of the ColorBlender class.
	 * It creates the entire user interface for the color blending.
	 */
	public void makeUI()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		//sets up the size of the frame
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize ();

		//centers the screen and makes it the same size on every screen.
		Dimension frameSize = new Dimension ( screensize.width / 2, screensize.height / 2);
		frame.setBounds ( screensize.width / 2 - frameSize.width / 2, 
				screensize.height / 2 - frameSize.height / 2,
				frameSize.width, frameSize.height );

		//sets the label and text area to be a third of the screen width
		int width = (frameSize.width / 3) - 1;

		//Sets up the label that says Red
		labelR.setSize(width + 1, (frameSize.height / 5));
		labelR.setFont(new Font("Serif", Font.PLAIN, 40));
		labelR.setLocation(0, 0);
		labelR.setVisible(true);
		labelR.setOpaque(true);
		labelR.setBackground(Color.red);
		labelR.setForeground(Color.white);
		frame.add(labelR);

		//Sets up the label that says Green
		labelG.setSize(width, (frameSize.height / 5));
		labelG.setFont(new Font("Serif", Font.PLAIN, 40));
		labelG.setLocation((width + 1) , 0);
		labelG.setVisible(true);
		labelG.setOpaque(true);
		labelG.setBackground(Color.green.darker());
		labelG.setForeground(Color.white);
		frame.add(labelG);

		//Sets up the label that says Blue
		labelB.setSize(width, (frameSize.height / 5));
		labelB.setFont(new Font("Serif", Font.PLAIN, 40));
		labelB.setLocation((width * 2) + 1, 0);
		labelB.setVisible(true);
		labelB.setOpaque(true);
		labelB.setBackground(Color.blue.darker());
		labelB.setForeground(Color.white);
		frame.add(labelB);

		//Sets up the Text field that displays how much color is in red.
		Red.setBounds(0, labelR.getHeight(), width, (frameSize.height / 7));
		Red.setText("" + x);
		Red.setFocusable(false);
		Red.setFont(new Font("Serif", Font.PLAIN, 40));
		Red.setHorizontalAlignment(JTextField.CENTER);
		frame.add(Red);

		//Sets up the Text field that displays how much color is in green.
		Green.setBounds(width + 1, labelG.getHeight(), width, (frameSize.height / 7));
		Green.setText("" + y);
		Green.setFocusable(false);
		Green.setFont(new Font("Serif", Font.PLAIN, 40));
		Green.setHorizontalAlignment(JTextField.CENTER);
		frame.add(Green);

		//Sets up the Text field that displays how much color is in blue.
		Blue.setBounds((width * 2) + 1, labelB.getHeight(), width, (frameSize.height / 7));
		Blue.setText("" + z);
		Blue.setFocusable(false);
		Blue.setFont(new Font("Serif", Font.PLAIN, 40));
		Blue.setHorizontalAlignment(JTextField.CENTER);
		frame.add(Blue);


		//Sets the color of the bottom portion of the frame.
		frame.getContentPane().setBackground(new Color(x, y, z));
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setVisible(true);
	}


	/**
	 * Removes all color from the color blender.
	 */
	public void clear()
	{
		x=0;
		y=0;
		z=0;
		lastColor.removeAll(lastColor);
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * @param z the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * Adds an increment(15) of red to the color blender.
	 */
	public void red()
	{
		if (x>= 255)
		{
			x = 255;
			Red.setText("" + x);
		}

		else
		{
			x += 15;
			Red.setText("" + x);
		}

	}

	/**
	 * Adds an increment(15) of green to the color blender.
	 */
	public void green()
	{

		if (y>=255)
		{
			y = 255;
			Green.setText("" + y);
		}
		else
		{
			y += 15;
			Green.setText("" + y);
		}

	}

	/**
	 * Adds an increment(15) of blue to the color blender.
	 */
	public void blue()
	{
		if (z>=255)
		{
			z = 255;
			Blue.setText("" + z);
		}
		else
		{
			z += 15;
			Blue.setText("" + z);
		}
	}

	/**
	 * Decrements the last color added to the blender.
	 */

	public void deleteLastTap()
	{
		if (lastColor.size() != 0)
		{
			if (lastColor.get(lastColor.size() - 1) == 0)
			{
				if (x>0)
				{
					x-=15;
					lastColor.remove(lastColor.size() - 1);
				}
				else
				{
					if (lastColor != null)
					{
						lastColor.remove(lastColor.size() - 1);
					}
				}
			}
			else if (lastColor.get(lastColor.size() - 1) == 1)
			{
				if (y>0)
				{
					y-=15;
					lastColor.remove(lastColor.size() - 1);
				}
				else
				{
					if (lastColor != null)
					{
						lastColor.remove(lastColor.size() - 1);
					}
				}
			}
			else if (lastColor.get(lastColor.size() -1) == 2)
			{
				if (z>0)
				{
					z-=15;
					lastColor.remove(lastColor.size() - 1);
				}
				else
				{
					if (lastColor != null)
					{
						lastColor.remove(lastColor.size() - 1);
					}
				}
			}
			else
			{
				//do nothing
			}
		}
		else 
		{
			System.out.println("size is 0");
		}

	}

	/**
	 *Inner class for keyboard listening
	 */
	private class MyKeyListener implements KeyListener
	{
		public void keyTyped(KeyEvent e) 
		{}

		/**
		 * Listens for keys to be pressed while the program
		 * is running. Only keys that correspond to program
		 * function have actions.
		 */
		public void keyPressed(KeyEvent e)
		{
			//Activates if the R key is pressed
			if (e.getKeyCode() == KeyEvent.VK_R) 
			{
				red();
				makeUI();
				lastColor.add(0);
			}

			//Activates if the G key is pressed
			if (e.getKeyCode() == KeyEvent.VK_G) 
			{
				green();
				makeUI();
				lastColor.add(1);

			}

			//Activates if the B key is pressed
			if (e.getKeyCode() == KeyEvent.VK_B) 
			{
				blue();
				makeUI();
				lastColor.add(2);
			}

			//Activates if the D key is pressed
			if (e.getKeyCode() == KeyEvent.VK_D) 
			{
				deleteLastTap();
				makeUI();
			}

			//Activates if the C key is pressed
			if (e.getKeyCode() == KeyEvent.VK_C) 
			{
				clear();
				makeUI();
			}
		}

		public void keyReleased(KeyEvent e) 
		{}
	}

	/**
	 * Creates a ColorBlender object to run.
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args)
	{
		ColorBlender blender = new ColorBlender();
		blender.makeUI();
	}

}
