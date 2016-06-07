package org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.region;

import org.andengine.opengl.texture.region.*;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.util.adt.map.Library;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 11:52:26 - 20.08.2010
 */
public class TextureRegionLibrary extends Library<ITextureRegion> {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public TextureRegionLibrary(final int pInitialCapacity) {
		super(pInitialCapacity);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	@Override
	public TextureRegion get(final int pID) {
		return (TextureRegion) super.get(pID);
	}

	public org.andengine.opengl.texture.region.TiledTextureRegion getTiled(final int pID) {
		return (TiledTextureRegion) this.mItems.get(pID);
	}

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
