package com.example.Expense_Split.Repository;

import com.example.Expense_Split.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
