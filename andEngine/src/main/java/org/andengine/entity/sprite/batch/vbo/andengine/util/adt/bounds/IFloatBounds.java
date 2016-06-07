package org.andengine.entity.sprite.batch.vbo.andengine.util.adt.bounds;

import org.andengine.util.adt.bounds.IBounds;

/**
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 7:42:02 AM - Oct 10, 2011
 */
public interface IFloatBounds extends IBounds {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public float getXMin();
	public float getYMin();
	public float getXMax();
	public float getYMax();
}
