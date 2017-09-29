import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public void paintComponent(Graphics _g)
	{
		//super.paintComponent(_g);
		
		for (Drawable d: drawables)
		{
			d.Draw(_g);
		}
	}
	
	public void Update()
	{
		for (Drawable d: drawables)
		{
			d.Update();
		}
	}
	
	public void StartOnEnter()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Press enter to start simluation...");
		keyboard.nextLine();
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
		ONode n1 = new ONode(5, 5, 50, 350); //ONode
		RNode n2 = new RNode (5, 150, 350); //RNode
		QNode n3 = new QNode (5, 250, 450); //QNode
		QNode n4 = new QNode (5, 250, 250); //QNode
		DNode n5 = new DNode (5, 350, 550); // DNode
		DNode n6 = new DNode (5, 350, 150); //DNode
		SNode n7 = new SNode (5, 500, 350); //SNode
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
	
	public void InitEdgeTimers()
	{
		for (Edge e: edges)
		{
			e.StartFlowTimer();
		}
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
