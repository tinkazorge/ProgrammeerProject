package org.andengine.entity.sprite.batch.vbo.andengine.entity;

import org.andengine.entity.*;
import org.andengine.entity.IEntity;
import org.andengine.util.IMatcher;

/**
 * (c) 2012 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 20:06:28 - 26.03.2012
 */
public interface IEntityMatcher extends IMatcher<org.andengine.entity.IEntity> {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	@Override
	public boolean matches(final IEntity pEntity);
}