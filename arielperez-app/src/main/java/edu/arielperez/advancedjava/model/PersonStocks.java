package edu.arielperez.advancedjava.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * Models a table the combines person with their stock symbols.
 */
@Entity
@Table(name = "person_stocks", catalog = "stocks")
public class PersonStocks {
    private int id;
    private Person person;
    private String stockSymbol;

    /**
     * Create a PersonStocks that needs to be initialized
     */
    public PersonStocks() {
        // this empty constructor is required by hibernate framework

    }

    /**
     * Create a valid PersonStocks
     *
     * @param person       the person to assign the stock symbol to
     * @param stock_symbol the stock symbol to associate the person with
     */
    public PersonStocks(Person person, String stock_symbol) {
        setStock(stock_symbol);
        setPerson(person);
    }

    /**
     * Primary Key - Unique ID for a particular row in the person_stocks table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person_stocks table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return get the Person associated with this stock symbol
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public Person getPerson() {
        return person;
    }

    /**
     * Specify the Person associated with the stock symbol.
     *
     * @param person a person instance
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the stock symbol
     */
    @Basic
    @Column(name = "stock_symbol", nullable = false, insertable = true, updatable = true, length = 4)
    public String getStock() {
        return stockSymbol;
    }

    /**
     * Specify the stock symbol
     *
     * @param stock_symbol a String value
     */
    public void setStock(String stock_symbol) {
        this.stockSymbol = stock_symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonStocks that = (PersonStocks) o;

        if (id != that.id) return false;
        if (stockSymbol != null ? !stockSymbol.equals(that.stockSymbol) : that.stockSymbol != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + (stockSymbol != null ? stockSymbol.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonStock{" +
                "id=" + id +
                ", person=" + person +
                ", stock symbol=" + stockSymbol +
                '}';
    }
}
