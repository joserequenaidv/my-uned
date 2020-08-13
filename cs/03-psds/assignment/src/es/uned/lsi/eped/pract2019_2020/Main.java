package es.uned.lsi.eped.pract2019_2020;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static void printUsage() {
		System.err.println("Error en los parámetros de entrada:");
		System.err.println("-Primer parámetro: nombre del fichero con el diccionario de palabras");
		System.err.println("-Segundo parámetro: nombre del fichero con las secuencias de letras a buscar");
	}
	
	public static void main(String [] args) throws IOException{
		if ( args.length != 2 ) {
			/* Se necesitan, exactamente, dos parámetros */
			printUsage();
		} else {
			/* Primer parámetro: fichero con el diccionario */
			String dict = args[0];
			Dictionary diccionario = new Dictionary();
			try {
				BufferedReader inDict = new BufferedReader(new InputStreamReader(new 
						FileInputStream(dict), "UTF-8"));
				String word;
				while ((word = inDict.readLine())!=null) {
					diccionario.insert(word);
				}
				inDict.close();
			} catch (IOException ex) {
				/* Error en el primer parámetro */
				System.err.println("No se puede abrir el fichero de diccionario para su lectura.");
			}
			/* Segundo parámetro: fichero de secuencias a buscar */
			String letterSequences = args[1];
			try {
				BufferedReader inSequences = new BufferedReader(new InputStreamReader(new 
						FileInputStream(letterSequences), "UTF-8"));
				String input;
				while((input = inSequences.readLine())!=null) {
					/* Separamos secuencia de tamaño */
					String[] data = input.split(" ");
					String sequence = data[0];
					System.out.println("Secuencia: \""+ sequence + "\"");
					if ( data[1].equalsIgnoreCase("ALL") ) {
						/* Se piden todos los tamaños de palabra */
						System.out.print(diccionario.search(sequence).toString());
					} else {
						/* Se pide un tamaño concreto de palabra */
						int len = Integer.parseInt(data[1]);
						System.out.print(diccionario.search(sequence,len).toString());
					}
					System.out.println("");
				}
				inSequences.close();
			} catch (IOException ex) {
				/* Error en el segundo parámetro */
				System.err.println("No se puede abrir el fichero de secuencias de letras para su lectura.");
			}
		}
	}
}
