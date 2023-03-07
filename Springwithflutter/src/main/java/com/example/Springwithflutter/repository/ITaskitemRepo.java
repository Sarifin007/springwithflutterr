package com.example.Springwithflutter.repository;

import com.example.Springwithflutter.model.Tastitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskitemRepo extends JpaRepository<Tastitem,Long> {

}
