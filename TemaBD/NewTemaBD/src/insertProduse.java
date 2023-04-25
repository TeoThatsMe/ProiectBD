import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import javax.swing.text.html.parser.Entity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class insertProduse {
    private JFrame frame;
    private Connection conn;
    private JButton done;
    public JPanel panel1;
    private JTextField Caracteristica;
    private JTextField Denumire;
    private JTextField Pret;
    private JTextField Cantitate;
    private JComboBox comboBox1;
    private ResultSet r;
    private String opt="1";
    public insertProduse(Connection conn,JFrame frame) throws SQLException {
    this.conn=conn;
    this.frame=frame;
        Statement stmt;
        ResultSet rs;
        try {
            stmt=conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt.execute("select * from categorii");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rs=stmt.getResultSet();
        r=rs;
        while(rs.next())
        {
            String asd=rs.getString("NUME_CATEGORIE");
            comboBox1.addItem(asd);
        }
        stmt.close();
    done.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Statement stmt;
            try {
                stmt=conn.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                stmt.execute("insert into produse(Denumire,Caracteristica,ID_Categorie,Pret,Cantitate) values('"+Denumire.getText()+"','"+Caracteristica.getText()+"','"+opt+"','"+Pret.getText()+"','"+Cantitate.getText()+"')");
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
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=comboBox1.getItemAt(comboBox1.getSelectedIndex()).toString();
                Statement stmt;
                ResultSet rs;
                try {
                    stmt=conn.createStatement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    stmt.execute("select * from categorii");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    rs=stmt.getResultSet();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                while(true)
                {
                    try {
                        if (!rs.next()) break;
                        if(rs.getString("nume_categorie")==s) {
                            opt = rs.getString("id_categorie");
                            break;
                        }

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public insertProduse(Connection conn,JFrame frame,String val) throws SQLException {
        this.conn=conn;
        this.frame=frame;
        Statement stmt;
        ResultSet rs;
        try {
            stmt=conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt.execute("select * from categorii");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rs=stmt.getResultSet();
        while(rs.next())
        {
            String asd=rs.getString("NUME_CATEGORIE");
            comboBox1.addItem(asd);

        }
            done.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Statement stmt;
                    try {
                        stmt=conn.createStatement();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        stmt.execute("update produse set denumire='"+Denumire.getText()+"',caracteristica='"+Caracteristica.getText()+"',id_categorie='"+opt+"',pret='"+Pret.getText()+"',cantitate='"+Cantitate.getText()+"' where id_produs='"+val+"'");
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
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=comboBox1.getItemAt(comboBox1.getSelectedIndex()).toString();
                Statement stmt;
                ResultSet rs;
                try {
                    stmt=conn.createStatement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    stmt.execute("select * from categorii");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    rs=stmt.getResultSet();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                while(true)
                {
                    try {
                        if (!rs.next()) break;
                        if(rs.getString("nume_categorie")==s) {
                            opt = rs.getString("id_categorie");
                            break;
                        }

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        }
    }

