package com.freeformatter.blog.pojo;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

	@Test
	public void test() throws Exception {
		
		User user1 = new User("Peter", "Parker", "peter.parker@dailybugle.com");
		User user2 = new User();
		
		BeanUtils.copyProperties(user1, user2);
		
		Assert.assertEquals(user1.getFirstName(), user2.getFirstName());
		Assert.assertEquals(user1.getLastName(), user2.getLastName());
		Assert.assertEquals(user1.getEmail(), user2.getEmail());
		
	}
	
	@Test
	public void testWithAnotherUser() throws Exception {
		
		User user1 = new User("Peter", "Parker", "peter.parker@dailybugle.com");
		AnotherUser user2 = new AnotherUser();
		
		BeanUtils.copyProperties(user1, user2);
		
		Assert.assertEquals(user1.getFirstName(), user2.getFirstName());
		Assert.assertEquals(user1.getLastName(), user2.getLastName());
		Assert.assertEquals(user1.getEmail(), user2.getEmail());
		Assert.assertEquals(user2.getAge(), 0);
		
	}
	
	@Test
	public void testUserWithCar() throws Exception {
		
		User user = new User("Peter", "Parker", "peter.parker@dailybugle.com");
		Car car = new Car();
		
		BeanUtils.copyProperties(user, car);
						
	}
	
	@Test
	public void testCarWithWine() throws Exception {
		
		Car car = new Car("Ford Escort", 1984);
		Wine wine = new Wine();
		
		BeanUtils.copyProperties(car, wine);
		
		Assert.assertNull(wine.getName());
		Assert.assertEquals(wine.getYear(), 0);
		
	}
	
	@Test
	public void testCarWithWineWithSpringBeanUtils() throws Exception {
		
		Car car = new Car("Ford Escort", 1984);
		Wine wine = new Wine();
		
		org.springframework.beans.BeanUtils.copyProperties(car, wine);
		
		Assert.assertEquals(car.getName(), wine.getName());
		Assert.assertEquals(car.getYear(), wine.getYear());
		
	}	
		
}
