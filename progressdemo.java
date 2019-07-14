import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;
import javax.swing.table.*;
import java.util.Calendar;
import java.util.Date;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;
import org.jdatepicker.graphics.*;
import java.text.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
 
 // code for book detail
     
   class form2
    {
       JFrame jf;
       JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
       JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
       JButton jb1,jb2,jb3,jb4,jb5;
       JPanel jp; 
       ImageIcon ic;
       Dimension ds;
        form2()
      {
        jf=new JFrame();
        ic=new ImageIcon("d:/proj/pic5.jpg");
        jp=new JPanel();
        jl8=new JLabel(ic);
        jf.setTitle("BOOK INFO");
        ds=Toolkit.getDefaultToolkit().getScreenSize();
        jf.setSize(550,550);
        jf.setLayout(null);
        jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,1),"BOOK INFO"));
        jf.setDefaultCloseOperation(jf.DO_NOTHING_ON_CLOSE);
        jl1=new JLabel("ISBN NO");  
        jl2=new JLabel("BOOK NAME");
        jl3=new JLabel("SUBJECT");
        jl4=new JLabel("AUTHOUR");
        jl5=new JLabel("PUBLISHER");
        jl6=new JLabel("QUANTITY");
        jl7=new JLabel("RACK NO");
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jl1.setBounds(30,40,100,30);  
        jl2.setBounds(30,90,100,30);  
        jl3.setBounds(30,140,100,30);  
        jl4.setBounds(30,190,100,30);  
        jl5.setBounds(30,240,100,30);
        jl6.setBounds(30,290,100,30);
        jl7.setBounds(30,340,100,30);
        jl8.setBounds(0,0,550,550);
        jp.setBounds(0,0,550,550);
        jp.setBackground(Color.pink);
        jp.setBackground(Color.pink);
        jt1=new JTextField("");
        jt2=new JTextField("");
        jt3=new JTextField("");
        jt4=new JTextField("");
        jt5=new JTextField("");
        jt6=new JTextField("");
        jt7=new JTextField("");     
        jt1.setBounds(160,40,150,30);
        jt2.setBounds(160,90,150,30);
        jt3.setBounds(160,140,150,30);
        jt4.setBounds(160,190,150,30);
        jt5.setBounds(160,240,150,30);
        jt6.setBounds(160,290,150,30);
        jt7.setBounds(160,340,150,30);     
        jt1.setBackground(Color.lightGray);
        jt2.setBackground(Color.lightGray);
        jt3.setBackground(Color.lightGray);
        jt4.setBackground(Color.lightGray);
        jt5.setBackground(Color.lightGray);
        jt6.setBackground(Color.lightGray);
        jt7.setBackground(Color.lightGray);
        jl1.setForeground(Color.black);
        jl2.setForeground(Color.black);
        jl3.setForeground(Color.black);
        jl4.setForeground(Color.black);
        jl5.setForeground(Color.black);
        jl6.setForeground(Color.black);
        jl7.setForeground(Color.black);
        jt1.setForeground(Color.black);
        jt2.setForeground(Color.black);
        jt3.setForeground(Color.black);
        jt4.setForeground(Color.black);
        jt5.setForeground(Color.black);
        jt6.setForeground(Color.black);
        jt7.setForeground(Color.black);
        jb1=new JButton("ADD"); 
        jb2=new JButton("UPDATE");
        jb3=new JButton("DELETE");
        jb4=new JButton("CLEAR");
        jb5=new JButton("EXIT");
        jb1.setBackground(Color.magenta);
        jb2.setBackground(Color.magenta);
        jb3.setBackground(Color.magenta);
        jb4.setBackground(Color.magenta);
        jb5.setBackground(Color.magenta);
        jb1.setForeground(Color.black);
        jb2.setForeground(Color.black);
        jb3.setForeground(Color.black);
        jb4.setForeground(Color.black);
        jb5.setForeground(Color.black);
        jb1.setBounds(40,390,80,30);
        jb2.setBounds(210,390,80,30);
        jb3.setBounds(400,390,80,30);
        jb4.setBounds(95,440,80,30);
        jb5.setBounds(300,440,80,30);
        jf.add(jp);
        jp.add(jl8);
        jl8.add(jl1);
        jl8.add(jl2);
        jl8.add(jl3);
        jl8.add(jl4);
        jl8.add(jl5);  
        jl8.add(jl6); 
        jl8.add(jl7);
        jl8.add(jt1);
        jl8.add(jt2);
        jl8.add(jt3);
        jl8.add(jt4);
        jl8.add(jt5);
        jl8.add(jt6);
        jl8.add(jt7);
        jl8.add(jb1);
        jl8.add(jb2);
        jl8.add(jb3);
        jl8.add(jb4);
        jl8.add(jb5); 


               
       // code for fetch data in book information table by using key Activity.
    
                    jt1.addKeyListener(new KeyAdapter()
         {
                     public void keyPressed(KeyEvent ae)
                     {
                             jt2.setText("");
                             jt3.setText("");
                             jt4.setText("");
                             jt5.setText("");
                             jt6.setText("");
                             jt7.setText("");
                      }
                            public void keyReleased(KeyEvent ae)
              {
                           try
                       
                           {                                                  
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("select *from book_info where isbn_no = ? ");                            
                             pst.setString(1,jt1.getText()); 
                             ResultSet rs=pst.executeQuery();
                             String x="",y="";
                             String z="",w="";
                             String a="",b="";
                             String c="";
                              while(rs.next())  
                              {
                               
                                 z=rs.getString(1);
                                 x=rs.getString(2);
                                 y=rs.getString(3);
                                 w=rs.getString(4);
                                 a=rs.getString(5);
                                 b=rs.getString(6);
                                 c=rs.getString(7);
                                if(z.equals(jt1.getText()))
                                 {
                                                        
                                  jt2.setText(x);
                                  jt3.setText(y);
                                  jt4.setText(w);
                                 jt5.setText(a);
                                 jt6.setText(b);
                                 jt7.setText(c);
                                 }
                               } 
                          }
                        catch(Exception e)
                        {
                            System.out.println(e);
                         }   
                           
                     }
           });

        
     
     
// code for insert data in book information table by useing mouse and key Activity.

     
      jb1.addActionListener(new ActionListener()
           {
                     public void actionPerformed(ActionEvent ae)
                   
                     {
                            try
                          {
                                
                             if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt5.getText().equals("") || jt6.getText().equals("") || jt7.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert the Coloumn");
                             else
                           {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("insert into book_info values (?,?,?,?,?,?,?)");
                             pst.setString(1,jt1.getText());
                             pst.setString(2,jt2.getText());
                             pst.setString(3,jt3.getText());
                             pst.setString(4,jt4.getText());
                             pst.setString(5,jt5.getText());
                             pst.setString(6,jt6.getText());
                             pst.setString(7,jt7.getText());
                             pst.executeUpdate(); 
                            JOptionPane.showMessageDialog(jf,"Inserted Successfully");
                          }
                         }
                       catch(Exception e)
                          {
                            System.out.println(e);
                          }
                            jf.dispose();
                 new form2();   
                     }
           });     
      jb1.addKeyListener(new KeyAdapter()
           {
                     public void keyPressed(KeyEvent ae)
                         {
                             int key = ae.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
                     {
                          try
                          {
                            if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt5.getText().equals("") || jt6.getText().equals("") || jt7.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert the Coloumn");
                             else
                           {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("insert into book_info values(?,?,?,?,?,?,?)");
                             pst.setString(1,jt1.getText());
                             pst.setString(2,jt2.getText());
                             pst.setString(3,jt3.getText());
                             pst.setString(4,jt4.getText());
                             pst.setString(5,jt5.getText());
                             pst.setString(6,jt6.getText());
                             pst.setString(7,jt7.getText());
                             pst.executeUpdate(); 
                            JOptionPane.showMessageDialog(jf,"Inserted Successfully");
                          }
      			}
                       catch(Exception e)
                          {
                            System.out.println(e);
                          }   
}
                                jf.dispose();
                               new form2();
                     }
           }); 
    
