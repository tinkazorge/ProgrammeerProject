package org.andengine.entity.sprite.batch.vbo.andengine.util.animationpack;

import org.andengine.util.animationpack.*;
import org.andengine.util.animationpack.AnimationPackTiledTextureRegion;

import java.util.HashMap;

/**
 * (c) 2012 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 17:17:37 - 03.05.2012
 */
public class AnimationPackTiledTextureRegionLibrary {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private final HashMap<String, org.andengine.util.animationpack.AnimationPackTiledTextureRegion> mAnimationPackTiledTextureRegionMapping = new HashMap<String, org.andengine.util.animationpack.AnimationPackTiledTextureRegion>();

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public void put(final org.andengine.util.animationpack.AnimationPackTiledTextureRegion pAnimationPackTiledTextureRegion) {
		this.mAnimationPackTiledTextureRegionMapping.put(pAnimationPackTiledTextureRegion.getAnimationName(), pAnimationPackTiledTextureRegion);
	}

	public AnimationPackTiledTextureRegion get(final String pAnimationName) {
		return this.mAnimationPackTiledTextureRegionMapping.get(pAnimationName);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
