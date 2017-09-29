import java.awt.*;
import java.util.ArrayList;

public class Node extends Drawable
{
	protected int nodeRadius = 50;
	
	protected int maxVehicles;
	protected int currentVehicles;
	protected int trafficScore;
	
	protected String drawString;
	
	protected ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public Node(int _maxVehicles, int _x, int _y)
	{
		super(_x, _y);
		this.maxVehicles = _maxVehicles;
	}
	
	public void Draw(Graphics _g)
	{
		_g.setColor(colour);
		
		_g.fillOval(X, Y, nodeRadius, nodeRadius);
		
		drawString = drawString.valueOf(currentVehicles) + "/" + drawString.valueOf(maxVehicles);
		_g.drawString(drawString, X + ((nodeRadius / 2) - 10), Y + (nodeRadius + 10));
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
	
	public int GetRadius()
	{
		return this.nodeRadius;
	}
	
	public int GetCurrentVehicles()
	{
		return this.currentVehicles;
	}
	
	public int GetMaxVehicles()
	{
		return this.maxVehicles;
	}
	
	public void SetMaxVehicles(int _max)
	{
		this.maxVehicles = _max;
	}
}