//code for update table by using mouse and key activity

          jb2.addActionListener(new ActionListener()
           {
                     public void actionPerformed(ActionEvent ae)
                     {
                          try
                          {
                            if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt5.getText().equals("") || jt6.getText().equals("") || jt7.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert Particuler Field For Updation");
                             else
                           {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("update book_info set subject=?,book_name=?,authour=?,publisher=?,quantity=?,rack_no=? where isbn_no=? ");
                             pst.setString(1,jt2.getText());
                             pst.setString(2,jt3.getText());
                             pst.setString(3,jt4.getText());
                             pst.setString(4,jt5.getText());
                             pst.setString(5,jt6.getText());
                             pst.setString(6,jt7.getText());
                             pst.setString(7,jt1.getText());
                             pst.executeUpdate(); 

                            JOptionPane.showMessageDialog(jf,"Updated Successfully");
                           }
                        }
                          catch(Exception e)
                          {
                           System.out.println(e);
                          }   
                                 jf.dispose();
                               new form2();
                     }
           }); 
          jb2.addKeyListener(new KeyAdapter()
           {
                     public void keyPressed(KeyEvent ke)
                            {
                                     int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
                     {
                          try
                          {
                           if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt5.getText().equals("") || jt6.getText().equals("") || jt7.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert Particuler Field Updation");
                             else
                           {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("update book_info set subject=?,book_name=?,authour=?,publisher=?,quantity=?,rack_no=? where isbn_no=? ");
                             pst.setString(1,jt2.getText());
                             pst.setString(2,jt3.getText());
                             pst.setString(3,jt4.getText());
                             pst.setString(4,jt5.getText());
                             pst.setString(5,jt6.getText());
                             pst.setString(6,jt7.getText());
                             pst.setString(7,jt1.getText());
                             pst.executeUpdate(); 
                            JOptionPane.showMessageDialog(jf,"Updated Successfully");
                           }
			}
                          catch(Exception e)
                          {
                           System.out.println(e);
                          } 
                        }    jf.dispose();
                              new form2();  
                     }
           }); 

// code for delete data in book information table by useing mouse and key Activity.

          jb3.addActionListener(new ActionListener()
           {
                     public void actionPerformed(ActionEvent ae)
                     {
                          try
                          {
                           if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt5.getText().equals("") || jt6.getText().equals("") || jt7.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert Particuler Field for Deletetion");
                             else
                           {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("delete from book_info where isbn_no=?");
                             pst.setString(1,jt1.getText());
                             pst.executeUpdate(); 
                             JOptionPane.showMessageDialog(jf,"Deleted Successfully");
                          }
			}
                          catch(Exception e)
                           {
                            System.out.println(e);
                           }
                            jf.dispose();
                 new form2();   
                     }
           }); 

       jb3.addKeyListener(new KeyAdapter()
         {
             public void keyPressed(KeyEvent ae)
               {
                        int key = ae.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                          try
                          {
	             if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt5.getText().equals("") || jt6.getText().equals("") || jt7.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert Particuler Field for Deletetion");
                             else
                           {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("delete from book_info where isbn_no=?");
                             pst.setString(1,jt1.getText());
                             pst.executeUpdate(); 
                             JOptionPane.showMessageDialog(jf,"Deleted Successfully");
                          }
                         }
                          catch(Exception e)
                           {
                            System.out.println(e);
                           }
                      }

                          jf.dispose();
                 new form2();   
                     }
           }); 

     // code for clear button in book detail by using mouse and key Listener
   
       jb4.addActionListener(new ActionListener ()
         {
             public void actionPerformed(ActionEvent ae)
               {
                   jt1.setText("");
                  jt2.setText("");
                  jt3.setText("");
                  jt4.setText("");
                  jt5.setText(""); 
                  jt6.setText("");
                  jt7.setText("");   
               }
         }); 
     jb4.addKeyListener(new KeyAdapter()
         {
             public void keyPressed(KeyEvent ae)
         {  
                  int key = ae.getKeyCode();
                    if(key ==KeyEvent.VK_ENTER)
               {
                  jt1.setText(""); 
                  jt2.setText("");
                  jt3.setText("");
                  jt4.setText("");
                  jt5.setText("");
                  jt6.setText(""); 
                  jt7.setText("");     
               }
           }
         });

  // code for exit button in book detail by using mouse and key Listener
   
         jb5.addActionListener(new ActionListener ()
         {
             public void actionPerformed(ActionEvent ae)
               {
                 jf.dispose();
                 new form();
               }
         });
         jb5.addKeyListener(new KeyAdapter()
         {
            public void keyPressed(KeyEvent ke)
     {
                 int key = ke.getKeyCode();
                   if(key ==KeyEvent.VK_ENTER)
              {
                   jf.dispose();
                   new form();
              }
}
         });
 
//code for to exit the window by using exit button .

       jf.addWindowListener(new WindowAdapter()
          {
             public void windowClosing(WindowEvent we)
             {
                 JOptionPane.showMessageDialog(jf,"SORRY , PLEASE PRESS ON EXIT BUTTON TO CLOSE THE FORM");
             }
          });
         jf.setVisible(true);
      }
    }

// code for members detail
     
   class form3
    {
       JFrame jf;
       JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
       JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
       JButton jb1,jb2,jb3,jb4,jb5;
       JComboBox jcb,jcb1;
       ImageIcon ic;
       JPanel jp;
        form3()
      {
        jf=new JFrame();
        ic=new ImageIcon("d:/proj/pic5.jpg");
        jp=new JPanel();
        jl8=new JLabel(ic);
        jcb=new JComboBox();
        jcb1=new JComboBox();
        jf.setTitle("MEMBER INFORMATION");
        jf.setSize(550,550);
        jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,1),"MEMBER INFO"));
        jf.setDefaultCloseOperation(jf.DO_NOTHING_ON_CLOSE);
        jf.setLayout(null);
        jl1=new JLabel("MEMBER ID");  
        jl2=new JLabel("MEMBER NAME");
        jl3=new JLabel("FATHER NAME");
        jl4=new JLabel("COURSE");
        jl5=new JLabel("MEMBER TYPE");
        jl6=new JLabel("GENDER");
        jl7=new JLabel("PHONE NO");
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);    
        jl1.setBounds(30,40,100,30);  
        jl2.setBounds(30,90,100,30);
        jl3.setBounds(30,140,100,30);   
        jl4.setBounds(30,190,100,30);  
        jl5.setBounds(30,240,100,30);  
        jl6.setBounds(30,290,100,30);
        jl7.setBounds(30,340,100,30);
        jl8.setBounds(0,0,550,550);
        jp.setBounds(0,0,550,550);
        jp.setBackground(Color.pink);
        jt1=new JTextField("");
        jt2=new JTextField("");
        jt3=new JTextField("");
        jt4=new JTextField("");
        jcb.addItem("Select");
        jcb.addItem("Student");  
        jcb.addItem("Faculty");
        jcb1.addItem("Select");
        jcb1.addItem("Male");  
        jcb1.addItem("Female");
        jt7=new JTextField("");  
        jt1.setBounds(160,40,150,30);
        jt2.setBounds(160,90,150,30);
        jt3.setBounds(160,140,150,30);
        jt4.setBounds(160,190,150,30);
        jcb.setBounds(160,240,150,30);
        jcb1.setBounds(160,290,150,30);
        jt7.setBounds(160,340,150,30);
        jb1=new JButton("ADD"); 
        jb2=new JButton("UPDATE");
        jb3=new JButton("DELETE");
        jb4=new JButton("CLEAR");
        jb5=new JButton("EXIT");
        jb1.setBounds(40,390,80,30);
        jb2.setBounds(210,390,80,30);
        jb3.setBounds(400,390,80,30);
        jb4.setBounds(95,440,80,30);
        jb5.setBounds(300,440,80,30);
         jf.add(jp);
        jp.add(jl8);  
        jl8.add(jl1);
        jl8.add(jl2);
        jl8.add(jl3);
        jl8.add(jl4);
        jl8.add(jl5);
        jl8.add(jl6);
        jl8.add(jl7);
        jl8.add(jt1);
        jl8.add(jt2);
        jl8.add(jt3);
        jl8.add(jt4);
        jl8.add(jcb);
        jl8.add(jcb1);
        jl8.add(jt7);
        jl8.add(jb1);
        jl8.add(jb2);
        jl8.add(jb3);
        jl8.add(jb4);
        jl8.add(jb5);                 
        jt1.setBackground(Color.lightGray);
        jt2.setBackground(Color.lightGray);
        jt3.setBackground(Color.lightGray);
        jt4.setBackground(Color.lightGray);
        jcb.setBackground(Color.lightGray);
        jcb1.setBackground(Color.lightGray);
        jt7.setBackground(Color.lightGray);
        jl1.setForeground(Color.black);
        jl2.setForeground(Color.black);
        jl3.setForeground(Color.black);
        jl4.setForeground(Color.black);
        jl5.setForeground(Color.black);
        jl6.setForeground(Color.black);
        jl7.setForeground(Color.black);
        jt1.setForeground(Color.black);
        jt2.setForeground(Color.black);
        jt3.setForeground(Color.black);
        jt4.setForeground(Color.black);
        jcb.setForeground(Color.black);
        jcb1.setForeground(Color.black); 
        jt7.setForeground(Color.black);
        jb1.setBackground(Color.magenta);
        jb2.setBackground(Color.magenta);
        jb3.setBackground(Color.magenta);
        jb4.setBackground(Color.magenta);
        jb5.setBackground(Color.magenta);
        jb1.setForeground(Color.black);
        jb2.setForeground(Color.black);
        jb3.setForeground(Color.black);
        jb4.setForeground(Color.black);
        jb5.setForeground(Color.black);
               
      // code for fetch  data in member information table by useing mouse and key Activity.
              
                jt1.addKeyListener(new KeyAdapter()
         {
                     public void keyPressed(KeyEvent ae)
                 
                     {       
            
                             jt2.setText("");
                             jt3.setText("");
                             jt4.setText("");
                             jcb.setSelectedItem("Select");
                             jcb1.setSelectedItem("Select");
                             jt7.setText("");

                      }
                     public void keyReleased(KeyEvent ae)
           
                   {
                           try
                           {                                                  
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("select *from member_info where member_id = ? ");                            
                             pst.setString(1,jt1.getText()); 
                             ResultSet rs=pst.executeQuery();
                             String x="",y="";
                             String z="",w="";
                             String a="",b="";
                             String c="";
                              while(rs.next())  
                              {
                               
                                 z=rs.getString(1);
                                 x=rs.getString(2);
                                 y=rs.getString(3);
                                 w=rs.getString(4);
                                 a=rs.getString(5);
                                 b=rs.getString(6);
                                 c=rs.getString(7);                           
                                 jt2.setText(x);
                                 jt3.setText(y);
                                 jt4.setText(w);
                                 jcb.setSelectedItem(a);
                                 jcb1.setSelectedItem(b);
                                 jt7.setText(c);
                               } 
                          }
                        catch(Exception e)
                        {
                            System.out.println(e);
                         }   
       
                     }
           });
 

