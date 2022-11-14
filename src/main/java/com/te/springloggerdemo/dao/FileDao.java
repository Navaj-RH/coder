package com.te.springloggerdemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.springloggerdemo.entity.FileEntity;

public interface FileDao extends CrudRepository<FileEntity, String>{

	FileEntity findByFileName(String fileName);
}
