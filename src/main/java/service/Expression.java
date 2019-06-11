package service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Expression {
	@XmlElement
	private String expression = "";
	
	public void setExpression(String exp) {
		this.expression = exp;
	}
	
	public String getExpression() {
		return this.expression;
	}
}
