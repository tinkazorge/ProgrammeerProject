package org.andengine.entity.sprite.batch.vbo.andengine.util.modifier.ease;

import org.andengine.util.modifier.ease.EaseExponentialIn;
import org.andengine.util.modifier.ease.EaseExponentialOut;
import org.andengine.util.modifier.ease.IEaseFunction;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Gil
 * @author Nicolas Gramlich
 * @since 16:52:11 - 26.07.2010
 */
public class EaseExponentialInOut implements IEaseFunction {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static org.andengine.util.modifier.ease.EaseExponentialInOut INSTANCE;

	// ===========================================================
	// Constructors
	// ===========================================================

	private EaseExponentialInOut() {

	}

	public static org.andengine.util.modifier.ease.EaseExponentialInOut getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new org.andengine.util.modifier.ease.EaseExponentialInOut();
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
			return 0.5f * EaseExponentialIn.getValue(2 * percentage);
		} else {
			return 0.5f + 0.5f * EaseExponentialOut.getValue(percentage * 2 - 1);
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}