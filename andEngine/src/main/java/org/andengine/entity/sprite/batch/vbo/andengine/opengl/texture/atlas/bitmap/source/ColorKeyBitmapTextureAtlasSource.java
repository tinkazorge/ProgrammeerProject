package org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.atlas.bitmap.source;

import org.andengine.opengl.texture.atlas.bitmap.source.*;
import org.andengine.opengl.texture.atlas.bitmap.source.ColorSwapBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.util.adt.color.Color;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 22:16:41 - 06.08.2010
 */
public class ColorKeyBitmapTextureAtlasSource extends org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.atlas.bitmap.source.ColorSwapBitmapTextureAtlasSource {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public ColorKeyBitmapTextureAtlasSource(final org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final org.andengine.entity.sprite.batch.vbo.andengine.util.adt.color.Color pColorKeyColor) {
		super(pBitmapTextureAtlasSource, pColorKeyColor, org.andengine.entity.sprite.batch.vbo.andengine.util.adt.color.Color.TRANSPARENT);
	}

	public ColorKeyBitmapTextureAtlasSource(final org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final int pColorKeyColorARGBPackedInt) {
		super(pBitmapTextureAtlasSource, pColorKeyColorARGBPackedInt, org.andengine.entity.sprite.batch.vbo.andengine.util.adt.color.Color.TRANSPARENT_ARGB_PACKED_INT);
	}

	public ColorKeyBitmapTextureAtlasSource(final org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final org.andengine.entity.sprite.batch.vbo.andengine.util.adt.color.Color pColorKeyColor, final int pTolerance) {
		super(pBitmapTextureAtlasSource, pColorKeyColor, pTolerance, org.andengine.entity.sprite.batch.vbo.andengine.util.adt.color.Color.TRANSPARENT);
	}

	public ColorKeyBitmapTextureAtlasSource(final org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final int pColorKeyColorARGBPackedInt, final int pTolerance) {
		super(pBitmapTextureAtlasSource, pColorKeyColorARGBPackedInt, pTolerance, org.andengine.entity.sprite.batch.vbo.andengine.util.adt.color.Color.TRANSPARENT_ARGB_PACKED_INT);
	}

	@Override
	public ColorKeyBitmapTextureAtlasSource deepCopy() {
		return new ColorKeyBitmapTextureAtlasSource(this.mBitmapTextureAtlasSource, this.mColorKeyColorARGBPackedInt, this.mTolerance);
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

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
