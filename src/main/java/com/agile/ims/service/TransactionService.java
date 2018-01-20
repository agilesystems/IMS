/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.service;

import com.agile.ims.entity.Account;
import com.agile.ims.entity.Transaction;
import java.util.Collection;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muhammad
 */
@Service
public interface TransactionService {

    /**
     * this method to add new or update current in the transaction
     *
     * @param transaction an argument to specify the transaction to saved
     * @return true if the transaction saved successfully or false if not saved
     */
    boolean save(Transaction transaction);

    /**
     * This method for soft deleted the transaction , just update the deleted
     * field with value(1
     *
     * @param transaction an argument to specify the data to updated
     * @return true if deleted field updated successfully or false in not
     * updated
     */
    boolean delete(Transaction transaction);

    /**
     * this method to get all transaction where the deleted field not equal 1
     *
     * @return a collection of all transactions
     */
    Collection<Transaction> getAll();

    /**
     * this method to get a collection of Transactions by account
     *
     * @param account an object of account argument to specify the account id to
     * get it
     * @return a collection of transactions by account id
     */
    Collection<Transaction> findByAccountid(Account account);

    /**
     * this method to get all transaction by type id (sales - purchase - etc...)
     *
     * @param typeid an integer argument to specify the id of transaction type
     * @return a collection of transactions by the transaction type.
     */
    Collection<Transaction> findByTypeid(int typeid);

    /**
     * this method to get all transaction between two dates
     *
     * @param from an date argument to specify the start of period transaction
     * @param to an date argument to specify the end of period transaction
     * @return a collection of transaction between @from date and @to date
     */
    Collection<Transaction> findByTransactiondate(Date from, Date to);

    /**
     * this method to get all transaction by value type (debit or credit )
     *
     * @param valuetype an integer argument to specify the type of value
     * (1-Debit , 2-Credit )
     * @return a collection of transaction by the value type argument
     */
    Collection<Transaction> findByValuetype(int valuetype);

}
