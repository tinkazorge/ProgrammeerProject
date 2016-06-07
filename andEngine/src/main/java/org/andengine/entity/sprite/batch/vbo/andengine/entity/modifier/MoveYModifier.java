package org.andengine.entity.sprite.batch.vbo.andengine.entity.modifier;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.*;
import org.andengine.entity.modifier.SingleValueSpanEntityModifier;
import org.andengine.util.modifier.ease.EaseLinear;
import org.andengine.util.modifier.ease.IEaseFunction;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 12:04:21 - 30.08.2010
 */
public class MoveYModifier extends SingleValueSpanEntityModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public MoveYModifier(final float pDuration, final float pFromY, final float pToY) {
		this(pDuration, pFromY, pToY, null, EaseLinear.getInstance());
	}

	public MoveYModifier(final float pDuration, final float pFromY, final float pToY, final IEaseFunction pEaseFunction) {
		this(pDuration, pFromY, pToY, null, pEaseFunction);
	}

	public MoveYModifier(final float pDuration, final float pFromY, final float pToY, final IEntityModifierListener pEntityModifierListener) {
		super(pDuration, pFromY, pToY, pEntityModifierListener, EaseLinear.getInstance());
	}

	public MoveYModifier(final float pDuration, final float pFromY, final float pToY, final IEntityModifierListener pEntityModifierListener, final IEaseFunction pEaseFunction) {
		super(pDuration, pFromY, pToY, pEntityModifierListener, pEaseFunction);
	}

	protected MoveYModifier(final org.andengine.entity.modifier.MoveYModifier pMoveYModifier) {
		super(pMoveYModifier);
	}

	@Override
	public org.andengine.entity.modifier.MoveYModifier deepCopy() {
		return new org.andengine.entity.modifier.MoveYModifier(this);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected void onSetInitialValue(final IEntity pEntity, final float pY) {
		pEntity.setY(pY);
	}

	@Override
	protected void onSetValue(final IEntity pEntity, final float pPercentageDone, final float pY) {
		pEntity.setY(pY);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
