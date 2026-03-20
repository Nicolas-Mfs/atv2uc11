package dao;

import model.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {


    // Salvar item
    public boolean salvar(Item item) {
        try (Connection conn = conectar()) {
            String sql = "INSERT INTO itens (nome, valor_inicial) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, item.getNome());
            stmt.setDouble(2, item.getValorInicial());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar itens
    public List<Item> listar() {
        List<Item> itens = new ArrayList<>();
        try (Connection conn = conectar()) {
            String sql = "SELECT nome, valor_inicial FROM itens";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                itens.add(new Item(
                    rs.getString("nome"),
                    rs.getDouble("valor_inicial")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itens;
    }

    // Atualizar item
    public boolean atualizar(String nome, double novoValor) {
        try (Connection conn = conectar()) {
            String sql = "UPDATE itens SET valor_inicial = ? WHERE nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, novoValor);
            stmt.setString(2, nome);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Excluir item
    public boolean excluir(String nome) {
        try (Connection conn = conectar()) {
            String sql = "DELETE FROM itens WHERE nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
private Connection conectar() throws SQLException {
    return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/leilao", 
        "root",      // seu usuário
        "35242292"       // sua senha
    );
}

    public boolean atualizar(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
