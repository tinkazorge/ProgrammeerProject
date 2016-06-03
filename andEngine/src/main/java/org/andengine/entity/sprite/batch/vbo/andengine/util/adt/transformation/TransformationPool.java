package org.andengine.entity.sprite.batch.vbo.andengine.util.adt.transformation;

import org.andengine.util.adt.pool.GenericPool;
import org.andengine.util.adt.transformation.*;
import org.andengine.util.adt.transformation.Transformation;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 23:07:53 - 23.02.2011
 */
public class TransformationPool {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static final GenericPool<org.andengine.util.adt.transformation.Transformation> POOL = new GenericPool<org.andengine.util.adt.transformation.Transformation>() {
		@Override
		protected org.andengine.util.adt.transformation.Transformation onAllocatePoolItem() {
			return new org.andengine.util.adt.transformation.Transformation();
		}
	};

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	public static org.andengine.util.adt.transformation.Transformation obtain() {
		return POOL.obtainPoolItem();
	}

	public static void recycle(final Transformation pTransformation) {
		pTransformation.setToIdentity();
		POOL.recyclePoolItem(pTransformation);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}