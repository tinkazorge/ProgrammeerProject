package org.andengine.entity.sprite.batch.vbo.andengine.util.algorithm.path;

import org.andengine.util.algorithm.path.IPathFinderMap;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 23:00:24 - 16.08.2010
 */
public interface ICostFunction<T> {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	public float getCost(final IPathFinderMap<T> pPathFinderMap, final int pFromX, final int pFromY, final int pToX, final int pToY, final T pEntity);
}
