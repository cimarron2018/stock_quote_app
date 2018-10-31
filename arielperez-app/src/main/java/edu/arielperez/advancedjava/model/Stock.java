package edu.arielperez.advancedjava.model;

import edu.arielperez.advancedjava.service.XMLDomainObject;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="symbol" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="price" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="time" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "stock")


public class Stock implements XMLDomainObject {

    @XmlAttribute(name = "symbol", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String symbol;
    @XmlAttribute(name = "price", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String price;
    @XmlAttribute(name = "time", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String time;

    /**
     * Gets the value of the price property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrice(String value) {
        this.price = value;
    }

    /**
     * Gets the value of the time property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the age property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the age property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSymbol(String value) {
        this.symbol = value;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol'" + symbol + '\'' +
                ", price'" + price + '\'' +
                ", time'" + time + '\'' +
                '}';
    }

}
