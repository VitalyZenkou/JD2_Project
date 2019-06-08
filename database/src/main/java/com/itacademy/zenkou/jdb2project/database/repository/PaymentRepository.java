package com.itacademy.zenkou.jdb2project.database.repository;

import com.itacademy.zenkou.jdb2project.database.entity.db.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
