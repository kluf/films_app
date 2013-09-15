/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package films;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 *
 * @author AdmiN
 */
public class Films {
//    
//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet res = null;
//        try {
//            Driver driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
//            DriverManager.registerDriver(driver);
//            String url = "jdbc:sqlite:E:\\Other\\Computer\\GIT_LOCAL_REPO\\films_app\\myFilms.db";
//            conn = DriverManager.getConnection(url);
//            String sql = "SELECT * FROM film_list";
//            stmt = conn.createStatement();
//            res = stmt.executeQuery(sql);
//            while(res.next()){
//                System.out.println(res.getString("ORIG_NAME")+" - "+res.getObject("TRANSLATED_NAME"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            try{
//                if(res!=null) res.close();
//                if(stmt!=null) stmt.close();
//                if(conn!=null) conn.close();
//            } catch(Exception ex){
//                
//            }
//        }
//       
//    }
    
    
//    =========next trying
//    public static void main(String[] args) throws Exception {
//        Class.forName("org.sqlite.JDBC");
//        Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\Other\\Computer\\GIT_LOCAL_REPO\\films_app\\myFilms.db");
//        Statement stat = conn.createStatement();
////        stat.executeUpdate("drop table if exists people;");
////        stat.executeUpdate("create table people (name, occupation);");
////        PreparedStatement prep = conn.prepareStatement(
////            "insert into people values (?, ?);");
////
////        prep.setString(1, "Gandhi");
////        prep.setString(2, "politics");
////        prep.addBatch();
////        prep.setString(1, "Turing");
////        prep.setString(2, "computers");
////        prep.addBatch();
////        prep.setString(1, "Wittgenstein");
////        prep.setString(2, "smartypants");
////        prep.addBatch();
////
////        conn.setAutoCommit(false);
////        prep.executeBatch();
////        conn.setAutoCommit(true);
//
//        ResultSet rs = stat.executeQuery("select * from film_list;");
//        while (rs.next()) {
//            System.out.println("name = " + rs.getString("ORIG_NAME"));
//            System.out.println("job = " + rs.getString("TRANSLATED_NAME"));
//        }
//        rs.close();
//        conn.close();
//    }
//    other trying
            public static void main (String[] args) throws Exception
{
    Object[][] tableData = {{}};
    Object[] headers= {"id","Оригінальна назва","Переклад","Жанри","Дата виходу"};
    JFrame frame = new JFrame("Test");
    frame.getContentPane().setLayout(new FlowLayout());
    frame.setSize(600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTable table = new JTable(tableData,headers);
    JScrollPane scroll = new JScrollPane(table);
    table.setPreferredScrollableViewportSize(new Dimension(400,200));
    frame.getContentPane().add(scroll);
    frame.setVisible(true);
// register the driver 
String sDriverName = "org.sqlite.JDBC";
Class.forName(sDriverName);
 
// now we set up a set of fairly basic string variables to use in the body of the code proper
String sTempDb = "E:\\Other\\Computer\\GIT_LOCAL_REPO\\films_app\\myFilms.db";
String sJdbc = "jdbc:sqlite";
String sDbUrl = sJdbc + ":" + sTempDb;
// which will produce a legitimate Url for SqlLite JDBC :
// jdbc:sqlite:hello.db
int iTimeout = 30;
//String sMakeTable = "CREATE TABLE dummy (id numeric, response text)";
//String sMakeInsert = "INSERT INTO dummy VALUES(1,'Hello from the database')";
String sMakeSelect = "SELECT * FROM myFilms";
 
// create a database connection
Connection conn = DriverManager.getConnection(sDbUrl);
try {
    java.sql.Statement stmt = conn.createStatement();
try {
stmt.setQueryTimeout(iTimeout);
//stmt.executeUpdate( sMakeTable );
//stmt.executeUpdate( sMakeInsert );
ResultSet rs = stmt.executeQuery(sMakeSelect);

try {
while(rs.next())
{
String sResult = rs.getString("ORIG_NAME")+ " - " +rs.getString("TRANSLATED_NAME");
tableData.add(sResult);
//System.out.println(sResult);
}
} finally {
    try { rs.close(); } catch (Exception ignore) {}
}
} finally {
    try { stmt.close(); } catch (Exception ignore) {}
}
} finally {
    try { conn.close(); } catch (Exception ignore) {}
}
}
}
