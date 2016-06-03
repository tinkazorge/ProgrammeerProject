package org.andengine.entity.sprite.batch.vbo.andengine.input.touch.detector;

import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.*;
import org.andengine.input.touch.detector.BaseDetector;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/**
 * @author rkpost
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 11:36:26 - 11.10.2010
 */
public abstract class SurfaceGestureDetector extends BaseDetector {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final float SWIPE_MIN_DISTANCE_DEFAULT = 120;

	// ===========================================================
	// Fields
	// ===========================================================

	private final GestureDetector mGestureDetector;

	// ===========================================================
	// Constructors
	// ===========================================================

	public SurfaceGestureDetector(final Context pContext) {
		this(pContext, org.andengine.input.touch.detector.SurfaceGestureDetector.SWIPE_MIN_DISTANCE_DEFAULT);
	}

	public SurfaceGestureDetector(final Context pContext, final float pSwipeMinDistance) {
		this.mGestureDetector = new GestureDetector(pContext, new InnerOnGestureDetectorListener(pSwipeMinDistance));
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	protected abstract boolean onSingleTap();
	protected abstract boolean onDoubleTap();
	protected abstract boolean onSwipeUp();
	protected abstract boolean onSwipeDown();
	protected abstract boolean onSwipeLeft();
	protected abstract boolean onSwipeRight();

	@Override
	public void reset() {

	}

	@Override
	public boolean onManagedTouchEvent(final TouchEvent pSceneTouchEvent) {
		return this.mGestureDetector.onTouchEvent(pSceneTouchEvent.getMotionEvent());
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	private class InnerOnGestureDetectorListener extends SimpleOnGestureListener {
		// ===========================================================
		// Constants
		// ===========================================================

		// ===========================================================
		// Fields
		// ===========================================================

		private final float mSwipeMinDistance;

		// ===========================================================
		// Constructors
		// ===========================================================

		public InnerOnGestureDetectorListener(final float pSwipeMinDistance) {
			this.mSwipeMinDistance = pSwipeMinDistance;
		}

		// ===========================================================
		// Getter & Setter
		// ===========================================================

		// ===========================================================
		// Methods for/from SuperClass/Interfaces
		// ===========================================================

		@Override
		public boolean onSingleTapConfirmed(final MotionEvent pMotionEvent) {
			return org.andengine.input.touch.detector.SurfaceGestureDetector.this.onSingleTap();
		}

		@Override
		public boolean onDoubleTap(final MotionEvent pMotionEvent) {
			return org.andengine.input.touch.detector.SurfaceGestureDetector.this.onDoubleTap();
		}

		@Override
		public boolean onFling(final MotionEvent pMotionEventStart, final MotionEvent pMotionEventEnd, final float pVelocityX, final float pVelocityY) {
			final float swipeMinDistance = this.mSwipeMinDistance;

			final boolean isHorizontalFling = Math.abs(pVelocityX) > Math.abs(pVelocityY);

			if (isHorizontalFling) {
				if (pMotionEventStart.getX() - pMotionEventEnd.getX() > swipeMinDistance) {
					return org.andengine.input.touch.detector.SurfaceGestureDetector.this.onSwipeLeft();
				} else if (pMotionEventEnd.getX() - pMotionEventStart.getX() > swipeMinDistance) {
					return org.andengine.input.touch.detector.SurfaceGestureDetector.this.onSwipeRight();
				}
			} else {
				if (pMotionEventStart.getY() - pMotionEventEnd.getY() > swipeMinDistance) {
					return org.andengine.input.touch.detector.SurfaceGestureDetector.this.onSwipeUp();
				} else if (pMotionEventEnd.getY() - pMotionEventStart.getY() > swipeMinDistance) {
					return org.andengine.input.touch.detector.SurfaceGestureDetector.this.onSwipeDown();
				}
			}

			return false;
		}

		// ===========================================================
		// Methods
		// ===========================================================

		// ===========================================================
		// Inner and Anonymous Classes
		// ===========================================================
	}
}