import java.util.List;
import java.util.Optional;

/**
 * Interface genérica para operações de persistência de dados (CRUD).
 *
 * @param <T>  O tipo da entidade (ex: Usuario, Produto)
 * @param <ID> O tipo do identificador (ex: Long, String)
 */
public interface DbInterface<T, ID> {

    // Cria ou atualiza um registro
    T save(T entity);

    // Busca um registro pelo seu identificador único
    Optional<T> findById(ID id);

    // Retorna todos os registros da base
    List<T> findAll();

    // Remove um registro da base pelo ID
    void deleteById(ID id);

    // Verifica se um registro existe
    boolean existsById(ID id);

    // Retorna a contagem total de registros
    long count();
}