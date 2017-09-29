import java.awt.*;

public class Drawable
{
	protected int X;
	protected int Y;
	protected Color colour;
	
	Drawable(int _x, int _y)
	{
		this.X = _x;
		this.Y = _y;
	}
	
	//override this method
	public void Update() {}
	
	//override this method
	public void Draw(Graphics _g) {} 
	
	public int GetX()
	{
		return this.X;
	}
	
	public int GetY()
	{
		return this.Y;
	}
	
	public void SetColour(Color _c)
	{
		this.colour = _c;
	}
}
