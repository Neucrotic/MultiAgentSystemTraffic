import java.awt.*;
import java.util.ArrayList;

public class Node extends Drawable
{
	protected int nodeRadius = 50;
	
	protected int id;
	protected int currentVehicles;
	
	protected String drawString;
	
	public Node(int _id, int _x, int _y)
	{
		super(_x, _y);
		this.id = _id;
		this.currentVehicles = 0;
	}
	
	public void Update()
	{		
		
	}
	
	public void Draw(Graphics _g)
	{
		_g.setColor(colour);
		
		_g.fillOval(X, Y, nodeRadius, nodeRadius);
		
		//drawString = drawString.valueOf(currentVehicles) + "/" + drawString.valueOf(maxVehicles);
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
	
	public int GetId()
	{
		return this.id;
	}
	
	public int GetCurrentVehicles()
	{
		return this.currentVehicles;
	}
	
	public int GetRadius()
	{
		return this.nodeRadius;
	}
}
