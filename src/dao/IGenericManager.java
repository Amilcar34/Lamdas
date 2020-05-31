package dao;

import java.util.List;

@FunctionalInterface
public interface IGenericManager<T> {

	List<T> getAll();

}
