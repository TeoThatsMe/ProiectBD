import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insertFacturi {
    private Connection conn;
    private JFrame frame;

    private JButton doneButton;
    public JPanel panel1;
    private JComboBox comboBox1;
    private JTextField idComanda;
    private String opt="1";
public insertFacturi(Connection conn,JFrame frame) {
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
        stmt.execute("select * from comenzi");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    try {
        rs=stmt.getResultSet();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    while(true)
    {
        try {
            if (!rs.next()) break;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String asd= null;
        try {
            asd = rs.getString("id_comanda");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        comboBox1.addItem(asd);

    }
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
                stmt.execute("insert into Facturi(ID_Comanda) values('"+opt+"')");
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
                stmt.execute("select * from comenzi");
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
                    if(rs.getString("id_comanda").equals(s)) {
                        opt = rs.getString("id_comanda");
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
public insertFacturi(Connection conn,JFrame frame,String val) {
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
        stmt.execute("select * from comenzi");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    try {
        rs=stmt.getResultSet();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    while(true)
    {
        try {
            if (!rs.next()) break;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String asd= null;
        try {
            asd = rs.getString("id_comanda");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        comboBox1.addItem(asd);

    }
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
                    stmt.execute("update Facturi set id_comanda='"+opt+"' where id_factura='"+val+"'");
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
                stmt.execute("select * from comenzi");
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
                    if(rs.getString("id_comanda").equals(s)) {
                        opt = rs.getString("id_comanda");
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
