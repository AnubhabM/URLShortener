package com.bootCrud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootCrud.models.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {
	public List<Url> findAll();
	public Url findById(int id);	
	public Url findBybigUrl(String url);
	public Url findBysmallUrl(String url);
}
