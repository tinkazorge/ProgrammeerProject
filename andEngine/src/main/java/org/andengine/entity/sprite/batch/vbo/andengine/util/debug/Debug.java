package org.andengine.entity.sprite.batch.vbo.andengine.util.debug;

import org.andengine.util.Constants;

import android.util.Log;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 13:29:16 - 08.03.2010
 */
public final class Debug {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static String sTag = Constants.DEBUGTAG;
	private static String sDebugUser = "";
	private static DebugLevel sDebugLevel = DebugLevel.VERBOSE;

	// ===========================================================
	// Constructors
	// ===========================================================

	private Debug() {

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public static String getTag() {
		return org.andengine.util.debug.Debug.sTag;
	}

	public static void setTag(final String pTag) {
		org.andengine.util.debug.Debug.sTag = pTag;
	}

	public static DebugLevel getDebugLevel() {
		return org.andengine.util.debug.Debug.sDebugLevel;
	}

	public static void setDebugLevel(final DebugLevel pDebugLevel) {
		if (pDebugLevel == null) {
			throw new IllegalArgumentException("pDebugLevel must not be null!");
		}
		org.andengine.util.debug.Debug.sDebugLevel = pDebugLevel;
	}

	public static void setDebugUser(final String pDebugUser) {
		if (pDebugUser == null) {
			throw new IllegalArgumentException("pDebugUser must not be null!");
		}
		org.andengine.util.debug.Debug.sDebugUser = pDebugUser;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public static void log(final DebugLevel pDebugLevel, final String pMessage) {
		switch (pDebugLevel) {
			case NONE:
				return;
			case VERBOSE:
				org.andengine.util.debug.Debug.v(pMessage);
				return;
			case INFO:
				org.andengine.util.debug.Debug.i(pMessage);
				return;
			case DEBUG:
				org.andengine.util.debug.Debug.d(pMessage);
				return;
			case WARNING:
				org.andengine.util.debug.Debug.w(pMessage);
				return;
			case ERROR:
				org.andengine.util.debug.Debug.e(pMessage);
				return;
		}
	}

	public static void log(final DebugLevel pDebugLevel, final String pMessage, final Throwable pThrowable) {
		switch (pDebugLevel) {
			case NONE:
				return;
			case VERBOSE:
				org.andengine.util.debug.Debug.v(pMessage, pThrowable);
				return;
			case INFO:
				org.andengine.util.debug.Debug.i(pMessage, pThrowable);
				return;
			case DEBUG:
				org.andengine.util.debug.Debug.d(pMessage, pThrowable);
				return;
			case WARNING:
				org.andengine.util.debug.Debug.w(pMessage, pThrowable);
				return;
			case ERROR:
				org.andengine.util.debug.Debug.e(pMessage, pThrowable);
				return;
		}
	}

	public static void log(final DebugLevel pDebugLevel, final String pTag, final String pMessage) {
		switch (pDebugLevel) {
			case NONE:
				return;
			case VERBOSE:
				org.andengine.util.debug.Debug.v(pTag, pMessage);
				return;
			case INFO:
				org.andengine.util.debug.Debug.i(pTag, pMessage);
				return;
			case DEBUG:
				org.andengine.util.debug.Debug.d(pTag, pMessage);
				return;
			case WARNING:
				org.andengine.util.debug.Debug.w(pTag, pMessage);
				return;
			case ERROR:
				org.andengine.util.debug.Debug.e(pTag, pMessage);
				return;
		}
	}

	public static void log(final DebugLevel pDebugLevel, final String pTag, final String pMessage, final Throwable pThrowable) {
		switch (pDebugLevel) {
			case NONE:
				return;
			case VERBOSE:
				org.andengine.util.debug.Debug.v(pTag, pMessage, pThrowable);
				return;
			case INFO:
				org.andengine.util.debug.Debug.i(pTag, pMessage, pThrowable);
				return;
			case DEBUG:
				org.andengine.util.debug.Debug.d(pTag, pMessage, pThrowable);
				return;
			case WARNING:
				org.andengine.util.debug.Debug.w(pTag, pMessage, pThrowable);
				return;
			case ERROR:
				org.andengine.util.debug.Debug.e(pTag, pMessage, pThrowable);
				return;
		}
	}

	public static void v(final String pMessage) {
		org.andengine.util.debug.Debug.v(org.andengine.util.debug.Debug.sTag, pMessage, null);
	}

	public static void v(final String pMessage, final Throwable pThrowable) {
		org.andengine.util.debug.Debug.v(org.andengine.util.debug.Debug.sTag, pMessage, pThrowable);
	}

	public static void v(final String pTag, final String pMessage) {
		org.andengine.util.debug.Debug.v(pTag, pMessage, null);
	}

	public static void v(final String pTag, final String pMessage, final Throwable pThrowable) {
		if (org.andengine.util.debug.Debug.sDebugLevel.isSameOrLessThan(DebugLevel.VERBOSE)) {
			if (pThrowable == null) {
				Log.v(pTag, pMessage);
			} else {
				Log.v(pTag, pMessage, pThrowable);
			}
		}
	}

	public static void vUser(final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.v(pMessage);
		}
	}

	public static void vUser(final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.v(pMessage, pThrowable);
		}
	}

