package test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lujun
 * @date 2018年7月9日
 */
public class TestJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String json = "{'response':{'data':[{'address':'北京','province':'海淀','district':'西三旗','city':'地铁'}]},'status':'ok'}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		String response = jsonObject.getString("response");
		JSONObject jsonObject2 = JSONObject.fromObject(response);
		JSONArray data = jsonObject2.getJSONArray("data"); 
		for(int i=0;i<data.size();i++){
		String s = data.getString(i);
		JSONObject data2 = JSONObject.fromObject(s); 
		if(data2.get("address")!=null && !data2.get("address").equals("")){
			System.out.println(data2.getString("address")); 
		}
		
		/*System.out.println(data2.getString("province")); 
		System.out.println(data2.getString("district")); 
		System.out.println(data2.getString("city")); */
		}
		/*String json1= "{'count':1,'data':[{'sku':'1','name':'1','style':'1','purchasePrice':'1','listPrice':'1','curPrice':'1','colors':'1','sizes':'1','unit':'1','upperLimitNum':1,'lowerLimitNum':1}]}";
		JSONObject jsonObject=	JSONObject.fromObject(json1);
		JSONArray array=jsonObject.getJSONArray("data");
		for (int i = 0; i < array.size(); i++) {
			String s=array.getString(i);
			System.out.println(s);
			JSONObject data2 = JSONObject.fromObject(s); 
			System.out.println(data2.getString("sku")); 
			System.out.println(data2.getString("name")); 
			System.out.println(data2.getString("style")); 
		}*/
		/*String json = "{'status':200,'message':'查询成功','data':[{'id':1,'name':'name1','describe':'第一条数据'}]}"; 
		JSONObject data = JSONObject.fromObject(json); 
		JSONArray data1 = data.getJSONArray("data"); 
		for(int i=0;i<data1.size();i++){ 
		String s = data1.getString(i); 
		System.out.println(s); 
		JSONObject data2 = JSONObject.fromObject(s); 
		System.out.println(data2.getString("id")); 
		System.out.println(data2.getString("name")); 
		System.out.println(data2.getString("describe")); 
		} */
	}

}
