package org.andengine.entity.sprite.batch.vbo.andengine.util.preferences;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 18:55:12 - 02.08.2010
 */
public class SimplePreferences {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static SharedPreferences INSTANCE;
	private static Editor EDITORINSTANCE;

	// ===========================================================
	// Constructors
	// ===========================================================

	public static SharedPreferences getInstance(final Context pContext) {
		if (org.andengine.util.preferences.SimplePreferences.INSTANCE == null) {
			org.andengine.util.preferences.SimplePreferences.INSTANCE = PreferenceManager.getDefaultSharedPreferences(pContext);
		}
		return org.andengine.util.preferences.SimplePreferences.INSTANCE;
	}

	public static Editor getEditorInstance(final Context pContext) {
		if (org.andengine.util.preferences.SimplePreferences.EDITORINSTANCE == null) {
			org.andengine.util.preferences.SimplePreferences.EDITORINSTANCE = org.andengine.util.preferences.SimplePreferences.getInstance(pContext).edit();
		}
		return org.andengine.util.preferences.SimplePreferences.EDITORINSTANCE;
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

	public static int incrementAccessCount(final Context pContext, final String pKey) {
		return org.andengine.util.preferences.SimplePreferences.incrementAccessCount(pContext, pKey, 1);
	}

	public static int incrementAccessCount(final Context pContext, final String pKey, final int pIncrement) {
		final SharedPreferences prefs = org.andengine.util.preferences.SimplePreferences.getInstance(pContext);
		final int accessCount = prefs.getInt(pKey, 0);

		final int newAccessCount = accessCount + pIncrement;
		prefs.edit().putInt(pKey, newAccessCount).commit();

		return newAccessCount;
	}

	public static int getAccessCount(final Context pCtx, final String pKey) {
		return org.andengine.util.preferences.SimplePreferences.getInstance(pCtx).getInt(pKey, 0);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
