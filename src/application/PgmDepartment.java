package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class PgmDepartment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== Test 01: Department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== Test 02: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== Test 03: Department insert ===");
		Department newDep = new Department(null, "Music");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());	
		System.out.println(newDep);
		
		System.out.println("\n=== Test 04: Department update ===");
		department = departmentDao.findById(1);
		System.out.println("Before Update: " + department);
		department.setName("Dep0029");
		departmentDao.update(department);
		System.out.println("After  Update: " + department);
		System.out.println("Update completed!");
		
		System.out.println("\n=== Test 05: Department delete ===");
		System.out.println("Enter id for delete test: ");
		int id= sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}
