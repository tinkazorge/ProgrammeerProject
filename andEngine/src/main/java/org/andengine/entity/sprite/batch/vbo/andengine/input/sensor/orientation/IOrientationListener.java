package org.andengine.entity.sprite.batch.vbo.andengine.input.sensor.orientation;

import org.andengine.input.sensor.orientation.*;
import org.andengine.input.sensor.orientation.OrientationData;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 11:30:42 - 25.05.2010
 */
public interface IOrientationListener {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public void onOrientationAccuracyChanged(final org.andengine.input.sensor.orientation.OrientationData pOrientationData);
	public void onOrientationChanged(final OrientationData pOrientationData);
}
