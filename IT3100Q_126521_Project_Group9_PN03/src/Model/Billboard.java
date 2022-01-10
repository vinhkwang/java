package Model;

public class Billboard {
	protected int id;
	protected String content;
	protected String color;
	protected double size;
	protected String shape;

	public void setBillBoard(int id, String content, String color, double size, String shape) {
		this.id = id;
		this.content = content;
		this.color = color;
		this.size = size;
		this.shape = shape;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public double calPrice(double size) {
		return size * 500000;
	}

}
