package org.andengine.entity.sprite.batch.vbo.andengine.util.call;

import org.andengine.util.call.*;
import org.andengine.util.call.Callback;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 15:00:30 - 14.05.2010
 * @param <T>
 */
public interface AsyncCallable<T> {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Computes a result asynchronously, return values and exceptions are to be handled through the callbacks.
	 * This method is expected to return almost immediately, after starting a {@link Thread} or similar.
	 *
	 * @return computed result
	 * @throws Exception if unable to compute a result
	 */
	public void call(final org.andengine.util.call.Callback<T> pCallback, final Callback<Exception> pExceptionCallback);
}