package edu.arielperez.advancedjava.service;

import edu.arielperez.advancedjava.model.Quote;
import edu.arielperez.advancedjava.utilities.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class DatabaseQuoteService implements QuoteService {
    /**
     * Get a list of all quotes
     *
     * @return a list of Quote instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Quote> getQuote() throws QuoteServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Quote> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Quote.class);

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new QuoteServiceException("Could not get Quote data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;

    }


    /**
     * Add a new quote or update an existing Quote's data
     *
     * @param quote a quote object to either update or create
     */
    @Override
    public void addOrUpdateQuote(Quote quote) {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(quote);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }
}
