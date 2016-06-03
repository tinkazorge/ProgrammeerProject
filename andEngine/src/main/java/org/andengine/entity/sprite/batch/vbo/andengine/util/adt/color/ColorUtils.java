package org.andengine.entity.sprite.batch.vbo.andengine.util.adt.color;

import org.andengine.util.adt.color.*;
import org.andengine.util.adt.color.Color;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 11:13:45 - 04.08.2010
 */
public final class ColorUtils {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final float[] HSV_TO_COLOR = new float[3];
	private static final int HSV_TO_COLOR_HUE_INDEX = 0;
	private static final int HSV_TO_COLOR_SATURATION_INDEX = 1;
	private static final int HSV_TO_COLOR_VALUE_INDEX = 2;

	private static final int INT_BITS_TO_FLOAT_MASK = 0xFFFFFFFF;
//	private static final int INT_BITS_TO_FLOAT_MASK = 0xFEFFFFFF; // To avoid producing NaN in the int->float conversion.

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	private ColorUtils() {

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

	/**
	 * @param pHue [0 .. 360)
	 * @param pSaturation [0...1]
	 * @param pValue [0...1]
	 */
	public static final int convertHSVToARGBPackedInt(final float pHue, final float pSaturation, final float pValue) {
		org.andengine.util.adt.color.ColorUtils.HSV_TO_COLOR[org.andengine.util.adt.color.ColorUtils.HSV_TO_COLOR_HUE_INDEX] = pHue;
		org.andengine.util.adt.color.ColorUtils.HSV_TO_COLOR[org.andengine.util.adt.color.ColorUtils.HSV_TO_COLOR_SATURATION_INDEX] = pSaturation;
		org.andengine.util.adt.color.ColorUtils.HSV_TO_COLOR[org.andengine.util.adt.color.ColorUtils.HSV_TO_COLOR_VALUE_INDEX] = pValue;

		return android.graphics.Color.HSVToColor(org.andengine.util.adt.color.ColorUtils.HSV_TO_COLOR);
	}

	/**
	 * @param pHue [0 .. 360)
	 * @param pSaturation [0...1]
	 * @param pValue [0...1]
	 */
	public static final org.andengine.util.adt.color.Color convertHSVToColor(final float pHue, final float pSaturation, final float pValue) {
		return org.andengine.util.adt.color.ColorUtils.convertARGBPackedIntToColor(org.andengine.util.adt.color.ColorUtils.convertHSVToARGBPackedInt(pHue, pSaturation, pValue));
	}


	public static org.andengine.util.adt.color.Color convertARGBPackedIntToColor(final int pARGBPackedInt) {
		final org.andengine.util.adt.color.Color color = new org.andengine.util.adt.color.Color();

		org.andengine.util.adt.color.ColorUtils.convertARGBPackedIntToColor(pARGBPackedInt, color);

		return color;
	}

	public static void convertARGBPackedIntToColor(final int pARGBPackedInt, final org.andengine.util.adt.color.Color pColor) {
		final float alpha = org.andengine.util.adt.color.ColorUtils.extractAlphaFromARGBPackedInt(pARGBPackedInt);
		final float red = org.andengine.util.adt.color.ColorUtils.extractRedFromARGBPackedInt(pARGBPackedInt);
		final float green = org.andengine.util.adt.color.ColorUtils.extractGreenFromARGBPackedInt(pARGBPackedInt);
		final float blue = org.andengine.util.adt.color.ColorUtils.extractBlueFromARGBPackedInt(pARGBPackedInt);

		pColor.set(red, green, blue, alpha);
	}

	public static org.andengine.util.adt.color.Color convertABGRPackedIntToColor(final int pABGRPackedInt) {
		final org.andengine.util.adt.color.Color color = new org.andengine.util.adt.color.Color();

		org.andengine.util.adt.color.ColorUtils.convertABGRPackedIntToColor(pABGRPackedInt, color);

		return color;
	}

	public static void convertABGRPackedIntToColor(final int pABGRPackedInt, final org.andengine.util.adt.color.Color pColor) {
		final float alpha = org.andengine.util.adt.color.ColorUtils.extractAlphaFromABGRPackedInt(pABGRPackedInt);
		final float blue = org.andengine.util.adt.color.ColorUtils.extractBlueFromABGRPackedInt(pABGRPackedInt);
		final float green = org.andengine.util.adt.color.ColorUtils.extractGreenFromABGRPackedInt(pABGRPackedInt);
		final float red = org.andengine.util.adt.color.ColorUtils.extractRedFromABGRPackedInt(pABGRPackedInt);

		pColor.set(red, green, blue, alpha);
	}


	public static final int convertRGBAToARGBPackedInt(final float pRed, final float pGreen, final float pBlue, final float pAlpha) {
		return ((int)(255 * pAlpha) << org.andengine.util.adt.color.Color.ARGB_PACKED_ALPHA_SHIFT) | ((int)(255 * pRed) << org.andengine.util.adt.color.Color.ARGB_PACKED_RED_SHIFT) | ((int)(255 * pGreen) << org.andengine.util.adt.color.Color.ARGB_PACKED_GREEN_SHIFT) | ((int)(255 * pBlue) << org.andengine.util.adt.color.Color.ARGB_PACKED_BLUE_SHIFT);
	}

	public static final float convertRGBAToARGBPackedFloat(final float pRed, final float pGreen, final float pBlue, final float pAlpha) {
		return org.andengine.util.adt.color.ColorUtils.convertPackedIntToPackedFloat(org.andengine.util.adt.color.ColorUtils.convertRGBAToARGBPackedInt(pRed, pGreen, pBlue, pAlpha));
	}

	public static final int convertRGBAToABGRPackedInt(final float pRed, final float pGreen, final float pBlue, final float pAlpha) {
		return ((int)(255 * pAlpha) << org.andengine.util.adt.color.Color.ABGR_PACKED_ALPHA_SHIFT) | ((int)(255 * pBlue) << org.andengine.util.adt.color.Color.ABGR_PACKED_BLUE_SHIFT) | ((int)(255 * pGreen) << org.andengine.util.adt.color.Color.ABGR_PACKED_GREEN_SHIFT) | ((int)(255 * pRed) << org.andengine.util.adt.color.Color.ABGR_PACKED_RED_SHIFT);
	}

	public static final float convertRGBAToABGRPackedFloat(final float pRed, final float pGreen, final float pBlue, final float pAlpha) {
		return org.andengine.util.adt.color.ColorUtils.convertPackedIntToPackedFloat(org.andengine.util.adt.color.ColorUtils.convertRGBAToABGRPackedInt(pRed, pGreen, pBlue, pAlpha));
	}


	public static final float convertPackedIntToPackedFloat(final int pPackedInt) {
		return Float.intBitsToFloat(pPackedInt & org.andengine.util.adt.color.ColorUtils.INT_BITS_TO_FLOAT_MASK);
	}


	public static float extractRedFromABGRPackedInt(final int pABGRPackedInt) {
		return ((pABGRPackedInt >> org.andengine.util.adt.color.Color.ABGR_PACKED_RED_SHIFT) & 0xFF) / 255.0f;
	}

	public static float extractGreenFromABGRPackedInt(final int pABGRPackedInt) {
		return ((pABGRPackedInt >> org.andengine.util.adt.color.Color.ABGR_PACKED_GREEN_SHIFT) & 0xFF) / 255.0f;
	}

	public static float extractBlueFromABGRPackedInt(final int pABGRPackedInt) {
		return ((pABGRPackedInt >> org.andengine.util.adt.color.Color.ABGR_PACKED_BLUE_SHIFT) & 0xFF) / 255.0f;
	}

	public static float extractAlphaFromABGRPackedInt(final int pABGRPackedInt) {
		return ((pABGRPackedInt >> org.andengine.util.adt.color.Color.ABGR_PACKED_ALPHA_SHIFT) & 0xFF) / 255.0f;
	}


	public static float extractBlueFromARGBPackedInt(final int pARGBPackedInt) {
		return ((pARGBPackedInt >> org.andengine.util.adt.color.Color.ARGB_PACKED_BLUE_SHIFT) & 0xFF) / 255.0f;
	}

	public static float extractGreenFromARGBPackedInt(final int pARGBPackedInt) {
		return ((pARGBPackedInt >> org.andengine.util.adt.color.Color.ARGB_PACKED_GREEN_SHIFT) & 0xFF) / 255.0f;
	}

	public static float extractRedFromARGBPackedInt(final int pARGBPackedInt) {
		return ((pARGBPackedInt >> org.andengine.util.adt.color.Color.ARGB_PACKED_RED_SHIFT) & 0xFF) / 255.0f;
	}

	public static float extractAlphaFromARGBPackedInt(final int pARGBPackedInt) {
		return ((pARGBPackedInt >> Color.ARGB_PACKED_ALPHA_SHIFT) & 0xFF) / 255.0f;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