	public static void vUser(final String pTag, final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.v(pTag, pMessage);
		}
	}

	public static void vUser(final String pTag, final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.v(pTag, pMessage, pThrowable);
		}
	}

	public static void d(final String pMessage) {
		org.andengine.util.debug.Debug.d(org.andengine.util.debug.Debug.sTag, pMessage, null);
	}

	public static void d(final String pMessage, final Throwable pThrowable) {
		org.andengine.util.debug.Debug.d(org.andengine.util.debug.Debug.sTag, pMessage, pThrowable);
	}

	public static void d(final String pTag, final String pMessage) {
		org.andengine.util.debug.Debug.d(pTag, pMessage, null);
	}

	public static void d(final String pTag, final String pMessage, final Throwable pThrowable) {
		if (org.andengine.util.debug.Debug.sDebugLevel.isSameOrLessThan(DebugLevel.DEBUG)) {
			if (pThrowable == null) {
				Log.d(pTag, pMessage);
			} else {
				Log.d(pTag, pMessage, pThrowable);
			}
		}
	}

	public static void dUser(final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.d(pMessage);
		}
	}

	public static void dUser(final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.d(pMessage, pThrowable);
		}
	}

	public static void dUser(final String pTag, final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.d(pTag, pMessage);
		}
	}

	public static void dUser(final String pTag, final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.d(pTag, pMessage, pThrowable);
		}
	}

	public static void i(final String pMessage) {
		org.andengine.util.debug.Debug.i(org.andengine.util.debug.Debug.sTag, pMessage, null);
	}

	public static void i(final String pMessage, final Throwable pThrowable) {
		org.andengine.util.debug.Debug.i(org.andengine.util.debug.Debug.sTag, pMessage, pThrowable);
	}

	public static void i(final String pTag, final String pMessage) {
		org.andengine.util.debug.Debug.i(pTag, pMessage, null);
	}

	public static void i(final String pTag, final String pMessage, final Throwable pThrowable) {
		if (org.andengine.util.debug.Debug.sDebugLevel.isSameOrLessThan(DebugLevel.INFO)) {
			if (pThrowable == null) {
				Log.i(pTag, pMessage);
			} else {
				Log.i(pTag, pMessage, pThrowable);
			}
		}
	}

	public static void iUser(final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.i(pMessage);
		}
	}

	public static void iUser(final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.i(pMessage, pThrowable);
		}
	}

	public static void iUser(final String pTag, final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.i(pTag, pMessage);
		}
	}

	public static void iUser(final String pTag, final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.i(pTag, pMessage, pThrowable);
		}
	}

	public static void w(final String pMessage) {
		org.andengine.util.debug.Debug.w(org.andengine.util.debug.Debug.sTag, pMessage, null);
	}

	public static void w(final Throwable pThrowable) {
		org.andengine.util.debug.Debug.w("", pThrowable);
	}

	public static void w(final String pMessage, final Throwable pThrowable) {
		org.andengine.util.debug.Debug.w(org.andengine.util.debug.Debug.sTag, pMessage, pThrowable);
	}

	public static void w(final String pTag, final String pMessage) {
		org.andengine.util.debug.Debug.w(pTag, pMessage, null);
	}

	public static void w(final String pTag, final String pMessage, final Throwable pThrowable) {
		if (org.andengine.util.debug.Debug.sDebugLevel.isSameOrLessThan(DebugLevel.WARNING)) {
			if (pThrowable == null) {
				Log.w(pTag, pMessage);
			} else {
				Log.w(pTag, pMessage, pThrowable);
			}
		}
	}

	public static void wUser(final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.w(pMessage);
		}
	}

	public static void wUser(final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.w(pThrowable);
		}
	}

	public static void wUser(final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.w(pMessage, pThrowable);
		}
	}

	public static void wUser(final String pTag, final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.w(pTag, pMessage);
		}
	}

	public static void wUser(final String pTag, final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.w(pTag, pMessage, pThrowable);
		}
	}

	public static void e(final String pMessage) {
		org.andengine.util.debug.Debug.e(org.andengine.util.debug.Debug.sTag, pMessage, null);
	}

	public static void e(final Throwable pThrowable) {
		org.andengine.util.debug.Debug.e(org.andengine.util.debug.Debug.sTag, pThrowable);
	}

	public static void e(final String pMessage, final Throwable pThrowable) {
		org.andengine.util.debug.Debug.e(org.andengine.util.debug.Debug.sTag, pMessage, pThrowable);
	}

	public static void e(final String pTag, final String pMessage) {
		org.andengine.util.debug.Debug.e(pTag, pMessage, null);
	}

	public static void e(final String pTag, final String pMessage, final Throwable pThrowable) {
		if (org.andengine.util.debug.Debug.sDebugLevel.isSameOrLessThan(DebugLevel.ERROR)) {
			if (pThrowable == null) {
				Log.e(pTag, pMessage);
			} else {
				Log.e(pTag, pMessage, pThrowable);
			}
		}
	}

	public static void eUser(final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.e(pMessage);
		}
	}

	public static void eUser(final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.e(pThrowable);
		}
	}

	public static void eUser(final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.e(pMessage, pThrowable);
		}
	}

	public static void eUser(final String pTag, final String pMessage, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.e(pTag, pMessage);
		}
	}

	public static void eUser(final String pTag, final String pMessage, final Throwable pThrowable, final String pDebugUser) {
		if (org.andengine.util.debug.Debug.sDebugUser.equals(pDebugUser)) {
			org.andengine.util.debug.Debug.e(pTag, pMessage, pThrowable);
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	public static enum DebugLevel implements Comparable<DebugLevel> {
		NONE, ERROR, WARNING, INFO, DEBUG, VERBOSE;

		public static final DebugLevel ALL = DebugLevel.VERBOSE;

		public boolean isSameOrLessThan(final DebugLevel pDebugLevel) {
			return this.compareTo(pDebugLevel) >= 0;
		}
	}
}
