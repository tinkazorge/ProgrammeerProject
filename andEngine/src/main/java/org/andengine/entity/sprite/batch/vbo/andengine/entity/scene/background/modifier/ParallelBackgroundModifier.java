package org.andengine.entity.sprite.batch.vbo.andengine.entity.scene.background.modifier;

import org.andengine.entity.scene.background.IBackground;
import org.andengine.entity.scene.background.modifier.*;
import org.andengine.entity.scene.background.modifier.IBackgroundModifier;
import org.andengine.util.modifier.ParallelModifier;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 15:03:57 - 03.09.2010
 */
public class ParallelBackgroundModifier extends ParallelModifier<IBackground> implements org.andengine.entity.scene.background.modifier.IBackgroundModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public ParallelBackgroundModifier(final org.andengine.entity.scene.background.modifier.IBackgroundModifier... pBackgroundModifiers) throws IllegalArgumentException {
		super(pBackgroundModifiers);
	}

	public ParallelBackgroundModifier(final IBackgroundModifierListener pBackgroundModifierListener, final IBackgroundModifier... pBackgroundModifiers) throws IllegalArgumentException {
		super(pBackgroundModifierListener, pBackgroundModifiers);
	}

	protected ParallelBackgroundModifier(final org.andengine.entity.scene.background.modifier.ParallelBackgroundModifier pParallelBackgroundModifier) throws DeepCopyNotSupportedException {
		super(pParallelBackgroundModifier);
	}

	@Override
	public org.andengine.entity.scene.background.modifier.ParallelBackgroundModifier deepCopy() throws DeepCopyNotSupportedException {
		return new org.andengine.entity.scene.background.modifier.ParallelBackgroundModifier(this);
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
