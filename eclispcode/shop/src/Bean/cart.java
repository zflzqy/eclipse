package Bean;
//购物车类

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;

import com.sun.javafx.collections.MappingChange.Map;

public class cart {
	//购买的商品集合
	private HashMap<shop, Integer> goods;
	//购买商品的总价啊
	private double totalprice;
	
	public cart() {
		//构造方法，初始化属性
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
	
	//添加商品
	public boolean addGoodsIncart(shop s,Integer number) {
		if(goods.containsKey(s)) 
		{
			//判断是否存在该商品
			goods.put(s, goods.get(s)+number);
		}
		else 
		{
			goods.put(s, number);
		}
		countTotalprice();//添加商品后重新计算金额
		return true;
	}
	
	//删除商品
	public boolean removeGoods(shop s) {
		goods.remove(s);
		countTotalprice();//删除商品后重新计算金额
		return true;
	}
	
	//计算商品总价
	public double countTotalprice() {
		double sum = 0.0;
		Set<shop> hs = goods.keySet();//获得键的集合，hashmap不能用循环遍历
		Iterator<shop> it = hs.iterator();//获得迭代器
		while(it.hasNext()) {
			shop s= it.next();//获得一个商品
			sum+=s.getPrice()*goods.get(s);//通过键获得值
		}
		this.setTotalprice(sum);//设置购物总金额
		return this.getTotalprice();//获取购物总金额
	}
	//测试购物车类
//	public static void main(String[] args) {
//		shop s1=new shop(1,"球鞋","上海",200,100,"001.jpg");
//		shop s2=new shop(2,"球鞋2","上海",200,100,"002.jpg");
//		shop s3=new shop(1,"球鞋","上海",200,100,"001.jpg");
//		cart c =new cart();
//		c.addGoodsIncart(s1, 1);
//		c.addGoodsIncart(s2, 2);
//		//再次购买球鞋
//		c.addGoodsIncart(s3, 4);
//		//遍历商品
//		Set<Entry<shop,Integer>> shops = c.getGoods().entrySet();
//		for(Entry<shop,Integer> obj:shops) {
//			System.out.println(obj);
//		}
//		//总金额
//		System.out.println(c.getTotalprice());
//		
//	}
}
