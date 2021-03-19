package com.banktransfer.et.demo.repository;

import com.banktransfer.et.demo.domains.Account;
import org.springframework.data.repository.CrudRepository;
// Long is the data type of
public interface AccountRepository  extends CrudRepository<Account,Long> {



}
