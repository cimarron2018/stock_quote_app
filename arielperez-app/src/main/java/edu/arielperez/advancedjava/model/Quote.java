package edu.arielperez.advancedjava.model;



import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Models the Person table
 */
@Entity
@Table(name = "quotes")
public class Quote {

    private int id;
    private String symbol;
    private Timestamp time;
    private BigDecimal price;

    /**
     * Primary Key - Unique ID for a particular row in the quotes table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the quotes table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the symbol of the stock
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 256)
    public String getSymbol() {
        return symbol;
    }

    /**
     * Specify the symbol of the stock
     *
     * @param symbol a String value
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the time of the stock price
     */
    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public Timestamp getTime() {
        return time;
    }

    /**
     * Specify the time of the stock price
     *
     * @param time a Time value
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * @return the price of the stock
     */
    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Specify the stock price
     *
     * @param price a BigDecimal value
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote = (Quote) o;

        if (id != quote.id) return false;
        if (symbol != null ? !symbol.equals(quote.symbol) : quote.symbol != null)
            return false;
        if (time != null ? !time.equals(quote.time) : quote.time != null)
            return false;
        if (price != null ? !price.equals(quote.price) : quote.price != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", time='" + time + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
