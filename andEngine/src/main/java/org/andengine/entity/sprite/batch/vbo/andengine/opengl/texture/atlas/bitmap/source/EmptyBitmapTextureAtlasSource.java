package org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.atlas.bitmap.source;


import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.source.BaseTextureAtlasSource;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 20:20:36 - 08.08.2010
 */
public class EmptyBitmapTextureAtlasSource extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public EmptyBitmapTextureAtlasSource(final int pTextureWidth, final int pTextureHeight) {
		this(0, 0, pTextureWidth, pTextureHeight);
	}

	public EmptyBitmapTextureAtlasSource(final int pTextureX, final int pTextureY, final int pTextureWidth, final int pTextureHeight) {
		super(pTextureX, pTextureY, pTextureWidth, pTextureHeight);
	}

	@Override
	public org.andengine.opengl.texture.atlas.bitmap.source.EmptyBitmapTextureAtlasSource deepCopy() {
		return new org.andengine.opengl.texture.atlas.bitmap.source.EmptyBitmapTextureAtlasSource(this.mTextureX, this.mTextureY, this.mTextureWidth, this.mTextureHeight);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public Bitmap onLoadBitmap(final Config pBitmapConfig) {
		return this.onLoadBitmap(pBitmapConfig, false);
	}

	@Override
	public Bitmap onLoadBitmap(final Config pBitmapConfig, final boolean pMutable) {
		return Bitmap.createBitmap(this.mTextureWidth, this.mTextureHeight, pBitmapConfig);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.mTextureWidth + " x " + this.mTextureHeight + ")";
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}