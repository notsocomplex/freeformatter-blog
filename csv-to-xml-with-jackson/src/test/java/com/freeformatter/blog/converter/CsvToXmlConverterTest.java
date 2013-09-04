package com.freeformatter.blog.converter;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.freeformatter.blog.pojo.Order;
import com.freeformatter.blog.pojo.OrderWrapper;

public class CsvToXmlConverterTest {

	@Test
	public void testFullConversion() throws Exception {

		// Get the sample data
		InputStream input = ClassLoader.getSystemResourceAsStream("orders.csv");

		// Create a converter instance
		CsvToXmlConverter converter = new CsvToXmlConverter();
		
		// Convert the CSV to POJOs first
		List<Order> orders = converter.toPojos(input, Order.class);
		
		// Convert the POJOs to XML
		String xml = converter.toXml(new OrderWrapper(orders));
		
		// The result is pretty printed!
		String result = "<orders>\r\n  <order>\r\n    <order>\r\n      <id>1</id>\r\n      <buyer>Mister President</buyer>\r\n      <address>1600 Pennsylvania Ave NW, Washington, DC 20500, United States</address>\r\n      <amount>45678.99</amount>\r\n    </order>\r\n    <order>\r\n      <id>2</id>\r\n      <buyer>Prime Minister</buyer>\r\n      <address>80 Wellington Street, Ottawa, ON K1A 0A2</address>\r\n      <amount>234.44</amount>\r\n    </order>\r\n  </order>\r\n</orders>";
		Assert.assertTrue(StringUtils.equals(xml, result));
		
	}
	
}
