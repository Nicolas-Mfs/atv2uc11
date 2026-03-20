package DAO;


import java.sql.*;
import java.util.*;

public class ProdutosDAO {

    // Método para vender um produto
    public void venderProduto(int idProduto) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
            System.out.println("Produto vendido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar produtos vendidos
    public List<Produto> listarProdutosVendidos() {
        List<Produto> vendidos = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setStatus(rs.getString("status"));
                vendidos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendidos;
    }
}