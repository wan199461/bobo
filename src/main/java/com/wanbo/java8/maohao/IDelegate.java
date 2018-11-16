package com.wanbo.java8.maohao;

@FunctionalInterface
public interface IDelegate<T, F> {
  
  T delegate(F form);

}
