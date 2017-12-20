package main;

import model.CatalogueFut;
import Dao.CatalogueFutDAO;
import Dao.GenericImplDAO;

public class test {

	public static void main(String[] args) {
		GenericImplDAO<CatalogueFut> df = new CatalogueFutDAO();
       System.out.println(df.getEntityManager());
	}

}
