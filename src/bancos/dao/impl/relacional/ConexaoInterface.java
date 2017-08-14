package bancos.dao.impl.relacional;

import java.sql.Connection;

/**
 *
 * @author osniellopesteixeira
 */
public interface ConexaoInterface {
    Connection getConnection();
    void close();
}
