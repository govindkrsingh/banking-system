import java.sql.*;
import java.util.Scanner;
public class banking {

	public static void main(String[] args) throws Exception {
	 try {
	  
	  Class.forName("com.mysql.jdbc.Driver");
	     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","govi9771");
	    
	     Statement st=conn.createStatement();
	     Statement st1=conn.createStatement();
	 
	 Scanner sc=new Scanner(System.in);
	 Scanner sc1=new Scanner(System.in);
	 
	 System.out.println("FUND TRANSFER");
	 System.out.println("MENU");
	 System.out.println("Press 1 to TRANSFER from SBI TO SBI");
	 System.out.println("Press 2 to TRANSFER from SBI TO ICICI ");
	 System.out.println("Press 3 to from ICICI TO ICICI");
	 System.out.println("Press 4 to from ICICI TO SBI");
	 System.out.println("Press 5 to CHECK YOUR BALANCE");
	 
	 int choice =sc.nextInt();
	 switch(choice){
	 
	 case 1:
	  
	   System.out.println("Please enter your name :");
	   String transferer=sc1.nextLine();
	   System.out.println("Please enter your customer ID:");
	   int transferid=sc.nextInt();
	   System.out.println("Please enter the fund you want to transfer : ");
	   float fund=sc.nextFloat();
	   System.out.println("Please enter Receiver's name :");
	   String receiver=sc1.nextLine();
	   System.out.println("Please enter Receiver's customer ID:");
	   int receiverid=sc.nextInt();
	   String sql="select * from sbi";
	   ResultSet rs=st.executeQuery(sql);
	   
	  
	   while(rs.next())
	   { 
	    

	      int tid=rs.getInt("custid");
	      String tname=rs.getString("custname");
	       float tbal=rs.getFloat("custbal");
	       
	     if(transferer.equalsIgnoreCase(tname) && transferid==tid )
	        {
	      
	      
	        if(tbal<fund)
	         System.out.println("INSUFFICENT BALANCE");
	        else
	        {
	         ResultSet rs1=st1.executeQuery(sql);
	        
	         while(rs1.next())
	         {
	          
	          int rid=rs1.getInt("custid");
	          String rname=rs1.getString("custname");
	           float rbal=rs1.getFloat("custbal");
	          
	          if(receiver.equalsIgnoreCase(rname) && receiverid==rid)
	          {
	           String query="update sbi set custbal=? where custid=?";
	           
	           rbal=rbal+fund;
	          
	           PreparedStatement ps=conn.prepareStatement(query);
	          
	           ps.setFloat(1, rbal);
	           ps.setInt(2,rid);
	           int r=ps.executeUpdate();
	           
	           tbal=tbal-fund;
	           ps=conn.prepareStatement(query);
	           ps.setFloat(1, tbal);
	           ps.setInt(2,tid);
	           int s=ps.executeUpdate();
	           
	           System.out.println((r+s)+"records updated");
	          
	          System.out.println("fund transfered \n Thank you for banking with us ");
	          
	          
	          } 
	        
	       
	         }
	        
	        }
	        
	     
	        }
	    
	   
	   }
	   
	   break;
	   
	 case 2:
	   System.out.println("Please enter your name :");
	         transferer=sc1.nextLine();
	   System.out.println("Please enter your customer ID:");
	    transferid=sc.nextInt();
	   System.out.println("Please enter the fund you want to transfer : ");
	   fund=sc.nextFloat();
	   System.out.println("Please enter Receiver's name :");
	    receiver=sc1.nextLine();
	   System.out.println("Please enter Receiver's customer ID:");
	   receiverid=sc.nextInt();
	    
	   rs=st.executeQuery("select * from sbi");
	   
	  
	   while(rs.next())
	   { 
	    

	      int tid=rs.getInt("custid");
	      String tname=rs.getString("custname");
	       float tbal=rs.getFloat("custbal");
	       
	     if(transferer.equalsIgnoreCase(tname) && transferid==tid )
	        {
	      
	      
	        if(tbal<fund)
	         System.out.println("INSUFFICENT BALANCE");
	        else
	        {
	         ResultSet rs1=st1.executeQuery("select * from icici");
	        
	         while(rs1.next())
	         {
	          
	          int rid=rs1.getInt("custid");
	          String rname=rs1.getString("custname");
	           float rbal=rs1.getFloat("custbal");
	          
	          if(receiver.equalsIgnoreCase(rname) && receiverid==rid)
	          {
	           
	           
	           rbal=rbal+fund;
	          
	           PreparedStatement ps=conn.prepareStatement("update icici set custbal=? where custid=?");
	          
	           ps.setFloat(1, rbal);
	           ps.setInt(2,rid);
	           int r=ps.executeUpdate();
	           
	           tbal=tbal-fund;
	           ps=conn.prepareStatement("update sbi set custbal=? where custid=?");
	           ps.setFloat(1, tbal);
	           ps.setInt(2,tid);
	           int s=ps.executeUpdate();
	           
	           System.out.println((r+s)+"records updated");
	          
	          System.out.println("fund transfered \n Thank you for banking with us ");
	          
	          
	          } 
	        
	       
	         }
	        
	        }
	        
	     
	        }
	    
	   
	   }
	   
	   break;
	  
	 case 3:
	 
	   System.out.println("Please enter your name :");
	        transferer=sc1.nextLine();
	   System.out.println("Please enter your customer ID:");
	    transferid=sc.nextInt();
	   System.out.println("Please enter the fund you want to transfer : ");
	   fund=sc.nextFloat();
	   System.out.println("Please enter Receiver's name :");
	    receiver=sc1.nextLine();
	   System.out.println("Please enter Receiver's customer ID:");
	   receiverid=sc.nextInt();
	   
	   rs=st.executeQuery("select * from icici");
	   
	  
	   while(rs.next())
	   { 
	    

	      int tid=rs.getInt("custid");
	      String tname=rs.getString("custname");
	       float tbal=rs.getFloat("custbal");
	       
	     if(transferer.equalsIgnoreCase(tname) && transferid==tid )
	        {
	      
	      
	        if(tbal<fund)
	         System.out.println("INSUFFICENT BALANCE");
	        else
	        {
	         ResultSet rs1=st1.executeQuery("select * from icici");
	        
	         while(rs1.next())
	         {
	          
	          int rid=rs1.getInt("custid");
	          String rname=rs1.getString("custname");
	           float rbal=rs1.getFloat("custbal");
	          
	          if(receiver.equalsIgnoreCase(rname) && receiverid==rid)
	          {
	           String query="update icici set custbal=? where custid=?";
	           
	           rbal=rbal+fund;
	          
	           PreparedStatement ps=conn.prepareStatement(query);
	          
	           ps.setFloat(1, rbal);
	           ps.setInt(2,rid);
	           int r=ps.executeUpdate();
	           
	           tbal=tbal-fund;
	           ps=conn.prepareStatement(query);
	           ps.setFloat(1, tbal);
	           ps.setInt(2,tid);
	           int s=ps.executeUpdate();
	           
	           System.out.println((r+s)+"records updated");
	          
	          System.out.println("fund transfered \n Thank you for banking with us ");
	          
	          
	          } 
	        
	       
	         }
	        
	        }
	        
	     
	        }
	    
	   
	   }
	   
	   break;
	   
	   
	  case 4:
	  
	    System.out.println("Please enter your name :");
	         transferer=sc1.nextLine();
	    System.out.println("Please enter your customer ID:");
	     transferid=sc.nextInt();
	    System.out.println("Please enter the fund you want to transfer : ");
	    fund=sc.nextFloat();
	    System.out.println("Please enter Receiver's name :");
	     receiver=sc1.nextLine();
	    System.out.println("Please enter Receiver's customer ID:");
	    receiverid=sc.nextInt();
	    
	    rs=st.executeQuery("select * from icici");
	    
	   
	    while(rs.next())
	    { 
	     

	       int tid=rs.getInt("custid");
	       String tname=rs.getString("custname");
	        float tbal=rs.getFloat("custbal");
	        
	      if(transferer.equalsIgnoreCase(tname) && transferid==tid )
	         {
	       
	       
	         if(tbal<fund)
	          System.out.println("INSUFFICENT BALANCE");
	         else
	         {
	          ResultSet rs1=st1.executeQuery("select * from sbi");
	         
	          while(rs1.next())
	          {
	           
	           int rid=rs1.getInt("custid");
	           String rname=rs1.getString("custname");
	            float rbal=rs1.getFloat("custbal");
	           
	           if(receiver.equalsIgnoreCase(rname) && receiverid==rid)
	           {
	           
	            
	            rbal=rbal+fund;
	           
	            PreparedStatement ps=conn.prepareStatement("update sbi set custbal=? where custid=?");
	           
	            ps.setFloat(1, rbal);
	            ps.setInt(2,rid);
	            int r=ps.executeUpdate();
	            
	            tbal=tbal-fund;
	            ps=conn.prepareStatement("update icici set custbal=? where custid=?");
	            ps.setFloat(1, tbal);
	            ps.setInt(2,tid);
	            int s=ps.executeUpdate();
	            
	            System.out.println((r+s)+"records updated");
	           
	           System.out.println("fund transfered \n Thank you for banking with us ");
	           
	           
	           } 
	         
	        
	          }
	         
	         }
	         
	      
	         }
	     
	    
	    }
	    
	    break;
	    
	    
	  case 5:
	   
	   System.out.println("MENU");
	   System.out.println("Press 1 if you are a customer of SBI");
	   System.out.println("Press 2 to you are a customer of ICICI ");
	   int c=sc.nextInt();
	   switch(c)
	   {
	   
	   case 1:
	     System.out.println("Please enter your name :");
	           transferer=sc1.nextLine();
	    System.out.println("Please enter your customer ID:");
	       transferid=sc.nextInt();
	       rs=st.executeQuery("select * from sbi");
	       while(rs.next())
	       {
	          int tid=rs.getInt("custid");
	        String tname=rs.getString("custname");
	         float tbal=rs.getFloat("custbal");
	         if(transferer.equalsIgnoreCase(tname) && transferid==tid )
	         {
	            System.out.println("YOU BALANCE IS :"+tbal);
	         }
	       }
	               break;
	   case 2:
	     System.out.println("Please enter your name :");
	           transferer=sc1.nextLine();
	    System.out.println("Please enter your customer ID:");
	       transferid=sc.nextInt();
	       rs=st.executeQuery("select * from icici");
	       while(rs.next())
	       {
	          int tid=rs.getInt("custid");
	        String tname=rs.getString("custname");
	         float tbal=rs.getFloat("custbal");
	         if(transferer.equalsIgnoreCase(tname) && transferid==tid )
	         {
	            System.out.println("YOU BALANCE IS :"+tbal);
	         }
	       }
	               break;
	          default :
	           System.out.println("IVALID OPTION");
	 }
	 
	   break;
	   
	  
	   default :
	          System.out.println("IVALID OPTION");
	 }
	 
	 } catch (Exception e) {
	  // TODO: handle exception
	  System.out.println("error "+e);
	 }
	}
	}

