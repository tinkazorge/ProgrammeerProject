package org.andengine.entity.sprite.batch.vbo.andengine.input.touch.detector;

import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.*;
import org.andengine.input.touch.detector.BaseDetector;

import android.view.MotionEvent;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @author Greg Haynes
 * @since 20:49:25 - 23.08.2010
 */
public class HoldDetector extends BaseDetector {
	// ===========================================================
	// Constants
	// ===========================================================

	protected static final long TRIGGER_HOLD_MINIMUM_MILLISECONDS_DEFAULT = 200;
	protected static final float TRIGGER_HOLD_MAXIMUM_DISTANCE_DEFAULT = 10;

	// ===========================================================
	// Fields
	// ===========================================================

	protected long mTriggerHoldMinimumMilliseconds;
	protected float mTriggerHoldMaximumDistance;
	protected final IHoldDetectorListener mHoldDetectorListener;

	protected int mPointerID = TouchEvent.INVALID_POINTER_ID;

	protected long mDownTimeMilliseconds = Long.MIN_VALUE;

	protected float mDownX;
	protected float mDownY;

	protected float mHoldX;
	protected float mHoldY;

	protected boolean mMaximumDistanceExceeded;

	protected boolean mTriggering;

	// ===========================================================
	// Constructors
	// ===========================================================

	public HoldDetector(final IHoldDetectorListener pHoldDetectorListener) {
		this(org.andengine.input.touch.detector.HoldDetector.TRIGGER_HOLD_MINIMUM_MILLISECONDS_DEFAULT, org.andengine.input.touch.detector.HoldDetector.TRIGGER_HOLD_MAXIMUM_DISTANCE_DEFAULT, pHoldDetectorListener);
	}

