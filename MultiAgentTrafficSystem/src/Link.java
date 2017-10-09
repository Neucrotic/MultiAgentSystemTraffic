import java.util.ArrayList;

public class Link extends Drawable
{
	private ArrayList<DNode> dNodes = new ArrayList<DNode>();
	
	Link(int _id, int _dist, int _x, int _y)
	{
		super(_x, _y);
		
		for (int i = 0; i < _dist; i++)
		{
			DNode d = new DNode((i + 1), 10, 0, 0);
			this.dNodes.add(d);
		}
	}
	
	public void Update()
	{
		
	}
	
	public void AddVehicle()
	{
		dNodes.get(0).AddVehicle();
	}
}
