import java.util.ArrayList;

public class Link extends Drawable
{
	private ArrayList<DNode> dNodes = new ArrayList<DNode>();
	
	Link(int _id, int _dist, int _x, int _y)
	{
		super(_x, _y);
		
		if (_dist != 0)
		{
			for (int i = 0; i < _dist; i++)
			{
				DNode d = new DNode((i + 1), 10, 0, 0);
				this.dNodes.add(d);
			}
		}
		else
		{
			DNode d = new DNode(1, 10, 0, 0);
			this.dNodes.add(d);
		}
		
	}
	
	public void Update()
	{
		for (int i = 0; i < dNodes.size() - 1; i++) //update DNodes, apart from last
		{
			if (dNodes.get(i).GetCurrentVehicles() > 0 && dNodes.get(i + 1).HasCapacity())
			{
				//dNodes.get(i)
			}
		}
	}
	
	public void AddVehicle()
	{
		dNodes.get(0).AddVehicle();
	}
}