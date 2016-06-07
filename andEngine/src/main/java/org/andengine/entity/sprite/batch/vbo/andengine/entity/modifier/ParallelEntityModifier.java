package org.andengine.entity.sprite.batch.vbo.andengine.entity.modifier;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.*;
import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.util.modifier.ParallelModifier;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 12:40:31 - 03.09.2010
 */
public class ParallelEntityModifier extends ParallelModifier<IEntity> implements org.andengine.entity.modifier.IEntityModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public ParallelEntityModifier(final org.andengine.entity.modifier.IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pEntityModifiers);
	}

	public ParallelEntityModifier(final IEntityModifierListener pEntityModifierListener, final IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pEntityModifierListener, pEntityModifiers);
	}

	protected ParallelEntityModifier(final org.andengine.entity.modifier.ParallelEntityModifier pParallelShapeModifier) throws DeepCopyNotSupportedException {
		super(pParallelShapeModifier);
	}

	@Override
	public org.andengine.entity.modifier.ParallelEntityModifier deepCopy() throws DeepCopyNotSupportedException {
		return new org.andengine.entity.modifier.ParallelEntityModifier(this);
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
