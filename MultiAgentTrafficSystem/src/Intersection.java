import java.util.ArrayList;

public class Intersection extends Drawable
{
	public int id;
	
	private boolean duel; //does this intersection have a single or duel exit.
	private RNode rNode; 
	private QNode qNodeLeft; //used if duel is false
	private QNode qNodeRight;
	private Link linkLeft;
	private Link linkRight;
	
	//which percentage of traffic flow to send down the left link.
	private int leftPercentage; //Only used if duel is true.
	private int flowRate;
	
	Intersection(int _id, boolean _duel, int _leftPercentage, int _flowrate, int _x, int _y)
	{
		super(_x, _y);
		
		this.id = _id;
		this.duel = _duel;
		this.leftPercentage = _leftPercentage;
		this.flowRate = _flowrate;
		
		if(duel)
			InitDuel();
		else
		{
			this.leftPercentage = 100;
			InitNonDuel();
		}
	}
	
	public void Update()
	{
		int leftCount = (this.leftPercentage / 100) * this.rNode.GetCurrentVehicles();
		
		if (duel)
		{
			int rightCount = this.rNode.GetCurrentVehicles() - leftCount;
			
			SendManyVehicles(this.rNode, this.qNodeLeft, leftCount);
			SendManyVehicles(this.rNode, this.qNodeRight, rightCount);
		}
		else
		{
			SendManyVehicles(this.rNode, this.qNodeLeft, leftCount);
		}
	}
	
	private void InitDuel()
	{
		this.rNode = new RNode(1, 10, 0, 0);
		
		this.qNodeLeft = new QNode(1, 20, 0, 0);
		this.qNodeRight = new QNode(2, 20, 0, 0);
	}
	
	private void InitNonDuel()
	{
		this.rNode = new RNode(1, 10, 0, 0);
		
		this.qNodeLeft = new QNode(1, 20, 0, 0);
		this.qNodeRight = null;
	}
	
	private void SendManyVehicles(RNode _rNode, QNode _qNode, int _num)
	{
		for (int i = 0; i < _num; i++)
		{
			if (_rNode.GetCurrentVehicles() > 0 && _qNode.HasCapacity())
			{
				_rNode.RemoveVehicle();
				_qNode.AddVehicle();
			}
		}
	}
	
	public RNode GetRNode()
	{
		return this.rNode;
	}
	
	public QNode GetLeftQNode()
	{
		return this.qNodeLeft;
	}
	
	public QNode GetRightQNode()
	{
		return this.qNodeRight;
	}
	
	public Link GetLinkLeft()
	{
		return this.linkLeft;
	}
	
	public Link GetLinkRight()
	{
		return this.linkRight;
	}
	
	public void SetLinkLeft(Link _l)
	{
		this.linkLeft = _l;
	}
	
	public void SetLinkRight(Link _l)
	{
		this.linkRight = _l;
	}
	
	public boolean IsLinkLeft(Link _l)
	{
		if (_l == this.linkLeft)
		{
			return true;
		}
		
		return false;
	}
}