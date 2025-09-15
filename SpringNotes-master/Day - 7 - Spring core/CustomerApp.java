package app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.CustomerConfig;
import model.Customer;

public class CustomerApp {

	public static void main(String[] args) {

ApplicationContext ctx=
new AnnotationConfigApplicationContext(CustomerConfig.class);
//Object getBean(String beanName)
 Customer cust=(Customer)  ctx.getBean("customer");


Scanner sc=new Scanner(System.in);
System.out.println("enter id");
int id=sc.nextInt();
cust.setCustomerId(id);
System.out.println(cust);
		
		

	}

}
