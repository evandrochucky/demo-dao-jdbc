package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

//		Department obj = new Department(1, "Books");
//		System.out.println(obj);
//		
//		Seller seller = new Seller(21, "Antonio" , "antonio@gmail.com", new Date(), 12354.56, obj);
//		System.out.println(seller);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
	}

}
