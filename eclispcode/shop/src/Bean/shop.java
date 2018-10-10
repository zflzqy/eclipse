package Bean;
		//商品类
public class shop {
	private int id;//商品编号
	private String name;//商品名称
	private String city;//商品产地
	private int price;//商品价格
	private int number;//商品库存
	private String picture;//商品图片
	//无参构造函数，写上，不然有参报错
	public shop() {
	}
	
	public shop(int id, String name, String city, int price, int number, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.price = price;
		this.number = number;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@Override
	public int hashCode() {
		//判断两个对象是否相等，相等则equals返回true，大部分时候相等，效率高
		return this.getId()+this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		//真实判断两个对象属性，以及属性的值相等，内存地址是否相等（如果不重写只判断内存地址）
		if (this == obj) 
		{
			return true;
		}
		if (obj instanceof shop)
		{
			shop s = (shop) obj;
			if (this.getId() == s.getId() && this.getName().equals(s.getName())) 
			{
				return true;
			} 
			else 
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
	}

	@Override
	public String toString() {
		return "商品编号:  "+getId()+"商品名称:  "+getName();
			
	}
}
