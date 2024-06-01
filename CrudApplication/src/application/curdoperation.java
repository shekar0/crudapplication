package application;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class curdoperation {
	private static final String User="root";
	private static final String Password="root";
	
	public static void main(String[] args) {
		
		int ch;
		do {
			System.out.println("crud operations :");
			display();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter your choice : ");
			ch=sc.nextInt();
			switch (ch) {
			case 1:
				createdatabase();
				break;
			case 2:
				dropdatabase();
				break;
			case 3:
				createtable();
				break;
			case 4:
				droptable();
				break;
			case 5:
				insertdata();
				break;
			case 6:
				updatedata();
				break;
			case 7:
				deletedata();
				break;
			case 8:
				getall();
				break;
			case 9:
				getbyemail();
				break;
			case 10:
				System.exit(0);
			default:
				System.out.println("invalid operation");
				
				
			}
			
			
		} while (ch>0);
	}

	private static void getbyemail() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter database name :");
		    String Url="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter table name :");
			String sql="select * from "+sc.next()+" where email=?";
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			System.out.println("enter email :");
			pmst.setString(1, sc.next());
						
			ResultSet rs=pmst.executeQuery();
			while(rs.next())
			{
				System.out.println("************************"+"\nid = "+rs.getInt("id")+"\nname = "+rs.getString("name")+"\nemail = "+rs.getString("email")+"\n**********************");
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private static void getall() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter database name :");
		    String Url="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter table name :");
			String sql="select * from "+sc.next();
			
			PreparedStatement pmst=conn.prepareStatement(sql);
						
			ResultSet rs=pmst.executeQuery();
			while(rs.next())
			{
				System.out.println("**********************"+"\nid = "+rs.getInt("id")+"\nname = "+rs.getString("name")+"\nemail = "+rs.getString("email")+"\n\n*********************");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private static void deletedata() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter database name :");
		    String Url="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter table name :");
			String sql="delete from "+sc.next()+" where id = ?";
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			System.out.println("enter id:");
			pmst.setInt(1,sc.nextInt());
			int i=pmst.executeUpdate();
			if(i>0)
			{
				System.out.println("successfully deleted");
			}
			else {
				System.out.println("not deleted");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private static void updatedata() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter database name :");
		    String Url="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter table name :");
			String sql="update "+sc.next()+" set name=?, email=? where id=?";
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			System.out.println("enter name :");
			pmst.setString(1, sc.next());
			System.out.println("enter email :");
			pmst.setString(2, sc.next());
			System.out.println("enter id :");
			pmst.setInt(3, sc.nextInt());
			
			
			int i=pmst.executeUpdate();
			if(i>0)
			{
				System.out.println("updated successfully");
			}
			else {
				System.out.println("not updated");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private static void insertdata() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter database name :");
		    String Url="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter table name :");
			String sql="insert into "+sc.next()+"(id ,name ,email) values(?,?,?)";
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			System.out.println("enter id :");
			pmst.setInt(1, sc.nextInt());
			System.out.println("enter name :");
			pmst.setString(2, sc.next());
			System.out.println("enter email :");
			pmst.setString(3, sc.next());
			
			int i=pmst.executeUpdate();
			if(i>0)
			{
				System.out.println("successfully inserted \n");
			}
			else {
				System.out.println("not inserted");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private static void droptable() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter database name :");
		    String Url="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter table name :");
			String sql="drop table "+sc.next();
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			
			int i=pmst.executeUpdate();
			if(i==0)
			{
				System.out.println("successfully deleted");
			}
			else {
				System.out.println("not deleted");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private static void createtable() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter database name :");
		    String Url="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter table name :");
			String sql="create table "+sc.next()+"(id int,name varchar(20),email varchar(40))";
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			
			int i=pmst.executeUpdate();
			if(i==0)
			{
				System.out.println("successfully created");
			}
			else {
				System.out.println("not created");
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private static void dropdatabase() {
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			String Url="jdbc:mysql://localhost:3306/";
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter database name :");
			String sql="drop database "+sc.next();
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			
			int i=pmst.executeUpdate();
			if(i==0)
			{
				System.out.println("successfully deleted");
			}
			else {
				System.out.println("not deleted");
			}
			
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
	}

	private static void createdatabase() {
			
				try {
					Scanner sc=new Scanner(System.in);
					String Url="jdbc:mysql://localhost:3306/";
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection conn=DriverManager.getConnection(Url, User, Password);
					System.out.println("enter database name :");
					String sql="create database "+sc.next();
					
					PreparedStatement pmst=conn.prepareStatement(sql);
					
					int i=pmst.executeUpdate();
					if(i>0)
					{
						System.out.println("successfully created");
					}
					else {
						System.out.println("not created");
					}
				
				} catch (Exception e) {
					
					e.printStackTrace();
				}

		
	}

	private static void display() {
		System.out.println("************************");
		System.out.println("1.create database : ");
		System.out.println("2.drop database : ");
		System.out.println("3.create table : ");
		System.out.println("4.drop table : ");
		System.out.println("5.insert data : ");
		System.out.println("6.update data : ");
		System.out.println("7.delete data : ");
		System.out.println("8.getall : ");
		System.out.println("9.get by email : ");
		System.out.println("10.EXIT : ");
		System.out.println("************************");
		
	}

}
