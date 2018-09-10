package dataStructures;
import java.io.Serializable;

public interface StackIterator<E> extends Stack<E>, Serializable{

	
	Iterator<E> iterator();
}
