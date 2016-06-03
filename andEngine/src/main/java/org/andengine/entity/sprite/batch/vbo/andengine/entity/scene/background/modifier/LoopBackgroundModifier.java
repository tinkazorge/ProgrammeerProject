package org.andengine.entity.sprite.batch.vbo.andengine.entity.scene.background.modifier;

import org.andengine.entity.scene.background.IBackground;
import org.andengine.entity.scene.background.modifier.*;
import org.andengine.entity.scene.background.modifier.IBackgroundModifier;
import org.andengine.util.modifier.LoopModifier;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 15:03:53 - 03.09.2010
 */
public class LoopBackgroundModifier extends LoopModifier<IBackground> implements org.andengine.entity.scene.background.modifier.IBackgroundModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public LoopBackgroundModifier(final org.andengine.entity.scene.background.modifier.IBackgroundModifier pBackgroundModifier) {
		super(pBackgroundModifier);
	}

	public LoopBackgroundModifier(final org.andengine.entity.scene.background.modifier.IBackgroundModifier pBackgroundModifier, final int pLoopCount) {
		super(pBackgroundModifier, pLoopCount);
	}

	public LoopBackgroundModifier(final org.andengine.entity.scene.background.modifier.IBackgroundModifier pBackgroundModifier, final int pLoopCount, final ILoopBackgroundModifierListener pLoopModifierListener) {
		super(pBackgroundModifier, pLoopCount, pLoopModifierListener, (IBackgroundModifierListener) null);
	}

	public LoopBackgroundModifier(final org.andengine.entity.scene.background.modifier.IBackgroundModifier pBackgroundModifier, final int pLoopCount, final IBackgroundModifierListener pBackgroundModifierListener) {
		super(pBackgroundModifier, pLoopCount, pBackgroundModifierListener);
	}

	public LoopBackgroundModifier(final IBackgroundModifier pBackgroundModifier, final int pLoopCount, final ILoopBackgroundModifierListener pLoopModifierListener, final IBackgroundModifierListener pBackgroundModifierListener) {
		super(pBackgroundModifier, pLoopCount, pLoopModifierListener, pBackgroundModifierListener);
	}

	protected LoopBackgroundModifier(final org.andengine.entity.scene.background.modifier.LoopBackgroundModifier pLoopBackgroundModifier) throws DeepCopyNotSupportedException {
		super(pLoopBackgroundModifier);
	}

	@Override
	public org.andengine.entity.scene.background.modifier.LoopBackgroundModifier deepCopy() throws DeepCopyNotSupportedException {
		return new org.andengine.entity.scene.background.modifier.LoopBackgroundModifier(this);
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

	public interface ILoopBackgroundModifierListener extends ILoopModifierListener<IBackground> {
		// ===========================================================
		// Constants
		// ===========================================================

		// ===========================================================
		// Methods
		// ===========================================================
	}
}
