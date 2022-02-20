package mainapp;

import java.util.ArrayList;
import java.util.Iterator;

import comparators.Compa;
import models.ColaDeCastigo;

public class mainapp {

	public static void main(String[] args) throws Exception {

		//Creo una cola de castigo sin utilizar expresi�n lambda
		Compa comparador1 = new Compa();
		@SuppressWarnings("unused")
		ColaDeCastigo<String> cdc2 = new ColaDeCastigo<String>(comparador1);
		
		//Creo una cola de castigo utilizando expresi�n lambda
		ColaDeCastigo<String> cdc = new ColaDeCastigo<String>((String s1, String s2) -> { return s1.compareTo(s2); });

		//Pruebo m�todo isEmpty
		System.out.println("Queue isEmpty = " + cdc.isEmpty());
		
		//Pruebo m�todo add
		cdc.add("B");
		cdc.add("F");
		cdc.add("A");
		cdc.add("D");
		cdc.add("C");
		cdc.add("G");
		cdc.add("E");
		cdc.add("K");
		cdc.add("J");
		
		//Pruebo m�todo add intentando exceder el m�ximo
		//cdc.add("I");
		//cdc.add("H");

		
		//Pruebo m�todo add cuando es null
		//cdc.add(null);
		
		//Pruebo el m�todo iterator y lo uso para imprimir la cola
		recorrerQueue(cdc);
		
		//Pruebo m�todo size
		System.out.println("Queue size = " + cdc.size());
	
		//Pruebo m�todo isEmpty
		System.out.println("Queue isEmpty = " + cdc.isEmpty());
		
		//Pruebo m�todo contains
		System.out.println("Queue contains(Z) = " + cdc.contains("Z"));
		System.out.println("Queue contains(A) = " + cdc.contains("A"));
		
		//Pruebo el m�todo toArray
		Object[] prueba = cdc.toArray();
		//Compruebo que funciona viendo si tienen el mismo tama�o
		System.out.println("Queue toArray = " + prueba.length);
		
		//Pruebo el m�todo remove(Object o)
		System.out.println("Queue remove(A) = " + cdc.remove("A"));
		System.out.println("Queue remove(B) = " + cdc.remove("B"));
		System.out.println("Queue remove(C) = " + cdc.remove("C"));
		System.out.println("Queue remove(D) = " + cdc.remove("D"));
		recorrerQueue(cdc);
		
		//Pruebo el m�todo containAll
		ArrayList<String> prueba2 = new ArrayList<String>();
		prueba2.add("A");
		prueba2.add("Z");
		System.out.println("Queue containsAll = " + cdc.containsAll(prueba2));
		
		//Pruebo el m�todo addAll
		System.out.println("Queue addAll = " + cdc.addAll(prueba2));
		recorrerQueue(cdc);

		//Pruebo el m�todo removeAll
		System.out.println("Queue removeAll = " + cdc.removeAll(prueba2));
		recorrerQueue(cdc);
		
		//Pruebo el m�todo retainAll - Comentar el removeAll antes para probar que funcione
		//System.out.println("Queue retainAll = " + cdc.retainAll(prueba2));
		//recorrerQueue(cdc);
		
		//Pruebo el m�tedo clear
		//cdc.clear();

		//Pruebo el m�todo offer
		System.out.println("Queue offer (M) = " + cdc.offer("M"));
		System.out.println("Queue offer (N) = " + cdc.offer("N"));
		System.out.println("Queue offer (L) = " + cdc.offer("L"));
		recorrerQueue(cdc);
		
		//Pruebo el m�todo remove
		System.out.println("Queue remove = " + cdc.remove());
		recorrerQueue(cdc);
		
		//Pruebo el m�todo poll
		System.out.println("Queue poll = " + cdc.poll());
		recorrerQueue(cdc);
		
		//Pruebo el m�todo element
		System.out.println("Queue element = " + cdc.element());

		//Pruebo el m�todo peek
		System.out.println("Queue peek = " + cdc.peek());

		
	}
	
	public static void recorrerQueue(ColaDeCastigo<String> cdc) {
		
		Iterator<String> iterador = cdc.iterator();
		System.out.print("Queue elementos = ");
		while(iterador.hasNext()) {
			System.out.print(iterador.next() + ", ");
		}
		System.out.print("\n");
	}
}
