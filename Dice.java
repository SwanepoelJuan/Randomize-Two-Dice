import java.awt.event.*; // Enable use of awt events
import javax.swing.*; // Enable use of swing components
import java.util.*; 
import java.awt.*; // Enable use of of awt

/**
* A program that randomizes two dice by Juan Swanepoel 
*/
public class Dice extends JFrame implements MouseListener{
    
    /**
    * Creation of elements used within the program 
    */    
    private JPanel mainPanel = new JPanel(); // Create a new panel, this is our main panel 
    private JPanel northPanel = new JPanel(); // Create a new panel, this is our north panel 
    private JPanel centerPanel = new JPanel(); // Create a new panel, this is our center panel
    private JButton rollButton = new JButton("Roll Dice"); // Create a new button, this is our roll button 
    private JLabel label1 = new JLabel(); // Create a label, used to display our dice
    private JLabel label2 = new JLabel(); // Create a label, used to display our dice
    
    private BorderLayout borderLayout = new BorderLayout(); // Create a new Border Layout
    private FlowLayout flowLayout = new FlowLayout(); // Create a new Flow Layout 
    
    /**
    * The constructor for the Dice class 
    */
    public Dice(){
        super("The Dice Game");
        createView();
    }
    
    /**
    * A method to create our UI 
    */
    public void createView(){
        
        mainPanel.setLayout(borderLayout); // Set the layout of the Main Panel
        northPanel.setLayout(flowLayout); // Set the layout of the North Panel (the panel added to the north side of the border layout)
        centerPanel.setLayout(flowLayout); // Set the layout of the Center Panel (the panel added to the center of the border layout)
        
        northPanel.add(rollButton); 
        rollButton.addMouseListener(this); // Add a Mouse Listener to the button (this can also be an Action Listener)
        
        mainPanel.add(northPanel, BorderLayout.NORTH); // Add the North Panel to the Main Panel
        mainPanel.add(centerPanel, BorderLayout.CENTER); // Add the Center Panel to the Main Panel
        
        this.add(mainPanel); // Add the Main Panel to the JFrame 
        
        int r1 = randomNum(1, 6); // Randomize a number
        int r2 = randomNum(1, 6); // Randomize a number 
        setDice(r1, r2); //Call the setDice method       
    }
    
    /**
    * Method created to update the two labels which contain the dice images
    */
    public void setDice(int r1, int r2){

        centerPanel.remove(label1); // Remove label1
        centerPanel.remove(label2); // Remove label2
        centerPanel.repaint(); // Repaint the Center Panel 
        centerPanel.revalidate(); // Revalidate the Center Panel
        
        mainPanel.remove(centerPanel); // Remove the Center Panel 
        
        mainPanel.revalidate(); // Revalidate the Main Panel 

        this.repaint(); // Repaint the JFrame
        this.revalidate(); // Revalidate the JFrame
        
        centerPanel = new JPanel(); // Create a new object for the Center Panel 
        
        ImageIcon icon1 = new ImageIcon("dice"+r1+".png"); // Store a random image in icon1
        ImageIcon icon2 = new ImageIcon("dice"+r2+".png"); // Store a random image in icon2
        
        label1 = new JLabel("", icon1, JLabel.CENTER); // Create a new label object to display icon1
        label2  = new JLabel("", icon2, JLabel.CENTER); // Create a new label object to display icon2
        
        centerPanel.add(label1); // Add the new label to the Center Panel
        centerPanel.add(label2); // Add the new label to the Center Panel
        
        mainPanel.add(centerPanel); // Add the updated Center Panel to the Main Panel
    }
    
    public int randomNum(int min, int max) //method for random number
	{
		Random randomNumbers = new Random(); //create new object of random
    	return randomNumbers.nextInt((max - min) + 1) + min; // return the number we generate 
	}
    
    public void mousePressed(MouseEvent me){} //override method
	public void mouseReleased(MouseEvent me){} //override method
	public void mouseEntered(MouseEvent me){} //override method
	public void mouseExited(MouseEvent me){} //override method
	
	public void mouseClicked(MouseEvent me)
	{
		if(me.getButton() == MouseEvent.BUTTON1) // Get button is a built in method, mouse event button1 = left click
		{			
			if (me.getSource()==rollButton){
                int r1 = randomNum(1, 6); // Randomize a number between 1 and 6
                int r2 = randomNum(1, 6); // Randomize a number between 1 and 6
                setDice(r1, r2); // Call the setDice method
            }
        }
    }

}