
package banco.dao.impl.relacional.javabd;

import bancos.dao.impl.relacional.ConexaoInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJavaDb implements ConexaoInterface{
    private String usuario;
    private String senha;
    private String hostname;
    private int porta;
    private String nomeBancoDados;
    private Connection conexao;
    public ConexaoJavaDb(String usuario, String senha, String hostname, int porta, String n){
        this.usuario = usuario;
        this.senha = senha;
        this.hostname = hostname;
        this.porta = porta;
        this.nomeBancoDados = n;
    }
    @Override
    public Connection getConnection(){
        if(conexao == null){
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://" + hostname+ ":"+ porta+"/"+ nomeBancoDados;
                conexao = DriverManager.getConnection(url, usuario, senha);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return conexao;
    }

    @Override
    public void close() {
        try{
            conexao.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        conexao = null;
    }
}
