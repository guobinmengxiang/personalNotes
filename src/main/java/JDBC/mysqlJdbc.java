package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author mysql連接jdbc進行數據庫操作
 * jdbc五步走
 * 加载驱动
 * 获取conn连接
 * 创建Statement
 * 执行sql
 * 关闭连接
 *
 */

public class mysqlJdbc {

	
	public mysqlJdbc(){
		  try {
	        	//加载驱动
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}
	  public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testjdbc?characterEncoding=UTF-8",
	                "root", "123456");
	    }
	   public static void main(String[] args) {
		   
		   selectPreparedStatement();
	    }
	   
	   /**
	 * statement 方式新增数据，因删除、更改与新增处理一致，只是sql不同，所以这里不做展示
	 */
	private static void addStatement(){
	  //try-with-resource 自动关闭连接
	  //因为Connection和Statement都实现了AutoCloseable接口
	        try (
	        		Connection c = getConnection();
	            Statement s = c.createStatement();             
	        )
	        {
	        
	        	//新增100条数据
	        	for(int i=0;i<100;i++){
	  	          //  String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";

	        		   s.execute("insert into hero values(null," + "'提莫"+i+"'"+ "," + 313.0f + "," + 50 + ")");
	        	}
	              
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	/**
	 * 查询
	 */
	private static void selectStatement(){
	  //try-with-resource 自动关闭连接
	  //因为Connection和Statement都实现了AutoCloseable接口
	        try (
	        		Connection c = getConnection();
	            Statement s = c.createStatement();             
	        )
	        {
	        
	        	 String sql = "select * from hero";
	        	 // 执行查询语句，并把结果集返回给ResultSet
	             ResultSet rs = s.executeQuery(sql);
	             // 在取第二列的数据的时候，用的是rs.get(2) ，而不是get(1). 这个是整个Java自带的api里唯二的地方，使用基1的，即2就代表第二个。
	             while (rs.next()) {
	                 int id = rs.getInt("id");// 可以使用字段名
	                 String name = rs.getString(2);// 也可以使用字段的顺序
	                 float hp = rs.getFloat("hp");
	                 int damage = rs.getInt(4);
	                 System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
	             }
	             // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
	             // rs.close();
	        	 
	              
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	private static void addPreparedStatement(){
	        String sql = "insert into hero values(null,?,?,?)";
	        try (Connection c = getConnection();
	                PreparedStatement ps = c.prepareStatement(sql);
	        		Statement s = c.createStatement();
	            ) {
	            // Statement执行10次，需要10次把SQL语句传输到数据库端
	            // 数据库要对每一次来的SQL语句进行编译处理
	            for (int i = 0; i < 10; i++) {
	                String sql0 = "insert into hero values(null," + "'提莫'" + ","
	                        + 313.0f + "," + 50 + ")";
	                s.execute(sql0);
	            }
	            s.close();
	  
	            // PreparedStatement 执行10次，只需要1次把SQL语句传输到数据库端
	            // 数据库对带?的SQL进行预编译
	  
	            // 每次执行，只需要传输参数到数据库端
	            // 1. 网络传输量比Statement更小
	            // 2. 数据库不需要再进行编译，响应更快
	            for (int i = 0; i < 10; i++) {
	                ps.setString(1, "提莫");
	                ps.setFloat(2, 313.0f);
	                ps.setInt(3, 50);
	                ps.execute();
	            }
	 
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	  
	    }
	
	private static void selectPreparedStatement(){
	  
	        String sql = "select * from hero where name = ?";
	        try (Connection c = getConnection();
	        		Statement s = c.createStatement();
	            PreparedStatement ps = c.prepareStatement(sql);
	        ) {
	            // 假设name是用户提交来的数据
	            String name = "'盖伦' OR 1=1";
	            String sql0 = "select * from hero where name = " + name;
	            // 拼接出来的SQL语句就是
	            // select * from hero where name = '盖伦' OR 1=1
	            // 因为有OR 1=1，所以恒成立
	            // 那么就会把所有的英雄都查出来，而不只是盖伦
	            // 如果Hero表里的数据是海量的，比如几百万条，把这个表里的数据全部查出来
	            // 会让数据库负载变高，CPU100%，内存消耗光，响应变得极其缓慢
	            System.out.println(sql0);
	  
	            ResultSet rs0 = s.executeQuery(sql0);
	            while (rs0.next()) {
	                String heroName = rs0.getString("name");
	                System.out.println(heroName);
	            }
	  
	            s.execute(sql0);
	  
	            // 使用预编译Statement就可以杜绝SQL注入
	  
	            ps.setString(1, name);
	  
	            ResultSet rs = ps.executeQuery();
	            // 查不出数据出来
	            while (rs.next()) {
	                String heroName = rs.getString("name");
	                System.out.println(heroName);
	            }
	 
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	  
	    }
	}
/*	
和 Statement一样，PreparedStatement也是用来执行sql语句的
与创建Statement不同的是，需要根据sql语句创建PreparedStatement
除此之外，还能够通过设置参数，指定相应的值，而不是Statement那样使用字符串拼接
PreparedStatement的优点：参数设置可读性好，PreparedStatement有预编译机制，性能比Statement更快，防止sql注入
*
*/


