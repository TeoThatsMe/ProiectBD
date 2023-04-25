import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class insertCategorii {
    private Connection conn;
    private JFrame frame;
    private JButton doneButton;
    public JPanel panel1;
    private JTextField Nume_Categorie;
public insertCategorii(Connection conn, JFrame frame) {
    this.conn=conn;
    this.frame=frame;
    doneButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Statement stmt;
            try {
                stmt=conn.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                stmt.execute("insert into Categorii(Nume_Categorie) values('"+Nume_Categorie.getText()+"')");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            frame.setVisible(false);
            frame.dispose();
        }
    });
}
public insertCategorii(Connection conn, JFrame frame,String val) {
        this.conn=conn;
        this.frame=frame;
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statement stmt;
                try {
                    stmt=conn.createStatement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    stmt.execute("update Categorii set nume_categorie='"+Nume_Categorie.getText()+"' where id_categorie='"+val+"'");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                frame.setVisible(false);
                frame.dispose();
            }
        });
    }
}
