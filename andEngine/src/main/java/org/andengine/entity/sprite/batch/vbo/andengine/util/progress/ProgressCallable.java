package org.andengine.entity.sprite.batch.vbo.andengine.util.progress;


import org.andengine.util.progress.IProgressListener;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 20:52:44 - 03.01.2010
 */
public interface ProgressCallable<T> {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Computes a result, or throws an exception if unable to do so.
	 * @param pProgressListener
	 * @return computed result
	 * @throws Exception if unable to compute a result
	 */
	public T call(final IProgressListener pProgressListener) throws Exception;
}