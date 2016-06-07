package org.andengine.entity.sprite.batch.vbo.andengine.util.modifier.ease;

import org.andengine.util.modifier.ease.*;
import org.andengine.util.modifier.ease.EaseStrongIn;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Gil
 * @author Nicolas Gramlich
 * @since 16:52:11 - 26.07.2010
 */
public class EaseStrongInOut implements IEaseFunction {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static org.andengine.util.modifier.ease.EaseStrongInOut INSTANCE;

	// ===========================================================
	// Constructors
	// ===========================================================

	private EaseStrongInOut() {

	}

	public static org.andengine.util.modifier.ease.EaseStrongInOut getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new org.andengine.util.modifier.ease.EaseStrongInOut();
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
			return 0.5f * EaseStrongIn.getValue(2 * percentage);
		} else {
			return 0.5f + 0.5f * EaseStrongOut.getValue(percentage * 2 - 1);
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
