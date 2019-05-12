package com.seoul.controller;

import java.io.FileInputStream;
import java.util.HashMap;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class ControllerFactory {

	private Properties mappings;
	private HashMap<String, Controller> controllers;
	
	public ControllerFactory(String mappingFilePath) {
		mappings = new Properties();
		controllers = new HashMap<>();
		FileInputStream istream = null;
		try {
			istream = new FileInputStream(mappingFilePath);
			mappings.load(istream);
		for (Object actionName : mappings.keySet()) {
			String typeName = mappings.getProperty(actionName.toString()); //키를 하나씩 꺼내 getProperty하면 value
			Controller controller = createInstance(typeName);
			controllers.put((String)actionName, controller);
		}
	} catch (Exception ex) {
		
	} finally {
		try {istream.close();} catch (Exception ex) {}
	}
		
	}
	
	public Controller getInstance(String action) {
		String typeName = mappings.getProperty(action);
		Controller controller = controllers.get(action);
		return controller;
	}
	
private Controller createInstance(String typeName) {
	Controller controller = null;
	try {
		//전달인자에 지정된 타입정보를 관리하는 객체 반환
		Class claz = Class.forName(typeName); 
		//타입에 대한 정보를 관리하는 인스턴스 - 객체생성
		//클래스 정보를 사용해서 인스턴스 만들기
		controller = (Controller)claz.newInstance();
	} catch (Exception ex) {
		ex.printStackTrace();
	} //인스턴스에 대한 정보를 가져올 수 있음.
	return controller;

}
	
}
