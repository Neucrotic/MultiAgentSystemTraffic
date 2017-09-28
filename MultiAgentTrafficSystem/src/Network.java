import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Network extends JFrame
{
	public boolean run = true;
	private int vehicleCount = 0;
	
	private int frameWidth = 700;
	private int frameHeight = 500;
	
	private ArrayList<Node> nodes = new ArrayList<Node>();
	
	Network(int _vehicleCount)
	{
		this.vehicleCount = _vehicleCount;
		
		setBounds(100, 100, frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Node n1 = new Node(100, 200);
		Node n2 = new Node (350, 100);
		nodes.add(n1);
		nodes.add(n2);
	}
	
	public void paint(Graphics _g)
	{
		Draw(_g);
	}
	
	public void Update()
	{
		
	}
	
	public void Draw(Graphics _g)
	{
		for (Node n: nodes)
		{
			n.Draw(_g);
		}
	}
}
