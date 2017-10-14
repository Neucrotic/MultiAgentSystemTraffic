import java.util.ArrayList;

public class Link extends Drawable
{
	private int id;
	public boolean isLeftLink;
	private Intersection to;
	private Intersection from;
	private ArrayList<DNode> dNodes = new ArrayList<DNode>();
	private int flowRate;
	
	Link(int _id, Intersection _from, Intersection _to, int _dist, int _flowrate, int _x, int _y)
	{
		super(_x, _y);
		
		this.id = _id;
		this.to = _to;
		this.from = _from;
		this.flowRate = _flowrate;
		
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
		if (dNodes.get(dNodes.size() - 1).GetCurrentVehicles() > 0 && to.GetRNode().HasCapacity())
		{
			dNodes.get(dNodes.size() - 1).RemoveVehicle();
			to.GetRNode().AddVehicle();
		}
		
		//update DNodes backwards, apart from last
		for (int i = dNodes.size() - 2; i >= 0; i--)
		{
			if (dNodes.get(i).GetCurrentVehicles() > 0 && dNodes.get(i + 1).HasCapacity())
			{
				dNodes.get(i).RemoveVehicle();
				dNodes.get(i + 1).AddVehicle();
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
		
		//Print console data
		System.out.println("Link " + this.id + " contains:");
		for (int p = 0; p < this.dNodes.size(); p++)
		{
			System.out.println("DNode " + dNodes.get(p).GetId() + " holds " + dNodes.get(p).GetCurrentVehicles() + " vehicles");
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