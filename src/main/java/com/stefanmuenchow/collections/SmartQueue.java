/**
 * Copyright (c) Stefan Muenchow. All rights reserved.
 * The use and distribution terms for this software are covered by the
 * Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 * which can be found in the file epl-v10.html at the root of this distribution.
 * By using this software in any fashion, you are agreeing to be bound by
 * the terms of this license.
 * You must not remove this notice, or any other, from this software.
 **/

package com.stefanmuenchow.collections;

import java.util.Queue;

import com.stefanmuenchow.collections.function.UnaryFunction;

/**
 * A SmartQueue is an ordered collection that can hold duplicate elements.
 * In contrast to lists, there are some restrictions on the elements'
 * accessability. Elements are ordered in an FIFO (First-In-First-Out) manner.
 * This means that elements can be retrieved only from the head of the queue
 * and inserted only at the end.
 * 
 * @see Queue
 * @see SmartLinkedQueue
 *
 * @author Stefan Muenchow
 */
public interface SmartQueue<E> extends Queue<E>, SmartCollection<E> {

	/**
	 * Inserts the specified element at the end of this queue. Changes the
	 * original queue.
	 * 
	 * @param o		Element to insert
	 * @return		Queue with element added.
	 */
	SmartQueue<E> offerReturn(E o);
	
	/**
	 * @see SmartCollection#map(UnaryFunction)
	 */
    @Override
    <R> SmartQueue<R> map(UnaryFunction<R, ? super E> function);

    /**
     * @see SmartCollection#castEach(Class)
     */
    @Override
    <T> SmartQueue<T> castEach(Class<T> clazz);
    
    /**
     * @see SmartCollection#toStandardCollection()
     */
    @Override
    Queue<E> toStandardCollection();
}
