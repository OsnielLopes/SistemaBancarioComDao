
package banco.apps;

import banco.dao.api.ContaDaoInterface;
import banco.dao.impl.relacional.javabd.ConexaoJavaDb;
import banco.dominio.Conta;
import bancos.dao.impl.relacional.ConexaoInterface;
import bancos.dao.impl.relacional.ContaDaoRelacional;
import java.util.List;

/**
 *
 * @author osniellopesteixeira & Helder Gomes
 */
public class AppSelectContasComDao {
    public static void main(String[] args) {
        ConexaoInterface conexao;
        conexao = new ConexaoJavaDb("app", "123", "127.0.0.1", 1527,"sistema_bancario");
        ContaDaoInterface dao;
        dao = new ContaDaoRelacional(conexao);
        List<Conta> todasContas;
        todasContas = dao.listarTudo();
        for (Conta c: todasContas){
            System.out.print("Nro: " + c.getNumero());
            System.out.print(" - ");
            System.out.println("Saldo: R$ " + c.getSaldo());
        }
        conexao.close();
    }
}
