package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.List;

/**
 * Indica que la entidad marcada tiene una valor
 * 
 * @author germanmr
 * @param <T>
 * 
 */
public interface Tienevalor {

	<T> T getValor();

}
