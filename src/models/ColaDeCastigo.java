package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import exceptions.ColaExceededSizeException;
import exceptions.ElementBlockedException;
import exceptions.LlevateTuNullDeAquiException;

public class ColaDeCastigo<E> {
	
	// ~~~ ATRIBUTOS
	private List<E> miQueue;
	private Comparator<E> miComparador;
	
	// ~~~ CONSTRUCTOR
	public ColaDeCastigo(Comparator<E> miComparador) {
		super();
		this.miQueue = new ArrayList<E>();
		this.miComparador = miComparador;
	}

	// ~~~ METODOS
	/**
	 * 
	 * @return Devuelve un int que representa el tama�o de la queue
	 */
	public int size() {
		return miQueue.size();
	}

	/**
	 * Metodo que sirve para saber si la queue esta vacia o no
	 * @return Devuelve True si esta vacia, o False si no lo esta
	 */
	public boolean isEmpty() {
		if(miQueue.size() != 0)
			return false;
		else
			return true;
	}

	/**
	 * Metodo que sirve para saber si hay un determinado objeto en nuestra queue
	 * @param o Objeto a buscar
	 * @return True si existe el objeto, False si no existe
	 */
	public boolean contains(Object o) {
		if(miQueue.contains(o)) 
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @return Devuelve un interador que ha sido creado y agregado a la queue
	 */
	public Iterator<E> iterator() {
		return miQueue.iterator();
	}

	/**
	 * 
	 * @return Transforma y devuelve la queue en forma de array
	 */
	public Object[] toArray() {
		return miQueue.toArray();
	}

	/**
	 * Transforma y devuelve la queue en forma de array agregandole de manera ordenada
	 * el array que se le pasa
	 * @param o Object[] que tiene los elementos a quitar para ser agregados a la queue
	 * @return La queue junto a los elementos extraidos del Object[] pasado
	 */
	public Object[] toArray(Object[] o) {
		return miQueue.toArray(o);
	}

	/**
	 * Metodo que elimina un objeto indicado de la queue solo si hay m�s de 1 elemento en ella.
	 * @param o Objeto a eliminar
	 * @return True si se encontro y se elimino
	 * @throws Exception Por intentar eliminar un objeto de la queue cuando solo queda 1 elemento
	 */
	public boolean remove(Object o) throws Exception {
		if(miQueue.size() > 1) { //Si tienes m�s de 1 objeto en el array...
			miQueue.remove(o);
			return true;
		} else { 
			throw new Exception(new ElementBlockedException("ERR0R >>> No se puede eliminar el �ltimo objeto de la queue <<< ERR0R"));
		}
	}

	/**
	 * Metodo que comprueba si la queue tiene todos los elementos de una coleccion
	 * @param c Coleccion a comparar con la queue
	 * @return Devuelve True si todos los elementos de la coleccion estan presentes en la queue, de lo contrario devuelve False
	 */
	public boolean containsAll(Collection<E> c) {
		if(miQueue.contains(c)) 
			return true;
		else
			return false;
	}

	/**
	 * M�todo que nos permite a�adir una colecci�n entera a nuestra queue
	 * @param c Coleccion a a�adir
	 * @return True en caso de que se haya podido a�adir la coleccion, de lo contrario False
	 * @throws LlevateTuNullDeAquiException  En caso de que la coleccion contenga un null
	 * @throws ColaExceededSizeException En caso de que se quieran a�adir muchos elementos, sobrepasando el m�ximo de 10
	 */
	public boolean addAll(Collection<E> c) throws LlevateTuNullDeAquiException, ColaExceededSizeException {
		if(c.size() + miQueue.size() < 10) { //Si el tama�o de la colecci�n y del array no superan 10
			if(c.contains(null)) { //Si la coleccion tiene un null
				throw new LlevateTuNullDeAquiException("ERR0R >>> La colecci�n tiene un elemento NULL que no puede ser agregado <<< ERR0R");
			} else {
				miQueue.addAll(c);
				return true;
			}
		} else {
			throw new ColaExceededSizeException("ERR0R >>> Esa coleccion no cabe en esta queue (M�ximo 10 elementos) <<< ERR0R");
		} 
	}

	/**
	 * Metodo que elimina de la queue todos los elementos que esten en la colecci�n dada
	 * @param c Coleccion con los elementos a eliminar de la queue
	 * @return True en caso de haber podido remover elementos, False en caso contrario
	 * @throws Exception En caso de querer eliminar todos los elementos y dejar la queue vacia
	 */
	public boolean removeAll(Collection<E> c) throws Exception {
		if(miQueue.size() - c.size() <= 0) {
			throw new Exception(new ElementBlockedException("ERR0R >>> No se puede eliminar todos los elementos de la queue <<< ERR0R"));
		} else {
			miQueue.removeAll(c);
			return true;
		}
	}

	/**
	 * Metodo que elimina de la queue todos los elementos que no se encuentren en la colecci�n dada
	 * @param c Colecci�n de la cual conservar elementos
	 * @return True en caso de haber podido remover elementos, False en caso contrario
	 * @throws Exception En caso de que se vaya a quedar vacia
	 */
	public boolean retainAll(Collection<E> c) throws Exception {
		//Creo una colecci�n auxiliar para comprobar si al aplicar el m�todo esta
		//quedar�a vacia, de ser as�, no se podr�a aplicar a la queue original y
		//lanzaria la exception
		ArrayList<E> aux = new ArrayList<E>();
		aux.addAll(miQueue);
		aux.retainAll(c);
		
		if(!aux.isEmpty()) 
			return miQueue.retainAll(c);
		else 
			throw new Exception(new ElementBlockedException("ERR0R >>> La queue no puede quedar vacia <<< ERR0R"));
	}

	/**
	 * Metodo que originalmente deber�a vaciar la queue, pero como no esta permitido, lanzar� una Exception
	 * @throws Exception No se puede vaciar la queue
	 */
	public void clear() throws Exception {
		throw new Exception(new ElementBlockedException("ERR0R >>> La queue no puede quedar vacia <<< ERR0R"));
	}

	/**
	 * A�ade el elemento dado a la queue y ordena la queue de forma ascendente
	 * @param e Elemento a a�adir
	 * @return True en caso de ser a�adido, False en caso contrario
	 * @throws LlevateTuNullDeAquiException En caso de querer introducir un elemento null
	 * @throws ColaExceededSizeException En caso de querer introducir un elemento con la queue llena
	 */
	public boolean add(E e) throws LlevateTuNullDeAquiException, ColaExceededSizeException {
		if(miQueue.size() < 10) { //Si mi queue aun no mide 10
			if(e.equals(null)) {//Si el elemento es null
				throw new LlevateTuNullDeAquiException("ERR0R >>> No se puede a�adir un elemento NULL <<< ERR0R");
			} else {
				miQueue.add(e);
				miQueue.sort(miComparador); //Siempre que se a�ada algo, se ordenara seg�n el comparador
				return true;
			}
		} else {
			throw new ColaExceededSizeException("ERR0R >>> La queue esta llena, por lo que no acepta nuevos elementos. Elimina uno primero <<< ERR0R");
		}
	}
	

	/**
	 * A�ade el elemento dado a la queue
	 * A diferencia con el add este ya incluye la excepci�n anti-nulls
	 * @param e Elemento a agregar
	 * @return True en caso de ser a�adido, False en caso contrario
	 * @throws LlevateTuNullDeAquiException En caso de querer introducir un elemento null
	 */
	public boolean offer(E e) throws ColaExceededSizeException {
		if(miQueue.size() < 10) { //Si mi queue aun no mide 10
				miQueue.add(e);
				return true;
		} else {
			throw new ColaExceededSizeException("ERR0R >>> La queue esta llena, por lo que no acepta nuevos elementos. Elimina uno primero <<< ERR0R");
		}
	}

	/**
	 * Remueve la cabeza de la queue (primer elemento) siempre y cuando esta no vaya a quedar vacia
	 * @return La cabeza de la queue y luego la remueve
	 * @throws Exception En caso de que solo haya 1 elemento en la queue
	 */
	public Object remove() throws Exception {
		if(miQueue.size() != 1) {
			return miQueue.remove(0);
		} else {
			throw new Exception(new ElementBlockedException("ERR0R >>> La queue no puede quedar vacia <<< ERR0R"));
		}
		
	}

	/**
	 * Remueve la cabeza de la queue (primer elemento). A diferencia de remove() si esta vacia devuelve null
	 * @return La cabeza de la queue y luego la remueve o null si la queue esta vacia
	 */
	public Object poll() {
		if(!miQueue.isEmpty()) {
			return miQueue.remove(0);
		} else {
			return null;
		}
	}

	/**
	 * Metodo que sirve para conocer la cabeza de la queue
	 * @return El primer elemento de la queue
	 */
	public Object element() {
		return miQueue.get(0);
	}

	/**
	 * Metodo igual que element() con la diferencia de que si la queue esta vacia, devolvera null
	 * @return El primer elemento de la queue
	 */
	public Object peek() {
		if(!miQueue.isEmpty()) {
			return miQueue.get(0);
		} else {
			return null;
		}
	}

}
