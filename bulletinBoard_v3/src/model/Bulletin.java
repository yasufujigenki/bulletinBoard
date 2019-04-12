package model;
import java.io.Serializable;
//SQLと連携する時は、フールドの値とカラムの値を揃える。
public class Bulletin implements Serializable{
	private int id;
	private String userName;
	private String text;
	private String created_at;

	public Bulletin() {}
	public Bulletin(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	public Bulletin(int id, String userName, String text, String created_at) {
		this.id = id;
		this.userName = userName;
		this.text = text;
		this.created_at = created_at;
	}

	public int getId() { return id; }
	public String getUserName() { return userName; }
	public String getText() { return text; }
	public String getCreated_at() { return created_at; }
}
