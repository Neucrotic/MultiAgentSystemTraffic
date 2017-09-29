import java.awt.*;
import java.util.ArrayList;

public class Node extends Drawable
{
	protected int nodeRadius = 50;
	
	protected int id;
	protected int maxVehicles;
	protected int currentVehicles;
	protected Edge bestEdge = null;
	
	protected String drawString;
	
	protected ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public Node(int _id, int _maxVehicles, int _x, int _y)
	{
		super(_x, _y);
		this.id = _id;
		this.maxVehicles = _maxVehicles;
		this.currentVehicles = 0;
	}
	
	public void Update()
	{
		this.bestEdge = GetLowestEdge();
		
		if (currentVehicles == maxVehicles)
		{
			this.colour = Color.RED;
		}
		else if (currentVehicles == 0)
		{
			this.colour = Color.GREEN;
		}
		else if (currentVehicles > 0)
		{
			this.colour = Color.YELLOW;
		}
	}
	
	public void Draw(Graphics _g)
	{
		_g.setColor(colour);
		
		_g.fillOval(X, Y, nodeRadius, nodeRadius);
		
		drawString = drawString.valueOf(currentVehicles) + "/" + drawString.valueOf(maxVehicles);
		_g.drawString(drawString, X + ((nodeRadius / 2) - 10), Y + (nodeRadius + 10));
	}
	
	public void SendVehicle(Node _dest)
	{
		this.RemoveVehicle();
		_dest.AddVehicle();
	}
	
	public void AddVehicle()
	{
		this.currentVehicles++;
	}
	
	public void RemoveVehicle()
	{
		this.currentVehicles--;
	}
	
	public boolean HasCapacity()
	{
		if (this.currentVehicles < this.maxVehicles)
		{
			return true;
		}
		
		return false;
	}
	
	public int GetId()
	{
		return this.id;
	}
	
	public int GetCurrentVehicles()
	{
		return this.currentVehicles;
	}
	
	public int GetMaxVehicles()
	{
		return this.maxVehicles;
	}
	
	public Edge GetBestEdge()
	{
		return this.bestEdge;
	}
	
	public int GetRadius()
	{
		return this.nodeRadius;
	}
	
	private Edge GetLowestEdge()
	{
		Edge e = edges.get(0);
		for (int i = 1; i < edges.size(); i++)
		{
			if (edges.get(i).trafficScore < e.trafficScore)
			{
				e = edges.get(i);
			}
		}
		
		return e;
	}
}
