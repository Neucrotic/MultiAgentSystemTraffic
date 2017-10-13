import java.util.ArrayList;

public class Link extends Drawable
{
	public boolean isLeftLink;
	private Intersection to;
	private Intersection from;
	private ArrayList<DNode> dNodes = new ArrayList<DNode>();
	private int flowRate;
	
	Link(int _id, Intersection _from, Intersection _to, int _dist, int _flowrate, int _x, int _y)
	{
		super(_x, _y);
		
		this.to = _to;
		this.from = _from;
		this.flowRate = _flowrate;
		this.isLeftLink = this.from.IsLinkLeft(this);
		
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
		//push to TO inter
		if (dNodes.get(dNodes.size()).GetCurrentVehicles() > 0 && to.GetRNode().HasCapacity())
		{
			dNodes.get(dNodes.size()).RemoveVehicle();
			to.GetRNode().AddVehicle();
		}
		
		//update DNodes backwards, apart from last
		for (int i = dNodes.size() - 1; i >= 0; i--)
		{
			if (dNodes.get(i + 1) != null)
			{
				if (dNodes.get(i).GetCurrentVehicles() > 0 && dNodes.get(i + 1).HasCapacity())
				{
					dNodes.get(i).RemoveVehicle();
					dNodes.get(i + 1).AddVehicle();
				}
			}
		}
		
		//pull a vehicle from FROM inter
		if (this.isLeftLink)
		{
			if (this.from.GetLeftQNode().GetCurrentVehicles() > 0 && this.dNodes.get(0).HasCapacity())
			{
				this.from.GetLeftQNode().RemoveVehicle();
				this.dNodes.get(0).AddVehicle();
			}
		}
		else
		{
			if (this.from.GetRightQNode().GetCurrentVehicles() > 0 && this.dNodes.get(0).HasCapacity())
			{
				this.from.GetRightQNode().RemoveVehicle();
				this.dNodes.get(0).AddVehicle();
			}
		}
	}
	
	public Intersection To()
	{
		return this.to;
	}
	
	public Intersection From()
	{
		return this.from;
	}
	
	public void AddVehicle()
	{
		dNodes.get(0).AddVehicle();
	}
}