// code for insert data in member information table by useing mouse and key Activity.

     
      jb1.addActionListener(new ActionListener()
           {
                     public void actionPerformed(ActionEvent ae)
                   
                     {
                          try
                          {
                             if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt7.getText().equals("") ) 
                               JOptionPane.showMessageDialog(jf,"Please insert the Member Data");
                             else
                           {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("insert into member_info values(?,?,?,?,?,?,?)");
                             pst.setString(1,jt1.getText());
                             pst.setString(2,jt2.getText());
                             pst.setString(3,jt3.getText());
                             pst.setString(4,jt4.getText());
                             pst.setString(5,jcb.getSelectedItem().toString());
                             pst.setString(6,jcb1.getSelectedItem().toString());
                             pst.setString(7,jt7.getText());
                             pst.executeUpdate(); 
                            JOptionPane.showMessageDialog(jf,"Inserted Successfully");      
                          }
                         }
                       catch(Exception e)
                          {
                            System.out.println(e);
                          }
                     
                           jf.dispose();
                           new form3();   
                     }
           }); 
                     jb1.addKeyListener(new KeyAdapter()
           {
                     public void keyPressed(KeyEvent ae)
                   {
                              int key = ae.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
                     {
                          try
                          {
	             if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt7.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert The Member Data");
                             else
                           {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("insert into member_info values(?,?,?,?,?,?,?)");
                             pst.setString(1,jt1.getText());
                             pst.setString(2,jt2.getText());
                             pst.setString(3,jt3.getText());
                             pst.setString(4,jt4.getText());
                             pst.setString(5,jcb.getSelectedItem().toString());
                             pst.setString(6,jcb1.getSelectedItem().toString());
                             pst.setString(7,jt7.getText());
                             pst.executeUpdate(); 
                            JOptionPane.showMessageDialog(jf,"Inserted Successfully");
                         }  
			}
                       catch(Exception e)
                          {
                            System.out.println(e);
                          } 
}
                            jf.dispose();
                            new form3();  
                     }
           }); 
    

//code for update table by using mouse and key activity

          jb2.addActionListener(new ActionListener()
           {
                     public void actionPerformed(ActionEvent ae)
                     {
                          try
                          {
	                if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") ||  jt7.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert Particuler Field For Updation");
                             else
                           {
                               Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("update member_info set member_name=?,father_name=?,course=?,member_type=?,gender=?,phone_no=? where member_id=? ");
                             pst.setString(1,jt2.getText());
                             pst.setString(2,jt3.getText());
                             pst.setString(3,jt4.getText());
                             pst.setString(4,jcb.getSelectedItem().toString());
                             pst.setString(5,jcb1.getSelectedItem().toString());
                             pst.setString(6,jt7.getText());
                             pst.setString(7,jt1.getText());
                             pst.executeUpdate(); 
                            JOptionPane.showMessageDialog(jf,"Updated Successfully");
                          }  
			 }
                          catch(Exception e)
                          {
                           System.out.println(e);
                          } 
                         jf.dispose();
                         new form3();  
                     }
           }); 

          jb2.addKeyListener(new KeyAdapter()
           {
                     public void keyPressed(KeyEvent ke)
                {
                        int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
                     {    
                      try
                          {
	           if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") ||  jt7.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert Particuler Field for Updation");
                             else
                           {  
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("update member_info set member_name=?,father_name=?,course=?,member_type=?,gender=?,phone_no=? where member_id=? ");
                             pst.setString(1,jt2.getText());
                             pst.setString(2,jt3.getText());
                             pst.setString(3,jt4.getText());
                             pst.setString(4,jcb.getSelectedItem().toString());
                             pst.setString(5,jcb1.getSelectedItem().toString());
                             pst.setString(6,jt7.getText());
                             pst.setString(7,jt1.getText());
                             pst.executeUpdate(); 
                            JOptionPane.showMessageDialog(jf,"Updated Successfully");
                           }
			}
                          catch(Exception e)
                          {
                           System.out.println(e);
                          }  
} 
                               jf.dispose();
                               new form3();
                     }
           }); 


