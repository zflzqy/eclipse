package com.scokettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class testUrl {

	public static void main(String[] args) {
		URL url;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			url = new URL("http://www.baidu.com");
			in = url.openStream();//∂¡»Î¡˜
			isr = new InputStreamReader(in,"utf-8");
			br = new BufferedReader(isr);
			String line  ;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
				isr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
