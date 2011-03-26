/**
 * Copyright (c) Stefan Muenchow. All rights reserved.
 * 
 * The use and distribution terms for this software are covered by the
 * Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 * which can be found in the file epl-v10.html at the root of this distribution.
 * By using this software in any fashion, you are agreeing to be bound by
 * the terms of this license.
 * You must not remove this notice, or any other, from this software.
 **/

package com.stefanmuenchow.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.stefanmuenchow.collections.function.Predicate;
import com.stefanmuenchow.collections.function.UnaryFunction;

public class SmartLinkedQueue<E> extends AbstractSmartCollection<E> implements SmartQueue<E> {

    public SmartLinkedQueue(final Collection<E> collection) {
        super(new LinkedList<E>(collection));
    }
    
    public SmartLinkedQueue() {
        this(new LinkedList<E>());
    }

    public SmartLinkedQueue(final E... elems) {
        this(Arrays.asList(elems));
    }

    /** Helper methods */

    private Queue<E> getInternalQueue() {
        return (Queue<E>) internalColl;
    }

    @Override
    protected SmartLinkedQueue<E> createNewInstance() {
        return new SmartLinkedQueue<E>();
    }

    @Override
    protected <T> SmartLinkedQueue<T> createNewInstance(final Collection<T> aColl) {
        return new SmartLinkedQueue<T>(aColl);
    }

    /** Queue methods */

    @Override
    public boolean offer(final E e) {
        return getInternalQueue().offer(e);
    }

    @Override
    public E remove() {
        return getInternalQueue().remove();
    }

    @Override
    public E poll() {
        return getInternalQueue().poll();
    }

    @Override
    public E element() {
        return getInternalQueue().element();
    }

    @Override
    public E peek() {
        return getInternalQueue().peek();
    }

	@Override
	public SmartQueue<E> offerReturn(E o) {
		offer(o);
		return this;
	}
	
    /** Overridden methods from SmartCollection */
    
    public SmartQueue<E> addReturn(E elem) {
    	return (SmartQueue<E>) super.addReturn(elem);
    }

    public SmartQueue<E> addAllReturn(Collection<E> coll) {
    	return (SmartQueue<E>) super.addAllReturn(coll);
    }
    
    public SmartQueue<E> removeReturn(E elem) {
    	return (SmartQueue<E>) super.removeReturn(elem);
    }
    
    public SmartQueue<E> removeAllReturn(Collection<E> coll) {
    	return (SmartQueue<E>) super.removeAllReturn(coll);
    }
    
    public SmartQueue<E> retainAllReturn(Collection<E> coll) {
    	return (SmartQueue<E>) super.retainAllReturn(coll);
    }
    
    public SmartQueue<E> filter(Predicate<? super E> predicate) {
    	return (SmartQueue<E>) super.filter(predicate);
    }
    
    public SmartQueue<E> remove(Predicate<? super E> predicate) {
    	return (SmartQueue<E>) super.remove(predicate);
    }
    
    public SmartQueue<E> replace(E seek, E replacement) {
    	return (SmartQueue<E>) super.replace(seek, replacement);
    }
    
    public SmartQueue<E> replace(Predicate<? super E> predicate, E replacement) {
    	return (SmartQueue<E>) super.replace(predicate, replacement);
    }
    
    public SmartQueue<E> replace(Map<E, E> replacements) {
    	return (SmartQueue<E>) super.replace(replacements);
    }
    
    @Override
    public <R> SmartQueue<R> map(final UnaryFunction<R, ? super E> function) {
        return (SmartQueue<R>) super.map(function);
    }

    @Override
    public <T> SmartQueue<T> castEach(final Class<T> clazz) {
        return (SmartQueue<T>) super.castEach(clazz);
    }
    
    @Override
    public Queue<E> toStandardCollection() {
    	return (Queue<E>) super.toStandardCollection();
    }
}