// code for delete data in member information table by useing mouse and key Activity.

          jb3.addActionListener(new ActionListener()
           {
                     public void actionPerformed(ActionEvent ae)
                     {
                         try
                          {
	         if(jt1.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert Particuler Field for Deletetion");
                             else
                           {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("delete from member_info where member_id=?");
                             pst.setString(1,jt1.getText());
                             pst.executeUpdate(); 
                             JOptionPane.showMessageDialog(jf,"Deleted Successfully");
                          }
			}
                          catch(Exception e)
                           {
                            System.out.println(e);
                           }   
                             jf.dispose();
                               new form3();
                     }
           }); 

       jb3.addKeyListener(new KeyAdapter()
         {
             public void keyPressed(KeyEvent ae)
            {
                        int key = ae.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                          try
                         {     if(jt1.getText().equals("") ) 
                                   JOptionPane.showMessageDialog(jf,"Please insert Particuler Field for Deletetion");
                             else
                           {
                           Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("delete from member_info where member_id=?");
                             pst.setString(1,jt1.getText());
                             pst.executeUpdate(); 
                             JOptionPane.showMessageDialog(jf,"Deleted Successfully");
                          }
			}
                          catch(Exception e)
                           {
                            System.out.println(e);
                           } 
}
                              jf.dispose();
                               new form3();  
                     }
           }); 


      
     // code for clear button in book detail by using mouse and key Listener
  
   jb4.addActionListener(new ActionListener ()
         {
             public void actionPerformed(ActionEvent ae)
               {
                  jt1.setText(""); 
                  jt2.setText("");
                  jt3.setText("");
                  jt4.setText("");
                 jcb.setSelectedItem("Select");
                  jcb1.setSelectedItem("Select");
                  jt7.setText("");    
               }
         });
     jb4.addKeyListener(new KeyAdapter()
         {
             public void keyPressed(KeyEvent ae)
{
                   int key = ae.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                  jt1.setText(""); 
                  jt2.setText("");
                  jt3.setText("");
                  jt4.setText("");
                  jcb.setSelectedItem("Select");
                  jcb1.setSelectedItem("Select");
                  jt7.setText(""); 

               }
               }
         });

  // code for exit button in book detail by using mouse and key Listener
   
         jb5.addActionListener(new ActionListener ()
         {
             public void actionPerformed(ActionEvent ae)
               {
                 jf.dispose();
                 new form();
               }
         });
         jb5.addKeyListener(new KeyAdapter()
         {
            public void keyPressed(KeyEvent ke)
         {
                     int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
              {
                   jf.dispose();
                   new form();
              }
}
         });

    //code for to exit the window by using exit button .

       jf.addWindowListener(new WindowAdapter()
          {
             public void windowClosing(WindowEvent we)
             {
                 JOptionPane.showMessageDialog(jf,"SORRY , PLEASE PRESS ON EXIT BUTTON TO CLOSE THE FORM");
             }
          });
        jf.add(jp);
        jp.add(jl8);
    jf.setVisible(true);
      }
    }

   // code for book issue detail
 class form4
    {
       JFrame jf;
       JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
       JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt9;
       JButton jb1,jb2,jb3,jb4,jb5;
       ImageIcon ic;
       JPanel jp; 
      form4()
      {
        jf=new JFrame();
        ic=new ImageIcon("d:/proj/pic5.jpg");
        jp=new JPanel();
        jl10=new JLabel(ic);
        jf.setTitle("BOOK ISSUE DETAIL");
        jf.setSize(600,600);
        
       Properties p = new Properties(); 
        p.put("text.today", "Today"); 
        p.put("text.month", "Month"); 
        p.put("text.year", "Year");  
        jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,1),"BOOK ISSUE/RETURN"));
        jf.setDefaultCloseOperation(jf.DO_NOTHING_ON_CLOSE);
        jf.setLayout(null);
        UtilDateModel model = new UtilDateModel();
        model.setDate(2017,04,20);
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        datePicker.setBounds(30,390,130,30);
        jl1=new JLabel("MEMBER ID");  
        jl2=new JLabel("MEMBER NAME");
        jl3=new JLabel("FATHER NAME");
        jl4=new JLabel("ISBN NO");
        jl5=new JLabel("BOOK NAME");
        jl6=new JLabel("SUBJECT");
        jl7=new JLabel("BOOK NO");
        jl8=new JLabel("ISSUE DATE");
        jl9=new JLabel(" PHONE NO.");
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);    
        jl1.setBounds(30,40,100,30);  
        jl2.setBounds(30,90,100,30);  
        jl3.setBounds(30,140,100,30);  
        jl4.setBounds(30,190,100,30);  
        jl5.setBounds(30,240,100,30);
        jl6.setBounds(30,290,100,30);
        jl7.setBounds(30,340,100,30);
        jl8.setBounds(30,390,130,30);
        jl9.setBounds(30,440,130,30);
        jl10.setBounds(0,0,600,600);
        jp.setBounds(0,0,600,600);
        jp.setBackground(Color.pink);
        jt1=new JTextField("");
        jt2=new JTextField("");
        jt3=new JTextField("");
        jt4=new JTextField("");
        jt5=new JTextField("");
        jt6=new JTextField("");
        jt7=new JTextField("");
  //      jt8=new JTextField("");
        jt9=new JTextField("");
        jt2.setEnabled(false);
        jt3.setEnabled(false);
        jt5.setEnabled(false);
        jt6.setEnabled(false);
        jt9.setEnabled(false);
        jt2.setDisabledTextColor(Color.black);
        jt3.setDisabledTextColor(Color.black);
        jt5.setDisabledTextColor(Color.black);
        jt6.setDisabledTextColor(Color.black);
        jt9.setDisabledTextColor(Color.black);
        jt1.setBounds(160,40,150,30);
        jt2.setBounds(160,90,150,30);
        jt3.setBounds(160,140,150,30);
        jt4.setBounds(160,190,150,30);
        jt5.setBounds(160,240,150,30);
        jt6.setBounds(160,290,150,30);
        jt7.setBounds(160,340,150,30);
        datePicker.setBounds(160,390,150,30);
        jt9.setBounds(160,440,150,30);
        jl10.setBounds(0,0,600,600);
        jp.setBounds(0,0,600,600);
        jp.setBackground(Color.pink);  
        jb1=new JButton("ISSUE"); 
        jb2=new JButton("RETURN");
        jb3=new JButton("CLEAR");
        jb4=new JButton("EXIT");
          if(form.setval==true) 
      {
            jb1.setVisible(false);  
           jl8.setVisible(false);    
           datePicker.setVisible(false);
          jl9.setBounds(30,390,130,30);                                                                                        
          jt9.setBounds(160,390,150,30);
       }
       else
      {
           jb2.setVisible(false);
           jl8.setVisible(true);    
           datePicker.setVisible(true);
          jl9.setBounds(30,440,130,30);                                                                                        
          jt9.setBounds(160,440,150,30);
      
       }
        jb1.setBounds(40,500,80,30);
        jb2.setBounds(40,500,80,30);
        jb3.setBounds(210,500,80,30);
        jb4.setBounds(400,500,80,30);
        jl10.add(jl1);
        jl10.add(jl2);
        jl10.add(jl3);
        jl10.add(jl4);
        jl10.add(jl5);   
        jl10.add(jl6);
        jl10.add(jl7);
        jl10.add(jl8);
        jl10.add(jl9);
        jl10.add(jt1);
        jl10.add(jt2);
        jl10.add(jt3);
        jl10.add(jt4);
        jl10.add(jt5);
        jl10.add(jt6);
        jl10.add(jt7);
        jl10.add(datePicker);
        jl10.add(jt9);
        jl10.add(jb1);
        jl10.add(jb2);
        jl10.add(jb3);
        jl10.add(jb4);
        jf.add(jp); 
        jp.add(jl10);
        jt1.setBackground(Color.lightGray);
        jt2.setBackground(Color.lightGray);
        jt3.setBackground(Color.lightGray);
        jt4.setBackground(Color.lightGray);
        jt5.setBackground(Color.lightGray);
        jt6.setBackground(Color.lightGray);
        jt7.setBackground(Color.lightGray);
       datePicker.setBackground(Color.lightGray);
        jt9.setBackground(Color.lightGray);
        jl1.setForeground(Color.black);
        jl2.setForeground(Color.black);
        jl3.setForeground(Color.black);
        jl4.setForeground(Color.black);
        jl5.setForeground(Color.black);
        jl6.setForeground(Color.black);
        jl7.setForeground(Color.black);
        jl8.setForeground(Color.black);
        jl9.setForeground(Color.black); 
        jt1.setForeground(Color.black);
        jt2.setForeground(Color.black);
        jt3.setForeground(Color.black);
        jt4.setForeground(Color.black);
        jt5.setForeground(Color.black);
        jt6.setForeground(Color.black);
        jt7.setForeground(Color.black);
       datePicker.setForeground(Color.black);
        jt9.setForeground(Color.black);
        jb1.setBackground(Color.magenta);
        jb2.setBackground(Color.magenta);
        jb3.setBackground(Color.magenta);
        jb4.setBackground(Color.magenta);
        jb1.setForeground(Color.black);
        jb2.setForeground(Color.black);
        jb3.setForeground(Color.black);
        jb4.setForeground(Color.black);

        // code for fetch data in book_issue table by using mouse and key Activity.
 
        jt4.addKeyListener(new KeyAdapter()
         {
                     public void keyPressed(KeyEvent ae)
                     {
                            jt5.setText("");
                            jt6.setText("");
                                              
                      }
                            public void keyReleased(KeyEvent ae)
              {
                           try
                           {                                                  
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("select *from book_info where isbn_no = ? ");                            
                             pst.setString(1,jt4.getText()); 
                             ResultSet rs=pst.executeQuery();
                             String x="",y="",z="";
                            
                              while(rs.next())  
                              {
                               
                                 x=rs.getString(1);
                                 y=rs.getString(2);
                                 z=rs.getString(3);
                                 
                                if(x.equals(jt4.getText()))
                                 {
                                                        
                                 jt5.setText(y);
                                 jt6.setText(z);
                               
                                 }
                               } 
                          }
                        catch(Exception e)
                        {
                            System.out.println(e);
                         }   
       
                     }
           });       
  
  
                      jt1.addKeyListener(new KeyAdapter()
                    {
                     public void keyPressed(KeyEvent ae)
                     {
                             jt2.setText("");
                             jt3.setText("");
                             jt9.setText("");
                         }   
                            public void keyReleased(KeyEvent ae)
                           
                         {
                           try
                           {                                                  
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("select *from member_info where member_id = ? ");                            
                             pst.setString(1,jt1.getText()); 
                             ResultSet rs=pst.executeQuery();
                             String x="",y="";
                             String z="",w="";
                             
                              while(rs.next())  
                              {
                               
                                 z=rs.getString(1);
                                 x=rs.getString(2);
                                 y=rs.getString(3);
                                 w=rs.getString(7);
                               
                                if(z.equals(jt1.getText()))
                                 {
                                                        
                                 jt2.setText(x);
                                 jt3.setText(y);
                                 jt9.setText(w);
                                

                                 }
                               } 
                          }
                        catch(Exception e)
                        {
                            System.out.println(e);
                         }   
       
                     }
           });
     
        jb1.addActionListener(new ActionListener()
           {
                     public void actionPerformed(ActionEvent ae)
                     {
                          try
                          {
                             
                             if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt5.getText().equals("") || jt6.getText().equals("") || jt7.getText().equals("") || jt9.getText().equals("")) 
                                   JOptionPane.showMessageDialog(jf,"Please insert value");
                             else
                              {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("insert into book_issue values(?,?,?,?,?,?,?,?,?)");
                             pst.setString(1,jt1.getText());
                             pst.setString(2,jt2.getText());
                             pst.setString(3,jt3.getText());
                             pst.setString(4,jt4.getText());
                             pst.setString(5,jt5.getText());
                             pst.setString(6,jt6.getText());
                             pst.setString(7,jt7.getText());
                            Date d=(Date)datePicker.getModel().getValue();
                            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                           String reportDate= df.format(d);
                           System.out.println(reportDate);   
                             pst.setString(8,reportDate);
                             pst.setString(9,jt9.getText());
                             pst.executeUpdate(); 
                            JOptionPane.showMessageDialog(jf,"Issued Successfully");
                            pst=cn.prepareStatement("select *from book_info where book_name=?"); 
                            pst.setString(1,jt5.getText());
                            ResultSet rs=pst.executeQuery();
                             int x=0;
                            while(rs.next())
                            { 
                               //    System.out.println();
                                    x=rs.getInt("quantity");
                            } 
                             x=x-1;
                             pst=cn.prepareStatement("update book_info set quantity=? where book_name=?");
                             pst.setString(1,x+"");
                             pst.setString(2,jt5.getText());
                             pst.executeUpdate(); 
                          }
                     }  catch(Exception e)
                          {
                            System.out.println(e);
                          }
                            jf.dispose();
                            new form4();   
                     }
           }); 
      jb1.addKeyListener(new KeyAdapter()
           {
                     public void keyPressed(KeyEvent ae)
               {
                             int key = ae.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
                     {
                          try
                          {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("insert into book_issue values(?,?,?,?,?,?,?,?,?)");
                             pst.setString(1,jt1.getText());
                             pst.setString(2,jt2.getText());
                             pst.setString(3,jt3.getText());
                             pst.setString(4,jt4.getText());
                             pst.setString(5,jt5.getText());  
                             pst.setString(6,jt6.getText());
                             pst.setString(7,jt7.getText());
                             Date d=(Date)datePicker.getModel().getValue();   
                           System.out.println(d);
                           DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                           String reportDate= df.format(d);
                          System.out.println(reportDate); 
                             pst.setString(8,reportDate);  
                             pst.setString(9,jt9.getText());
                             pst.executeUpdate(); 
                            JOptionPane.showMessageDialog(jf,"Issued Successfully");
                              jt1.setText("");   

                          }
                       catch(Exception e)
                          {
                            System.out.println("Problem"+e);
                          }
} 
                             jf.dispose();
                               new form4();  
                     }
           }); 
    
