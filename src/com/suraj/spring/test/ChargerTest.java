package com.suraj.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.suraj.spring.beans.Laptop;

public class ChargerTest {

	public static void main(String[] args) {
		
		Resource resource = new ClassPathResource("spring.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		// 1. getBean(String name):Object
		Object obj = factory.getBean("laptop");
		Laptop laptop = (Laptop)obj;
		laptop.getCharger().getCharging();
		
		System.out.println("-----------------------------------------------");
		
		//2. getBean(String name, Class clazz):T- BeanFactory   (Laptop)
		Laptop laptop1 = factory.getBean("laptop", Laptop.class);
		laptop1.getCharger().getCharging();
		
		System.out.println("-----------------------------------------------");
		
		//3. getBean(Class clazz):T- BeanFactory  (Laptop)
		Laptop laptop2 = factory.getBean(Laptop.class);
		laptop2.getCharger().getCharging();
		
		System.out.println("-----------------------------------------------");
		
		//4. getType(String name):Class<?>
		Class<?> clazz = factory.getType("laptop");
		System.out.println(clazz.getName());
		
		System.out.println("-----------------------------------------------");
		
		//5. getAliases(String name):String[]- BeanFactory (aliases defines in configuration file)
		String []names = factory.getAliases("laptop");
		for (String aNames : names) {
			System.out.println(aNames);
		}
		
		System.out.println("-----------------------------------------------");
		
		//6. To check bean is singleton/prototype   (By default every bean is singleton)
		// isSingleton(String name):Boolean- BeanFactory
		// isPrototype(String name):Boolean- BeanFactory
		System.out.println("TO Check Laptop is singleton or not : "+factory.isSingleton("laptop"));
		System.out.println("TO Check Laptop is prototype or not : "+factory.isPrototype("laptop"));
		
	}
}
