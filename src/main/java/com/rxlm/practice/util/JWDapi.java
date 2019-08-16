package com.rxlm.practice.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName: JWDapi
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/6/5 14:20
 * @Version: 1.0
 */
public class JWDapi {
    /**
     * @param addr
     * 查询的地址
     * @return
     * @throws IOException
     */
    public static String[] getCoordinate(String addr) throws IOException {
        String lng = null;//经度
        String lat = null;//纬度
        String address = null;
        try {
            address = java.net.URLEncoder.encode(addr, "UTF-8");
        }catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        //System.out.println(address);
        String url = "http://api.map.baidu.com/geocoder/v2/?output=json&ak=hZtedoMYjYqgq72dgF2wsS0UoMz2X36D&address="+address;
        URL myURL = null;

        URLConnection httpsConn = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader insr = null;
        BufferedReader br = null;
        try {
            httpsConn = (URLConnection) myURL.openConnection();
            if (httpsConn != null) {
                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = null;
                while((data= br.readLine())!=null){
                    JSONObject json = JSONObject.parseObject(data);
                    if (json != null) {
                        lng = json.getJSONObject("result").getJSONObject("location").getString("lng");
                        lat = json.getJSONObject("result").getJSONObject("location").getString("lat");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(insr!=null){
                insr.close();
            }
            if(br!=null){
                br.close();
            }
        }
        return new String[]{lng,lat};
    }

    public static String[] getAddr(String lng,String lat) throws IOException {

        String url = "http://api.map.baidu.com/geocoder/v2/?output=json&ak=您的ak&location="+lat+","+lng;
        URL myURL = null;
        String city = "";
        String qx = "";
        URLConnection httpsConn = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader insr = null;
        BufferedReader br = null;
        try {
            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
            if (httpsConn != null) {
                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = null;
                while((data= br.readLine())!=null){
                    JSONObject json = JSONObject.parseObject(data);
                    if (json != null) {
                        city = json.getJSONObject("result").getJSONObject("addressComponent").getString("city");
                        qx= json.getJSONObject("result").getJSONObject("addressComponent").getString("district");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(insr!=null){
                insr.close();
            }
            if(br!=null){
                br.close();
            }
        }
        return new String[]{city,qx};
    }


    public static void main(String[] args) throws IOException {
        String addr = "怀柔区012县道庙城家园院内南侧";
        String[] coordinate = getCoordinate(addr);
        for (int i = 0; i < coordinate.length; i++) {
            System.out.println();
        }
    }

}
