package Dao;

import java.io.Serializable;
import java.util.*;

public interface GenericDAO<T> {
	   T save(T entity); 
	   T update(T entity);
	   void remove(Object id);
	   T findById(Object id);
	   List<T> findAll();
	   Long getTotalResult();
 
}
