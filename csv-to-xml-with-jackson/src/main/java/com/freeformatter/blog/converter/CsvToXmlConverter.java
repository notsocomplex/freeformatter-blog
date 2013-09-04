package com.freeformatter.blog.converter;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import com.fasterxml.aalto.stax.InputFactoryImpl;
import com.fasterxml.aalto.stax.OutputFactoryImpl;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.freeformatter.blog.pojo.Order;

public class CsvToXmlConverter {

	@SuppressWarnings("unchecked")
	public <T> List<T> toPojos(InputStream in, Class<T> clazz) throws Exception {

		//	Note: You can create a schema manually if you prefer not using
		//		  the Jackson annotations in your pojos
		// 
		//	CsvSchema schema = CsvSchema.builder()
		//		.addColumn("id")
		//		.addColumn("buyer")
		//		.addColumn("address")
		//		.addColumn("amount", CsvSchema.ColumnType.NUMBER)
		//		.build();

		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(clazz);

		// Read all the values in the stream using the schema
		// to map to the pojo
		MappingIterator<Order> iterator = 
			mapper.reader(clazz).with(schema).readValues(in);

		return (List<T>) iterator.readAll();

	}

	public String toXml(Object pojo) throws Exception {
		 
		// Because of a known bug with woodstock and the pretty-printing
		// we use aalto instead
		XmlFactory factory = new XmlFactory(
			new InputFactoryImpl(), new OutputFactoryImpl()
		);
		
		// No need to use a wrapper, we will provide one manually
		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		
		// Create a mapper and enable Jaxb annotations
		XmlMapper mapper = new XmlMapper(factory);		
		mapper.registerModules(module, new JaxbAnnotationModule());
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		// Write the resulting xml to a writer and we are done!
		StringWriter writer = new StringWriter();
		mapper.writeValue(writer, pojo);
		return writer.toString();
		
	}	
	
}