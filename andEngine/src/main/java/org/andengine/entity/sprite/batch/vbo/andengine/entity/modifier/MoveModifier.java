package org.andengine.entity.sprite.batch.vbo.andengine.entity.modifier;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.*;
import org.andengine.entity.modifier.DoubleValueSpanEntityModifier;
import org.andengine.util.modifier.ease.EaseLinear;
import org.andengine.util.modifier.ease.IEaseFunction;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 16:12:52 - 19.03.2010
 */
public class MoveModifier extends DoubleValueSpanEntityModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public MoveModifier(final float pDuration, final float pFromX, final float pFromY, final float pToX, final float pToY) {
		this(pDuration, pFromX, pFromY, pToX, pToY, null, EaseLinear.getInstance());
	}

	public MoveModifier(final float pDuration, final float pFromX, final float pFromY, final float pToX, final float pToY, final IEaseFunction pEaseFunction) {
		this(pDuration, pFromX, pFromY, pToX, pToY, null, pEaseFunction);
	}

	public MoveModifier(final float pDuration, final float pFromX, final float pFromY, final float pToX, final float pToY, final IEntityModifierListener pEntityModifierListener) {
		super(pDuration, pFromX, pToX, pFromY, pToY, pEntityModifierListener, EaseLinear.getInstance());
	}

	public MoveModifier(final float pDuration, final float pFromX, final float pFromY, final float pToX, final float pToY, final IEntityModifierListener pEntityModifierListener, final IEaseFunction pEaseFunction) {
		super(pDuration, pFromX, pToX, pFromY, pToY, pEntityModifierListener, pEaseFunction);
	}

	protected MoveModifier(final org.andengine.entity.modifier.MoveModifier pMoveModifier) {
		super(pMoveModifier);
	}

	@Override
	public org.andengine.entity.modifier.MoveModifier deepCopy() {
		return new org.andengine.entity.modifier.MoveModifier(this);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected void onSetInitialValues(final IEntity pEntity, final float pX, final float pY) {
		pEntity.setPosition(pX, pY);
	}

	@Override
	protected void onSetValues(final IEntity pEntity, final float pPercentageDone, final float pX, final float pY) {
		pEntity.setPosition(pX, pY);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
