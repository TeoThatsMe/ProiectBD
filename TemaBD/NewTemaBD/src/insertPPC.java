import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class insertPPC {
    private Connection conn;
    private JFrame frame;
    private JButton doneButton;
    public JPanel panel1;
    private JTextField id_Produs;
    private JTextField id_Comanda;
    private JTextField id_factura;
public insertPPC(Connection conn,JFrame frame) {
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
                stmt.execute("insert into Produse_Pe_Comanda(ID_Produse,ID_Comanda,ID_Factura) values('"+id_Produs.getText()+"','"+id_Comanda.getText()+"','"+id_factura.getText()+"')");
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
public insertPPC(Connection conn,JFrame frame,String val,String val1,String val2) {
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
                    stmt.execute("update Produse_Pe_Comanda set id_produs='"+id_Produs.getText()+"', id_comanda='"+id_Comanda.getText()+"', id_factura='"+id_factura.getText()+"' where id_produs='"+val+"' and id_comanda='"+val1+"' and id_factura='"+val2+"'");
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

