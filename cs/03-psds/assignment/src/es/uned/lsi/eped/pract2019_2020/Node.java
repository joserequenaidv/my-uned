package es.uned.lsi.eped.pract2019_2020;

public abstract class Node {
	public enum NodeType {
		ROOTNODE, LETTERNODE, WORDNODE
	}
	
	/* Prescribe un getter que devuelve el tipo de nodo */
	public abstract NodeType getNodeType();
}
