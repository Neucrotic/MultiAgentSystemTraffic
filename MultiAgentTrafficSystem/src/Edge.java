import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Edge extends Drawable
{
	private Node from;
	private Node to;
	
	private int flowRate;
	private String flowString;
	
	protected Timer flowTimer = new Timer();
	protected TimerTask flowTask = new TimerTask() {
				public void run() {
					FlowVehicles();
				}
			};
	
	Edge(int _flowRate, Node _from, Node _to, int _x, int _y)
	{
		super(_x, _y);
		this.to = _to;
		this.from = _from;
		this.flowRate = _flowRate;
	}
	
	public void Update()
	{
		
	}
	
	public void Draw(Graphics _g)
	{
		_g.setColor(colour);
		
		int x1 = from.GetX() + (from.GetRadius() / 2);
		int y1 = from.GetY() + (from.GetRadius() / 2);
		int x2 = to.GetX() + (from.GetRadius() / 2);
		int y2 = to.GetY() + (from.GetRadius() / 2);
		
		_g.drawLine(x1, y1 -  (from.GetRadius() / 4), x2, y2 - (from.GetRadius() / 4));
		_g.drawLine(x1, y1 + (from.GetRadius() / 4), x2, y2 + (from.GetRadius() / 4));
		
		flowString = flowString.valueOf(flowRate);
		X = ((x1 + x2) / 2) - 10;
		Y = ((y1 + y2) / 2);
		
		_g.drawString(flowString, X, Y);
	}
	
	public void StartFlowTimer()
	{
		flowTimer.scheduleAtFixedRate(flowTask, flowRate, flowRate);
	}
	
	private void FlowVehicles()
	{
		if (from.GetCurrentVehicles() > 0 && to.HasCapacity())
		{
			from.RemoveVehicle();
			to.AddVehicle();
		}	
	}
}