// code for delete data in book issue table by useing mouse and key Activity.

          jb2.addActionListener(new ActionListener()
           {
                     public void actionPerformed(ActionEvent ae)
                     {
                          try
                           {
                             
                             if(jt1.getText().equals("") || jt2.getText().equals("") || jt3.getText().equals("") || jt4.getText().equals("") || jt5.getText().equals("") || jt6.getText().equals("") ||  jt7.getText().equals("") ||  jt9.getText().equals("")) 
                                   JOptionPane.showMessageDialog(jf,"Please insert value");
                             else
                          {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("delete from book_issue where book_no=?");
                             pst.setString(1,jt7.getText());
                             pst.executeUpdate(); 
                             JOptionPane.showMessageDialog(jf,"Return Successfully");
                            pst=cn.prepareStatement("select *from book_info where book_name=?"); 
                            pst.setString(1,jt5.getText());
                            ResultSet rs=pst.executeQuery();
                             int x=0;
                            while(rs.next())
                            { 
                              
                                    x=rs.getInt("quantity");
                            } 
                             x=x+1;
                             pst=cn.prepareStatement("update book_info set quantity=? where book_name=?");
                             pst.setString(1,x+"");
                             pst.setString(2,jt5.getText());
                             pst.executeUpdate(); 
                       
                          }
                       }   catch(Exception e)
                           {
                            System.out.println(e);
                           } 
                             jf.dispose();
                               new form4();  
                     }
           }); 

       jb2.addKeyListener(new KeyAdapter()
         {
             public void keyPressed(KeyEvent ae)
           {
                             int key = ae.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                          try
                          {
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash") ;
                             PreparedStatement pst=cn.prepareStatement("delete from book_issue where book_no=?");
                             pst.setString(1,jt7.getText());
                             pst.executeUpdate(); 
                             JOptionPane.showMessageDialog(jf,"Return Successfully");
                          }
                          catch(Exception e)
                           {
                            System.out.println(e);
                           }
}
                              jf.dispose();
                               new form4();   
                     }
           }); 
   
   // code for clear button in book detail by using mouse and key Listener
  
   jb3.addActionListener(new ActionListener ()
         {
             public void actionPerformed(ActionEvent ae)
               {
                  jt1.setText(""); 
                  jt2.setText("");
                  jt3.setText("");
                  jt4.setText("");
                  jt5.setText("");  
                  jt6.setText("");
                  jt7.setText("");
               //   datePicker.setModel("2017,04,20");
                // datePicker.setValue("0000,00,00");       
               }
         });
     jb3.addKeyListener(new KeyAdapter()
         {
             public void keyPressed(KeyEvent ae)
       {
                             int key = ae.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                  jt1.setText(""); 
                  jt2.setText("");
                  jt3.setText("");
                  jt4.setText("");
                  jt5.setText("");
                  jt6.setText("");
                  jt7.setText("");
               //    datePicker.setModel().setValue(""); 
         //  model.setDate("0000,00,00");
               }
}
         });
  // code for exit button in fine detail by using mouse and key Listener
   
         jb4.addActionListener(new ActionListener ()
         {
             public void actionPerformed(ActionEvent ae)
               {
                 jf.dispose();
                 new form();
               }
         });
         jb4.addKeyListener(new KeyAdapter()
         {
            public void keyPressed(KeyEvent ke)
           {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
              {
                   jf.dispose();
                   new form();
              }
}
         });
  //code for to exit the window by using exit button .

       jf.addWindowListener(new WindowAdapter()
          {
             public void windowClosing(WindowEvent we)
             {
                 JOptionPane.showMessageDialog(jf,"SORRY , PLEASE PRESS ON EXIT BUTTON TO CLOSE THE FORM");
             }
          });
       jf.setVisible(true);
       form.setval=false;
 } 
   }
        class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
        return "";
    }
}

//code for project report 

class form5
{
     JFrame jf; 
     JButton jb,jb1,jb2,jb3,jb4;
     JTable jtb;
     JLabel jl1;
     JScrollPane jsp;
     JPanel jp;
     ImageIcon ic;
     JComboBox jcb;
     form5()
     {
         jf=new JFrame ();
         jcb=new JComboBox();
         ic=new ImageIcon("d:/proj/a1.jpg");
         jl1=new JLabel(ic);
         jp=new JPanel();
           jcb.addItem("SELECT");
         jcb.addItem("Student");
         jcb.addItem("Faculty");
         String [ ][ ] data={};
         String cols[]={};  
         jf.setLayout(null);
         jf.setSize(900,750); 
         jf.setTitle("PROJECT REPORT");
         jf.setResizable(false);
         jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,1),"PROJECT REPORT"));
         jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
         jf.setDefaultCloseOperation(jf.DO_NOTHING_ON_CLOSE);
         jf.setLocationRelativeTo(null); 
         jtb=new JTable(data,cols);
         jsp=new JScrollPane(jtb); 
         jsp.setBounds(20,20,850,600); 
         jp.setBounds(0,0,900,750);
         jp.setBackground(Color.pink);        
         JTableHeader jth=jtb.getTableHeader();
         Font f=new Font("Arial",Font.BOLD,14);
         jth.setForeground(Color.white);
         jth.setBackground(Color.black);
         jtb.setBackground(Color.cyan);
         jth.setFont(f);
         jf.add(jsp);   
         jb=new JButton("BOOK INFO");
      //   jb1=new JButton("MEMBER INFO");
         jb2=new JButton("BOOK ISSUE");
         jb3=new JButton("CLEAR");
         jb4=new JButton("EXIT");
         jb.setBounds(150,645,120,25);
         jcb.setBounds(415,635,170,30);
         jb2.setBounds(715,645,120,25);
         jb3.setBounds(310,680,80,25);
         jb4.setBounds(605,680,80,25);
         jb.setBackground(Color.magenta);
         jcb.setBackground(Color.magenta);
         jb2.setBackground(Color.magenta);
         jb3.setBackground(Color.magenta);
         jb4.setBackground(Color.magenta);   
         jf.add(jb);
         jf.add(jcb);
         jf.add(jb2);
         jf.add(jb3);
         jf.add(jb4);
         jf.add(jp); 
         jp.add(jl1);      
    
