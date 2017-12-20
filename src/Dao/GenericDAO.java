package Dao;


import java.util.*;

import javax.ws.rs.core.Response;

public interface GenericDAO<T> {
   public  List<T> getAll();
	 public List<T>FindByListId(Object i);
     public List<T> FindByListName(String Name);
	 public Response Create(T entite);
	 public Response Update(T entite);
	 public Response DeleteFuts(Object entite);
 
}
