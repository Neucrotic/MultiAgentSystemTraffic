import java.util.ArrayList;

public class Intersection extends Drawable
{
	public int id;
	
	private boolean duel; //does this intersection have a single or duel exit.
	private RNode rNode; 
	private QNode qNodeLeft; //used if duel is false
	private QNode qNodeRight;
	
	//which percentage of traffic flow to send down the left link.
	private int leftPercentage; //Only used if duel is true.
	
	private ArrayList<Link> links = new ArrayList<Link>();
	
	Intersection(int _id, boolean _duel, int _leftPercentage, ArrayList<Link> _links, int _x, int _y)
	{
		super(_x, _y);
		
		this.id = _id;
		this.duel = _duel;
		this.leftPercentage = _leftPercentage;
		this.links = _links;
		
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
		int rightCount = this.rNode.GetCurrentVehicles() - leftCount;
		
		SendManyVehicles(this.rNode, this.qNodeLeft, leftCount);
		SendManyVehicles(this.rNode, this.qNodeRight, rightCount);
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
}