//code for view book info by using mouse and key activity. 
     
         jb.addActionListener(new ActionListener()
         {
              public void actionPerformed(ActionEvent ae)
             {
               try
               {
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash");
                 PreparedStatement pst=con.prepareStatement("select * from book_info");
                 ResultSet rs=pst.executeQuery();
                 jtb.setModel(DbUtils.resultSetToTableModel(rs));                
               }
               catch(Exception e)
              {
                System.out.println(e);
              } 
         }
           });
                    jb.addKeyListener(new KeyAdapter()
         {
              public void keyPressed(KeyEvent ke)
               {
                             int key = ke.getKeyCode();
                             if(key ==KeyEvent.VK_ENTER)
             {
                try
                   {
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash");
                 PreparedStatement pst=con.prepareStatement("select * from book_info");
                 ResultSet rs=pst.executeQuery();
                 jtb.setModel(DbUtils.resultSetToTableModel(rs));                
               }
               catch(Exception e)
              {
                System.out.println(e);
              } 
}
         }
           });

//code for view member datail by usnig mouse and key activity

   jcb.addActionListener(new ActionListener()
         {
              public void actionPerformed(ActionEvent ae)
             {
               try
               {
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash");
                 PreparedStatement pst=con.prepareStatement("select * from member_info where member_type=?");
                 pst.setString(1,jcb.getSelectedItem().toString()); 
                 ResultSet rs=pst.executeQuery();
                 jtb.setModel(DbUtils.resultSetToTableModel(rs));                
               }
               catch(Exception e)
               {  
                 System.out.println(e);
               } 
         }
           });
   jcb.addKeyListener(new KeyAdapter()
         {
              public void keyPressed(KeyEvent ke)
               {
                             int key = ke.getKeyCode();
                             if(key ==KeyEvent.VK_ENTER)
             {
               try
               {
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash");
                 PreparedStatement pst=con.prepareStatement("select * from member_info where member_type=?");
                 pst.setString(1,jcb.getSelectedItem().toString()); 
                 ResultSet rs=pst.executeQuery();
                 jtb.setModel(DbUtils.resultSetToTableModel(rs));                
               }
               catch(Exception e)
               {  
                 System.out.println(e);
               } 
}
         }
           });

//code for view book isse detail by using mouse and key activity

            jb2.addActionListener(new ActionListener()
         {
              public void actionPerformed(ActionEvent ae)
             {
               try
               {
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash");
                 PreparedStatement pst=con.prepareStatement("select * from book_issue");
                 ResultSet rs=pst.executeQuery();
                 jtb.setModel(DbUtils.resultSetToTableModel(rs));                
               }
              catch(Exception e)
              {
               System.out.println(e);
              } 
         }
           });
            jb2.addKeyListener(new KeyAdapter()
         {
              public void keyPressed(KeyEvent ke)
             {
                             int key = ke.getKeyCode();
                             if(key ==KeyEvent.VK_ENTER)
             {
               try
               {
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash");
                 PreparedStatement pst=con.prepareStatement("select * from book_issue");
                 ResultSet rs=pst.executeQuery();
                 jtb.setModel(DbUtils.resultSetToTableModel(rs));                
               }
              catch(Exception e)
              {
               System.out.println(e);
              }
} 
         }
           });

//code for exit button by using mouse and key activity 

          jb4.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent ae)
               {
                  jf.dispose(); 
               	  new form();
               }
          });
          jb4.addKeyListener(new KeyAdapter()
          {
            public void keyPressed(KeyEvent ke)
              {
                             int key = ke.getKeyCode();
                             if(key ==KeyEvent.VK_ENTER)
               {
                  jf.dispose(); 
  	          new form();
               }
}
          });
                  jb3.addActionListener(new ActionListener ()
         {
             public void actionPerformed(ActionEvent ae)
               {
                  new form5();
                  jf.dispose();
               }
         });
              jb3.addKeyListener(new KeyAdapter()
          {
            public void keyPressed(KeyEvent ke)
              {
                             int key = ke.getKeyCode();
                             if(key ==KeyEvent.VK_ENTER)
               {
                  new form5();
                    jf.dispose(); 
               }
}
          });

//code for to exit the window by using exit button .

       jf.addWindowListener(new WindowAdapter()
          {
             public void windowClosing(WindowEvent we)
             {
                 JOptionPane.showMessageDialog(jf,"SORRY , PLEASE PRESS ON EXIT BUTTON TO CLOSE THE FORM");
             }
          });
 
    jf.setVisible(true);  
}
   }


 //code for about project 
    
   class form6
    {
       JFrame jf;
       JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
       JButton jb1;
       JPanel jp;
       ImageIcon ic;
        form6()
      {
        jf=new JFrame();
        ic=new ImageIcon("d:/proj/pic6.jpg");
        jp=new JPanel();
        jl8=new JLabel(ic);
        jf.setTitle("ABOUT PROJECT");
        jf.setSize(500,550);
        jf.setDefaultCloseOperation(jf.DO_NOTHING_ON_CLOSE);
        jf.setLayout(null);
        Font f=new Font("Jokerman",Font.ITALIC,20); 
        jl1=new JLabel("FRONT END .....");  
        jl2=new JLabel("BACK END .....");
        jl3=new JLabel("DEVELOPED BY .....");
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);    
        jl4=new JLabel("JAVA");
        jl5=new JLabel("MY SQL");
        jl6=new JLabel("PRAKHAR YADAV");
        jl7=new JLabel("VISHWASH BHARDWAJ");
        jl1.setFont(f);
        jl2.setFont(f);
        jl3.setFont(f); 
        jl4.setFont(f);
        jl5.setFont(f);
        jl6.setFont(f);
        jl7.setFont(f);
        jl1.setBounds(50,40,150,30);  
        jl2.setBounds(50,90,150,30);  
        jl3.setBounds(10,140,200,30);  
        jl4.setBounds(200,40,350,30);
        jl5.setBounds(200,90,350,30);
        jl6.setBounds(200,140,350,30);
        jl7.setBounds(200,170,350,30);
        jl8.setBounds(0,0,550,550);
        jp.setBounds(0,0,550,550);
        jp.setBackground(Color.pink);  
        jl8.add(jl1);
        jl8.add(jl2);
        jl8.add(jl3); 
        jl8.add(jl4);
        jl8.add(jl5);
        jl8.add(jl6);
        jl8.add(jl7);
        jf.add(jl8); 
        jf.add(jp); 
        jp.add(jl8);    
        jb1=new JButton("OK"); 
        jb1.setBounds(160,300,80,30);
        jl8.add(jb1);
        jb1.setBackground(Color.orange);
        jb1.setForeground(Color.black);
        jl1.setForeground(Color.red);
        jl2.setForeground(Color.red);
        jl3.setForeground(Color.red);
        jl4.setForeground(Color.blue); 
        jl5.setForeground(Color.blue);
        jl6.setForeground(Color.blue);  
        jl7.setForeground(Color.blue);

   // code for ok button in about form to perform activity by using mouse and key 
  
      jb1.addActionListener(new ActionListener ()
         {
             public void actionPerformed(ActionEvent ae)
               {
                 jf.dispose();
                 new form();  
               }
         });
         jb1.addKeyListener(new KeyAdapter ()
         {
             public void KeyPressed(KeyEvent ke)
           {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                 jf.dispose();
                 new form();
               }
}
         });
  
