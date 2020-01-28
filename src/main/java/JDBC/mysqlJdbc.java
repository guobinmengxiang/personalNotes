package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author mysql�B��jdbc�M�Д��������
 * jdbc�岽��
 * ��������
 * ��ȡconn����
 * ����Statement
 * ִ��sql
 * �ر�����
 *
 */

public class mysqlJdbc {

	
	public mysqlJdbc(){
		  try {
	        	//��������
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
	 * statement ��ʽ�������ݣ���ɾ������������������һ�£�ֻ��sql��ͬ���������ﲻ��չʾ
	 */
	private static void addStatement(){
	  //try-with-resource �Զ��ر�����
	  //��ΪConnection��Statement��ʵ����AutoCloseable�ӿ�
	        try (
	        		Connection c = getConnection();
	            Statement s = c.createStatement();             
	        )
	        {
	        
	        	//����100������
	        	for(int i=0;i<100;i++){
	  	          //  String sql = "insert into hero values(null," + "'��Ī'" + "," + 313.0f + "," + 50 + ")";

	        		   s.execute("insert into hero values(null," + "'��Ī"+i+"'"+ "," + 313.0f + "," + 50 + ")");
	        	}
	              
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	/**
	 * ��ѯ
	 */
	private static void selectStatement(){
	  //try-with-resource �Զ��ر�����
	  //��ΪConnection��Statement��ʵ����AutoCloseable�ӿ�
	        try (
	        		Connection c = getConnection();
	            Statement s = c.createStatement();             
	        )
	        {
	        
	        	 String sql = "select * from hero";
	        	 // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
	             ResultSet rs = s.executeQuery(sql);
	             // ��ȡ�ڶ��е����ݵ�ʱ���õ���rs.get(2) ��������get(1). ���������Java�Դ���api��Ψ���ĵط���ʹ�û�1�ģ���2�ʹ���ڶ�����
	             while (rs.next()) {
	                 int id = rs.getInt("id");// ����ʹ���ֶ���
	                 String name = rs.getString(2);// Ҳ����ʹ���ֶε�˳��
	                 float hp = rs.getFloat("hp");
	                 int damage = rs.getInt(4);
	                 System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
	             }
	             // ��һ��Ҫ������ر�ReultSet����ΪStatement�رյ�ʱ�򣬻��Զ��ر�ResultSet
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
	            // Statementִ��10�Σ���Ҫ10�ΰ�SQL��䴫�䵽���ݿ��
	            // ���ݿ�Ҫ��ÿһ������SQL�����б��봦��
	            for (int i = 0; i < 10; i++) {
	                String sql0 = "insert into hero values(null," + "'��Ī'" + ","
	                        + 313.0f + "," + 50 + ")";
	                s.execute(sql0);
	            }
	            s.close();
	  
	            // PreparedStatement ִ��10�Σ�ֻ��Ҫ1�ΰ�SQL��䴫�䵽���ݿ��
	            // ���ݿ�Դ�?��SQL����Ԥ����
	  
	            // ÿ��ִ�У�ֻ��Ҫ������������ݿ��
	            // 1. ���紫������Statement��С
	            // 2. ���ݿⲻ��Ҫ�ٽ��б��룬��Ӧ����
	            for (int i = 0; i < 10; i++) {
	                ps.setString(1, "��Ī");
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
	            // ����name���û��ύ��������
	            String name = "'����' OR 1=1";
	            String sql0 = "select * from hero where name = " + name;
	            // ƴ�ӳ�����SQL������
	            // select * from hero where name = '����' OR 1=1
	            // ��Ϊ��OR 1=1�����Ժ����
	            // ��ô�ͻ�����е�Ӣ�۶������������ֻ�Ǹ���
	            // ���Hero����������Ǻ����ģ����缸����������������������ȫ�������
	            // �������ݿ⸺�ر�ߣ�CPU100%���ڴ����Ĺ⣬��Ӧ��ü��仺��
	            System.out.println(sql0);
	  
	            ResultSet rs0 = s.executeQuery(sql0);
	            while (rs0.next()) {
	                String heroName = rs0.getString("name");
	                System.out.println(heroName);
	            }
	  
	            s.execute(sql0);
	  
	            // ʹ��Ԥ����Statement�Ϳ��Զž�SQLע��
	  
	            ps.setString(1, name);
	  
	            ResultSet rs = ps.executeQuery();
	            // �鲻�����ݳ���
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
�� Statementһ����PreparedStatementҲ������ִ��sql����
�봴��Statement��ͬ���ǣ���Ҫ����sql��䴴��PreparedStatement
����֮�⣬���ܹ�ͨ�����ò�����ָ����Ӧ��ֵ��������Statement����ʹ���ַ���ƴ��
PreparedStatement���ŵ㣺�������ÿɶ��Ժã�PreparedStatement��Ԥ������ƣ����ܱ�Statement���죬��ֹsqlע��
*
*/


