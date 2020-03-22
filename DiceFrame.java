import java.awt.event.*; //enable use of awt events
import javax.swing.*; //enable use of swing components
import java.awt.*; //enable use of of awt
 
public class DiceFrame
{
	public static void main(String[] args)
	{
		Dice frame = new Dice(); // Create new object of the class First
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close when exiting the program
		frame.setSize(400,300); // Size of the frame
		frame.setLocationRelativeTo(null); // Center my program on the screen
		frame.getContentPane(); 
		frame.setVisible(true); // Set visibility of the frame
	}
}