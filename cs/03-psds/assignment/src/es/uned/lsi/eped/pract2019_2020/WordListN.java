package es.uned.lsi.eped.pract2019_2020;

public class WordListN {
	/* Atributos de la clase con la estructura adecuada */
	...
	/* Atributos de la clase con la estructura adecuada */

	public WordListN(int size) {...}
	
	public void add(String word) {...}
	
	public int getWordSize() {...}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		int numPalabras = /* Longitud de la secuencia de palabras */
		salida.append("-Palabras de ");
		salida.append(this.getWordSize());
		salida.append(" letra");
		if ( this.getWordSize() > 1 ) { salida.append('s'); }
		salida.append(": ");
		for (int pos = 1 ; pos <= numPalabras ; pos++) {
			/* Estas líneas dependen de la estructura escogida */
			String word = /* Obtener la siguiente palabra */
			/* Avanzar a la siguiente sin destruir la estructura */
			...
			/* Estas líneas dependen de la estructura escogida */
			salida.append(word);
			if ( pos < numPalabras ) {
				salida.append(", ");
			}
		}
		salida.append('\n');
		return salida.toString();
	}
}
