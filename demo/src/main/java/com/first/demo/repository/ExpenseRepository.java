package com.first.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.demo.domain.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}