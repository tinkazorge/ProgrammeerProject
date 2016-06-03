package org.andengine.entity.sprite.batch.vbo.andengine.entity.modifier;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.*;
import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.util.modifier.SequenceModifier;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 12:41:15 - 03.09.2010
 */
public class SequenceEntityModifier extends SequenceModifier<IEntity> implements org.andengine.entity.modifier.IEntityModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public SequenceEntityModifier(final org.andengine.entity.modifier.IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pEntityModifiers);
	}

	public SequenceEntityModifier(final ISubSequenceShapeModifierListener pSubSequenceShapeModifierListener, final org.andengine.entity.modifier.IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pSubSequenceShapeModifierListener, pEntityModifiers);
	}

	public SequenceEntityModifier(final IEntityModifierListener pEntityModifierListener, final org.andengine.entity.modifier.IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pEntityModifierListener, pEntityModifiers);
	}

	public SequenceEntityModifier(final ISubSequenceShapeModifierListener pSubSequenceShapeModifierListener, final IEntityModifierListener pEntityModifierListener, final IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pSubSequenceShapeModifierListener, pEntityModifierListener, pEntityModifiers);
	}

	protected SequenceEntityModifier(final org.andengine.entity.modifier.SequenceEntityModifier pSequenceShapeModifier) throws DeepCopyNotSupportedException {
		super(pSequenceShapeModifier);
	}

	@Override
	public org.andengine.entity.modifier.SequenceEntityModifier deepCopy() throws DeepCopyNotSupportedException {
		return new org.andengine.entity.modifier.SequenceEntityModifier(this);
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

	public interface ISubSequenceShapeModifierListener extends ISubSequenceModifierListener<IEntity> {
		// ===========================================================
		// Constants
		// ===========================================================

		// ===========================================================
		// Methods
		// ===========================================================
	}
}
