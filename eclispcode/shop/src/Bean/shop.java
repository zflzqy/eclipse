package Bean;
		//��Ʒ��
public class shop {
	private int id;//��Ʒ���
	private String name;//��Ʒ����
	private String city;//��Ʒ����
	private int price;//��Ʒ�۸�
	private int number;//��Ʒ���
	private String picture;//��ƷͼƬ
	//�޲ι��캯����д�ϣ���Ȼ�вα���
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
		//�ж����������Ƿ���ȣ������equals����true���󲿷�ʱ����ȣ�Ч�ʸ�
		return this.getId()+this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		//��ʵ�ж������������ԣ��Լ����Ե�ֵ��ȣ��ڴ��ַ�Ƿ���ȣ��������дֻ�ж��ڴ��ַ��
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
		return "��Ʒ���:  "+getId()+"��Ʒ����:  "+getName();
			
	}
}
