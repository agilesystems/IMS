/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.service;

import com.agile.ims.entity.Account;
import com.agile.ims.entity.Lookup;
import com.agile.ims.entity.User;
import java.util.Collection;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * 
 * @author Muhammad
 */
@Service
public interface AccountService {

    /**
     * save new or update Current Account with all details This method always
     * returns immediately true or false
     *
     * @param account an argument to determined the account that we need to use
     * it
     * @return true or false . if the account saved return true and the account
     * not saved return false .
     */
    boolean save(Account account);

    /**
     * this method to soft delete account , Just update the deleted field with
     * value (1)
     *
     * @param account an argument to specify the account to be updated
     * @return this method must return True if the account Already update the
     * deleted field or False if not update the deleted field
     */
    boolean delete(Account account);

    boolean save(int id, String name, String phone, String email, String address, Lookup type, String Code, String extrainfo, User createdby, Date createdat, User updatedby, Date updatedat, boolean deleted, User deletedby);

    /**
     * this method to get All Accounts .
     *
     * @return  a collection of accounts
     */
    Collection<Account> getAll();

    /**
     * Return One Or more accounts By name argument Or a part of it. this method
     * to get the account if name argument matched Or a part of name argument
     *
     * @param name an argument to specify the full name of account name or part
     * of account name using like %{
     * @name}%
     *
     * @return a collection type of accounts
     */
    Collection<Account> findByName(String name);

    /**
     * this method to get specified account with id argument
     *
     * @param id an argument to specify the account
     * @return one Account
     */
    Account findById(int id);
//    Collection<Account> findByTypeId(int typeid);

}
