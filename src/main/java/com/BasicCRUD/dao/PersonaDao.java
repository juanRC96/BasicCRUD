package com.BasicCRUD.dao;

import com.BasicCRUD.models.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona,Long> {

}
