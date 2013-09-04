package com.freeformatter.blog.pojo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("serial")
public final class OrderWrapper implements Serializable {

	@XmlElement(name = "order")
	private List<Order> orders;
	
	public OrderWrapper(List<Order> orders) {
		this.orders = orders;
	}
	
}