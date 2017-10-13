import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Network extends JFrame
{
	public boolean run = true;
	
	private int frameWidth = 1000;
	private int frameHeight = 700;
	private Scanner keyboard = new Scanner(System.in);
	
	private int scenario;
	private ArrayList<Intersection> inters = new ArrayList<Intersection>();
	private ArrayList<Link> links = new ArrayList<Link>();
	
	private ArrayList<ONode> originNodes = new ArrayList<ONode>();
	private SNode sink;
	
	private ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	
	Network()
	{			
		setBounds(100, 100, frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		System.out.println("Which scenario would you like to run?");
		this.scenario = keyboard.nextInt();
		
		InitScenario(this.scenario);
		
		MergeLists();
	}
	
	public void Update()
	{		
		for (ONode o: originNodes)
		{
			o.Update();
		}
		
		sink.Update();
		
		for (Link l: links)
		{
			l.Update();
		}
		
		for (Intersection i: inters)
		{
			i.Update();
		}
	}
	
	public void paint(Graphics _g)
	{
		for (Drawable d: drawables)
		{
			d.Draw(_g);
		}
	}
	
	public void StartOnEnter()
	{
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
		int originSpawnRate;
		int firstInterLeft;
		int distAB;
		int distAC;
		int distBD;
		int distCD;
		
		//Ask for user initialization
		System.out.println("What is the origins spawn rate?");
		originSpawnRate = keyboard.nextInt();
		System.out.println("Which percentage of cars will go left at the first intersection?");
		firstInterLeft = keyboard.nextInt();
		
		System.out.println("What is the distance between intersections A and B?");
		distAB = keyboard.nextInt();
		System.out.println("What is the distance between intersections A and C?");
		distAC = keyboard.nextInt();
		System.out.println("What is the distance between intersections B and D?");
		distBD = keyboard.nextInt();
		System.out.println("What is the distance between intersections C and D?");
		distCD = keyboard.nextInt();
		
		//Create Intersections and Links
		Intersection A = new Intersection(1, true, firstInterLeft, 1, 0, 0);
		Intersection B = new Intersection(2, false, 0, 1, 0, 0);
		Intersection C = new Intersection(3, false, 0, 1, 0, 0);
		Intersection D = new Intersection(4, false, 0, 1, 0, 0);
		
		Link AB = new Link(1, A, B, distAB, 1, 0, 0);
		Link AC = new Link(2, A, C, distAC, 1, 0, 0);
		Link BD = new Link(3, B, D, distBD, 1, 0, 0);
		Link CD = new Link(4, C, D, distCD, 1, 0, 0);
		
		//Attach Links to Intersections
		A.SetLinkLeft(AB);
		A.SetLinkRight(AC);
		B.SetLinkLeft(BD);
		C.SetLinkLeft(CD);
		
		inters.add(A);
		inters.add(B);
		inters.add(C);
		inters.add(D);
		
		//Initialise Origin and Sink Nodes
		ONode o = new ONode(originSpawnRate, 1, i1, 0, 0);
		this.originNodes.add(o);
			
		this.sink = new SNode(1, i4, 0, 0);
	}
	
	public void InitThreeStart()
	{
		
	}
	
	public void InitExtraRoads()
	{
		
	}
	
	public ArrayList<Drawable> GetDrawables()
	{
		return this.drawables;
	}
	
	private void MergeLists()
	{
		
	}
	
	private void VehicleOriginToInter(ONode _origin, Intersection _inter)
	{
		if (_origin.GetCurrentVehicles() > 0 && _inter.GetRNode().HasCapacity())
		{
			_origin.RemoveVehicle();
			_inter.GetRNode().AddVehicle();
		}
	}
	
	private void VehicleInterToLink(Intersection _inter, Link _link)
	{
		
	}
	
	private void VehicleLinkToInter(Link _link, Intersection _inter)
	{
		
	}
	
	private void VehicleInterToSink(Intersection _inter)
	{
		if (_inter.GetRightQNode() != null)
		{
			if (_inter.GetRightQNode().GetCurrentVehicles() > 0)
			{
				_inter.GetRightQNode().RemoveVehicle();
				this.sink.AddVehicle();
			}
		}
	}
}