//code for to exit the window by using exit button .

       jf.addWindowListener(new WindowAdapter()
          {
             public void windowClosing(WindowEvent we)
             {
                 JOptionPane.showMessageDialog(jf,"SORRY , PLEASE PRESS ON OK BUTTON TO CLOSE THE FORM");
             }
          });
        jf.setVisible(true);
      }
    }
       
          
// code for administrater module 

   class form
   {
      Dimension ds;
      JPanel jp1,jp2,jp3;
      JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
      JFrame jf,jf1;
      JLabel jl1,jl2,jl3;
      ImageIcon ic,ic1,ic2;
      public static boolean setval=false;
      form()
       {
         
        jf= new JFrame();
        ic=new ImageIcon("d:/proj/a.png");
        ic1=new ImageIcon("d:/proj/x.jpg"); 
        ic2=new ImageIcon("d:/proj/lib.jpg");
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jl1=new JLabel(ic);
        jl2=new JLabel(ic1);
        jl3=new JLabel(ic2);
        jf.setTitle("WELCOME TO THE ADMINISTRATER MODULE");
        jf.setLayout(null);
        jf.setBackground(Color.green);
        jf.setDefaultCloseOperation(jf.DO_NOTHING_ON_CLOSE);
        ds=Toolkit.getDefaultToolkit().getScreenSize();
        jf.setSize(ds.width,ds.height);  
        jp1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green,3),"Library Moudule"));
        jp2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green,3),"Library Moudule"));     
        jp3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green,3),"Library Moudule"));     
        jb1=new JButton("BOOK INFORMATION");  
        jb2=new JButton("MEMBER INFORMATION");
        jb3=new JButton("BOOK ISSUE ");
        jb4=new JButton("BOOK RETURN");
        jb5=new JButton("REPORT");
        jb6=new JButton("ABOUT PROJECT");
        jb7=new JButton("LOGOUT");
        jp1.setBounds(10,3,541,495);
        jp1.setBackground(Color.lightGray);
//        jl1.setBounds(0,0,500,500);

        jp2.setBounds(750,3,550,495);
        jp2.setBackground(Color.lightGray);
//        jl2.setBounds(0,0,500,700);

        jp3.setBounds(60,500,1200,500);
        jp3.setBackground(Color.lightGray);
//        jl3.setBounds(0,0,500,500);

        jb1.setBounds(550,10,200,50);
        jb2.setBounds(550,85,200,50);
        jb3.setBounds(550,160,200,50);
        jb4.setBounds(550,235,200,50);
        jb5.setBounds(550,310,200,50);
        jb6.setBounds(550,385,200,50);
        jb7.setBounds(550,460,200,50);
        jb1.setBackground(Color.magenta);
        jb2.setBackground(Color.magenta);
        jb3.setBackground(Color.magenta);
        jb4.setBackground(Color.magenta);
        jb5.setBackground(Color.magenta);
        jb6.setBackground(Color.magenta);
        jb7.setBackground(Color.magenta);
        jb1.setForeground(Color.black);
        jb2.setForeground(Color.black);
        jb3.setForeground(Color.black);
        jb4.setForeground(Color.black);
        jb5.setForeground(Color.black);
        jb6.setForeground(Color.black);
         jb7.setForeground(Color.black);
      
// code for book info.button in admini. form to perform activity by using mouse and key 

        jb1.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent ae)
            {  
                new form2() ;
                jf.dispose();
            }
         });
         jb1.addKeyListener(new KeyAdapter ()
         {
             public void keyPressed(KeyEvent ke)
          {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                  new form2();
                  jf.dispose();  
               }
}
         });
          jb2.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent ae)
            {
                new form3() ;
                jf.dispose();
            }
         });
         jb2.addKeyListener(new KeyAdapter ()
         {
             public void keyPressed(KeyEvent ke)
            {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                  new form3();
                  jf.dispose();  
               }
}
         });  
      jb3.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent ae)
            {
                new form4();
                jf.dispose();
            }
         });
     jb3.addKeyListener(new KeyAdapter ()
         {
             public void keyPressed(KeyEvent ke)
           {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                  new form4();
                  jf.dispose();  
               }
}
         });   
              jb4.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent ke)
               {
                 setval=true;
                 new form4();
                 jf.dispose();
               }
         });              
        
         jb5.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent ae)
            {
                new form5() ;
                jf.dispose();
            }
         });
        jb5.addKeyListener(new KeyAdapter ()
         {
             public void keyPressed(KeyEvent ke)
            {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                  new form5();
                  jf.dispose();  
               }
}
         });
          jb6.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent ae)
            {
                new form6() ;
                jf.dispose();
            }
         });
        jb6.addKeyListener(new KeyAdapter ()
         {
             public void keyPressed(KeyEvent ke)
         {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                  new form6();
                  jf.dispose();  
               }
}
         });           
        jb7.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent ae)
            {
                jf.dispose();
                new login();
            }
         });
        jb7.addKeyListener(new KeyAdapter ()
         {
             public void keyPressed(KeyEvent ke)
           {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
               {
                  jf.dispose();  
                  new login();
               }
}
         }); 
           
        jf.add(jp1);
        jp1.add(jl1);
        jf.add(jp2);
        jp2.add(jl2);
        jf.add(jp3);
        jp3.add(jl3);
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(jb4);  
        jf.add(jb5);      
        jf.add(jb6); 
        jf.add(jb7);   

//code for to exit the window by using exit button .

       jf.addWindowListener(new WindowAdapter()
          {
             public void windowClosing(WindowEvent we)
             {
                 JOptionPane.showMessageDialog(jf,"SORRY , PLEASE PRESS ON LOGOUT BUTTON TO CLOSE THE FORM");
             }
          });    
         jf.setVisible(true);      
        }
   }

   // code for admin login form   

     class login
    {  
          JFrame jf;
          ImageIcon ic;
          Dimension ds;
          JPanel jp1;
          JButton jb1,jb2;
          JTextField jt1;
          JPasswordField jpf;
          JLabel jl1,jl2,jl3,jl4,jl5;
          JComboBox jcb;
          int ch=0;
            login()
        {
          jf=new JFrame();
          ic=new ImageIcon("d:/proj/pic6.jpg");
          jl5=new JLabel(ic);
          jp1=new JPanel();
          jf.setTitle("Welcome To Admin LogIn Form");
          jf.setSize(400,400);
          jf.setLocationRelativeTo(null);
          jf.setResizable(false);    
          jf.setLayout(null);
          jp1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,1),"ADMIN LOGIN"));
          jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE); 
          jl1=new JLabel("ADMIN ID");
          jpf=new JPasswordField("");
          jcb=new JComboBox();
   //       jl2=new JLabel("ADMIN LOGIN");
          jl3=new JLabel("ADMIN PASSWORD");
          jl4=new JLabel("");
          jt1=new JTextField();
          jt1.setText("ENTER ADMIN ID");
          jt1.setForeground(Color.black);
          jb1=new JButton("LOGIN");
          jb2=new JButton("RESET");
          jb1.setBounds(150,180,80,30);
          jb1.setBackground(Color.white);
          jb1.setForeground(Color.black);
          jb2.setBounds(260,180,80,30);
          jb2.setBackground(Color.white);
          jb2.setForeground(Color.black);
          jp1.setBounds(0,0,400,400);
          jl1.setBounds(90,50,150,30);           
  //        jl2.setBounds(100,20,150,30); 
          jl3.setBounds(90,110,150,30);
          jl4.setBounds(50,300,300,30);
          jl5.setBounds(0,0,300,300);
          jt1.setBounds(220,50,150,25);
          jpf.setBounds(220,110,150,25);
          jpf.setBackground(Color.white);
          jpf.setForeground(Color.black);
          jp1.setBackground(Color.pink);
         jl1.setForeground(Color.black);
          jl3.setForeground(Color.black);

              
 // code , to perform activity on login form by using key Listener

       jb1.addKeyListener(new KeyAdapter()
           {
              public void keyPressed(KeyEvent ke)
           {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
            {
                  try
                    {
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash");
                       Statement st= con.createStatement();
                       ResultSet rs=st.executeQuery("select *from login");
                        String x,y;
                        x=jt1.getText();
                        y=jpf.getText();
                        boolean f=false;
                         while(rs.next())
                             {
                                  if(x.equals(rs.getString(1)))
                                  {
                                     if(y.equals(rs.getString(2)))
                                      {
                                           f=true;
                                           break;
                                      }

                                           else
                                           f=false;
                                  }

                                          else
                                          f=false; 
                             }

                                   if(f==true)
                                 {
                                     JOptionPane.showMessageDialog(jl4," YOU ARE AUTHROISED");
                                     jf.dispose();
                                     new form();
                                 }
                                   else
                                 {
                                     JOptionPane.showMessageDialog(jl4,"YOU ARE UN-AUTHROISED");
                                     jf.dispose();
                                 }                                                                                         
                }
                       catch(Exception e)
                    {
                        System.out.println(e);
                    }
}
                           jf.dispose();                  
                  }     
           });  
               jb2.addKeyListener(new KeyAdapter()
               {
                   public void keyPressed(KeyEvent ke)
                {
                             int key = ke.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER) 
                  {
                     jt1.setText("");
                     jpf.setText("");
                     jl4.setText("");
                  }  
}   
           });
          jt1.addKeyListener(new KeyAdapter()
           {
              public void keyPressed(KeyEvent ke)
             {
                  if(ch==0)
                  jt1.setText("");
                  ch++;
                  jt1.setBackground(Color.gray);
             }     
           });
           jt1.addMouseListener(new MouseAdapter()
            {
               public void mousePressed(MouseEvent me)
                 {
                   if(ch==0)
                   jt1.setText("");
                   ch++;
                   jt1.setBackground(Color.gray);
                 }
            });
           jb1.addActionListener(new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
                {
               try
                    {
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/bca","root","vishwash");
                       Statement st= con.createStatement();
                       ResultSet rs=st.executeQuery("select *from login");
                        String x,y;
                        x=jt1.getText();
                        y=jpf.getText();
                        boolean f=false;
                         while(rs.next())
                             {
                                  if(x.equals(rs.getString(1)))
                                  {
                                     if(y.equals(rs.getString(2)))
                                      {
                                           f=true;
                                           break;
                                      }

                                           else
                                           f=false;
                                  }

                                          else
                                          f=false; 
                             }

                                   if(f==true)
                                 {
                                     JOptionPane.showMessageDialog(jl4," YOU ARE AUTHROISED");
                                     jf.dispose();
                                     new form();
                                 }
                                   else
                                 {
                                     JOptionPane.showMessageDialog(jl4,"YOU ARE UN-AUTHROISED");
                                     jf.dispose();
                                 }                                                                                         
                }
                       catch(Exception e)
                    {
                        System.out.println(e);
                    }
                           jf.dispose();                  
                }  
              });                 
            jb2.addActionListener(new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
                {
                     jt1.setText("");
                     jpf.setText("");
                     jl4.setText("");
                }  
          }) ;  
          jf.add(jp1);
          jp1.add(jl5); 
          jl5.add(jl1);
          jl5.add(jpf);
   //      jl5.add(jl2);
          jl5.add(jl3);
          jl5.add(jl4);
          jl5.add(jb1);
          jl5.add(jb2);
          jl5.add(jt1);         
          


   
          jf.setVisible(true);
        }
    }   
