package Blob;

public class ImageHolder {
	private int id;//��װͼƬ��ID
	private String name;//��װͼƬ������
	public ImageHolder() {
	}
	public ImageHolder(int id,String name) {
		this.id=id;
		this.name=name; 
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return name;
	}

}
