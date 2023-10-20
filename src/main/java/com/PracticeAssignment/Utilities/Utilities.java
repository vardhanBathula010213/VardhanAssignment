package com.PracticeAssignment.Utilities;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.PracticeAssignment.BaseClass.BaseClass;

public class Utilities extends BaseClass{

	public static String getStringDataFromJsonArray(String filePath,String arraykey,String key) throws Exception {
		JSONParser jsonParser=new JSONParser();
		FileReader fileReader=new FileReader(filePath);
		Object object = jsonParser.parse(fileReader);
		JSONObject jsonObject=(JSONObject)object;
		JSONArray jarray=(JSONArray)jsonObject.get(arraykey);
		String getValue="";
		for(int i=0;i<1;i++)
		{
			JSONObject jso=(JSONObject)jarray.get(0);
			String getTestData=(String)jso.get(key);
			getValue=getTestData;
		}
		return getValue;
	}
}