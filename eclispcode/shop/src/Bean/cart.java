package Bean;
//���ﳵ��

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;

import com.sun.javafx.collections.MappingChange.Map;

public class cart {
	//�������Ʒ����
	private HashMap<shop, Integer> goods;
	//������Ʒ���ܼ۰�
	private double totalprice;
	
	public cart() {
		//���췽������ʼ������
		goods = new HashMap<shop,Integer>();
		totalprice = 0.0;
	}
	
	public HashMap<shop, Integer> getGoods() {
		return goods;
	}
	public void setGoods(HashMap<shop, Integer> goods) {
		this.goods = goods;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
	//�����Ʒ
	public boolean addGoodsIncart(shop s,Integer number) {
		if(goods.containsKey(s)) 
		{
			//�ж��Ƿ���ڸ���Ʒ
			goods.put(s, goods.get(s)+number);
		}
		else 
		{
			goods.put(s, number);
		}
		countTotalprice();//�����Ʒ�����¼�����
		return true;
	}
	
	//ɾ����Ʒ
	public boolean removeGoods(shop s) {
		goods.remove(s);
		countTotalprice();//ɾ����Ʒ�����¼�����
		return true;
	}
	
	//������Ʒ�ܼ�
	public double countTotalprice() {
		double sum = 0.0;
		Set<shop> hs = goods.keySet();//��ü��ļ��ϣ�hashmap������ѭ������
		Iterator<shop> it = hs.iterator();//��õ�����
		while(it.hasNext()) {
			shop s= it.next();//���һ����Ʒ
			sum+=s.getPrice()*goods.get(s);//ͨ�������ֵ
		}
		this.setTotalprice(sum);//���ù����ܽ��
		return this.getTotalprice();//��ȡ�����ܽ��
	}
	//���Թ��ﳵ��
//	public static void main(String[] args) {
//		shop s1=new shop(1,"��Ь","�Ϻ�",200,100,"001.jpg");
//		shop s2=new shop(2,"��Ь2","�Ϻ�",200,100,"002.jpg");
//		shop s3=new shop(1,"��Ь","�Ϻ�",200,100,"001.jpg");
//		cart c =new cart();
//		c.addGoodsIncart(s1, 1);
//		c.addGoodsIncart(s2, 2);
//		//�ٴι�����Ь
//		c.addGoodsIncart(s3, 4);
//		//������Ʒ
//		Set<Entry<shop,Integer>> shops = c.getGoods().entrySet();
//		for(Entry<shop,Integer> obj:shops) {
//			System.out.println(obj);
//		}
//		//�ܽ��
//		System.out.println(c.getTotalprice());
//		
//	}
}
