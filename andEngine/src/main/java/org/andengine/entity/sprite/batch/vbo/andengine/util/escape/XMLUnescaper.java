package org.andengine.entity.sprite.batch.vbo.andengine.util.escape;

import org.andengine.util.escape.*;
import org.andengine.util.escape.Unescaper;
import org.andengine.util.escape.UnescaperEntityMap;

/**
 * (c) 2012 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 3:27:44 PM - Apr 26, 2012
 */
public final class XMLUnescaper {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static final org.andengine.util.escape.UnescaperEntityMap XMLUNESCAPER_ENTITYMAP = new UnescaperEntityMap() {
		{
			/* BASIC */
			this.add("quot", 34); // " - double-quote
			this.add("amp", 38); // & - ampersand
			this.add("lt", 60); // < - less-than
			this.add("gt", 62); // > - greater-than

			/* XML */
			this.add("apos", 39); // XML apostrophe

			this.init();
		}
	};

	// ===========================================================
	// Constructors
	// ===========================================================

	private XMLUnescaper() {

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

	public static String unescape(final CharSequence pCharSequence) {
		return Unescaper.unescape(pCharSequence, org.andengine.util.escape.XMLUnescaper.XMLUNESCAPER_ENTITYMAP);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
