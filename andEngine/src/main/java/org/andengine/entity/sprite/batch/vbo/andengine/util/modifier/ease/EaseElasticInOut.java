package org.andengine.entity.sprite.batch.vbo.andengine.util.modifier.ease;


import org.andengine.util.modifier.ease.*;
import org.andengine.util.modifier.ease.EaseElasticOut;
import org.andengine.util.modifier.ease.IEaseFunction;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Gil
 * @author Nicolas Gramlich
 * @since 16:52:11 - 26.07.2010
 */
public class EaseElasticInOut implements IEaseFunction {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static org.andengine.util.modifier.ease.EaseElasticInOut INSTANCE;

	// ===========================================================
	// Constructors
	// ===========================================================

	private EaseElasticInOut() {

	}

	public static org.andengine.util.modifier.ease.EaseElasticInOut getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new org.andengine.util.modifier.ease.EaseElasticInOut();
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
		final float percentage = pSecondsElapsed / pDuration;

		if (percentage < 0.5f) {
			return 0.5f * EaseElasticIn.getValue(2 * pSecondsElapsed, pDuration, 2 * percentage);
		} else {
			return 0.5f + 0.5f * EaseElasticOut.getValue(pSecondsElapsed * 2 - pDuration, pDuration, percentage * 2 - 1);
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
