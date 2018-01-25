package Dao;


import java.util.*;

import javax.ws.rs.core.Response;

public interface GenericDAO<T> {
   public  List<T> getAll();
	 public List<T>FindByListId(Object i);
     public List<T> FindByListName(String Name);
	 public boolean Create(T entite);
	 public boolean Update(T entite);
	 public boolean Delete(Object entite);
 
}
