/**
*
*/
package org.example.model;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.Set;



/**
 * Un ListIterator fusionnant plusieurs ExtendedListIterator en interdisant
 * toutes les opérations de modification (i.e. add, remove, set).
 *
 * Un FusionSortedIterator garantie que, si les ListIterator fusionnés sont
 * ordonnés, alors ce FusionSortedIterator sera également ordonné.
 *
 * Par défaut, l'ordre considéré est l'ordre naturel entre les éléments,
 * cependant un ordre alternatif peut-être spécifié à la création de l'instance.
 * 
 * @param <E> le type des éléments énumérés par cet itérateur
 * @param <I> le type des itérateurs fusionnés
 *
 * @model ListIterObserver<Post> iterModel = new
 *        ListIterObserverAdapter<Post>(self);
 * @invariant nextIndex() == previousIndex() + 1;
 * @invariant lastIndex() == nextIndex() || lastIndex() == previousIndex();
 * @invariant previousIndex() >= -1 && previousIndex() < iterModel.size());
 * @invariant nextIndex() >= 0 && nextIndex() <= iterModel.size());
 * @invariant lastIndex() >= -1 && lastIndex() < iterModel.size());
 * @invariant lastIndex() == -1 <==> lastIterator() == null;
 * @invariant !hasPrevious() <==> previousIndex() == -1;
 * @invariant !iterModel.contains(null);
 * @invariant iterModel.isSorted(comparator());
 * @invariant comparator() != null;
 * 
 * @author Marc Champesme
 * @since 2/08/2023
 * @version 8/12/2023
 *
 */
