import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Network extends JFrame
{
	public boolean run = true;
	
	private int frameWidth = 1000;
	private int frameHeight = 700;
	
	private ArrayList<Node> nodes = new ArrayList<Node>();
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	
	Network(int _scenario)
	{	
		setBounds(100, 100, frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		InitScenario(_scenario);
		
		MergeLists();
	}
	
	public void paint(Graphics _g)
	{
		for (Drawable d: drawables)
		{
			d.Draw(_g);
		}
	}
	
	public void Update()
	{
		for (Node n: nodes)
		{
			n.Update();
		}
		
		for (Edge e: edges)
		{
			e.Update();
		}
	}
	
	private void InitScenario(int _s)
	{
		switch (_s)
		{
		case 1:
			InitSimple();
		break;
		case 2:
			InitThreeStart();
		break;
		case 3:
			InitExtraRoads();
		break;
		default:
			InitSimple();
		}
	}
	
	public void InitSimple()
	{
		Node n1 = new Node(5, 50, 350); //ONode
		Node n2 = new Node (5, 150, 350); //RNode
		Node n3 = new Node (5, 250, 450); //QNode
		Node n4 = new Node (5, 250, 250); //QNode
		Node n5 = new Node (5, 350, 550); // DNode
		Node n6 = new Node (5, 350, 150); //DNode
		Node n7 = new Node (5, 500, 350); //SNode
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);
		nodes.add(n6);
		nodes.add(n7);
		
		Edge e1 = new Edge(1000, n1, n2, 0, 0); // O - R
		Edge e2 = new Edge(1000, n2, n4, 0, 0); // R - Q
		Edge e3 = new Edge(1000, n2, n3, 0, 0); // R - Q
		Edge e4 = new Edge(1000, n4, n6, 0, 0); // Q - D
		Edge e5 = new Edge(1000, n3, n5, 0, 0); // Q - D
		Edge e6 = new Edge(1000, n6, n7, 0, 0); // D - F
		Edge e7 = new Edge(1000, n5, n7, 0, 0); // D - F
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		edges.add(e5);
		edges.add(e6);
		edges.add(e7);
	}
	
	public void InitThreeStart()
	{
		
	}
	
	public void InitExtraRoads()
	{
		
	}
	
	private void MergeLists()
	{
		for (Node n: nodes)
		{
			drawables.add(n);
		}
		
		for (Edge e: edges)
		{
			drawables.add(e);
		}
	}
}
