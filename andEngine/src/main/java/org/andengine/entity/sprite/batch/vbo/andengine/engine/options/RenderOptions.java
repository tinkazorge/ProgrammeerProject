package org.andengine.entity.sprite.batch.vbo.andengine.engine.options;

import org.andengine.engine.options.*;
import org.andengine.engine.options.ConfigChooserOptions;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 13:01:40 - 02.07.2010
 */
public class RenderOptions {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private boolean mDithering;

	private org.andengine.engine.options.ConfigChooserOptions mConfigChooserOptions = new org.andengine.engine.options.ConfigChooserOptions();

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public boolean isDithering() {
		return this.mDithering;
	}

	public void setDithering(final boolean pDithering) {
		this.mDithering = pDithering;
	}

	public ConfigChooserOptions getConfigChooserOptions() {
		return this.mConfigChooserOptions;
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
