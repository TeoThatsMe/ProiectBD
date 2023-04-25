import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insertComeni {
    private Connection conn;
    private JFrame frame;
    private JButton doneButton;
    public JPanel panel1;
    private JTextField id_Client;
    private JTextField id_Adresa;
    private JComboBox idComboBox;
    private JComboBox adresaComboBox;
    private String opt1;
    private String opt2;

    public insertComeni(Connection conn, JFrame frame) {
        this.conn = conn;
        this.frame = frame;
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statement stmt;
                try {
                    stmt = conn.createStatement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    stmt.execute("insert into Comenzi(ID_Client,ID_Adresa) values('" + id_Client.getText() + "','" + id_Adresa.getText() + "')");
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
        idComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = idComboBox.getItemAt(idComboBox.getSelectedIndex()).toString();
                Statement stmt;
                ResultSet rs;
                try {
                    stmt = conn.createStatement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    stmt.execute("select * from clienti");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    rs = stmt.getResultSet();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                while (true) {
                    try {
                        if (!rs.next()) break;
                        if (rs.getString("nume") == s) {
                            opt1 = rs.getString("id_client");
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
        adresaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statement stmt;
                ResultSet rs;
                try {
                    stmt=conn.createStatement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String s=adresaComboBox.getItemAt(adresaComboBox.getSelectedIndex()).toString();
                try {
                    stmt.execute("select * from detalii_livrare");
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
                        if(rs.getString("adresa")==s) {
                            opt2 = rs.getString("id_adresa");
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

    public insertComeni(Connection conn, JFrame frame, String val) {
        this.conn = conn;
        this.frame = frame;
        Statement stmt;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt.execute("select * from clienti");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            rs = stmt.getResultSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String asd = null;
            try {
                asd = rs.getString("Nume");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            idComboBox.addItem(asd);
            try {
                stmt.execute("select * from detalii_livrare");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                rs = stmt.getResultSet();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                try {
                    if (!rs.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                asd = null;
                try {
                    asd = rs.getString("Adresa");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                adresaComboBox.addItem(asd);

            }
            doneButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Statement stmt;
                    try {
                        stmt = conn.createStatement();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        stmt.execute("update Comenzi set id_client='" + idComboBox.getItemAt(idComboBox.getSelectedIndex()) + "', id_adresa='" + adresaComboBox + "' where id_comanda='" + val + "'");
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
}