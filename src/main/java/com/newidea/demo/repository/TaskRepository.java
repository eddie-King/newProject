package com.newidea.demo.repository;

import com.newidea.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByGroupCode(String groupCode);
    @Modifying
    @Transactional
    @Query(value = "truncate table task", nativeQuery = true)
    void truncateTable();
}

