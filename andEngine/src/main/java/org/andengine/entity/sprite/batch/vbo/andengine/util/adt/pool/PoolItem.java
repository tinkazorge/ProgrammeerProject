package org.andengine.entity.sprite.batch.vbo.andengine.util.adt.pool;

import org.andengine.util.adt.pool.*;
import org.andengine.util.adt.pool.Pool;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Valentin Milea
 * @author Nicolas Gramlich
 *
 * @since 23:02:47 - 21.08.2010
 */
public abstract class PoolItem {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	org.andengine.util.adt.pool.Pool<? extends org.andengine.util.adt.pool.PoolItem> mParent;
	boolean mRecycled = true;

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public org.andengine.util.adt.pool.Pool<? extends org.andengine.util.adt.pool.PoolItem> getParent() {
		return this.mParent;
	}

	public boolean isRecycled() {
		return this.mRecycled;
	}

	public boolean isFromPool(final Pool<? extends org.andengine.util.adt.pool.PoolItem> pPool) {
		return pPool == this.mParent;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	protected void onRecycle() {

	}

	protected void onObtain() {

	}

	public void recycle() {
		if (this.mParent == null) {
			throw new IllegalStateException("Item already recycled!");
		}

		this.mParent.recycle(this);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}