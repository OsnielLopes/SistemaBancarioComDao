package bancos.dao.impl.relacional;

import banco.dao.api.ContaDaoInterface;
import banco.dominio.Conta;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Osniel Teixeira e Helder
 */
public class ContaDaoRelacional implements ContaDaoInterface {
    
    private ConexaoInterface conexao;
    
    public ContaDaoRelacional(ConexaoInterface conexao){
        this.conexao = conexao;
    }

    @Override
    public List<Conta> listarTudo() {
        List<Conta> contas;
        contas = new ArrayList<>();
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "SELECT nro_conta, saldo FROM contas";
            ResultSet resultados = st.executeQuery(sql);
            
            while (resultados.next()){
                long n = resultados.getLong("nro_conta");
                BigDecimal b = resultados.getBigDecimal("saldo");
                Conta c = new Conta(n, b);
                contas.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contas;
    }
}
