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
	 * @return Devuelve un int que representa el tamaño de la queue
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
	 * Metodo que elimina un objeto indicado de la queue solo si hay más de 1 elemento en ella.
	 * @param o Objeto a eliminar
	 * @return True si se encontro y se elimino
	 * @throws Exception Por intentar eliminar un objeto de la queue cuando solo queda 1 elemento
	 */
	public boolean remove(Object o) throws Exception {
		if(miQueue.size() > 1) { //Si tienes más de 1 objeto en el array...
			miQueue.remove(o);
			return true;
		} else { 
			throw new Exception(new ElementBlockedException("ERR0R >>> No se puede eliminar el último objeto de la queue <<< ERR0R"));
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
	 * Método que nos permite añadir una colección entera a nuestra queue
	 * @param c Coleccion a añadir
	 * @return True en caso de que se haya podido añadir la coleccion, de lo contrario False
	 * @throws LlevateTuNullDeAquiException  En caso de que la coleccion contenga un null
	 * @throws ColaExceededSizeException En caso de que se quieran añadir muchos elementos, sobrepasando el máximo de 10
	 */
	public boolean addAll(Collection<E> c) throws LlevateTuNullDeAquiException, ColaExceededSizeException {
		if(c.size() + miQueue.size() < 10) { //Si el tamaño de la colección y del array no superan 10
			if(c.contains(null)) { //Si la coleccion tiene un null
				throw new LlevateTuNullDeAquiException("ERR0R >>> La colección tiene un elemento NULL que no puede ser agregado <<< ERR0R");
			} else {
				miQueue.addAll(c);
				return true;
			}
		} else {
			throw new ColaExceededSizeException("ERR0R >>> Esa coleccion no cabe en esta queue (Máximo 10 elementos) <<< ERR0R");
		} 
	}

	/**
	 * Metodo que elimina de la queue todos los elementos que esten en la colección dada
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
	 * Metodo que elimina de la queue todos los elementos que no se encuentren en la colección dada
	 * @param c Colección de la cual conservar elementos
	 * @return True en caso de haber podido remover elementos, False en caso contrario
	 * @throws Exception En caso de que se vaya a quedar vacia
	 */
	public boolean retainAll(Collection<E> c) throws Exception {
		//Creo una colección auxiliar para comprobar si al aplicar el método esta
		//quedaría vacia, de ser así, no se podría aplicar a la queue original y
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
	 * Metodo que originalmente debería vaciar la queue, pero como no esta permitido, lanzará una Exception
	 * @throws Exception No se puede vaciar la queue
	 */
	public void clear() throws Exception {
		throw new Exception(new ElementBlockedException("ERR0R >>> La queue no puede quedar vacia <<< ERR0R"));
	}

	/**
	 * Añade el elemento dado a la queue y ordena la queue de forma ascendente
	 * @param e Elemento a añadir
	 * @return True en caso de ser añadido, False en caso contrario
	 * @throws LlevateTuNullDeAquiException En caso de querer introducir un elemento null
	 * @throws ColaExceededSizeException En caso de querer introducir un elemento con la queue llena
	 */
	public boolean add(E e) throws LlevateTuNullDeAquiException, ColaExceededSizeException {
		if(miQueue.size() < 10) { //Si mi queue aun no mide 10
			if(e.equals(null)) {//Si el elemento es null
				throw new LlevateTuNullDeAquiException("ERR0R >>> No se puede añadir un elemento NULL <<< ERR0R");
			} else {
				miQueue.add(e);
				miQueue.sort(miComparador); //Siempre que se añada algo, se ordenara según el comparador
				return true;
			}
		} else {
			throw new ColaExceededSizeException("ERR0R >>> La queue esta llena, por lo que no acepta nuevos elementos. Elimina uno primero <<< ERR0R");
		}
	}
	

	/**
	 * Añade el elemento dado a la queue
	 * A diferencia con el add este ya incluye la excepción anti-nulls
	 * @param e Elemento a agregar
	 * @return True en caso de ser añadido, False en caso contrario
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
