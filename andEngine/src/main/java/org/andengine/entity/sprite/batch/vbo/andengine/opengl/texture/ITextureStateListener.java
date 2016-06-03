package org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture;


import org.andengine.opengl.texture.*;
import org.andengine.opengl.texture.ITexture;

/**
 * (c) 2012 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 11:25:58 - 05.04.2012
 */
public interface ITextureStateListener {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public void onLoadedToHardware(final org.andengine.opengl.texture.ITexture pTexture);
	public void onUnloadedFromHardware(final ITexture pTexture);
}