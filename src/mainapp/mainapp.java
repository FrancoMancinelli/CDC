package mainapp;

import java.util.ArrayList;
import java.util.Iterator;

import comparators.Compa;
import models.ColaDeCastigo;

public class mainapp {

	public static void main(String[] args) throws Exception {

		//Creo una cola de castigo sin utilizar expresión lambda
		Compa comparador1 = new Compa();
		@SuppressWarnings("unused")
		ColaDeCastigo<String> cdc2 = new ColaDeCastigo<String>(comparador1);
		
		//Creo una cola de castigo utilizando expresión lambda
		ColaDeCastigo<String> cdc = new ColaDeCastigo<String>((String s1, String s2) -> { return s1.compareTo(s2); });

		//Pruebo método isEmpty
		System.out.println("Queue isEmpty = " + cdc.isEmpty());
		
		//Pruebo método add
		cdc.add("B");
		cdc.add("F");
		cdc.add("A");
		cdc.add("D");
		cdc.add("C");
		cdc.add("G");
		cdc.add("E");
		cdc.add("K");
		cdc.add("J");
		
		//Pruebo método add intentando exceder el máximo
		//cdc.add("I");
		//cdc.add("H");

		
		//Pruebo método add cuando es null
		//cdc.add(null);
		
		//Pruebo el método iterator y lo uso para imprimir la cola
		recorrerQueue(cdc);
		
		//Pruebo método size
		System.out.println("Queue size = " + cdc.size());
	
		//Pruebo método isEmpty
		System.out.println("Queue isEmpty = " + cdc.isEmpty());
		
		//Pruebo método contains
		System.out.println("Queue contains(Z) = " + cdc.contains("Z"));
		System.out.println("Queue contains(A) = " + cdc.contains("A"));
		
		//Pruebo el método toArray
		Object[] prueba = cdc.toArray();
		//Compruebo que funciona viendo si tienen el mismo tamaño
		System.out.println("Queue toArray = " + prueba.length);
		
		//Pruebo el método remove(Object o)
		System.out.println("Queue remove(A) = " + cdc.remove("A"));
		System.out.println("Queue remove(B) = " + cdc.remove("B"));
		System.out.println("Queue remove(C) = " + cdc.remove("C"));
		System.out.println("Queue remove(D) = " + cdc.remove("D"));
		recorrerQueue(cdc);
		
		//Pruebo el método containAll
		ArrayList<String> prueba2 = new ArrayList<String>();
		prueba2.add("A");
		prueba2.add("Z");
		System.out.println("Queue containsAll = " + cdc.containsAll(prueba2));
		
		//Pruebo el método addAll
		System.out.println("Queue addAll = " + cdc.addAll(prueba2));
		recorrerQueue(cdc);

		//Pruebo el método removeAll
		System.out.println("Queue removeAll = " + cdc.removeAll(prueba2));
		recorrerQueue(cdc);
		
		//Pruebo el método retainAll - Comentar el removeAll antes para probar que funcione
		//System.out.println("Queue retainAll = " + cdc.retainAll(prueba2));
		//recorrerQueue(cdc);
		
		//Pruebo el métedo clear
		//cdc.clear();

		//Pruebo el método offer
		System.out.println("Queue offer (M) = " + cdc.offer("M"));
		System.out.println("Queue offer (N) = " + cdc.offer("N"));
		System.out.println("Queue offer (L) = " + cdc.offer("L"));
		recorrerQueue(cdc);
		
		//Pruebo el método remove
		System.out.println("Queue remove = " + cdc.remove());
		recorrerQueue(cdc);
		
		//Pruebo el método poll
		System.out.println("Queue poll = " + cdc.poll());
		recorrerQueue(cdc);
		
		//Pruebo el método element
		System.out.println("Queue element = " + cdc.element());

		//Pruebo el método peek
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
