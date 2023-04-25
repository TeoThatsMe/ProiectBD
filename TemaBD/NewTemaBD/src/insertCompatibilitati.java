import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class insertCompatibilitati {
    private Connection conn;
    private JFrame frame;
    private JTextField id1;
    public JPanel panel1;
    private JTextField id2;
    private JButton doneButton;
public insertCompatibilitati(Connection conn,JFrame frame) {
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
                stmt.execute("insert into Compatibilitati(ID_Produs,ID_Produs2) values('"+id1.getText()+"','"+id2.getText()+"')");
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
public insertCompatibilitati(Connection conn,JFrame frame,String val,String val2) {
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
                    stmt.execute("update Compatibilitati set id_produs='"+id1.getText()+"',id_produs2='"+id2.getText()+"' where id_produs='"+val+"' and id_produs2='"+val2+"'");
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
