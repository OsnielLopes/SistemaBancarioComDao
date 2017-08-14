package banco.apps;

import banco.dao.api.TitularDaoInterface;
import banco.dao.impl.relacional.javabd.ConexaoJavaDb;
import banco.dominio.Titular;
import bancos.dao.impl.relacional.*;
import java.util.List;

/**
 *
 * @author osniellopesteixeira
 */
public class AppSelectTitularesComDao {
    public static void main(String[] args) {
        //Cria a conexao com o banco
        ConexaoInterface conexao;
        conexao = new ConexaoJavaDb("app", "123", "127.0.0.1", 1527,"sistema_bancario");
        
        //Cria um objeto que permite acessar todos os titulares do banco
        TitularDaoInterface dao;
        dao = new TitularDaoRelacional(conexao);
        
        //Pega todos os titulares do banco
        List<Titular> titulares = dao.listarTudo();
        
        int maior = 0;
        for(Titular t: titulares){
            if(t.getNome().length()>maior){
                maior = t.getNome().length();
            }
        }
        for(Titular t: titulares){
            System.out.print("Numero: "+t.getNro_titular() + " - ");
            System.out.printf("Nome: %-"+maior+"s - ",t.getNome());
            System.out.print("CPF: "+t.getCpf()+" - ");
            System.out.println("RG: "+t.getRg());
        }
        
    }
    
    
    
    
}
