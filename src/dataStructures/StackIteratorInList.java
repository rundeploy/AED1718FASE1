package dataStructures;

public class StackIteratorInList<E> extends StackInList<E> implements StackIterator<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Iterator<E> iterator() {
		
		return list.iterator();
	}

}
