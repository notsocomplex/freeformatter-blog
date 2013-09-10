package com.freeformatter.blog;

import java.io.File;
import java.io.StringReader;
import java.net.URL;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderXSDFactory;
import org.jdom2.input.sax.XMLReaders;
import org.junit.Test;

@SuppressWarnings("unused")
public class ReadDocumentTest {
		
	@Test
	public void parseXmlFromFile() throws Exception {
			
		File file = new File(ClassLoader.getSystemResource("catalog.xml").getFile());
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
		
	}
	
	@Test
	public void parseXmlFromFileName() throws Exception {
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(ClassLoader.getSystemResource("catalog.xml").getFile());
		
	}
	
	// @Test
	public void parseXmlFromUrl() throws Exception {
		
		// Goes on the web to fetch it!
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new URL("http://www.w3schools.com/xml/cd_catalog.xml"));
		
	}	

	@Test
	public void parseXmlFromString() throws Exception {
		
		String xml = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\r\n<!-- from http://www.w3schools.com/xml/cd_catalog.xml -->\r\n<catalog>\r\n\t<cd>\r\n\t\t<title>empire burlesque</title>\r\n\t\t<artist>bob dylan</artist>\r\n\t\t<country>usa</country>\r\n\t\t<company>columbia</company>\r\n\t\t<price>10.90</price>\r\n\t\t<year>1985</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>hide your heart</title>\r\n\t\t<artist>bonnie tyler</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>cbs records</company>\r\n\t\t<price>9.90</price>\r\n\t\t<year>1988</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>greatest hits</title>\r\n\t\t<artist>dolly parton</artist>\r\n\t\t<country>usa</country>\r\n\t\t<company>rca</company>\r\n\t\t<price>9.90</price>\r\n\t\t<year>1982</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>still got the blues</title>\r\n\t\t<artist>gary moore</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>virgin records</company>\r\n\t\t<price>10.20</price>\r\n\t\t<year>1990</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>eros</title>\r\n\t\t<artist>eros ramazzotti</artist>\r\n\t\t<country>eu</country>\r\n\t\t<company>bmg</company>\r\n\t\t<price>9.90</price>\r\n\t\t<year>1997</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>one night only</title>\r\n\t\t<artist>bee gees</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>polydor</company>\r\n\t\t<price>10.90</price>\r\n\t\t<year>1998</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>sylvias mother</title>\r\n\t\t<artist>dr.hook</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>cbs</company>\r\n\t\t<price>8.10</price>\r\n\t\t<year>1973</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>maggie may</title>\r\n\t\t<artist>rod stewart</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>pickwick</company>\r\n\t\t<price>8.50</price>\r\n\t\t<year>1990</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>romanza</title>\r\n\t\t<artist>andrea bocelli</artist>\r\n\t\t<country>eu</country>\r\n\t\t<company>polydor</company>\r\n\t\t<price>10.80</price>\r\n\t\t<year>1996</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>when a man loves a woman</title>\r\n\t\t<artist>percy sledge</artist>\r\n\t\t<country>usa</country>\r\n\t\t<company>atlantic</company>\r\n\t\t<price>8.70</price>\r\n\t\t<year>1987</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>black angel</title>\r\n\t\t<artist>savage rose</artist>\r\n\t\t<country>eu</country>\r\n\t\t<company>mega</company>\r\n\t\t<price>10.90</price>\r\n\t\t<year>1995</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>1999 grammy nominees</title>\r\n\t\t<artist>many</artist>\r\n\t\t<country>usa</country>\r\n\t\t<company>grammy</company>\r\n\t\t<price>10.20</price>\r\n\t\t<year>1999</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>for the good times</title>\r\n\t\t<artist>kenny rogers</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>mucik master</company>\r\n\t\t<price>8.70</price>\r\n\t\t<year>1995</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>big willie style</title>\r\n\t\t<artist>will smith</artist>\r\n\t\t<country>usa</country>\r\n\t\t<company>columbia</company>\r\n\t\t<price>9.90</price>\r\n\t\t<year>1997</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>tupelo honey</title>\r\n\t\t<artist>van morrison</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>polydor</company>\r\n\t\t<price>8.20</price>\r\n\t\t<year>1971</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>soulsville</title>\r\n\t\t<artist>jorn hoel</artist>\r\n\t\t<country>norway</country>\r\n\t\t<company>wea</company>\r\n\t\t<price>7.90</price>\r\n\t\t<year>1996</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>the very best of</title>\r\n\t\t<artist>cat stevens</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>island</company>\r\n\t\t<price>8.90</price>\r\n\t\t<year>1990</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>stop</title>\r\n\t\t<artist>sam brown</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>a and m</company>\r\n\t\t<price>8.90</price>\r\n\t\t<year>1988</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>bridge of spies</title>\r\n\t\t<artist>t'pau</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>siren</company>\r\n\t\t<price>7.90</price>\r\n\t\t<year>1987</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>private dancer</title>\r\n\t\t<artist>tina turner</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>capitol</company>\r\n\t\t<price>8.90</price>\r\n\t\t<year>1983</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>midt om natten</title>\r\n\t\t<artist>kim larsen</artist>\r\n\t\t<country>eu</country>\r\n\t\t<company>medley</company>\r\n\t\t<price>7.80</price>\r\n\t\t<year>1983</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>pavarotti gala concert</title>\r\n\t\t<artist>luciano pavarotti</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>decca</company>\r\n\t\t<price>9.90</price>\r\n\t\t<year>1991</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>the dock of the bay</title>\r\n\t\t<artist>otis redding</artist>\r\n\t\t<country>usa</country>\r\n\t\t<company>atlantic</company>\r\n\t\t<price>7.90</price>\r\n\t\t<year>1987</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>picture book</title>\r\n\t\t<artist>simply red</artist>\r\n\t\t<country>eu</country>\r\n\t\t<company>elektra</company>\r\n\t\t<price>7.20</price>\r\n\t\t<year>1985</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>red</title>\r\n\t\t<artist>the communards</artist>\r\n\t\t<country>uk</country>\r\n\t\t<company>london</company>\r\n\t\t<price>7.80</price>\r\n\t\t<year>1987</year>\r\n\t</cd>\r\n\t<cd>\r\n\t\t<title>unchain my heart</title>\r\n\t\t<artist>joe cocker</artist>\r\n\t\t<country>usa</country>\r\n\t\t<company>emi</company>\r\n\t\t<price>8.20</price>\r\n\t\t<year>1987</year>\r\n\t</cd>\r\n</catalog>";
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new StringReader(xml));
		
	}	
	
	@Test
	public void parseXmlFileWithSchemaValidation() throws Exception {

		File xsd = new File(ClassLoader.getSystemResource("catalog.xsd").getFile());
		
		XMLReaderJDOMFactory factory = new XMLReaderXSDFactory(xsd);
		SAXBuilder builder = new SAXBuilder(factory);
		
		File xml = new File(ClassLoader.getSystemResource("catalog.xml").getFile());
		Document doc = builder.build(xml);
		
	}
	
	@Test
	public void disableDtdResolutions() throws Exception {

		String xml = "<?xml version = \"1.0\" ?><!DOCTYPE catalog SYSTEM \"catalog.dtd\"><catalog></catalog>";
		
		SAXBuilder builder = new SAXBuilder(XMLReaders.NONVALIDATING);

	    builder.setFeature("http://xml.org/sax/features/validation", false);
	    builder.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
	    builder.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		
		Document doc = builder.build(new StringReader(xml));
		
	}
		
}
