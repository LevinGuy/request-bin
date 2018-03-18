package com.levin.guy.bin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class Repository<T>
{
	private Map<String, T> entities = new ConcurrentHashMap<String, T>();
	
	public <S extends T> S save(String key, S entity) {
		Assert.notNull(entity, "Entity must not be null!");
		entities.put(key, entity);
		return entity;
	}

	public T findOne(String id) {
		Assert.notNull(id, "The given id must not be null!");
		return entities.get(id);
	}

	public boolean exists(String id) {
		Assert.notNull(id, "The given id must not be null!");
		return entities.containsKey(id);
	}

	public long count() {
		return entities.size();
	}

	public void delete(String id) {
		Assert.notNull(id, "The given id must not be null!");
		entities.remove(id);
	}

	
	private static <T> List<T> convertIterableToList(Iterable<T> entities) {

		if (entities instanceof List) {
			return (List<T>) entities;
		}

		int capacity = tryDetermineRealSizeOrReturn(entities, 10);

		if (capacity == 0 || entities == null) {
			return Collections.<T> emptyList();
		}

		List<T> list = new ArrayList<T>(capacity);
		for (T entity : entities) {
			list.add(entity);
		}

		return list;
	}

	private static int tryDetermineRealSizeOrReturn(Iterable<?> iterable, int defaultSize) {
		return iterable == null ? 0 : (iterable instanceof Collection) ? ((Collection<?>) iterable).size() : defaultSize;
	}

	
}
