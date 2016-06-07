package org.andengine.entity.sprite.batch.vbo.andengine.util.modifier.ease;

import org.andengine.util.modifier.ease.IEaseFunction;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Gil
 * @author Nicolas Gramlich
 * @since 16:52:11 - 26.07.2010
 */
public class EaseQuartIn implements IEaseFunction {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static org.andengine.util.modifier.ease.EaseQuartIn INSTANCE;

	// ===========================================================
	// Constructors
	// ===========================================================

	private EaseQuartIn() {

	}

	public static org.andengine.util.modifier.ease.EaseQuartIn getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new org.andengine.util.modifier.ease.EaseQuartIn();
		}
		return INSTANCE;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public float getPercentage(final float pSecondsElapsed, final float pDuration) {
		return org.andengine.util.modifier.ease.EaseQuartIn.getValue(pSecondsElapsed / pDuration);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	public static float getValue(final float pPercentage) {
		return pPercentage * pPercentage * pPercentage * pPercentage;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}