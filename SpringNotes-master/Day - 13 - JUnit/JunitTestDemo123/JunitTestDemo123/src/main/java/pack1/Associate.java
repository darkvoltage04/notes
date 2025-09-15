package pack1;


public class Associate {
	String name;
	int age;
	String city;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public Associate getAssociate(String name, int age, String city)
			throws InvalidAssociate
	{
		
		if(age<18 || name.length()<3 || city.equals("abc"))
		{
			throw new InvalidAssociate("not valid Associate");
		}
		Associate a=new Associate();
		a.setAge(age);
		a.setCity(city);
		a.setName(name);
		return a;
		
		
	}
	
	
	
	
	
	

}
