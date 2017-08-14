package bancos.dao.impl.relacional;

import banco.dao.api.TitularDaoInterface;
import banco.dominio.Titular;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osniellopesteixeira
 */
public class TitularDaoRelacional implements TitularDaoInterface{
    
    private ConexaoInterface conexao;

    public TitularDaoRelacional(ConexaoInterface conexao){
        this.conexao = conexao;
    }

    @Override
    public List<Titular> listarTudo() {
        List<Titular> titulares;
        titulares = new ArrayList<>();
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            
            String sql = "select nro_titular, nome, rg, cpf from titulares";
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                long n = result.getLong("nro_titular");
                String nome = result.getString("nome");
                String rg = result.getString("rg");
                String cpf = result.getString("cpf");
                Titular t = new Titular(n,nome,rg,cpf);
                titulares.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TitularDaoRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return titulares;
    }
    
    
}
