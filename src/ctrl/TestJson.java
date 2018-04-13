package ctrl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.naming.java.javaURLContextFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;



@Controller
public class TestJson  {
@ResponseBody
@RequestMapping("testJson")
public User testAjax(int a,String b,HttpServletResponse response){
	User user = new User();
	user.setName("jack");
	user.setSex("son");
	user.setPwd("json");
	return user;
}
@RequestMapping("getJsonFromNet")
public  String getJsonFromNet(HttpServletResponse response,HttpServletRequest request) throws IOException{
	 String result="";//访问返回结果
	 BufferedReader read=null;//读取访问结果
	 StringBuilder json = new StringBuilder();                  
     try {  
         URL urlObject = new URL("http://localhost:13197/TestAPI.aspx?id=1");  
         URLConnection uc = urlObject.openConnection();  
         BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));  
         String inputLine = null;  
         while ( (inputLine = in.readLine()) != null) {  
             json.append(inputLine);  
         }  
         in.close();  
     } catch (MalformedURLException e) {  
         e.printStackTrace();  
     } catch (IOException e) {  
         e.printStackTrace();  
     }  
     String jsonStr= json.toString();
     //  / <body> ([\s\S]*?) <\/body> /i 
     jsonStr=  jsonStr.substring(jsonStr.indexOf("<body>")+6, jsonStr.indexOf("<!--"));
     
     Map  testMap = parseJSON2Map(jsonStr);
	return "netInterface";
}
//这是从html获取body里边的内容
public static String getBodyString(BufferedReader br) {
String inputLine;
   String str = "";
 try {
   while ((inputLine = br.readLine()) != null) {
    str += inputLine;
   }
   br.close();
 } catch (IOException e) {
   System.out.println("IOException: " + e);
 }
 return str;
}
//这是进行 访问URl 并返回数据的
@SuppressWarnings("unchecked")
public static String SendGET(String url,String param){
String result="";//访问返回结果
BufferedReader read=null;//读取访问结果
try {
 //创建url
 URL realurl=new URL(url+"?id="+param);
 //打开连接
 URLConnection connection=realurl.openConnection();
  // 设置通用的请求属性
          connection.setRequestProperty("accept", "*/*");
          connection.setRequestProperty("connection", "Keep-Alive");
          connection.setRequestProperty("user-agent",
                  "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
          //建立连接
          connection.connect();
       // 获取所有响应头字段
          Map<String, List<String>> map = connection.getHeaderFields();
          // 遍历所有的响应头字段，获取到cookies等
          for (String key : map.keySet()) {
              System.out.println(key + "--->" + map.get(key));
          }
          // 定义 BufferedReader输入流来读取URL的响应
          read = new BufferedReader(new InputStreamReader(
                  connection.getInputStream(),"UTF-8"));
          String line;//循环读取
          while ((line = read.readLine()) != null) {
              result += line;
          }
} catch (IOException e) {
 e.printStackTrace();
}finally{
 if(read!=null){//关闭流
  try {
   read.close();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}
List<String> list = new ArrayList<String>(); 
JSONArray jsonArray = JSONArray.fromObject(result);//把String转换为json 
list = JSONArray.toList(jsonArray);
  
return result; 
}

private static HashMap<String, String> toHashMap(Object object)  
{  
    HashMap<String, String> data = new HashMap<String, String>();  
    // 将json字符串转换成jsonObject  
    JSONObject jsonObject = JSONObject.fromObject(object);  
    Iterator it = jsonObject.keys();  
    // 遍历jsonObject数据，添加到Map对象  
    while (it.hasNext())  
    {  
        String key = String.valueOf(it.next());  
        String value = (String) jsonObject.get(key);  
        data.put(key, value);  
    }  
    return data;  
}  
public static Map<String, Object> parseJSON2Map(String jsonStr){
    ListOrderedMap map = new ListOrderedMap();
    //最外层解析
    JSONObject json = JSONObject.fromObject(jsonStr);
    for(Object k : json.keySet()){
        Object v = json.get(k); 
        //如果内层还是数组的话，继续解析
        if(v instanceof JSONArray){
            List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
            Iterator<JSONObject> it = ((JSONArray)v).iterator();
            while(it.hasNext()){
                JSONObject json2 = it.next();
                list.add(parseJSON2Map(json2.toString()));
            }
            map.put(k.toString(), list);
        } else {
            map.put(k.toString(), v);
        }
    }
    return map;
}
}
