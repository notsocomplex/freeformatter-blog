package com.freeformatter.blog;

import java.io.File;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.Text;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.junit.Assert;
import org.junit.Test;

public class XPathTest {

	@Test
	public void testXPathWithExplicitNamespace() throws Exception {
		
		// You can explicitly declare the namespaces
		final Namespace NS_LIB = Namespace.getNamespace("lib", "http://eric.van-der-vlist.com/ns/library");
	    final Namespace NS_HR = Namespace.getNamespace("hr", "http://eric.van-der-vlist.com/ns/person");
			    
		File file = new File(ClassLoader.getSystemResource("books.xml").getFile());
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
		
		XPathExpression<Element> expression = XPathFactory.instance().compile(
			"//lib:book", 
			Filters.fclass(Element.class), 
			null, 
			NS_LIB, 
			NS_HR
		);
		
		List<Element> elements = expression.evaluate(doc);
		
		Assert.assertTrue(elements.size() == 1);
		Assert.assertEquals(elements.get(0).getAttributeValue("id"), "b0836217462");
		
	}
	
	@Test
	public void testXPathWithNamespaceInScope() throws Exception {
		
		File file = new File(ClassLoader.getSystemResource("books.xml").getFile());
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
		
		// Tell the factory to use every namespace declared in the document
		XPathExpression<Element> expression = XPathFactory.instance().compile(
			"//lib:book", 
			Filters.fclass(Element.class), 
			null, 
			doc.getRootElement().getNamespacesInScope()
		);
		
		List<Element> elements = expression.evaluate(doc);
		
		Assert.assertTrue(elements.size() == 1);
		Assert.assertEquals(elements.get(0).getAttributeValue("id"), "b0836217462");
		
	}
	
	@Test
	public void testXPathWithUnknownReturnType() throws Exception {
		
		File file = new File(ClassLoader.getSystemResource("books.xml").getFile());
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
		
		// fpassthrough means to let everything through as an object, therefore
		// we need to cast the result to the proper type
		XPathExpression<Object> expression = XPathFactory.instance().compile(
			"//lib:book/lib:title/text()", 
			Filters.fpassthrough(), 
			null, 
			doc.getRootElement().getNamespacesInScope()
		);
		
		List<Object> elements = expression.evaluate(doc);
		
		Assert.assertTrue(elements.size() == 1);
		Assert.assertEquals(elements.get(0).getClass(), Text.class);
		
		Text text = (Text) elements.get(0);
		Assert.assertEquals(text.getValue(), "Being a Dog Is a Full-Time Job");
		
	}
	
}
