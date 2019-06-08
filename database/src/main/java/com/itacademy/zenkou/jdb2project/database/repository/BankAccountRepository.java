package com.itacademy.zenkou.jdb2project.database.repository;

import com.itacademy.zenkou.jdb2project.database.entity.db.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
