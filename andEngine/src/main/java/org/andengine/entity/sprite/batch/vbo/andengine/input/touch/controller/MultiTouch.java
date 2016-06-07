package org.andengine.entity.sprite.batch.vbo.andengine.input.touch.controller;

import org.andengine.util.system.SystemUtils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 16:00:38 - 14.07.2010
 */
public final class MultiTouch {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static Boolean sSupported;
	private static Boolean sSupportedDistinct;

	// ===========================================================
	// Constructors
	// ===========================================================

	private MultiTouch() {

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public static boolean isSupported(final Context pContext) {
		if (org.andengine.input.touch.controller.MultiTouch.sSupported == null) {
			org.andengine.input.touch.controller.MultiTouch.sSupported = SystemUtils.hasSystemFeature(pContext, PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH, false);
		}

		return org.andengine.input.touch.controller.MultiTouch.sSupported;
	}

	public static boolean isSupportedDistinct(final Context pContext) {
		if (org.andengine.input.touch.controller.MultiTouch.sSupportedDistinct == null) {
			org.andengine.input.touch.controller.MultiTouch.sSupportedDistinct = SystemUtils.hasSystemFeature(pContext, PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT, false);
		}

		return org.andengine.input.touch.controller.MultiTouch.sSupportedDistinct;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
