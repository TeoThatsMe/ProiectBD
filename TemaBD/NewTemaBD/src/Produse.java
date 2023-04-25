import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Produse {
    private String optTabel="Produse";
    private Connection conn=null;
    private JTable Tabel;
    public JPanel panel1;
    private JButton refreshButton;
    private JComboBox comboBox1;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;

    public Produse(Connection conn){
    this.conn=conn;
    Statement statement;
    try {
        statement=conn.createStatement();
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    ResultSet rs;
    try {
        statement.execute("select * from " + optTabel);
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    try {
        rs=statement.getResultSet();
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    Tabel.setModel(DbUtils.resultSetToTableModel(rs));
    try {
        statement.close();
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    refreshButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Statement statement;
            try {
                statement=conn.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            ResultSet rs;
            try {
                statement.execute("select * from " + optTabel);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                rs=statement.getResultSet();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            Tabel.setModel(DbUtils.resultSetToTableModel(rs));
            try {
                statement.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optTabel=comboBox1.getItemAt(comboBox1.getSelectedIndex()).toString();
                Statement statement;
                try {
                    statement=conn.createStatement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                ResultSet rs;
                try {
                    statement.execute("select * from " + optTabel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    rs=statement.getResultSet();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Tabel.setModel(DbUtils.resultSetToTableModel(rs));
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insertFrame=new JFrame("Insert");
                switch (optTabel)
                {
                    case "Produse":
                        try {
                            insertFrame.setContentPane(new insertProduse(conn,insertFrame).panel1);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "Produse_Pe_Comanda":
                        insertFrame.setContentPane(new insertPPC(conn,insertFrame).panel1);
                        break;
                    case "Categorii":
                        insertFrame.setContentPane(new insertCategorii(conn,insertFrame).panel1);
                        break;
                    case "Clienti":
                        insertFrame.setContentPane(new insertClienti(conn,insertFrame).panel1);
                        break;
                    case "Compatiblitati":
                        insertFrame.setContentPane(new insertCompatibilitati(conn,insertFrame).panel1);
                        break;
                    case "Detalii_Livrare":
                        insertFrame.setContentPane(new insertDL(conn,insertFrame).panel1);
                        break;
                    case "Comezi":
                        insertFrame.setContentPane(new insertComeni(conn,insertFrame).panel1);
                        break;
                    case "Facturi":
                        insertFrame.setContentPane(new insertFacturi(conn,insertFrame).panel1);
                        break;
                }
                insertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                insertFrame.pack();
                insertFrame.setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=Tabel.getSelectedRow();
                String val=Tabel.getModel().getValueAt(row,0).toString();
                Statement stmt;
                try {
                    stmt=conn.createStatement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    switch (optTabel) {
                        case "Produse":
                            stmt.execute("delete from " + optTabel + " where id_produs='" + val + "'");
                            break;
                        case "Produse_Pe_Comanda":
                            stmt.execute("delete from " + optTabel + " where id_produs='" + val + "'");
                            break;
                        case "Categorii":
                            stmt.execute("delete from " + optTabel + " where id_categorie='" + val + "'");
                            break;
                        case "Clienti":
                            stmt.execute("delete from " + optTabel + " where id_client='" + val + "'");
                            break;
                        case "Compatiblitati":
                            stmt.execute("delete from " + optTabel + " where id_produs='" + val + "'");
                            break;
                        case "Detalii_Livrare":
                            stmt.execute("delete from " + optTabel + " where id_adresa='" + val + "'");
                            break;
                        case "Comezi":
                            stmt.execute("delete from " + optTabel + " where id_comanda='" + val + "'");
                            break;
                        case "Facturi":
                            stmt.execute("delete from " + optTabel + " where id_factura='" + val + "'");
                            break;

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=Tabel.getSelectedRow();
                String val=Tabel.getModel().getValueAt(row,0).toString();

                JFrame insertFrame=new JFrame("Update");
                switch (optTabel)
                {
                    case "Produse":
                        try {
                            insertFrame.setContentPane(new insertProduse(conn,insertFrame,val).panel1);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "Produse_Pe_Comanda":
                        String val1=Tabel.getModel().getValueAt(row,1).toString();
                        String val2=Tabel.getModel().getValueAt(row,2).toString();
                        insertFrame.setContentPane(new insertPPC(conn,insertFrame,val,val1,val2).panel1);
                        break;
                    case "Categorii":
                        insertFrame.setContentPane(new insertCategorii(conn,insertFrame,val).panel1);
                        break;
                    case "Clienti":
                        insertFrame.setContentPane(new insertClienti(conn,insertFrame,val).panel1);
                        break;
                    case "Compatiblitati":
                        String valComp=Tabel.getModel().getValueAt(row,1).toString();
                        insertFrame.setContentPane(new insertCompatibilitati(conn,insertFrame,val,valComp).panel1);
                        break;
                    case "Detalii_Livrare":
                        insertFrame.setContentPane(new insertDL(conn,insertFrame,val).panel1);
                        break;
                    case "Comezi":
                        insertFrame.setContentPane(new insertComeni(conn,insertFrame,val).panel1);
                        break;
                    case "Facturi":
                        insertFrame.setContentPane(new insertFacturi(conn,insertFrame,val).panel1);
                        break;
                }
                insertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                insertFrame.pack();
                insertFrame.setVisible(true);
            }
        });
    }
}
