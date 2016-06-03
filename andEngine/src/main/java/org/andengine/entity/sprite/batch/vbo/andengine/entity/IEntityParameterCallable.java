package org.andengine.entity.sprite.batch.vbo.andengine.entity;

import org.andengine.entity.*;
import org.andengine.entity.IEntity;
import org.andengine.util.call.ParameterCallable;

/**
 * (c) 2012 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 20:06:53 - 26.03.2012
 */
public interface IEntityParameterCallable extends ParameterCallable<org.andengine.entity.IEntity> {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	@Override
	public void call(final IEntity pEntity);
}