// code for main class  

   class project
      {
         JFrame jf;
         Dimension ds;
         JMenuBar jmb;
         JMenu jm1;
         JMenuItem jmi1;
         ImageIcon ic;   
         JPanel jp;
         JLabel jl1;
         project()
      {    
       jf=new JFrame();
       ic=new ImageIcon("d:/proj/pic9.jpg");    
       jl1=new JLabel(ic);
 //      jl1.setBounds(10,200,800,800); 
       jp=new JPanel();
       ds=Toolkit.getDefaultToolkit().getScreenSize();
       jf.setTitle("WELCOME TO LOGIN FORM"); 
       jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,1),"Welcome In Libreary Mgt System"));
       jmb=new JMenuBar();
       jm1=new JMenu("LOGIN"); 
       jmi1=new JMenuItem("ADMIN");
       ds=Toolkit.getDefaultToolkit().getScreenSize();
       jf.setSize(ds.width,ds.height);
       jp.setSize(ds.width,ds.height);
       jp.setBackground(Color.green);
       jf.setLayout(null);  
       jf.add(jp);
       jp.add(jl1);     
       jmb.add(jm1);
       jm1.add(jmi1);
       jf.setResizable(false);
    
// code for menu in admin form to perform activity by using mouse and key  

       jmi1.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent ae)
            {
                  new login();
            }   
       });
       jmi1.addKeyListener(new KeyAdapter()
       {
          public void keyPressed(KeyEvent ae)
         {
                             int key = ae.getKeyCode();
                                    if(key ==KeyEvent.VK_ENTER)
            {
                  new login();
            }  
} 
       });
        jf.setJMenuBar(jmb);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        Font f=new Font("Gill Sanes",Font.ITALIC,30);
        jmb.setFont(f);
        jf.setVisible(true);         
    }
      public static void main(String args[])
     {
       new project();
     }
}
        
        // MAIN CLASS  


class progressdemo
{
      JFrame jf;   
      Dimension ds;     
      JProgressBar jpb;
      JLabel jl,jl1,jl2,jl3,jl4,jl5;
      JPanel jp;  
      ImageIcon ic;  
      JButton jb1,jb2; 
      int i=0; 
      progressdemo()
      {
                 jf=new JFrame();
                 ic=new ImageIcon("d:/proj/abc.jpg");
                 jl=new JLabel(ic);
                 jp=new JPanel();
                 jl1=new JLabel("&&&&&...LIBRARY  MANAGEMENT  SYSTEM...&&&&&");
                 jl1.setBounds(500,130,900,25);
                 Font f=new Font("Jokerman",Font.BOLD,30);
                 jl1.setForeground(Color.red);
                 jl1.setFont(f);
                 Font f1=new Font("Gigi",Font.BOLD,30);
                 jl2=new JLabel(" &&&&&...WELCOME  TO  OUR...&&&&&");
                 jl2.setBounds(600,50,850,50);
                 jl2.setForeground(Color.orange);
                 jl2.setFont(f1);
                 jl3=new JLabel("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                 jl3.setBounds(480,155,950,50);
                 jl3.setForeground(Color.yellow);
                 jl4=new JLabel("`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````");
                 jl4.setBounds(500,75,850,50);
                 jl4.setForeground(Color.orange);
                 Font f2=new Font("Gigi",Font.BOLD,30);
                 jl5=new JLabel("Project is Loading Please Wait For Awhile......");
                 jl5.setBounds(600,600,650,30);
                 jl5.setForeground(Color.green);
                 jl5.setFont(f2);
                 jb1=new JButton("COUNTINUE....");
                 jb1.setBounds(1450,650,150,25);
                 jb1.setForeground(Color.white);
                 jb1.setBackground(Color.black);
                 jb2=new JButton("EXIT....");
                 jb2.setBounds(300,650,150,25);
                 jb2.setForeground(Color.white);
                 jb2.setBackground(Color.black);
                 ds=Toolkit.getDefaultToolkit().getScreenSize();
                 jf.setSize(ds.width,ds.height);  
                 jl.setSize(ds.width,ds.height);   
                 jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green,2),"WELCOME TO OUR LIBRARY"));
                 jp.setSize(ds.width,ds.height); 
                 jp.setBackground(Color.black); 
                 jf.setTitle("WELCOME TO THE LIBRARY MANAGEMENT SYSTEM");
                 jf.setLayout(null) ;
                 jf.setLocationRelativeTo(null);
                 jf.setResizable(false);
                 jf.setDefaultCloseOperation(jf.DO_NOTHING_ON_CLOSE);
                 jpb=new JProgressBar(0,500);
                 jpb.setStringPainted(true);
                 jpb.setBackground(Color.black);
                 jpb.setForeground(Color.gray);
                 jpb.setBounds(650,550,550,30);
                 jf.add(jp);
                 jp.add(jl);
                 jl.add(jpb);
                 jl.add(jl1);
                 jl.add(jl2);
                 jl.add(jl3);
                 jl.add(jl4);
                 jl.add(jl5); 
           //      jl.add(jb1);
           //      jl.add(jb2);
                 jf.setVisible(true); 
          
                while(i<=500)
               {
                      jpb.setValue(i);
                     try
                     {
                             Thread.sleep(2);
                     }catch(Exception e){}
                      i++;    
               }
               if(i>500)
               {
                    jf.dispose();                               
                     new project();                 
                    jl.setVisible(true);
              }
          
     //code for to exit the window by using exit button .

       jf.addWindowListener(new WindowAdapter()
          {
             public void windowClosing(WindowEvent we)
             {
                 JOptionPane.showMessageDialog(jf,"SORRY , PLEASE PRESS ON EXIT BUTTON TO CLOSE THE FORM");
             }
          });

      }
    public static void main(String [] args)
    {
         new progressdemo(); 
    }
}

