import javax.swing.*;
import java.util.List;

public class VendasView extends JFrame {
    private JTable tabelaVendidos;
    private ProdutosDAO dao = new ProdutosDAO();

    public VendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<Produto> vendidos = dao.listarProdutosVendidos();
        String[] colunas = {"ID", "Nome", "Status"};
        Object[][] dados = new Object[vendidos.size()][3];

        for (int i = 0; i < vendidos.size(); i++) {
            dados[i][0] = vendidos.get(i).getId();
            dados[i][1] = vendidos.get(i).getNome();
            dados[i][2] = vendidos.get(i).getStatus();
        }

        tabelaVendidos = new JTable(dados, colunas);
        add(new JScrollPane(tabelaVendidos));
    }
}