public class FusionSortedIterator<E extends Comparable<? super E>, I extends ExtendedListIterator<? extends E>>
		implements ListIterator<E> {

	/**
	 * Initialise une instance permettant d'itérer selon l'ordre "naturel" sur tous
	 * les éléments des ListIterator de l'ensemble spécifié. Il s'agit donc d'une
	 * fusion de tous les ListIterator contenus dans l'ensemble spécifié. Les
	 * ListIterator spécifiés sont supposés ordonnés selon l'ordre "naturel" de
	 * leurs éléments.
	 *
	 * @param iters ensemble des ListIterator à fusionner
	 *
	 * @requires iters != null && !iters.contains(null);
	 * @ensures (\forall ListIterator<Post> iter; postIterators.contains(iter);
	 *          iterModel.containsAll(toList(iter)));
	 * @ensures iterModel.size() == (\sum ListIterator<Post> iter;
	 *          postIterators.contains(iter); size(iter));
	 * @ensures (\forall Post p; iterModel.contains(p); (\exists ListIterator<Post>
	 *          iter; postIterators.contains(iter); contains(iter, p)));
	 * @ensures !hasPrevious();
	 * @ensures lastIndex() == -1;
	 * @ensures lastIterator() == null;
	 * @ensures (\forall I iter; iters.contains(iter); !iter.hasPrevious() &&
	 *          iter.lastIndex() == -1);
	 * @ensures comparator() != null;
	 *
	 * @throws NullPointerException si l'ensemble spécifié est null ou contient null
	 */
	public FusionSortedIterator(Set<? extends I> iters) {
	}

	/**
	 * Initialise une instance permettant d'itérer sur tous les éléments des
	 * ListIterator de l'ensemble spécifié selon l'ordre spécifié. Il s'agit donc
	 * d'une fusion de tous les ListIterator contenus dans l'ensemble spécifié. les
	 * ListIterator contenus dans l'ensemble spécifié sont supposés ordonnés selon
	 * l'ordre induit par le Comparator spécifié.
	 *
	 *
	 * @param iters      ensemble des ListIterator à fusionner
	 * @param comparator le comparateur à utiliser
	 *
	 * @requires iters != null && !iters.contains(null);
	 * @requires comparator != null;
	 * @ensures comparator() != null;
	 * @ensures !hasPrevious();
	 * @ensures lastIndex() == -1;
	 * @ensures lastIterator() == null;
	 * @ensures (\forall I iter; iters.contains(iter); !iter.hasPrevious() &&
	 *          iter.lastIndex() == -1);
	 *
	 * @throws NullPointerException si l'ensemble spécifié est null ou contient
	 *                              null, ou si le Comparator spécifié est null
	 */
	public FusionSortedIterator(Set<? extends I> iters, Comparator<? super E> comparator) {
	}

	/**
	 * (Re)Initialise ce ListIterateur pour le démarrage d'une nouvelle itération
	 * sur ses éléments.
	 * 
	 * @ensures !hasPrevious();
	 * @ensures previousIndex() == -1;
	 * @ensures nextIndex() == 0;
	 * @ensures lastIndex() == -1;
	 * @ensures lastIterator() == null;
	 */
	public void startIteration() {
	}

	/**
	 * Renvoie le comparateur selon lequel les éléments de cet itérateur sont
	 * ordonnés.
	 * 
	 * @return le comparateur selon lequel les éléments de cet itérateur sont
	 *         ordonnés
	 * 
	 * @ensures \result != null;
	 * 
	 * @pure
	 */
	public Comparator<? super E> comparator() {
		return null;
	}

	/**
	 * Renvoie l'itérateur ayant produit l'élément lors du dernier appel à next() ou
	 * previous().
	 * 
	 * @return l'itérateur ayant produit l'élément lors du dernier appel à next() ou
	 *         previous()
	 * 
	 * @pure
	 */
	public I lastIterator() {
		return null;
	}

	/**
	 * Renvoie l'index pour cet itérateur du dernier élément retourné par next() ou
	 * previous().
	 * 
	 * @return l'index du dernier élément retourné par next() ou previous()
	 * 
	 * @pure
	 */
	public int lastIndex() {
		return -1;
	}

	/**
	 * Renvoie true s'il reste un élément après dans l'itération.
	 * 
	 * @return true s'il reste un élément après dans l'itération; false sinon
	 * 
	 * @ensures !\result <==> nextIndex() == iterModel.size();
	 * 
	 * @pure
	 */
	@Override
	public boolean hasNext() {
		return false;
	}

	/**
	 * Renvoie l'élément suivant et avance le curseur.
	 *
	 * @return l'élément suivant
	 *
	 * @throws NoSuchElementException si l'itérateur n'a pas d'élément suivant
	 *
	 * @requires hasNext();
	 * @ensures \result != null;
	 * @ensures lastIterator() != null;
	 * @ensures \result.equals(lastIterator().getPrevious());
	 * @ensures \result.equals(iterModel.get(previousIndex()))
	 * @ensures \result.equals(\old(iterModel.get(nextIndex())));
	 * @ensures \old(hasPrevious()) ==> comparator().compare(iterModel.get(\old(previousIndex())), \result) <= 0;
	 * @ensures hasPrevious();
	 * @ensures previousIndex() == \old(nextIndex());
	 * @ensures nextIndex() == \old(nextIndex() + 1);
	 * @ensures lastIndex() == \old(nextIndex());
	 */
	@Override
	public E next() {
		return null;
	}

	/**
	 * Renvoie true s'il y a un élément précédent dans l'itération.
	 * 
	 * @return true s'il y a un élément précédent dans l'itération; false sinon
	 * 
	 * @ensures !\result <==> previousIndex() == -1;
	 *
	 * @pure
	 */
	@Override
	public boolean hasPrevious() {
		return false;
	}

	/**
	 * Renvoie l'élément précédent et recule le curseur.
	 *
	 * @return l'élément précédent
	 *
	 * @throws NoSuchElementException si l'itérateur n'a pas d'élément précédent
	 *
	 * @requires hasPrevious();
	 * @ensures hasNext();
	 * @ensures \result != null;
	 * @ensures lastIterator() != null;
	 * @ensures \result.equals(lastIterator().getNext());
	 * @ensures \result.equals(\old(iterModel.get(previousIndex())));
	 * @ensures \result.equals(iterModel.get(nextIndex()));
	 * @ensures \old(hasNext()) ==> comparator().compare(\result, iterModel.get(\old(nextIndex())) <= 0;
	 * @ensures previousIndex() == \old(previousIndex()) - 1;
	 * @ensures nextIndex() == \old(nextIndex()) - 1;
	 * @ensures lastIndex() == \old(previousIndex());
	 */
	@Override
	public E previous() {
		return null;
	}

	/**
	 * Renvoie l'index de l'élément suivant dans l'itération. Renvoie le nombre
	 * total d'élément dans l'itération s'il n'y a pas d'élément suivant.
	 * 
	 * @return l'index de l'élément suivant dans l'itération
	 * 
	 * @ensures hasNext() <==> \result >= 0 && \result < iterModel.size();
	 * @ensures !hasNext() <==> \result == iterModel.size();
	 * 
	 * @pure
	 */
	@Override
	public int nextIndex() {
		return -1;
	}

	/**
	 * Renvoie l'index de l'élément précédent dans l'itération. Renvoie -1 s'il n'y
	 * a pas d'élément précédent.
	 * 
	 * @return l'index de l'élément précédent dans l'itération
	 * 
	 * @ensures hasPrevious() ==> \result >= 0;
	 * @ensures !hasPrevious() <==> \result == -1;
	 *
	 * @pure
	 */
	@Override
	public int previousIndex() {
		return -1;
	}

	/**
	 * Opération non supportée.
	 * 
	 * @throws UnsupportedOperationException toujours
	 */
	@Override
	public void remove() {
	}

	/**
	 * Opération non supportée.
	 * 
	 * @throws UnsupportedOperationException toujours
	 */
	@Override
	public void set(E e) {
	}

	/**
	 * Opération non supportée.
	 * 
	 * @throws UnsupportedOperationException toujours
	 */
	@Override
	public void add(E e) {
	}

}
