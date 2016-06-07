package org.andengine.entity.sprite.batch.vbo.andengine.opengl.font;

import org.andengine.opengl.font.*;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.EmptyTexture;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.PixelFormat;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.util.adt.color.Color;

import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 17:17:28 - 16.06.2010
 */
public final class FontFactory {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final boolean ANTIALIAS_DEFAULT = true;
	private static final int COLOR_DEFAULT = Color.BLACK_ARGB_PACKED_INT;

	// ===========================================================
	// Fields
	// ===========================================================

	private static String sAssetBasePath = "";

	// ===========================================================
	// Constructors
	// ===========================================================

	private FontFactory() {

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * @param pAssetBasePath must end with '<code>/</code>' or have <code>.length() == 0</code>.
	 */
	public static void setAssetBasePath(final String pAssetBasePath) {
		if (pAssetBasePath.endsWith("/") || pAssetBasePath.length() == 0) {
			org.andengine.opengl.font.FontFactory.sAssetBasePath = pAssetBasePath;
		} else {
			throw new IllegalStateException("pAssetBasePath must end with '/' or be length zero.");
		}
	}

	public static String getAssetBasePath() {
		return org.andengine.opengl.font.FontFactory.sAssetBasePath;
	}

	public static void onCreate() {
		org.andengine.opengl.font.FontFactory.setAssetBasePath("");
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final ITexture pTexture, final float pSize) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTexture, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final ITexture pTexture, final float pSize, final boolean pAntiAlias) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTexture, pSize, pAntiAlias, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final ITexture pTexture, final float pSize, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTexture, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final ITexture pTexture, final float pSize, final boolean pAntiAlias, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTexture, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), pSize, pAntiAlias, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final float pSize, final boolean pAntiAlias, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pSize, pAntiAlias, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final float pSize, final boolean pAntiAlias, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pTextureOptions, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), pSize, pAntiAlias, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final Typeface pTypeface, final float pSize) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final Typeface pTypeface, final float pSize, final boolean pAntiAlias) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pTypeface, pSize, pAntiAlias, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final Typeface pTypeface, final float pSize, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pTypeface, pSize, pAntiAlias, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pTextureOptions, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final boolean pAntiAlias) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pTextureOptions, pTypeface, pSize, pAntiAlias, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pTextureOptions, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, PixelFormat.RGBA_8888, pTextureOptions, pTypeface, pSize, pAntiAlias, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final boolean pAntiAlias) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions, pTypeface, pSize, pAntiAlias, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final int pColor) {
		return org.andengine.opengl.font.FontFactory.create(pFontManager, new EmptyTexture(pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions), pTypeface, pSize, pAntiAlias, pColor);
	}

	public static org.andengine.opengl.font.Font create(final FontManager pFontManager, final ITexture pTexture, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final int pColor) {
		return new org.andengine.opengl.font.Font(pFontManager, pTexture, pTypeface, pSize, pAntiAlias, pColor);
	}


	public static org.andengine.opengl.font.Font createFromAsset(final FontManager pFontManager, final ITexture pTexture, final AssetManager pAssetManager, final String pAssetPath, final float pSize, final boolean pAntiAlias, final int pColor) {
		return new org.andengine.opengl.font.Font(pFontManager, pTexture, Typeface.createFromAsset(pAssetManager, org.andengine.opengl.font.FontFactory.sAssetBasePath + pAssetPath), pSize, pAntiAlias, pColor);
	}

	public static org.andengine.opengl.font.Font createFromAsset(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final AssetManager pAssetManager, final String pAssetPath, final float pSize, final boolean pAntiAlias, final int pColor) {
		return org.andengine.opengl.font.FontFactory.createFromAsset(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pAssetManager, pAssetPath, pSize, pAntiAlias, pColor);
	}

	public static org.andengine.opengl.font.Font createFromAsset(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final AssetManager pAssetManager, final String pAssetPath, final float pSize, final boolean pAntiAlias, final int pColor) {
		return org.andengine.opengl.font.FontFactory.createFromAsset(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, PixelFormat.RGBA_8888, pTextureOptions, pAssetManager, pAssetPath, pSize, pAntiAlias, pColor);
	}

	public static org.andengine.opengl.font.Font createFromAsset(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final AssetManager pAssetManager, final String pAssetPath, final float pSize, final boolean pAntiAlias, final int pColor) {
		return new Font(pFontManager, new EmptyTexture(pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions), Typeface.createFromAsset(pAssetManager, org.andengine.opengl.font.FontFactory.sAssetBasePath + pAssetPath), pSize, pAntiAlias, pColor);
	}


	public static StrokeFont createStroke(final FontManager pFontManager, final ITexture pTexture, final float pSize, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTexture, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final ITexture pTexture, final float pSize, final boolean pAntiAlias, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTexture, pSize, pAntiAlias, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final ITexture pTexture, final float pSize, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTexture, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final ITexture pTexture, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTexture, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pTextureOptions, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final Typeface pTypeface, final float pSize, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pTypeface, pSize, pAntiAlias, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final Typeface pTypeface, final float pSize, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pTypeface, pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pTextureOptions, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pTextureOptions, pTypeface, pSize, pAntiAlias, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pTextureOptions, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, PixelFormat.RGBA_8888, pTextureOptions, pTypeface, pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions, pTypeface, pSize, pAntiAlias, org.andengine.opengl.font.FontFactory.COLOR_DEFAULT, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions, pTypeface, pSize, org.andengine.opengl.font.FontFactory.ANTIALIAS_DEFAULT, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStroke(pFontManager, new EmptyTexture(pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions), pTypeface, pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStroke(final FontManager pFontManager, final ITexture pTexture, final Typeface pTypeface, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return new StrokeFont(pFontManager, pTexture, pTypeface, pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}


	public static StrokeFont createStrokeFromAsset(final FontManager pFontManager, final ITexture pTexture, final AssetManager pAssetManager, final String pAssetPath, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return new StrokeFont(pFontManager, pTexture, Typeface.createFromAsset(pAssetManager, org.andengine.opengl.font.FontFactory.sAssetBasePath + pAssetPath), pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStrokeFromAsset(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final AssetManager pAssetManager, final String pAssetPath, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStrokeFromAsset(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, TextureOptions.DEFAULT, pAssetManager, pAssetPath, pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStrokeFromAsset(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final TextureOptions pTextureOptions, final AssetManager pAssetManager, final String pAssetPath, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return org.andengine.opengl.font.FontFactory.createStrokeFromAsset(pFontManager, pTextureManager, pTextureWidth, pTextureHeight, PixelFormat.RGBA_8888, pTextureOptions, pAssetManager, pAssetPath, pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	public static StrokeFont createStrokeFromAsset(final FontManager pFontManager, final TextureManager pTextureManager, final int pTextureWidth, final int pTextureHeight, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final AssetManager pAssetManager, final String pAssetPath, final float pSize, final boolean pAntiAlias, final int pColor, final float pStrokeWidth, final int pStrokeColor) {
		return new StrokeFont(pFontManager, new EmptyTexture(pTextureManager, pTextureWidth, pTextureHeight, pPixelFormat, pTextureOptions), Typeface.createFromAsset(pAssetManager, org.andengine.opengl.font.FontFactory.sAssetBasePath + pAssetPath), pSize, pAntiAlias, pColor, pStrokeWidth, pStrokeColor);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