	public HoldDetector(final long pTriggerHoldMinimumMilliseconds, final float pTriggerHoldMaximumDistance, final IHoldDetectorListener pHoldDetectorListener) {
		this.setTriggerHoldMinimumMilliseconds(pTriggerHoldMinimumMilliseconds);
		this.setTriggerHoldMaximumDistance(pTriggerHoldMaximumDistance);
		this.mHoldDetectorListener = pHoldDetectorListener;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public long getTriggerHoldMinimumMilliseconds() {
		return this.mTriggerHoldMinimumMilliseconds;
	}

	public void setTriggerHoldMinimumMilliseconds(final long pTriggerHoldMinimumMilliseconds) {
		if (pTriggerHoldMinimumMilliseconds < 0) {
			throw new IllegalArgumentException("pTriggerHoldMinimumMilliseconds must not be < 0.");
		}
		this.mTriggerHoldMinimumMilliseconds = pTriggerHoldMinimumMilliseconds;
	}

	public float getTriggerHoldMaximumDistance() {
		return this.mTriggerHoldMaximumDistance;
	}

	public void setTriggerHoldMaximumDistance(final float pTriggerHoldMaximumDistance) {
		if (pTriggerHoldMaximumDistance < 0) {
			throw new IllegalArgumentException("pTriggerHoldMaximumDistance must not be < 0.");
		}
		this.mTriggerHoldMaximumDistance = pTriggerHoldMaximumDistance;
	}

	public boolean isHolding() {
		return this.mTriggering;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	/**
	 * When {@link #isHolding()} this method will call through to {@link IHoldDetectorListener#onHoldFinished(org.andengine.input.touch.detector.HoldDetector, long, int, float, float).
	 */
	@Override
	public void reset() {
		if (this.mTriggering) {
			this.triggerOnHoldFinished(System.currentTimeMillis() - this.mDownTimeMilliseconds);
		}

		this.mTriggering = false;
		this.mMaximumDistanceExceeded = false;
		this.mDownTimeMilliseconds = Long.MIN_VALUE;
		this.mPointerID = TouchEvent.INVALID_POINTER_ID;
	}

	@Override
	public boolean onManagedTouchEvent(final TouchEvent pSceneTouchEvent) {
		final MotionEvent motionEvent = pSceneTouchEvent.getMotionEvent();

		switch (pSceneTouchEvent.getAction()) {
			case TouchEvent.ACTION_DOWN:
				if (this.mPointerID == TouchEvent.INVALID_POINTER_ID) {
					this.prepareHold(pSceneTouchEvent);
					return true;
				} else {
					return false;
				}
			case TouchEvent.ACTION_MOVE:
			{
				if (this.mPointerID == pSceneTouchEvent.getPointerID()) {
					this.mHoldX = pSceneTouchEvent.getX();
					this.mHoldY = pSceneTouchEvent.getY();

					final long holdTimeMilliseconds = System.currentTimeMillis() - this.mDownTimeMilliseconds;
					if (holdTimeMilliseconds >= this.mTriggerHoldMinimumMilliseconds) {
						if (this.mTriggering) {
							this.triggerOnHold(holdTimeMilliseconds);
						} else {
							final float triggerHoldMaximumDistance = this.mTriggerHoldMaximumDistance;
							this.mMaximumDistanceExceeded = this.mMaximumDistanceExceeded || Math.abs(this.mDownX - motionEvent.getX()) > triggerHoldMaximumDistance || Math.abs(this.mDownY - motionEvent.getY()) > triggerHoldMaximumDistance;

							if (!this.mMaximumDistanceExceeded) {
								if (!this.mTriggering) {
									this.triggerOnHoldStarted();
								} else {
									this.triggerOnHold(holdTimeMilliseconds);
								}
							}
						}
					}
					return true;
				} else {
					return false;
				}
			}
			case TouchEvent.ACTION_UP:
			case TouchEvent.ACTION_CANCEL:
			{
				if (this.mPointerID == pSceneTouchEvent.getPointerID()) {
					this.mHoldX = pSceneTouchEvent.getX();
					this.mHoldY = pSceneTouchEvent.getY();

					final long holdTimeMilliseconds = System.currentTimeMillis() - this.mDownTimeMilliseconds;
					if (holdTimeMilliseconds >= this.mTriggerHoldMinimumMilliseconds) {
						if (this.mTriggering) {
							this.triggerOnHoldFinished(holdTimeMilliseconds);
						} else {
							final float triggerHoldMaximumDistance = this.mTriggerHoldMaximumDistance;
							this.mMaximumDistanceExceeded = this.mMaximumDistanceExceeded || Math.abs(this.mDownX - motionEvent.getX()) > triggerHoldMaximumDistance || Math.abs(this.mDownY - motionEvent.getY()) > triggerHoldMaximumDistance;

							if (!this.mMaximumDistanceExceeded) {
								this.triggerOnHoldFinished(holdTimeMilliseconds);
							}
						}
					}

					this.mPointerID = TouchEvent.INVALID_POINTER_ID;
					return true;
				} else {
					return false;
				}
			}
			default:
				return false;
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	protected void prepareHold(final TouchEvent pSceneTouchEvent) {
		final MotionEvent motionEvent = pSceneTouchEvent.getMotionEvent();
		this.mDownTimeMilliseconds = System.currentTimeMillis();
		this.mDownX = motionEvent.getX();
		this.mDownY = motionEvent.getY();
		this.mMaximumDistanceExceeded = false;
		this.mPointerID = pSceneTouchEvent.getPointerID();
		this.mHoldX = pSceneTouchEvent.getX();
		this.mHoldY = pSceneTouchEvent.getY();

		if (this.mTriggerHoldMinimumMilliseconds == 0) {
			this.triggerOnHoldStarted();
		}
	}

	protected void triggerOnHoldStarted() {
		this.mTriggering = true;

		if (this.mPointerID != TouchEvent.INVALID_POINTER_ID) {
			this.mHoldDetectorListener.onHoldStarted(this, this.mPointerID, this.mHoldX, this.mHoldY);
		}
	}

	protected void triggerOnHold(final long pHoldTimeMilliseconds) {
		if (this.mPointerID != TouchEvent.INVALID_POINTER_ID) {
			this.mHoldDetectorListener.onHold(this, pHoldTimeMilliseconds, this.mPointerID, this.mHoldX, this.mHoldY);
		}
	}

	protected void triggerOnHoldFinished(final long pHoldTimeMilliseconds) {
		this.mTriggering = false;

		if (this.mPointerID != TouchEvent.INVALID_POINTER_ID) {
			this.mHoldDetectorListener.onHoldFinished(this, pHoldTimeMilliseconds, this.mPointerID, this.mHoldX, this.mHoldY);
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	public static interface IHoldDetectorListener {
		// ===========================================================
		// Constants
		// ===========================================================

		// ===========================================================
		// Methods
		// ===========================================================

		public void onHoldStarted(final org.andengine.input.touch.detector.HoldDetector pHoldDetector, final int pPointerID, final float pHoldX, final float pHoldY);
		public void onHold(final org.andengine.input.touch.detector.HoldDetector pHoldDetector, final long pHoldTimeMilliseconds, final int pPointerID, final float pHoldX, final float pHoldY);
		public void onHoldFinished(final org.andengine.input.touch.detector.HoldDetector pHoldDetector, final long pHoldTimeMilliseconds, final int pPointerID, final float pHoldX, final float pHoldY);
	}
}
