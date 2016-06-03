package org.andengine.entity.sprite.batch.vbo.andengine.entity;

import java.util.Comparator;
import java.util.List;

import org.andengine.entity.*;
import org.andengine.entity.IEntity;
import org.andengine.util.adt.list.IList;
import org.andengine.util.algorithm.sort.InsertionSorter;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 12:08:56 - 06.08.2010
 */
public class ZIndexSorter extends InsertionSorter<org.andengine.entity.IEntity> {
	// ===========================================================
	// Constants
	// ===========================================================

	private static org.andengine.entity.ZIndexSorter INSTANCE;

	// ===========================================================
	// Fields
	// ===========================================================

	private final Comparator<org.andengine.entity.IEntity> mZIndexComparator = new Comparator<org.andengine.entity.IEntity>() {
		@Override
		public int compare(final org.andengine.entity.IEntity pEntityA, final org.andengine.entity.IEntity pEntityB) {
			return pEntityA.getZIndex() - pEntityB.getZIndex();
		}
	};

	// ===========================================================
	// Constructors
	// ===========================================================

	private ZIndexSorter() {

	}

	public static org.andengine.entity.ZIndexSorter getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new org.andengine.entity.ZIndexSorter();
		}
		return INSTANCE;
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

	public void sort(final org.andengine.entity.IEntity[] pEntities) {
		this.sort(pEntities, this.mZIndexComparator);
	}

	public void sort(final org.andengine.entity.IEntity[] pEntities, final int pStart, final int pEnd) {
		this.sort(pEntities, pStart, pEnd, this.mZIndexComparator);
	}

	public void sort(final List<org.andengine.entity.IEntity> pEntities) {
		this.sort(pEntities, this.mZIndexComparator);
	}

	public void sort(final List<org.andengine.entity.IEntity> pEntities, final int pStart, final int pEnd) {
		this.sort(pEntities, pStart, pEnd, this.mZIndexComparator);
	}

	public void sort(final IList<org.andengine.entity.IEntity> pEntities) {
		this.sort(pEntities, this.mZIndexComparator);
	}

	public void sort(final IList<IEntity> pEntities, final int pStart, final int pEnd) {
		this.sort(pEntities, pStart, pEnd, this.mZIndexComparator);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}