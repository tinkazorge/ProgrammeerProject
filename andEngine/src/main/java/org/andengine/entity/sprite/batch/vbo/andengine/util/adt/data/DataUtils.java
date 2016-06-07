package org.andengine.entity.sprite.batch.vbo.andengine.util.adt.data;



/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 15:01:49 - 20.03.2011
 */
public final class DataUtils {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	private DataUtils() {

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	public static final int unsignedByteToInt(final byte pByte) {
		return pByte & 0xFF;
	}

	public static final int getBitLength(final int pNumber) {
		return Integer.SIZE - Integer.numberOfLeadingZeros(pNumber);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
