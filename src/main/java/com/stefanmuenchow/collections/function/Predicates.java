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

package com.stefanmuenchow.collections.function;

import java.util.Collection;

public class Predicates {
    public static final <T extends Number> Predicate<T> evenPred() {
        return new Predicate<T>() {

            @Override
            public boolean test(final T input) {
                return input.intValue() % 2 == 0;
            }
        };
    }
    
    public static final <T extends Number> Predicate<T> oddPred() {
        return new Predicate<T>() {

            @Override
            public boolean test(final T input) {
                return !evenPred().test(input);
            }
        };
    }
    
    public static final Predicate<String> containsPred(final String obj) {
    	return new Predicate<String>() {
    		private final String toFind = obj;
    		
			@Override
			public boolean test(String input) {
				return input.contains(toFind);
			}
		};
    }
    
    public static final Predicate<Collection<Object>> containsPred(final Object obj) {
    	return new Predicate<Collection<Object>>() {
    		private final Object toFind = obj;
    		
			@Override
			public boolean test(Collection<Object> input) {
				return input.contains(toFind);
			}
		};
    }
    
    public static final <T> Predicate<T> equalsPred(final T obj) {
    	return new Predicate<T>() {
    		private final T toComp = obj;
    		
			@Override
			public boolean test(T input) {
				return input.equals(toComp);
			}
		};
    }
    
    public static final <T extends Comparable<T>> Predicate<T> lessThanPred(final T obj) {
    	return new Predicate<T>() {
    		private final T toComp = obj;
    		
			@Override
			public boolean test(T input) {
				return input.compareTo(toComp) < 0;
			}
		};
    }
    
    public static final <T extends Comparable<T>> Predicate<T> lessEqualThanPred(final T obj) {
    	return new Predicate<T>() {
    		private final T toComp = obj;
    		
			@Override
			public boolean test(T input) {
				return input.compareTo(toComp) <= 0;
			}
		};
    }
    
    public static final <T extends Comparable<T>> Predicate<T> greaterThanPred(final T obj) {
    	return new Predicate<T>() {
    		private final T toComp = obj;
    		
			@Override
			public boolean test(T input) {
				return input.compareTo(toComp) > 0;
			}
		};
    }
    
    public static final <T extends Comparable<T>> Predicate<T> greaterEqualThanPred(final T obj) {
    	return new Predicate<T>() {
    		private final T toComp = obj;
    		
			@Override
			public boolean test(T input) {
				return input.compareTo(toComp) >= 0;
			}
		};
    }
}
