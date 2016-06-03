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
public class EaseExponentialIn implements IEaseFunction {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static org.andengine.util.modifier.ease.EaseExponentialIn INSTANCE;

	// ===========================================================
	// Constructors
	// ===========================================================

	private EaseExponentialIn() {

	}

	public static org.andengine.util.modifier.ease.EaseExponentialIn getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new org.andengine.util.modifier.ease.EaseExponentialIn();
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
		return org.andengine.util.modifier.ease.EaseExponentialIn.getValue(pSecondsElapsed / pDuration);

	}

	// ===========================================================
	// Methods
	// ===========================================================

	public static float getValue(final float pPercentage) {
		return (float) ((pPercentage == 0) ? 0 : Math.pow(2, 10 * (pPercentage - 1)) - 0.001f);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
