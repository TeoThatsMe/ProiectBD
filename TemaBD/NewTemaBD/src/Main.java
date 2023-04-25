import oracle.jdbc.pool.OracleDataSource;

import javax.management.Query;
import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static JFrame frame;
    public static void main(String[] args) throws SQLException {
        OracleDataSource ods=new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//bd-dc.cs.tuiasi.ro:1539/orcl");
        ods.setUser("bd132");
        ods.setPassword("password");
        Connection conn=ods.getConnection();
        frame=new JFrame("Main");
        frame.setContentPane(new Produse(conn).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}